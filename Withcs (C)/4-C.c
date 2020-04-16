/*
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main() {
	float a, b, n, m, l, x, y, X;
	

	scanf("%f %f", &a, &b);
	scanf("%f %f %f", &n, &m, &l);
	scanf("%f %f", &x, &y);
	scanf("%f", &X);

	float wondu;
	float sugar;
	float hotwater;


	wondu = X * (x / (x + y)) * (a / b) * (n / (n + m + l));
	sugar = X * (m / (n + m + l))*(x / (x + y)) ;
	hotwater = X * (y / (x + y) + (x / (x + y)) * (l / (n + m + l)) + (x / (x + y)) * (n / (n + m + l)));

	printf("%.2f\n", ceil(wondu *100) / 100.00);

	printf("%.2f\n", ceil(sugar * 100) / 100.00);

	printf("%.2f\n", ceil(hotwater * 100) / 100.00);






}*/
