#include <stdio.h>

int main() {

    int N;
    int number;
	
    int min = 1000001;
    int max = -1000001;
    
    
	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &number);

		if (number < min) {
			min = number;
		}
        
		if (number > max) {
			max = number;
		}
	}

	printf("%d %d", min, max);
}