#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {

	int turn_two(int num1);
	int turn_three(int num2);

	int N;
	scanf("%d", &N);

	printf("%d\n", N);
	while (N != 1) {
	
		
		if (N % 2 == 0) {

		


			N = turn_two(N);

			if (N == 1) {
				printf("1");
			}
			else{
				printf("%d\n", N);
			}
			
			
		}
		else {
			N = turn_three(N);

			if (N == 1) {
				printf("1");
			}
			else {
				printf("%d\n", N);
			}
			
		}
	
	
	}
	

	





}
int turn_two(int num1) {
	num1 = (num1) / 2;

	return num1;
}

int turn_three(int num2) {
	num2 = (3 * num2) + 1;
	return num2;
}