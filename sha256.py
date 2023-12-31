//SHA-256 Algorithm Compilation by Muhammad Azza Ulin Nuha

import hashlib

def sha256(inputhash):
    outputhash = \
        hashlib.sha256(inputhash.encode()).hexdigest()
    return outputhash

def xorString(string1, string2):
    panjang1 = len(string1)
    panjang2 = len(string2)
    if (panjang1>panjang2):
        for i in range (panjang1-panjang2):
            string2 = string2+'0'
    out2 = ""
    for j in range (panjang1):
        int1 = int(string1[j:j+1],16)
        #print(str(int1))
        int2 = int(string2[j:j+1],16)
        out = int1^int2
        out = str(out)
        out2 += out
    return out2

inputhash = 'abc'
outputhash = sha256(inputhash)
print("input : "+inputhash)
print("output : "+outputhash)
outputhash2 = outputhash[:15]
xor = xorString(outputhash, outputhash2)
print("Hasil XOR : "+xor)
# 3fef7ff0fc1660c6bd319b3a8109fcb9f81985eabcbbf8958869ef03d605a9eb
    




