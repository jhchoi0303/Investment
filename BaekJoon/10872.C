#include <stdio.h>


int main(){

    int number;
    scanf("%d",&number);

    if(number==0){
	printf("1");
    }
    
    else{
	for(int i=number-1;i>=1;i--){
		number*=i;
	}
	printf("%d",number);
}
}