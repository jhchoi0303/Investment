#include <stdio.h>
int gcd(int a,int b){
	if(b==0) return a;
	
	else return gcd(b,a%b);
	
	
}



int main(){
	int n;
	int a;
	int b;
	
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d %d",&a,&b);
		int c= a*b/gcd(a,b);
		printf("%d\n",c);
		
		
		
	}
	
	
	
	
	
}