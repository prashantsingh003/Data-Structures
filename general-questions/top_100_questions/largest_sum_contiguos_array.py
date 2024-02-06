# def fun(arr):
# 	res=[]
# 	for i in range(len(arr)):
# 		sub=[]
# 		for j in range(i,len(arr)):
# 			sub.append(arr[j])
# 		res.append(sub)
# 	return res

def get_all_combination(arr,i=0,curr=[],res=[]):
	if i == len(arr):
		res.append(curr)
		return
	get_all_combination(arr,i+1,curr+arr[i:i+1],res)
	get_all_combination(arr,i+1,curr,res)
	return res
def get_prod(arr):
	p=1
	for n in arr:
		p*=n
	return p
arr=[1,2,2,4]
target=4
print(get_all_combination(arr))