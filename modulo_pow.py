
def hcf(a,b):
    return b if a%b==0 else hcf(b,a%b)
"""
(a*b)%n=(a%n * b%n) % n
(a±b)%n=(a%n ± b%n) % n
"""
def get_pow(a,b,mod):
    res=1
    while(b>0):
        if(b&1):
            res=(res * a%mod)%mod
        a=(a%mod * a%mod)%mod
        b=b>>1
    return res
num=3978432
pow=5
mod=1000000007
print(get_pow(num,pow,mod))