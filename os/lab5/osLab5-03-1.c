#include <stdio.h>
#include <unistd.h>

int main() {
    printf("PID: %d\n", getpid());
    char *argv[] = {"myProgram", "CS", "KMITL", NULL};
    execvp("myProgram", argv);
    printf("Bye Bye ...\n");
}