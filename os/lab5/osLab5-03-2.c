#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    printf("HELLO ...\n... %s\n", argv[1]);
    printf("PID: %d\n", getpid());
}