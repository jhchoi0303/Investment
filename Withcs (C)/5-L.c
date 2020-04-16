#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {

	int arr[100001];
	int N;
	scanf("%d", &N);


	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < N; i++) {
	
		int num = 0;
		while (arr[i] != 1) {
		
			for (int j = 1; j <= arr[j]; j++) {
				if (arr[i] % j == 0) {
					arr[i] = arr[i] / j;
					num++;
				}
			}

			
		}
		printf("%d\n", num );

	
	
	}

	
	



}