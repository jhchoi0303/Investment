# Reverse Engineering

## 1. Reverse Engineering

이미 만들어진 시스템이나 장치에 대한 해체와 분석을 거쳐 그 대상 물체를 알아내는 일련의 과정. 
완성품의 설계도 없이 구조와 동작 과정을 알아내는 모든 단계.
"역공학","리버스 엔지니어링","리버싱"

소프트웨어 리버싱이란 소스코드가 없는 상태에서 컴파일된 대상 소프트웨어의 구조를 여러가지 방법으로 분석하고 메모리 덤프를 비롯한 바이너리 분석 결과를 토대로 동작 원리와 내부구조를 파악한 다음 원래의 소스가 어떻게 작성된 것인지 알아내는 과정.

## 2. Disclaimer

리버싱은 학습 및 연구용으로도 많이 사용되는 기술 뿐만 아니라 각종 악성코드나 불법 프로그램의 분석 및 대응수단으로도 효과적인 기술이다. 그러나 소스 코드를 비롯한 전체적인 작동 원리를 알아낼 수 있다는 점에서, 각종 상용 프로그램의 지적재산권을 침해할 수도 있다.

## 3. Static Analysis vs Dynamic Analysis

프로그램을 실행시키지 않고 분석하는 정적 분석 방법 (Static Analysis)과 프로그램을 실행시켜서 입출력과 내부 동작 단계를 살피며 분석하는 동적 분석 방법 (Dynamic Analysis) 두가지 방법이 있다.

정적 분석을 위해서는 실행파일을 구성하는 모든 요소, 대상 실행 파일이 실제로 동작할 CPU 아키텍처에 해당하는 어셈블리 코드를 이해하는 것이 필요.

동적 분석을 위해서는 실행단계별로 자세한 동작 과정을 살펴봐야 하므로 환경에 맞는 디버거를 이용해 단계별로 분석하는 기술을 익혀야 한다.


## 4. 코드가 컴파일 되는 과정

사람이 이해할 수 있는 소스코드를 컴퓨터가 이해할 수 있는 형태인 프로그램(바이너리)로 바꾸려면 컴파일을 거쳐야 한다.
이러한 과정에서 사용되는 프로그램을 "컴파일러"라고 부른다. 모든 프로그래밍 언어가 컴파일러를 통해서 실행가능한 바이너리가 되는 것은 아니지만, 대개는 단독적으로 실행 가능한 바이너리가 되기 위해서 컴파일 과정을 거친다.

컴파일러가 소스코드를 바이너리로 변환하기 위해서는 몇가지 단계를 거친다.

먼저, 원본 소스 코드는 사람이 알아보기 쉽도록 각종 주석이나 매크로 등을 포함하고 있다. 또는 참조할 헤더 파일을 포함하고 있기도 한다. 이와 같은 정보는 실제로는 코드가 아니라 참조를 위해 붙여둔 정보이므로, 컴파일러는 이를 모두 미리 처리해서 다음 단게에서 변환할 준비를 마친다.

이렇게 준비된 '중간 언어'를 컴파일러가 분석하고 최적화해 어셈블리 코드로 만들어 준다.

어셈블리 코드는 컴퓨터가 이해할 수 있는 기계 코드를 사람이 알아보기 쉽게 명령어(instruction) 단위로 표현한 것이다. 즉 어셈블리 코드와 기계 코드는 1:1 대응이 가능하므로, 최종적으로 어셈블리 코드가 기계 코드로 번역되는 과정을 (어셈블,Assemble) 거쳐 실행 가능한 바이너리가 완성된다.

* ### Source code<-???<-Binary Code

바이너리를 분석해 어떤 방식으로 동작하는지, 나아가 어떤 소스 코드를 바탕으로 만들어졌는지를 알아내려면 분석가는 컴파일러가 수행하는 과정을 역으로 진행해야 한다.

따라서, 주어진 바이너리를 어셈블리 코드로 변환하고, 변환된 어셈블리 코드를 분석하면 대상 바이너리가 어떤 식으로 동작하는지 알 수 있게 된다.
이렇게 바이너리 코드를 어셈블리 코드로 변환하는 과정을 Disassemble 이라고 한다.

'리버싱'으로 통용되는 소프트웨어 리버스 엔지니어링, 특히 정적 분석 방법에 해당되는 방법은 디스어셈블을 거쳐 나온 어셈블리 코드를 분석해 소프투웨어의 동작 구조를 알아내는 과정이다.



# x64 기초

## Intro

어셈블리 코드는 기계 코드와 1:1 대응되므로, 기계 코드가 실제로 동작할 CPU에 따라 기계 코드 역시 달라진다. CPU에 따라 어셈블리 코드도 다름.

가장 널리 쓰이는 Intel 구조의 64bit 버전 명령어 집합에서 쓰이는 x64 명령어 집합에 대해 알아보겠다.

### Instruction Cycle

어셈블리 코드는 기계 코드와 대응되므로, 기계 코드가 동작할 CPU가 어떤 역할을 하고 어떻게 동작하는지를 알아보는게 어셈블리 코드를 이해하는데 도움이 된다.

CPU는 아주 복잡해 보이지만, 기본적으로는 다음 실행할 명령어를 읽어오고 (Fetch)->읽어온 명령어를 해석한 다음(Decode)->해석한 결과를 실행하는 (Execute) 과정을 반복하는 장치이다.

한개의 명령어, 기계 코드가 실행되는 한번의 과정을 Instruction Cycle이라고 한다.

### 레지스터(Register)와 명령어(Instruction)

CPU는 Instruction Cycle을 수행하기 위해 기계 코드에 해앋하는 각종 명령어를 해석하기 위한 구성요소 외에도 읽어온 명령어가 저장된 공간을 임시로 기억해 둘 구성요소나, 명령어를 실행한 결과를 저장해 둘 구성요소가 필요하다. 이렇게 CPU의 동작에 필수적인 저장 공간의 역할을 하는 CPU의 구성요소를 레지스터(Register)라고 한다.

한편, CPU가 실행할 명령어(Instruction)들은 수행하는 동작에 따라 조금씩 

## Register

### 레지스터와 그 종류

레지스터는 CPU가 사용하는 저장공간이다. 대개의 경우 각각의 레지스터들은 특별히 쓰임새가 정해져 있지 않다. 그러나 쓰임새가 정해진 것은 아니지만 관행적으로 용도를 정해놓고 쓰는 레지스터도 있고, 엄격히 정해진 용도로만 쓰이는 레지스터가 있기도 하다.

