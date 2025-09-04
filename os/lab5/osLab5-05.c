#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    pid_t id;
    char input = 'z';
    while (input != 'q') {
        printf("\nSelect a letter to run a program\n");
        printf("'a' run --> uname -r\n");
        printf("'b' run --> ls -l\n");
        printf("'c' run --> ps -f\n");
        printf("'d' run --> df -h\n");
        printf("Exit a program press 'q'\n");
        printf("Enter a letter to run a program: ");
        scanf(" %c", &input);

        if (input == 'q') break;

        id = fork();
        if (id == 0) {
            if (input == 'a') execlp("uname", "uname", "-r", NULL);
            else if (input == 'b') execlp("ls", "ls", "-l", NULL);
            else if (input == 'c') execlp("ps", "ps", "-f", NULL);
            else if (input == 'd') execlp("df", "df", "-h", NULL);
            exit(0);
        } else {
            wait(NULL);
        }
    }
    return 0;
}