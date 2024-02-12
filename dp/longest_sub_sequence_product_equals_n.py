from functools import reduce
def get_all_combinations(arr,i=0,current_arr=[],res=[]):
	if i == len(arr):
		if len(current_arr)>0:
			res.append(current_arr)
		return
	get_all_combinations(arr,i+1,current_arr+arr[i:i+1],res)
	get_all_combinations(arr,i+1,current_arr,res)
	return res

def get_all_sub_seq_with_prod_n(arr,n):
	temp_arr=[x for x in arr if n%x==0]
	combinations=get_all_combinations(temp_arr)
	combinations=[c for c in combinations if reduce(lambda x,y:x*y,c)==n]
	return combinations

arr=[1,2,2,4,6,8,10,5]
n=10
print(get_all_sub_seq_with_prod_n(arr,n))