#include <stdio.h>

int main(void) {
	int arr[21];
	int N;
	scanf("%d", &N);

	for (int i = 0; i <= N; i++) {
		if (i == 0) {
			arr[i] = 0;
		}
		else if (i == 1) {
			arr[1] = 1;
		}
		else {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
	}

	printf("%d", arr[N]);


}
