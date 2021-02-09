# Dreamhack rev_basic3



byte_140003000=["49","60","67","74","63","67","42","66","80","78","69","69","7B","99","6D","88","68","94","9F","8D","4D","0A5","9D","45","0"]
str=""


for i in range (0,24):
    k=int(byte_140003000[i],16) #HextoDec
    print(k)

for i in range (0,24):
    str += (chr)(((int(byte_140003000[i],16)) - (2*i)) ^ i) #HextoDec, Inverse calculation (byte_140003000[i] = (i ^ *(unsigned __int8*)(a1 + i)) + (2 * i))

print("flag:" +str) 
