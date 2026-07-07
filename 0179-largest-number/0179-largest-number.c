#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* a, const void* b) {
    char ab[25], ba[25];

    sprintf(ab, "%s%s", *(char**)a, *(char**)b);
    sprintf(ba, "%s%s", *(char**)b, *(char**)a);

    return strcmp(ba, ab);
}

char* largestNumber(int* nums, int numsSize) {
    char** arr = (char**)malloc(numsSize * sizeof(char*));

    for (int i = 0; i < numsSize; i++) {
        arr[i] = (char*)malloc(12);
        sprintf(arr[i], "%d", nums[i]);
    }

    qsort(arr, numsSize, sizeof(char*), compare);

    if (strcmp(arr[0], "0") == 0) {
        char* result = (char*)malloc(2);
        strcpy(result, "0");
        return result;
    }

    int totalLen = 0;
    for (int i = 0; i < numsSize; i++) {
        totalLen += strlen(arr[i]);
    }

    char* result = (char*)malloc(totalLen + 1);
    result[0] = '\0';

    for (int i = 0; i < numsSize; i++) {
        strcat(result, arr[i]);
    }

    return result;
}