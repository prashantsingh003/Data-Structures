import math
def is_prime(n):
    if n in [1,2]:
        return True
    for i in range(1,int(math.sqrt(n))):
        if n%i==0:
            return False
    return True
def cal_lcm(arr,lcm):
    if len(arr)==0:
        return 1
    div=None
    for i in range(2,int(math.sqrt(max(arr)))):
        if not is_prime(i):
            continue
        comp_divide=True
        for n in arr:
            if n%i!=0:
                comp_divide=False
        if comp_divide:
            div=i
            break
    if div is None:
        return 1
    arr=[(x//div) for x in arr if x//div!=1]
    print(arr)
    lcm.append(div)
    return div*cal_lcm(arr,lcm)