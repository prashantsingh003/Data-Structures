# def fun(arr):
# 	res=[]
# 	for i in range(len(arr)):
# 		sub=[]
# 		for j in range(i,len(arr)):
# 			sub.append(arr[j])
# 		res.append(sub)
# 	return res

def get_all_combination(arr,i=0,curr=[],res=[]):
	if i ==len(arr):
		res.append(curr)
		return
	get_all_combination(arr,i+1,curr+arr[i:i+1],res)
	get_all_combination(arr,i+1,curr,res)
	return res

def get_all_permutation(arr):
	def swap(a,m,n):
		a[m],a[n]=a[n],a[m]
	 
	def recurse(arr,l,r,res=[]):
		if(l==r):
			res.append([x for x in arr])
			return
		for i in range(l,r):
			swap(arr,l,i)
			recurse(arr,l+1,r,res)
			swap(arr,l,i)
		return res
	return recurse(arr,0,len(arr))

arr=[1,2,4]
target=4
print(get_all_permutation(arr))