## 범용 레지스터 (General-Purpose Registers)

범용 레지스터(General-Purpose Registers, GPR) 는 말 그대로 용도를 특별히 정해두지 않고 다양하게 쓸 수 있는 레지스터다.

우리가 수학 계산을 할 때 연습장을 두고 쓰듯이, CPU도 범용 레지스터를 연습장처럼 쓴다 x64의 범용 레지스터는 총 16개.

범용 레지스터는 원칙적으로 용도가 정해져 있진 않지만, 관행적으로 그 쓰임새가 정해져 있는 경우도 있다.


rax는 함수가 실행된 후 리턴값을 저장 하기 위해 쓰인다. 즉, 어떤 함수의 실행이 종료되고 나면 해당 함수의 결과값이 반환될 때 이 rax 레지스터에 담겨 반환됩니다. 그러나 rax가 리턴값을 위해서만 쓰이는 것은 아닙니다. 함수가 반환되기 전까지 범용 레지스터로 자유롭게 사용되다가, 종료 후 리턴값을 반환하기 위한 레지스터로는 rax만이 사용.

x64의 범용 레지스터들 중에서는 함수가 실행될때 필요한 인자들을 저장하는 용도로 사용하는 레지스터들도 있다. 이를 함수 호출 규약 (Calling Convention)이라고 부르며, 운영체제의 종류나 함수의 종류에 따라 조금씩 다르다.

rcx rdx r8 r9 는 Windows 64bit에서 함수를 호출할 때 필요한 인자들을 순서대로 저장한다. 즉, 첫번째 인자는 rcx에, 두번째 인자는 rdx에....하는 방식으로 인자를 레지스터에 담아 함수를 호출한다.

rax와 마찬가지로, 함수 호출 규약에 쓰이는 레지스터들 역시 함수를 호출할때 인자를 전달하는 용도로 이 레지스터들이 정해진다. 함수 호출된 이후에도 범용 레지스터로 자유롭게 사용가능하다.

rsp는 조금 특별하다. 16개의 범용 레지스터 중 하나로 분류되지만, 다른 범용 레지스터들과 달리 용도가 정해져 있다.
rsp는 스택 포인터(Stack Pointer)로, 스택의 가장 위쪽 주소를 가리킨다. 스택은 함수가 사용할 지역 변수들(local variables)을 저장하기 위해 준비해놓는 공간이다.
스택과 rsp에 대해서는 스택 명령어를 공부할 때 보다 자세히 알아보겠다.

## 명령어 포인터

명령어 포인터(Instruction Pointer)는 범용 레지스터들과 달리 그 용도가 엄격히 정해져 있는 레지스터이다. 

명령어 포인터인 rip는 다음에 실행될 명령어가 위치한 주소를 가리키고 있다. 즉 프로그램의 실행 흐름과 관련된 주요한 레지스터이므로 범용적으로 사용되지 않는다.



## Data Size

우리가 사용하는 64bit CPU인 x64의 레지스터들이 담을 수 있는 값의 크기는 64bit(8byte, QWORD)이다. 그러나 꼭 8 byte 단위로 저장해야 하는 것은 아니다.

그림과 같이 rcx 레지스터를 예로 들자면, rcx 레지스터에 저장된 값 하위 32bit (4byte,DWORD)만 연산에 사용할 수도 있고, 혹은 하위 16bit(2byte, WORD)나 하위 8bit(1byte,BYTE)만 사용하는 것도 가능하다. 이렇게 레지스터의 하위 비트만 접근하려면 어셈블리코드에서 접근할 레지스터 이름으로 ecx,cx를 사용하면 된다.



## FLAGS

알아볼 레지스터는 상태 레지스터인 FLAGS 입니다. '깃발'을 의미하는 단어 뜻 그대로, 현재 상태나 조건을 0과 1로 나타내는 레지스터입니다. 앞서 본 레지스터들과 달리, FLAGS 레지스터를 구성하는 64개의 비트들 각각이 서로 다른 의미를 지닙니다. 다시 말해 0번째 비트, 1번째 비트, 2번째 비트... 등 각각의 비트가 서로 다른 상태를 나타낸다고 볼 수 있습니다.

몇 번째 비트가 어떤 플래그인지를 상세히 알 필요는 없지만(디버거에 어떤 플래그인지 표시되기 때문입니다.), 몇 가지 중요한 플래그들에 대해서는 짚고 넘어가겠습니다.


### CF (Carry Flag)

더하거나 빼는 등의 산술 연산 혹은 bit shift/rotate(레지스터에 저장된 값의 비트를 한 자리씩 옮기는 것) 등의 연산이 일어났을 때, 자리 올림(carry)이 생기는 경우 CF의 값이 1이 됩니다.

CF의 특징은 연산에 사용된 값들에 부호가 없다는(unsigned) 점입니다.



### ZF (Zero Flag)


연산의 결과가 0일 때 ZF는 1이 됩니다. 아주 간단한 플래그이지만, 매우 널리 쓰입니다.

예를 들어 두 값의 크기를 비교할 때 CPU는 한 값에서 다른 한 값을 빼는 방식으로 비교하는데, 두 값이 같다면 연산의 결과가 0이 되어 ZF가 1이 되므로 ZF의 값을 확인하면 비교한 두 대상의 값이 같은지를 확인할 수 있게 됩니다.



### SF (Sign Flag)

CF가 부호 없는(unsigned) 값의 연산에서 쓰인다면, SF는 부호가 있는 (signed) 값의 연산에서 쓰여서 결과가 음수인지 혹은 양수인지를 가리킵니다. 수행한 결과가 양수일 때, 즉 최상위 비트가 0이면 SF=0, 반대로 결과가 음수가 되어 최상위 비트가 1이면 SF=1이 됩니다.


### OF (Overflow Flag)

OF는 부호가 있는 (signed) 값의 연산에서 CF의 역할을 합니다. 즉 부호가 없는 값을 연산할 때 자리 올림이 생길 경우 CF를 통해 표시했지만, 연산에 사용된 값들에 부호가 있을 경우에는 CF 대신 OF를 사용합니다. ‘overflow’ 라는 이름에서 알 수 있듯이 부호 있는 값들을 대상으로 산술 연산을 했을 때 자리 올림이 생겼다는 것은 표시할 수 있는 값의 범위를 넘어갔다(overflowed)는 것을 의미합니다.



## 4. Instruction Format

지금까지 레지스터에 대해 상세히 알아보았으니, 본격적으로 명령어에 대해 알아보자.

