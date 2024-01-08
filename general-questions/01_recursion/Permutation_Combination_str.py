def getStrCombinations(str,i=0,current_str='',ans_arr=[]):
    if(i==len(str)):
        ans_arr.append(current_str)
        return
    getStrCombinations(str,i+1,current_str+str[i],ans_arr)
    getStrCombinations(str,i+1,current_str,ans_arr)
    return ans_arr

def get_all_permutations(nums): # will have duplicates in case of duplicates in the array
    def recurse(strArr,l,r,arr=[]): 
        if(l==r):
            arr.append([s for s in strArr])
            return
        for i in range(l,r+1):
            swap(strArr,l,i)
            recurse(strArr,l+1,r,arr)
            swap(strArr,l,i)
        return arr
    def swap(a,x,y):
        a[x],a[y]=a[y],a[x]
    
    if(len(nums)<2):
        return [nums]
    return recurse(nums,0,len(nums)-1)



# Python3 code for the same approach
def printAllPermutationsFast(s, l=''):
     
    if (len(s) < 1):
        print(l + s)
     
    uset = set()
     
    for i in range(len(s)):
        if s[i] in uset:
            continue
        else:
            uset.add(s[i])
         
        temp = ""
        if (i < len(s) - 1):
            temp = s[:i] + s[i + 1:]
        else:
            temp = s[:i]
         
        printAllPermutationsFast(temp, l + s[i])
         
printAllPermutationsFast("".join(sorted("ABC")))
