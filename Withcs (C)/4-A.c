
#include <stdio.h>

int main() {

	int aHour;
	int aMin;
	int aSec;
	int bHour;
	int bMin;
	int bSec;
	int cHour;
	int cMin;
	int cSec;

	
	scanf("%d %d %d", &aHour, &aMin, &aSec);
	scanf("%d %d %d", &bHour, &bMin, &bSec);

	
	if (aSec > bSec) {
		cSec=bSec - aSec+60;
		bMin=bMin-1;

		if (aMin > bMin) {
			cMin = bMin - aMin + 60;
			bHour = bHour - 1;
			cHour = bHour - aHour;
		}
		
		else {
			cMin = bMin - aMin;
			cHour = bHour - aHour;
		}
	}

	else {
		cSec = bSec - aSec;
		if (aMin > bMin) {
			cMin = bMin - aMin + 60;
			bHour = bHour - 1;
			cHour = bHour - aHour;
		}

		else {
			cMin = bMin - aMin;
			cHour = bHour - aHour;
		}
	
	}

	
	printf("%d %d %d", cHour, cMin, cSec);
	





}