명령어를 구성하는 두개의 큰 요소인 명령 코드(Opcode)와 피연산자(Operand)에 대해 먼저 공부해보자.


### Opcode (Operation Code)

명령 코드(Opcode, Operation Code)는 명령어에서 실제로 어떤 동작을 할지 나타내는 부분이다. 자료를 옮기거나, 산술 연사을 하거나, 자료를 제어하는 등 다양한 종류의 명령 코드가 있다.

명령 코드(Opcode), 기계 코드(Machine Code), 어셈블리 코드(Assembly Code)등 비슷한 용어가 계속해서 등장하니 간단한 용어를 정리하자.


#### 기계 코드 (Machine code) 또는 명령 코드(Opcode)

컴파일러가 만드는 결과물인 바이너리를 구성하고 있고, CPU가 실제로 수행할 작업을 나타내는 숫자이다. 디버거를 이용해 프로그램을 살펴보면, 숫자처럼 생긴 명령 코드를 확인할 수 있다. 이 명령 코드는 CPU의 종류별로 다른 값일 수도 있고, 명령 코드에 따라 피연산자(Operand)가 필요하기도 하다.


#### 어셈블리 코드 (Assembly Code)

숫자로 이뤄져 있는 명령 코드는 사람이 구분하고 이해하기 쉽지 않다. 따라서 이것이 어떤 의미를 갖는지 알아보기 쉽도록 문자로 작성된 (Mnemonic) 코드이다. 명령 코드를 알아보기 쉽도록 문자를 치환할 것이므로, 앞서 말한 것처럼 명령 코드와 1:1로 대응된다. 뿐만 아니라 명령 코드가 연산할 때 사용할 피연산자도 알아보기 쉽다. 명령 코드와 피연산자를 묶어 하나의 명령어(Instruction)가 된다.

어셈블리 코드는 CPU의 동작을 그대로 옮겨놓은 것에 가깝기 때문에 매우 직관적이고 단순한 반면, 실제로 소스코드와 달리 고차원적인 전체 흐름을 파악하기 어렵다. 


### Operand

명령 코드가 연산할 대상을 피연산자(Operand)라고 한다. 명령 코드를 함수라고 생각하면, 피연산자는 함수에 들어가는 인자라고 생각하면 조금 더 이해하기 쉽다. 명령 코드에 따라 조금씩 다를 수 있지만, Intel 방식의 어셈블리를 읽을 때에는 명령 코드에 따라 연산한 결과를 오니쪽 피연산자에 저장된다고 이해하는게 일반적이다.

명령 코드가 작업을 수행할 대상인 피연산자는 어떤 상수일 수도 있고, 레지스터에 들어가 있는 값일 수도 있으며, 어떤 주소에 들어있는 값일 수도 있다.

```
mov   rbp,rsp      ; rbp = rsp
mov   eax,0x0      ; eax = 0x0
add   rcx,0x8      ; rcx = rcx+0x8
dec   rcx          ; rcx = rcx-1
```


### Operand Types

주어진 명령 코드의 피연산자로는 상수, 레지스터, 혹은 레지스터가 가리키고 있는 메모리의 어떤 주소가 올 수 있다.

#### 상수값(Immediate)

가장 간단한 케이스로, 피연산자로 사용되는 값이 상수인 경우다.
```
mov   rcx,0xbeef
add   rcx,0x1337
```

#### 레지스터

레지스터도 피연산자로 사용될 수 있다. 이 경우에는 레지스터에 들어가 있는 값이 피연산자로 사용된다.
```
mov   rcx,rbx      ; rcx = rbx   
sub   rcx,rax      ; rcx = rcx - rax
```

#### Addressing Modes

리버싱을 할 때 매우 자주 볼 수 있는 사례로, 레지스터에 있는 값이 피연산자가 되는 것이 아니라 레지스터에 저장된 메모리 주소를 참조한 값이 피연산자가 되는 경우이다. 다시 말해 레지스터에 들어가 있는 값은 메모리 주소로, 실제로는 해당 메모리 주소를 참조한 값이 피연산자로 사용된다. C언어 포인터 개념과 유사. 

* [reg]
오른쪽의 첫번째 예시를 보면, mov 명령어의 결과로 rax 에 들어있는 값을 rcx 레지스터가 참조하는 주소의 메모리에 저장하게 된다.
오른쪽의 두번째 예시에서 사용된 byte ptr은 Pointer Directive라고 하며, 앞서 공부한 Data Size가 실제 어셈블리 코드에서 사용된 케이스다. 즉 rax 레지스터가 저장하고 있는 값 중 하위 8bit, 곧 1byte만 rcx 가 참조하는 주소에 저장하게 된다.

```
mov   [rcx],rax                   ; *rcx = rax
mov   byte ptr [rcx],al           ; *rcx = al
```

레지스터의 값이 메모리 주소로 바로 쓰이기도 하는 반면, 레지스터에 들어있는 값에서 특정 오프셋(offset)만큼 떨어진 주소값을 참조하기도 한다. 


* [reg+d]
레지스터에 들어있는 값을 주소의 기준으로 하여 d 만큼 떨어진 오프셋을 실제로 참조한 다음 피연산자로 쓴다.
오른쪽의 세번째 예시를 보면, rax 레지스터에 들어있는 값을 저장할 때 rbp 의 값을 참조한 메모리 주소에 바로 넣는 것이 아니라, 그 메모리 주소로부터 -0x1C 떨어진 곳을 계산하여 넣는다. 여기서도 등장하는 Pointer Directive를 고려하면, DWORD에 해당하는 사이즈인 하위 4byte만 넣는 것을 알 수 있다.

```
mov   dword ptr [rbp-1Ch],eax      
```


* [reg1+reg2*i+d]

가장 복잡해 보이지만, 그만큼 많이 쓰이기도 한다. 구조체가 사용된 경우 등에서 자주 보이는 방식이다.
오른쪽 예시 중 네번째를 보면 rdi 레지스터에 담긴 주소를 기준으로, rcx 레지스터의 값을 단위로 하여 4단위 떨어진 곳에 다시 offset 3만큼 더한 주소를 실제로 참조하고 있다. 여기에 1byte 사이즈의 값인 0xff가 저장된다.
reg2에 해당하는 레지스터에 담긴 값은 대개 자료형이나 구조체의 크기인 경우가 많다.

```
mov   byte ptr [rdi+rcx*4+3],0FFh 
```


### Instructions

