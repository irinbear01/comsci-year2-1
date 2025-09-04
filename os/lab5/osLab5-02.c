#include <stdio.h>
#include <unistd.h>

int main() {
    printf("PID: %d\n", getpid());
    printf("HELLO ...\n");
    // สร้าง array เก็บ arguments
    char *args[] = {"ls", "-a", "-l", NULL};
    // ใช้ path เต็มของ ls (อยู่ที่ /bin/ls)
    execv("/bin/ls", args);
    printf("... KMITL\n");
}