#include <stdio.h>
int gcd(int a, int b) {
	if (b == 0) return a;

	else return gcd(b, a%b);


}

int abb(int a, int b) {
	int c = a / gcd(a, b);

	int d = b / gcd(a, b);

	printf("%d %d", c, d);
}


int main() {
	int a;
	int b;
	int c;
	int d;

	scanf("%d %d\n%d %d", &a, &b, &c, &d);
	abb(a*d + b * c, b*d);



}