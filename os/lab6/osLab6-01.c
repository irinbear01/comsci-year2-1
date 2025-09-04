#include <stdio.h>

void runner(void) {
    int num = 10;
    int *ptr;      ptr  = &num;
    int **dPtr;    dPtr = &ptr;

    printf("Value at num = %d\n", num);
    printf("Address of num = %p\n\n", (void*)&num);

    // 1.1 ใช้ %p เพื่อพิมพ์ค่าพอยน์เตอร์ (ที่ชี้ไปยัง &num)
    printf("Value at ptr = %p\n", (void*)ptr);
    printf("Address of ptr = %p\n", (void*)&ptr);
    printf("Value at *ptr = %d\n\n", *ptr);

    printf("Value at dPtr = %p\n", (void*)dPtr);
    // 1.2 address ของ dPtr คือ &dPtr
    printf("Address of dPtr = %p\n", (void*)&dPtr);
    printf("Value at **dPtr = %d\n\n", **dPtr);
}

int main(void) {              // 1.3 เรียก runner()
    runner();
    return 0;
}