# Dreamhack rev_basic 07
arr=["52","0DF","0B3","60","0F1","8B","1C","0B5","57","0D1","9F","38","4B","29","0D9","26","7F","0C9","0A3","0E9","53","18","4F","0B8","6A","0CB","87","58","5B","39","1E"]


def ROR(num, count, bits=8):
    return ((num >> count) | (num << (bits - count))) & ((0b1<<bits) - 1)

flag_dec = 0

for index in range(0, len(arr)):
    arr[index] = ROR(int(arr[index],16)^index, index & 7)
    print(chr(arr[index]), end="")