#### Data Movement
값을 레지스터나 메모리 주소에 옮기는 명령어들.

mov
mov는 src에 들어있는 값을 dst로 옮긴다.

lea
lea는 Load Effective Address로, dst에 주소를 저장한다.

```
mov    dst,src       ; dst = src
lea    dst,addr      ; dst = addr
```

#### Arithmetic Operations
산술 연산과 관련된 것들. 따라서 FLAGS 레지스터의 CF, OF, ZF 등과 관련이 있음.

##### Unary Instructions

inc, dec
dst 의 값을 1 증가시키거나 감소.

neg
dst 에 들어있는 값의 부호를 바꿈(2의 보수).

not
dst 에 들어있는 값의 비트를 반전(bitwise inverse).

 
##### Binary Instructions

add
dst에 들어있는 값에 src를 더함.

sub
dst에 들어있는 값에 src를 뺀다.

imul
dst에 들어있는 값에 src를 곱함.

and
dst에 들어있는 값과 src간에 AND 논리연산을 한 결과를 dst에 저장.

or
dst에 들어있는 값과 src간에 OR 논리연산을 한 결과를 dst에 저장.

xor
dst에 들어있는 값과 src간에 XOR 논리연산을 한 결과를 dst에 저장.

##### Shift Instructions

shl, shr
dst의 값을 k만큼 왼쪽이나 오른쪽으로 shift합니다. 
이 때 shift는 logical shift이므로, shr의 경우 오른쪽으로 shift할 때 빈 bit 자리에는 0이 채워진다.

sal, sar
dst의 값을 k만큼 왼쪽이나 오른쪽으로 shift하는 것은 같지만, arithmetic shift이기 때문에 부호가 보전된다. 따라서 sar은 최상위비트(MSB, Most Significant Bit)가 shift 이후에도 보전된다.



#### Conditional Operations

##### test
```
test   rax,rax       ; if rax AND rax = 0 then ZF=1
                     ; if rax AND ras < 0 then SF =1
```

##### cmp

```
cmp    rax,rdi       ; ZF=1 if rax = rdi
                     ; ZF=0 if rax!= rdi
                     ; CF=1 if rax < rdi
                     ; CF=0 if rax > rdi
```

##### jmp, jcc

jmp 및 jcc는 피연산자가 가리키는 곳으로 점프한다는 점은 같지만, 무조건 점프하는 것과(jmp) 조건에 따라 점프의 수행 여부가 달라진다는 (jcc) 점에서 중요한 차이가 있다.

특히 jcc가 사용하는 조건은 FLAGS 레지스터의 플래그와 밀접한 관련이 있다. 이 경우 점프 명령어를 수행하기 전에 어떤 산술 연산을 하거나, test, cmp 등의 연산을 수행한 결과로 바뀐 플래그를 바탕으로 점프의 수행 여부를 결정한다.

jcc는 명령어의 이름이 아니라, 조건부 jmp를 묶어서 이르는 이름이다 (Jump if condition is met).


```
jmp    location
je     location      ; equal (ZF=1)
jne    location      ; not equal (ZF=0)
jg     location      ; >   signed
jge    location      ; >=  signed
jl     location      ; <   signed
jle    location      ; <=  signed
ja     location      ; >   unsigned
jb     location      ; <   unsigned
js     location      ; negative (SF=1)
jns    location      ; not negative (SF=0)
```




오른쪽 아래의 예시 중 첫번째는 cmp 명령어의 결과를 바탕으로 jle 명령어를 수행하는 내용이다. rbp 레지스터가 가리키는 주소에서 -0x2c만큼 떨어진 곳에 들어있는 값과 0x47을 비교하여, 이 값이 0x47보다 작거나 같으면(less or equal) 0x400a31로 점프한다.
두번째 예제는 test 명령어를 수행한 결과로 je의 수행 여부가 정해지는 내용이다. 만약 rax가 0이면 test 명령어를 수행한 뒤 ZF=1이 되므로, je 명령어에 의해 0x4006c5로 점프하게 된다.
주어진 조건을 만족하지 않을 경우에는 jcc를 수행하지 않고 다음으로 넘어간다.

```
cmp   dword ptr [rbp-0x2c], 0x47
jle   400a31
test  rax,rax
je    4006c5
```


#### Stack Operations

스택과 관련된 명령어들. 프로그램이 동작하는 동안 함수 안에서 지역변수를 사용할 떄가 많다. 지역 변수는 함수가 종료되면 더 이상 참조하거나 사용되지 않기 때문에, 함수 않에서는 마치 연습장과 같은 역할을 한다. 지역 변수들은 "스택"에 저장된다. 스택은 레지스터가 아닌 메모리에 준비된다. 새로운 함수가 시작될 때 스택이 준비되고, 함수가 종료될때 스택이 정리된다. 이 과정은 레지스터들 중 스택의 가장 윗부분을 가르키는 rsp 레지스터와 밀접한 관련이 있다.

##### rsp revisit

rsp는 스택 포인터로, 스택의 가장 위쪽 주소를 가리킨다. 스택에 새로운 데이터를 담을 수록 스택이 점점 길어진다. 스택의 가장 위쪽은 마지막으로 데이터가 담긴 메모리 주소이다. 
아키택처에 따라 새로운 데이터가 추가될 때 더 높은 메모리 주소가 쌓이는 경우도 있고, 그 반대의 경우도 있다.
우리가 다루는 Intel x86-64 아키택처에서 스택은 낮은 주소(더 작은 숫자)를 향해 자라기 때문에 스택이 자랄수록 rsp에 저장된 메모리 ㅈ소는 점점 낮아진다.


##### Function Prologue/Epilogue

함수가 시작될 때 (Function Prologue)에는 rsp 레지스터에 들어있는 주소에서 충분한 값을 빼준다. rsp가 가리키는 곳을 낮은 주소로 당겨오는 효과가 있기 떄문에, 함수 안에서 지역 변수를 사용하기 위한 공간을 확보하는 효과가 생긴다. 이때, rsp를 얼마나 내릴 것인지, 즉 스택을 어느 정도 크기로 확보할 것인지는 컴파일러가 최적화를 통해 결정한다.
반대로 함수가 끝날때 (Function Epilogue)에는 프롤로그에서 빼준 값 만큼 다시 rsp를 더해준다. 이렇게 스택 포인터를 복원하면 함수에서 사용했던 스택을 정리하는 효과를 볼 수 있다.

###### push, pop

