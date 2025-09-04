#include <stdio.h>
#include <pthread.h>

static int input = 999;

void *myfunc(void *argv) {
    int value = *((int *)argv);
    printf("From thread process ...\n");
    printf("Thread value: %d\n", value);
    pthread_exit(NULL);           // 3.1 จบเธรด
}

pthread_t launch_thread(void) {
    input += 1;
    pthread_t tid;
    pthread_attr_t tattr;
    pthread_attr_init(&tattr);
    pthread_create(&tid, &tattr, myfunc, &input);
    return tid;                   // 3.2 คืนค่า tid
}

int main(void) {
    pthread_t tid = launch_thread();  // 3.3
    pthread_join(tid, NULL);
    printf("From main process ...\n");
    return 0;
}