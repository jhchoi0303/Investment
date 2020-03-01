#include<cstdio>
#include<cstring>

int stack[10000];

int main() {
   int n;
   int index = -1;
   int num;
   scanf("%d", &n);
   while (n--) {
      char s[10];
      scanf("%s", s);
      if (!strcmp(s, "push")) {
      	scanf("%d",&num);
      	index++;
      	stack[index]=num;
      }
      else if (!strcmp(s, "pop")) {
         if (index<=-1) 
            printf("-1\n");
         else {
            printf("%d\n",stack[0]);
            for(int i=0;i<1000;i++){
            	stack[i]=stack[i+1];
            }
            index=index-1;
         }

      }
      else if (!strcmp(s, "size")) {
         printf("%d\n",index+1);
      }
      else if (!strcmp(s, "empty")) {
         if(index<=-1){
         	printf("1\n");
         	
         	
         }
         
         else{
         	printf("0\n");
         }
      }
      else if (!strcmp(s, "front")) {
         if (index<=-1){
         	printf("-1\n");
         }
         else {
           printf("%d\n",stack[0]);
         }
      }
      
      
      else if (!strcmp(s, "back")) {
         if (index<=-1){
         	printf("-1\n");
         }
         else {
           printf("%d\n",stack[index]);
         }
      }
   }
}