새로운 데이터가 들어가면 rsp 레지스터도 새로운 데이터가 들어간 주소를 가리켜야 하므로, push는 1) rsp가 가리키는 주소에서 들어갈 데이터의 사이즈만큼 빼서 데이터가 들어갈 크기를 확보한 뒤 2) 데이터를 복사하는 과정과 동일하다.
pop는 push 와 반대로 스택의 최상단에 있는 데이터를 빼내므로, 그 반대.

```
push   rdi           ; sub  rsp,8
                     ; mov  [rsp],rdi
pop    rdi           ; mov  rdi,[rsp]
                     ; add  rsp,8
```

##### Procedure Call Instructions

함수를 호출하는 명령어와 함수를 종료하는 명령어이다.

###### call 
함수를 실행할 때에는 call 명령어가 쓰인다. call은 피연사자로 실행할 함수로 주소를 받는다. 한편, call로 호출한 함수가 종료되고 다음 명령어를 실행할 장소로 돌아와야 한다. 즉 call을 사용한 이후에 실행되어야 하는 명령어의 주소가 어딘지 기억해둬야 함수가 종료된 다음에도 프로그램을 실행을 이어갈 수 있다. 이렇게 함수의 종료 이후에 돌아와야하는 주소, 즉 리턴할 때 참조해야할 주소를 Return Adress라고 부른다. call의 수행은 Return Address를 스택에 push 해둔 다음, 호출할 함수의 주소로 jmp 하는 것과 동일한 원리다.

###### ret
호출된 함수가 마지막으로 사용하는 명령어는 ret이다. 이 명령어는 함수를 종료한 뒤 Return Address로 돌아가는 역할을 한다. 따라서 스택에 들어있는 Return Address를 pop해 명령어 포인터인 rip 레지스터에 넣은 다음, 그 주소로 jmp하는 것과 동일한 효과를 낸다.
ret 명령어를 사용하기 전까진 함수에서 스택을 모두 정리한 상태이다. 따라서 Function Epilogue까지 마무리되어 있으므로 rsp는 함수가 시작하기 직전에 스택에 넣은 값을 가리키고 있다. 이 값은 call할때 스택에 넣었던 Return Address이므로, pop을 하면 스택에서 Return Address를 가져오게 된다.

```
call   location      ; push retaddr
                     ; jmp  location
ret                  ; pop  rip
                     ; jmp  rip
```






# puts("hello world!\n"); -> x86_64 asm


## hello world

C로 짜여진 hello world!를 출력하는 코드가 어떤 식으로 어셈블리 코드로 바뀌었는지 확인해보는 것을 통해 어셈블리 코드에 대한 기초, C코드가 어떻게 어셈블리 코드로 바뀌어있는지 공부.

64비트 릴리즈 모드로 컴파일. 프로그램 명은 consoleapplication1

```
#include <stdio.h>
int main(){
    puts("hello world!\n");
    return 0;
}
```



1. 주소

해당 어셈블리 코드의 시작 주소가 여기에 표시.

2. 기계 코드

사람이 읽을 수 있는 어셈블리 코드의 전 단계인 기계어가 여기에 표시. : 앞에 있는 값은 prefix 이고 띄어쓰기 다음에 있는 부분은 어셈블리 코드의 2번째 인자 부분.

3. 어셈블리어

비교적 사람이 읽기 쉬운 형태인 어셈블리 코드가 여기에 표시. 주소값의 경우 x64dbg가 적절한 형태로 바꾸어서 보여주기도 함. 3번째 줄을 보면 &puts라고 표시해주는것을 확인할 수 있음.

4. 코멘트

x64dbg가 프로그램을 분석하여 알게 된 추가적인 정보가 여기에 표시. 2번째 줄을 보면 7FF6ED802220 에 있는 문자열에 대한 정보가 표시되는 것을 확인할 수 있다. 여기서는 x64dbg를 기준으로 설명했지만 다른 디스어셈블러도 비슷한 형태로 표시해준다. 다만 디스어셈블 창에 보이는 숫자는 설정에 따라 0x가 없어도 16진수로 읽어야 하는 경우가 많으며, 하단에 나와있는 디스어셈블 결과의 경우 0x가 없지만 전부 16진수로 표기되어 있다.


```
7FF6ED801000 | 48:83EC 28       | sub rsp,28                          |
7FF6ED801004 | 48:8D0D 15120000 | lea rcx,qword ptr ds:[7FF6ED802220] | 00007FF6ED802220:"hello world!\n"
7FF6ED80100B | FF15 5F110000    | call qword ptr ds:[<&puts>]         |
7FF6ED801011 | 33C0             | xor eax,eax                         |
7FF6ED801013 | 48:83C4 28       | add rsp,28                          |
7FF6ED801017 | C3               | ret                                 |
```


## 디스어셈블리 결과 살펴보기

### sub rsp, 28
해당 명령어는 rsp에서 0x28만큼 빼 함수 내부에서 사용할 스택의 용량을 확보하는 명령어.
보통 함수에서 지역변수로 선언한 값들이 스택에 위치하게 되는데, 이 지역변수들이 저장될 공간을 컴파일러가 미리 계산하여 함수 시작부분에 확보.

잘 생각해보면 이상한 점이 있는데 소스코드와 디스어셈블 결과를 살펴보면 지역변수를 사용하는곳이 전혀 없음. 그런데도 0x28만큼 스택을 확보한 이유는 shadow space 또는 home space 라 불리는 공간을 확보하고 성능향상을 위한 메모리 사용 최적화가 적용되었기 때문.

### lea rcx,qword ptr ds:[7FF6ED802220]
해당 명령어는 rcx에 0x7FF6ED802220 값을 저장. 0x7FF6ED802220는 주소값이며 x64dbg가 생성한 디스어셈블 결과의 코멘트 부분을 확인해보면 puts의 첫번째 인자인 hello world!\n 가 위치한 주소인 것을 알 수 있음.

x64에는 많은 레지스터들이 존재하는데, puts의 첫번째 인자를 rcx에 넣은 이유는 사람들이 정해둔 규칙이 있기 때문. 이를 calling convention, 한국어로 함수 호출 규약이라 함.
함수 호출 규약은 한 가지가 아니며 여러 종류가 있는데 이 강좌에서는 보편적으로 사용되며 아래 예제에서도 사용된 64비트 Windows의 함수 호출 규약에 대해 설명.

windows의 함수 호출 규약은 다음과 같은 순서로 첫 4개의 인자를 받음.

