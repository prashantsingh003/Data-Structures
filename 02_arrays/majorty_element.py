# return the number that is present more thant n/2 times in a array with length n
nums=[1,1,1,2,1,5,6]

# Dict
def majority_num(arr):
	store={}
	for n in arr:
		if n in store.keys():
			store[str(n)]+=1
		else:
			store[str(n)]=1
	max_freq=0
	res=0
	for (n,freq) in store.items():
		if(freq>max_freq):
			max_freq=freq
			res=n
	if max_freq<=len(nums)//2:
		res=None
	return res

# print(majority_num(nums))

# MOORE BOYER MAJORITY VOTE ALGORITHYM
def moore_majority_element(nums):
	el=nums[0]
	count=0
	for n in nums:
		if el==n:
			count+=1
		else:
			if count-1==0:
				el=n
			else:
				count-=1
	count=0
	for n in nums:
		if n==el:
			count+=1
	if count>len(nums)//2:
		return el
	return None

arrays = [
    [1, 2, 2, 3, 2, 4, 2, 2, 5, 2],
    [3, 4, 3, 4, 2, 4, 4, 4, 5, 4, 4, 5, 4, 4, 5, 5, 5],
    [1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 7],
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    [2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5],
    [1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3],
    [3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6],
    [1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5],
    [5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9],
    [1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6]
]
for arr in arrays:
	print(arr)
	print(f"Using Hashmap:{majority_num(arr)}\tUsing Moore Voting Algo:{moore_majority_element(arr)}",end="\n\n")