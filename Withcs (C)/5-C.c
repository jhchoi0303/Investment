#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {


	int n;

	scanf("%d", &n);


	for (int i = 1; i < 9; i++) {
		printf("%d X %d = %d\n", n, i, n * i);
	
	}
	printf("%d X %d = %d", n, 9, n * 9);


}