rcx(ecx, cx, …)
rdx(edx, dx, …)
r8(r8d, r8w, …)
r9(r9d, r9w, …)
이후 5번째 인자부터는 스택에 넣게 됨. 함수의 리턴값은 rax(eax, ax, …)에 저장.

8개의 인자를 받는 함수의 디스어셈블 결과를 살펴보면 하단과 같이 나오게 됨.
살펴보면 rcx(ecx), rdx(edx), r8(r8d), r9(r9d)에 4번째 인자까지 넣고 5~8번째 인자는 미리 확보해둔 스택 영역에 저장하는것을 확인할 수 있음.

## call qword ptr ds:[<&puts>]
해당 명령어는 puts를 호출하는 명령어.

## xor eax,eax
해당 명령어는 eax를 0으로 만들어주는 명령어. main함수의 리턴값을 0으로 설정해놨기 때문에 함수의 리턴값을 의미하는 eax 레지스터를 0으로 설정하는 것. 이때 mov eax, 0 를 쓰지않고 xor을 통해서 하는 이유는 명령어의 길이가 짧고(5 bytes vs 2 bytes) CPU에서 좀더 빠르게 실행시키기 때문.

## add rsp,28
해당 명령어는 함수 시작시 확보해두었던 스택을 정리하는 명령어.

## ret
해당 명령어는 함수의 실행을 마치고 리턴하기 위해 사용하는 명령어. call 명령어를 통해 스택에 저장된 리턴 어드레스로 돌아감.

```
7FF611801040 | sub rsp,48                            |
7FF611801044 | mov dword ptr ss:[rsp+38],8           |
7FF61180104C | mov dword ptr ss:[rsp+30],7           |
7FF611801054 | mov dword ptr ss:[rsp+28],6           |
7FF61180105C | mov dword ptr ss:[rsp+20],5           |
7FF611801064 | mov r9d,4                             |
7FF61180106A | mov r8d,3                             |
7FF611801070 | mov edx,2                             |
7FF611801075 | mov ecx,1                             |
7FF61180107A | call consoleapplication1.7FF611801000 |
7FF61180107F | xor eax,eax                           |
7FF611801081 | add rsp,48                            |
7FF611801085 | ret                                   |
```




# x64dbg

x64dbg는 윈도우 디버거.
x64dbg는 강력한 디스어셈블 엔진을 가지고 있으며 그래프 뷰, 플러그인 등 리버싱에 있어서 편리한 여러가지 기능들이 내장됨.


F2

소프트웨어 브레이크 포인트를 걸 때 사용하는 단축키. 이미 브레이크 포인트가 걸려있는 주소에서 누를 경우 브레이크 포인트를 삭제.

F7

어셈블리 코드를 한 줄 실행합니다. 만약 call을 실행하려 하면 call한 함수 내부로 진입.

F8

어셈블리 코드를 한 줄 실행. 만약 call을 실행하려 하면 call한 함수가 ret 명령어를 실행할 때까지(리턴할 때까지) 실행한 다음 멈춤.

F9

프로그램의 실행을 재개.

ctrl + g

현재 창이 보여주는 주소를 바꿈. 디스어셈블 창에서 사용하면 디스어셈블 창이 해당 주소로 가고, 헥스덤프 창에서 사용하면 헥스덤프 창이 해당 주소로 가는 식. 주소값 말고도 간단한 사칙 연산이나 함수명도 인식.




주소와 어셈블리 코드와 x64dbg나 사용자가 단 주석이 여기에 표시됨.
왼쪽서부터

주소
옵코드
기계어 코드
주석
의 순서로 표시.
주소 부분에는 함수명을 알고 있을경우 함수명이 표시됨. 현재 rip(instruction pointer)가 가리키는 부분은 검은색 배경으로 표시해주며 브레이크 포인트가 걸려있는 경우 빨간색 배경으로 표시됨.
주석 부분에 x64dbg가 주석을 다는 경우로는 여러 가지가 있음. 가장 흔한 경우는 어셈블리 코드에서 가리키는 주소가 문자열이거나 익스포트된 함수일 경우. 해당 경우에는 주석에 문자열이나 함수의 이름을 표시해줌.

이곳에서 jmp나 call같은 실행 흐름을 바꾸는 어셈블리 코드를 선택하고 enter 키를 누르면 해당 부분으로 이동합니다. 되돌아올땐 -키를 사용합니다. 

현재 CPU의 레지스터 상태가 여기에 표시.
아래로 스크롤하면 xmm과 같은 부동소수점 관련 레지스터의 상태도 볼 수 있음.

1번창에서 선택한 부분에 대한 정보가 여기에 표시. 이 부분에는 1번창 주석에 표시되지 않는 내용까지 상세히 표시.

현재 레지스터 상태중 rcx, rdx, r8, r9값을 보여줌. 2번창과 별도로 보여주는 이유는 해당 레지스터 순서가 Windows 64비트 운영체제에서 기본적으로 사용하는 함수 호출 규약(Calling Convention)의 인자 순서이기 때문. 이를 통해 call 명령어에서 쉽게 인자로 어떤값들이 넘어가는지 확인할 수 있음.

핵스값을 보여줌. 프로그램 실행에 따라 자동으로 보여주지는 않으며 다른 창에서 헥스값을 보는 명령을 내리면 이 창에서 보여지게 됨.

스택값을 보여줌. 기본적으로 rsp값을 따라서 보여주게 됨. 가운데 부분의 파란색 선은 한 함수의 스택 영역을 나타냄. 

# 쉬운 crackme를 통한 디버거 사용법

## 분석

```
1|140001200 | sub rsp,38                         |
2|140001204 | lea rcx,qword ptr ds:[140002230]   | 140002230:"input: "
2|14000120B | call <easy-crackme1.sub_140001070> |
3|140001210 | lea r8,qword ptr ss:[rsp+20]       |
3|140001215 | lea rdx,qword ptr ss:[rsp+24]      | rdx:EntryPoint
3|14000121A | lea rcx,qword ptr ds:[140002238]   | 140002238:"%d %d"
3|140001221 | call <easy-crackme1.sub_140001120> |
4|140001226 | mov edx,dword ptr ss:[rsp+20]      |
4|14000122A | mov ecx,dword ptr ss:[rsp+24]      |
4|14000122E | call <easy-crackme1.sub_140001180> |
5|140001233 | test eax,eax                       |
5|140001235 | je easy-crackme1.140001246         |
5|140001237 | lea rcx,qword ptr ds:[140002240]   | 140002240:"correct!"
5|14000123E | call qword ptr ds:[<&puts>]        |
5|140001244 | jmp easy-crackme1.140001253        |
5|140001246 | lea rcx,qword ptr ds:[14000224C]   | 14000224C:"wrong!"
5|14000124D | call qword ptr ds:[<&puts>]        |
6|140001253 | xor eax,eax                        |
6|140001255 | add rsp,38                         |
6|140001259 | ret                                |
```





