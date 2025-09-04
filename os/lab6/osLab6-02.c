#include <stdio.h>

void passByValue(int argv) {
    argv += 1;
    printf("During pass-by-value: %d\n", argv);
}

// 2.1 รับเป็นพอยน์เตอร์
void passByReference(int *argv) {
    *argv += 1;
    printf("During pass-by-reference: %d\n", *argv);
}

void swap(char *argv1, char *argv2) {
    char tmp = *argv1;
    // 2.2 สลับค่า
    *argv1 = *argv2;
    *argv2 = tmp;
}

void passByArray(int argv[]) {   // อาเรย์ส่งแบบอ้างอิงโดยอัตโนมัติ
    argv[0] = 999;
}

int main(void) {
    int num = 10;

    printf("Before pass-by-value: %d\n", num);
    passByValue(num);
    printf("After pass-by-value: %d\n\n", num);

    printf("Before pass-by-reference: %d\n", num);
    passByReference(&num);        // 2.3 ส่งที่อยู่
    printf("After pass-by-reference: %d\n\n", num);

    char var1 = 'a', var2 = 'b';
    printf("Before swap: var1 = %c, var2 = %c\n", var1, var2);
    swap(&var1, &var2);
    printf("After swap: var1 = %c, var2 = %c\n\n", var1, var2);

    int arr[] = {777, 888};
    printf("Before pass:\t{%d, %d}\n", arr[0], arr[1]);
    passByArray(arr);
    printf("After pass:\t{%d, %d}\n", arr[0], arr[1]);

    return 0;
}