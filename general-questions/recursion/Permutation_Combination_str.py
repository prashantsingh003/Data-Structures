def getStrCombinations(str,i=0,current_str='',ans_arr=[]):
    if(i==len(str)):
        ans_arr.append(current_str)
        return
    getStrCombinations(str,i+1,current_str+str[i],ans_arr)
    getStrCombinations(str,i+1,current_str,ans_arr)
    return ans_arr

def permute(nums):
    if(len(nums)<2):
        return [nums]
    return getStrPermutation(nums,0,len(nums)-1)

def getStrPermutation(strArr,l,r,arr=[]):
    if(l==r):
        arr.append([s for s in strArr])
        return
    for i in range(l,r+1):
        swap(strArr,l,i)
        getStrPermutation(strArr,l+1,r,arr)
        swap(strArr,l,i)
    return arr
def swap(a,x,y):
    a[x],a[y]=a[y],a[x]
    return a
# print(getStrCombinations('0123456789'))
print(permute([x for x in "123"]))