1) 스택을 확장하는 코드. 이 함수에서는 0x38만큼 스택을 사용한다.

2) 첫 번째 인자에 input: 문자열의 주소를 넣고 sub_140001070함수를 호출. sub_140001070내부로 들어가서 분석할 수도 있지만, 여기서는 프로그램의 동작과 인자만으로도 printf이거나 printf와 비슷한 함수라는 것을 충분히 알 수 있기 때문에 내부 함수 분석은 넘어가도 됨. 이와 같이 내가 분석할 대상의 중요한 부분이 아니라면 적당히 추측하고 넘어가는 것이 분석 시간을 단축하는 데 있어 중요한 요소 중 하나.

3) 첫 번째 인자에 %d %d문자열의 주소를 넣고, 두 번째 인자에 rsp+0x24, 세 번째 인자에 rsp+0x20을 넣고 sub_140001120를 호출. 첫 번째 인자와 함수 호출 시점을 미뤄봤을 때 sub_140001120가 scanf라는 것을 추측할 수 있음. 그리고 rsp+0x24와 rsp+0x20에는 각각 입력한 첫번째 숫자와 두번째 숫자가 4바이트 정수형으로 들어간다는 것도 알 수 있음.

4) 첫 번째 인자에 rsp+0x24, 두 번째 인자에 rsp+0x20을 넣고 sub_140001180를 호출. 즉 입력받은 두 숫자를 인자로 받음.

5) sub_140001180함수의 리턴값인 eax를 확인해 0이면 점프를 뛰어 wrong! 이 출력되고 1이면 점프를 안 뛰어 correct!을 출력함. 이를 통해 sub_140001180함수가 입력받은 숫자를 검사하는 함수라는 것을 확실하게 알 수 있음.

6) main함수의 리턴값을 0으로 설정하고 확장한 스택을 정리한 후 리턴.

main함수를 분석해본 결과 결국 입력받은 값을 처리하는 부분은 sub_140001180라는 것을 알 수 있다.
<<<<<<< HEAD

## sub_140001180 분석

해당 함수의 디스어셈블 결과(오른쪽 상단 코드, 일부 생략됨)를 보면 jmp와 jcc코드가 많이 복잡해 보인다. 이렇게 주소를 기준으로 어셈블리어를 보여주는 형태는 이 함수처럼 분기문이 많은 함수를 보여주기에 적합하지 않다. 대신 그래프를 사용해서 보면 상당히 직관적으로 함수를 살펴볼 수 있는데, x64dbg는 그래프로 보기 기능을 지원한다. 


그래프는 노드(코드 부분)와 엣지(선)로 이루어져 있는데, 엣지의 색에 의미가 있다. 그 의미는 다음과 같다.

* 초록색: jcc명령어에서 분기를 취했을 때 가는 노드

* 빨간색: jcc명령어에서 분기를 취하지 않았을 때 가는 노드

* 파란색: 항상 분기를 취하는 노드


### 그래프 분석

1. 1번 노드(시작 부분)

인자로 받은 ecx(첫 번째 인자)와 edx(두 번째 인자)를 각각 rsp+0x8과 rsp+0x10에 저장. 하지만 이후 sub rsp, 0x18 명령어 때문에 이후 rsp를 통해 저장된 인자에 접근할 때는 rsp+0x8이 아닌 rsp+0x20, rsp+0x10이 아닌 rsp+0x28로 접근하게 됨.

2. 9번 노드

함수의 끝 노드. 확장한 스택을 정리하고 ret하는 코드밖에 없음.

3. 6, 7, 8번 노드

9번 노드(함수의 끝)와 연결된 노드들. 자세히 보시면 노드들이 함수의 리턴값인 eax를 설정한다는 것을 볼 수 있음. 6번과 8번 노드는 eax를 0으로, 7번 노드는 eax를 1로 설정.

앞서 메인함수 분석에서 sub_140001180가 1을 리턴했을때 correct!가 출력된다는 사실을 생각해 봤을 때, 6번 노드와 8번 노드를 지나가면 안 되고 무조건 7번 노드를 지나가야만 된다는 사실을 알 수 있음. 이를 생각했을 때 correct!를 출력하는 함수의 흐름은 다음과 같다.

1→2→3→4→5→7→9

이와 같은 흐름으로 실행되어야 1이 리턴되며 메인함수에서 correct!가 출력되게 만들 수 있음. 





* 1번 노드 → 2번 노드
첫 번째 분기문은 1번 노드. 1번 노드 끝 부분을 보면 cmp명령어 후 분기하는 것을 확인할 수 있음.

```
cmp dword ptr ss:[rsp+20],2000 ; rsp+0x20(첫번째 인자)과 0x2000을 비교한다
ja easy-crackme1.1400011A0 ; Jump short if above
```

2번 노드로 가기 위해서는 점프를 뛰지 말아야 하고(빨간색선) ja명령어니까 rsp+0x20(첫번째 인자)가 0x2000보다 작거나 같아야 함.



* 2번 노드 → 3번 노드
두 번째 분기문은 2번 노드. 1번 노드와 비슷한 명령어로 분기하는 것을 볼 수 있음.

```
cmp dword ptr ss:[rsp+28],2000 ; rsp+0x28(두번째 인자)과 0x2000을 비교한다
jbe easy-crackme1.1400011A4 ; Jump short if below or equal
```
3번 노드로 가기 위해서는 점프를 뛰어야 하고(초록색선) jbe명령어니까 rsp+0x28(두 번째 인자)가 0x2000보다 작거나 같아야 함.



* 3번 노드 → 4번 노드
```
mov eax,dword ptr ss:[rsp+20] ; eax = 첫 번째 인자
imul eax,dword ptr ss:[rsp+28] ; eax = eax * 두 번째 인자
mov dword ptr ss:[rsp],eax ; [rsp] = eax
xor edx,edx ; edx = 0
mov eax,dword ptr ss:[rsp+20] ; eax = 첫 번째 인자
div dword ptr ss:[rsp+28] ; eax = edx:eax / 두 번째 인자
mov dword ptr ss:[rsp+4],eax ; [rsp+4] = eax
mov eax,dword ptr ss:[rsp+28] ; eax = 두 번째 인자
mov ecx,dword ptr ss:[rsp+20] ; ecx = 첫 번째 인자
xor ecx,eax ; ecx = ecx ^ eax
mov eax,ecx ; eax = ecx
mov dword ptr ss:[rsp+8],eax ; [rsp+8] = eax
cmp dword ptr ss:[rsp],6AE9BC ; [rsp]와 0x6ae9bc을 비교한다.
jne easy-crackme1.1400011F1 ; Jump short if not equal
```

