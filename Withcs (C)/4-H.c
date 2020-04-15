/*#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main()
{
    long long int n;
    long long int a, b, c, d, r, s;
    scanf("%lld", &n);
    scanf("%lld %lld %lld", &a, &b, &r);
    scanf("%lld %lld %lld", &c, &d, &s);

    a = (a % n + n) % n;
    b = (b % n + n) % n;
    c = (c % n + n) % n;
    d = (d % n + n) % n;
    r = (r % n + n) % n;
    s = (s % n + n) % n;

    int i, j;
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if ((c * i + d * j) % n == s && (a * i + b * j) % n == r) {
                printf("%d\n%d", i, j);

            }
        }
    }
}*/