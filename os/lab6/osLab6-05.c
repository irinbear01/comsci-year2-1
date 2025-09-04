#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

typedef struct mydata {
    double d;
    int i;
} data;

// 4.1 ประกาศให้คืนค่าเป็น void*
void *myfunc(void *argv) {
    data *my = (data *)malloc(sizeof(data));
    my->d = 3.14;
    my->i = 40;
    pthread_exit((void*)my);      // 4.2 ส่งพอยน์เตอร์กลับ
}

int main(void) {
    pthread_t tid;
    data my;
    void *retval;

    // 4.3 ไม่ใช้ argv ก็ส่ง NULL
    pthread_create(&tid, NULL, myfunc, NULL);
    pthread_join(tid, &retval);

    // 4.4 แคสต์ชนิด แล้วก็อปปี้ค่าออกมา
    my = *((data *)retval);
    free(retval);

    printf("%f, %d\n", my.d, my.i);
    return 0;
}
