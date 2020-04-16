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
		long long sum = 0;
		long long int j;
		for (j = 1; j <= arr[i]; j++) {
			sum += (j * j * j);

		}

		if (i == N - 1) {
		printf("%lld", sum);
		}

		else { printf("%lld\n", sum); }
	
		
		
	}
	
		
		





}