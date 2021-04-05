// popen 함수(읽기 전용 모드) 사용하기
#include <stdlib.h>
#include <stdio.h>

int main(void) {
    FILE *fp;
    char buf[256];

    fp = popen("date", "r");
    if (fp == NULL) {
        fprintf(stderr, "popen failed\n");
        exit(1);
    }
    if (fgets(buf, sizeof(buf), fp) == NULL) {
        fprintf(stderr, "No data from pipe!\n");
        exit(1);
    }

    printf("line : %s", buf);
    pclose(fp);

    return 0;
}