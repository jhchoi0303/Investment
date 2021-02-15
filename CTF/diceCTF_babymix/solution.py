from z3 import*

a1 = [BitVec('a%i'%i,8) for i in range(0,22)]

s = Solver()


s.add(a1[0]>32)
s.add(a1[0]<126)
s.add(a1[1]>32)
s.add(a1[1]<126)

s.add(a1[12] - a1[17] + a1[12] + a1[8] == 153)
s.add(a1[6] - a1[14] + a1[9] - a1[2] + a1[8] - a1[15] + a1[21] - a1[11] == -109)
s.add(a1[19] - a1[7] + a1[0] + a1[16] + a1[11] + a1[17] == 361)
s.add(a1[10] - a1[8] + a1[2] - a1[19] == 74)
s.add(a1[17] - a1[1] + a1[4] + a1[11] + a1[17] - a1[9] == 166)
s.add(a1[14] + a1[10] + a1[18] - a1[9] + a1[5] + a1[10] == 413)
s.add(a1[5] - a1[16] + a1[8] - a1[12] + a1[17] - a1[13] + a1[11] - a1[2] + a1[1] + a1[21] == 98)
s.add(a1[4] - a1[0] + a1[2] - a1[4] + a1[15] - a1[21] + a1[17] + a1[2] == 265)
s.add(a1[11] - a1[21] + a1[12] - a1[10] == 36)
s.add(a1[19] + a1[10] + a1[10] + a1[19] + a1[0] - a1[20] + a1[3] - a1[18] == 297)
s.add(a1[0] - a1[15] + a1[20] + a1[18] == 156)
s.add(a1[13] - a1[8] + a1[10] - a1[20] + a1[3] - a1[17] == 85)
s.add(a1[5] - a1[18] + a1[17] - a1[4] + a1[15] + a1[2] + a1[21] - a1[18] + a1[7] + a1[6] == 250)


s.add(a1[8] - a1[17] + a1[14] - a1[3] + ((a1[8]) ^ (a1[14])) + a1[5] + a1[1] + a1[7] + a1[10] == 384)
s.add(a1[10] + a1[21] +(a1[19] ^ a1[2]) == 217)
s.add((a1[5] ^ a1[16]) + a1[16] + a1[3] + (a1[0] ^ a1[16]) == 232)
s.add( a1[10] +  a1[3] +  a1[3] -  a1[19] + (a1[19] ^ a1[0]) == 328)
s.add( (a1[19] ^ a1[13]) + a1[6] - a1[13] + a1[17] - a1[11] +  (a1[16] ^ a1[12]) == 85)
s.add( a1[4] -  a1[16] +  (a1[2] ^ a1[7]) == 77)
s.add(a1[21] - a1[19] + a1[7] - a1[18] + a1[16] - a1[21] +  (a1[12] ^ a1[18]) == 75)
s.add( (a1[10] ^ a1[2])+  a1[2]+  a1[7]+  a1[20]+  a1[13]+  (a1[3] ^ a1[16])+  a1[9]+  a1[6] == 621)
s.add(a1[8] - a1[3] +  (a1[14] ^ a1[2]) + a1[11] + a1[0] + a1[1] - a1[19] == 283)
s.add( a1[16] -  a1[14] +  (a1[0] ^ a1[11]) +  (a1[0] ^ a1[14]) +  a1[13] -  a1[19] == 106)
s.add(a1[3] - a1[17] + a1[19] + a1[4] +  (a1[12] ^ a1[17]) + a1[10] - a1[2] == 160)
s.add( (a1[18] ^ a1[19]) +  a1[6] -  a1[16] +  (a1[5] ^ a1[16]) == 102 )
s.add(a1[6] - a1[13] +  (a1[10] ^ a1[15]) + a1[21] - a1[5] == -48)
s.add( (a1[5] ^ a1[3]) +  a1[12] -  a1[11] +  (a1[6] ^ a1[4]) == 29)
s.add(a1[3] + a1[15] +  (a1[15] ^ a1[19]) == 296)


    
s.check()
m = s.model()

print("flag:",end='')
for j in range (0,22):
    print(chr(int(str(m[a1[j]]))),end='')


