#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define NUM_TASKS 4
char *messages[NUM_TASKS];

void *printHello(void *argv) {
    sleep(1);
    int taskID = *((int *)argv);    // 3.5 ดึงค่าอินพุต
    printf("Task %d: %s\n", taskID, messages[taskID]);
    free(argv);                     // คืนหน่วยความจำที่จอง
    pthread_exit(0);
}

int main(int argc, char *argv[]) {
    pthread_t threads[NUM_TASKS];
    int i, t;

    for (i = 0; i < NUM_TASKS; i++) {
        messages[i] = "Hello KMITL";
    }

    for (t = 0; t < NUM_TASKS; t++) {
        int *input = (int *)malloc(sizeof(int));  // 3.6 สำรองที่จำสำหรับส่งค่าให้เธรด
        *input = t;
        printf("Create thread %d\n", t);
        pthread_create(&threads[t], NULL, printHello, (void *)input);
        pthread_join(threads[t], NULL);           // 3.7 join ทีละตัว (ทำให้เหมือนรันทีละเธรด)
    }
    return 0;
}