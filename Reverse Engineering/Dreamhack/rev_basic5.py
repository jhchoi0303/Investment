#"Dreamhack"rev_basic5

from z3 import*
import binascii


a1 = [BitVec('a%i'%i,8) for i in range(0,24)]

byte_140003000=["AD","D8","CB","CB","9D","97","CB","C4","92","A1","D2","D7","D2","D6","A8","A5","DC","C7","AD","A3","A1","98","4C"]



for k in range (0,23):
    byte_140003000[k]=int(byte_140003000[k],16)


for q in range (48,124):
    s = Solver()

    s.add(a1[0]==q)

    for p in range (0,22):
        s.add(a1[p] + a1[p+1] ==byte_140003000[p])

    s.check()
    m = s.model()

    print("flag:",end='')
    for j in range (0,23):
        print(chr(int(str(m[a1[j]]))),end='')

    print('\n') #fine one that is plausible







