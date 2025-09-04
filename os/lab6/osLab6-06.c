#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

typedef struct {
    long n;
    long result;
} payload;

// ฟังก์ชันของ thread
void *sum_to_2n(void *arg) {
    payload *p = (payload *)arg;
    long sum = 0;
    for (long i = 1; i <= p->n * 2; i++) {
        sum += i;
    }
    p->result = sum;
    pthread_exit(NULL); // ส่งค่ากลับผ่าน struct ที่แชร์
}

// ฟังก์ชันคำนวณใน main
long sum_to_n(long n) {
    long sum = 0;
    for (long i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <positive integer>\n", argv[0]);
        return 1;
    }

    long n = atol(argv[1]);
    if (n <= 0) {
        fprintf(stderr, "Please enter a positive integer.\n");
        return 1;
    }

    pthread_t tid;
    payload data = { .n = n, .result = 0 };

    // สร้าง thread ให้คำนวณผลรวม 1 ถึง 2n
    pthread_create(&tid, NULL, sum_to_2n, &data);

    // คำนวณใน main process
    long msum = sum_to_n(n);

    // รอให้ thread ทำงานเสร็จ
    pthread_join(tid, NULL);

    // แสดงผลลัพธ์
    printf("From thread process ...\n");
    printf("csum = %ld\n", data.result);
    printf("From main process ...\n");
    printf("msum = %ld\n", msum);
    printf("Difference csum and msum = %ld\n", data.result - msum);

    return 0;
}