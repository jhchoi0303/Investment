import hashlib
import binascii

value= "129581926211651571912466741651878684928"
value=value.encode('utf-8')

value_md5=hashlib.md5(value)
value_hex= value_md5.hexdigest()
value_binary= value_md5.digest()

print(value_hex) #md 5 
print(value_binary) #md 5 true


or_hex= binascii.hexlify(b"'or'8")

print(or_hex) #or md5 true
