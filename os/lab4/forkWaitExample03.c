#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t id;
    int i = 0;

    id = fork();

    if (id > 0) {
        // Parent process
        wait(NULL); // รอให้ child ทำงานเสร็จ
        i += 1;
        printf("I'm parent, i = %d\n", i);
    } else if (id == 0) {
        // Child process
        i += 2;
        printf("I'm child, i = %d\n", i);
        exit(0); // ออกจาก child เพื่อไม่ให้รันบรรทัดสุดท้าย
    } else {
        // fork() failed
        perror("fork failed");
        exit(1);
    }

    // ทำงานในทั้ง parent และ child ถ้า child ไม่ exit
    printf("my i = %d\n", i);

    return 0;
}
