#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdbool.h>

int main() {

	
	int N;
	

	scanf("%d",&N);

	
	for (int i = 0; i < N; i++) {
		int C;
		scanf("%d", &C);

		

			
			int imp=0;

			bool exitOuterLoop = false;
			for (int A = 0; A <= C; A++) {
				for (int B = 0; B <= C; B++) {
					if (((A*A) - (B *B))==C) {
						printf("%d %d\n", A, B);

						exitOuterLoop = true;
						break;
					}
					
					
				}
				if (exitOuterLoop == true) {
					break;
				}
			}
				
			


			for (int A = 0; A <= C; A++) {
				for (int B = 0; B <= C; B++) {
					if (((A * A) - (B * B)) != C) {
						imp++;

						
					}

				}

			}


			if (imp == (C+1) * (C+1)) {
				printf("IMPOSSIBLE\n");
			}
			


	}




}