어셈블리어 부분을 빼고 정리하면 다음과 같다.

```
eax = 첫 번째 인자
eax = eax * 두 번째 인자
[rsp] = eax
edx = 0
eax = 첫 번째 인자
eax = edx:eax / 두 번째 인자
[rsp+4] = eax
eax = 두 번째 인자
ecx = 첫 번째 인자
ecx = ecx ^ eax
eax = ecx
[rsp+8] = eax
# [rsp]와 0x6ae9bc을 비교한다.
```


코드를 한 번 더 정리해보면 다음과 같다.

```
[rsp] = 첫 번째 인자 * 두 번째 인자
[rsp+4] = 첫 번째 인자 / 두 번째 인자
[rsp+8] = 첫 번째 인자 ^ 두 번째 인자
# [rsp]와 0x6ae9bc을 비교한다.
```

복잡해 보이는 어셈블리어는 이러한 식으로 한 단계씩 변형해 나가면 쉽게 의미를 파악할 수 있음.

결국 3번 노드에서 4번 노드로 가기 위해서는 명령어가 jne이고 빨간색 선이니 첫 번째 인자 * 두 번째 인자가 0x6ae9bc이여야함.

* 4번 노드 → 5번 노드
네 번째 분기문은 4번 노드.


```
cmp dword ptr ss:[rsp+4],4 ; [rsp+4]와 4를 비교한다
jne easy-crackme1.1400011F1 ; Jump near if not equal
```

* 5번 노드 → 7번 노드
다섯 번째 분기문은 5번 노드.

```
cmp dword ptr ss:[rsp+8],12FC ; [rsp+8]과 0x12fc를 비교한다
jne easy-crackme1.1400011F1 ; Jump near if not equal
```


3번 노드에서 설정한 [rsp+8]가 0x12fc인지 비교하고 점프. 7번 노드로 가려면 명령어가 jne이고 빨간 선이니 [rsp+8]이 0x12fc이여야 함.



## solve.py 작성

지금까지 구한 조건을 정리하면 다음과 같다.

* 첫 번째 인자가 0x2000보다 작거나 같아야 한다
* 두 번째 인자가 0x2000보다 작거나 같아야 한다
* 첫 번째 인자 * 두 번째 인자 가 0x6ae9bc여야 한다.
* 첫 번째 인자 / 두 번째 인자 가 4여야 한다.
* 첫 번째 인자 ^ 두 번째 인자 가 0x12fc여야 한다.

이를 바탕으로 모든 경우의 수를 탐색하는 코드를 작성해보면 답을 구할 수 있음.




```
# $ python solve.py 
# answer: 5678 1234
for x in range(0x2000 + 1):
    for y in range(0x2000 + 1):
        if x * y != 0x6ae9bc:
            continue
        
        if x // y != 4:
            continue
        
        if x ^ y != 0x12fc:
            continue
        
        print('answer:', x, y)
```


### solve.py 개선

문제는 풀었지만, solve.py를 실행하보면 답이 나오는데 시간이 좀 걸린다는 것을 알 수 있다. 모든 경우의 수를 하나씩 체크하는 방식으로 답을 찾았기 때문에 느린 것인데, 어떤 문제의 경우는 이러한 방식으로 답을 찾을 경우 굉장히 오랜 시간이 걸리는 경우도 있다. 이 문제 역시 0x2000보다 작거나 같다란 조건이 없으면 굉장히 시간이 오래 걸렸을 것이다.

이번에는 solve.py를 조금 더 개선시켜서 매우 빠른 시간 안에 답이 나오도록 바꿔보도록 하겠다.

두 인자의 조건중 다음과 같은 조건이 있었다.

첫 번째 인자 ^ 두 번째 인자 가 0x12fc여야 한다.

xor은 특이한 성질을 가지고 있는데 수식으로 정리하면 다음과 같다. (A와 B와 C는 임의의 정수)

A ^ B ^ B == A

A ^ A == 0

A ^ B == C 일 때, C ^ A == B이고 C ^ B == A이다.

문제에서는 첫 번째 인자 ^ 두 번째 인자 == 0x12fc이니, 두 번째 인자 == 첫 번째 인자 ^ 0x12fc라는걸 알 수 있다. 이를 이용해 다시 solve.py를 작성한 것이 오른쪽의 코드. 직접 돌려보면 처음의 solve.py보다 훨씬 빠른 속도로 답이 나온다.




```
# $ python solve.py 
# answer: 5678 1234
for x in range(0x2000 + 1):
    y = x ^ 0x12fc
    if x * y != 0x6ae9bc:
        continue
    
    if x // y != 4:
        continue
        
    print('answer:', x, y)
```


## 답안

컴파일은 visual studio 2019를 통해 하였으며 x64 릴리즈 모드의 옵션은 다음과 같음.

C/C++
최적화: 사용 안 함(/Od)
SDL 검사: 아니요(/sdl-)
링커
임의 기준 주소: 아니요(/DYNAMICBASE:NO)
이외의 옵션은 기본값을 사용.



```
// easy-crackme.cpp
#include <stdio.h>
int check(unsigned int input1, unsigned int input2) {
    unsigned int tmp1;
    unsigned int tmp2;
    unsigned int tmp3;
    if (input1 > 0x2000 || input2 > 0x2000) {
        return 0;
    }
    tmp1 = input1 * input2;
    tmp2 = input1 / input2;
    tmp3 = input1 ^ input2;
    if (tmp1 == 0x6ae9bc && tmp2 == 4 && tmp3 == 0x12fc) {
        return 1;
    }
    else {
        return 0;
    }
}
int main() {
    unsigned int input1;
    unsigned int input2;
    printf("input: ");
    scanf_s("%d %d", &input1, &input2);
    if (check(input1, input2)) {
        puts("correct!");
    }
    else {
        puts("wrong!");
    }
    return 0;
}
```


=======
>>>>>>> d56020cc40662ec2f1a339d88833d406a0967026
