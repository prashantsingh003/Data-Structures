
def get_2_sum_dict(arr,target):
	mp={}
	for num in arr:
		if mp.get(num):
			mp[num]+=1
		else:
			mp[num]=1
	
	for num,i in enumerate(arr):
		if mp.get(target-num):
			return(num,target-num)

def get_2_sum_2_pointer(arr,target):
	num_arr=arr[:]
	num_arr.sort()
	i=0
	j=len(arr)-1
	while(i<j):
		sum=num_arr[i]+num_arr[j]
		if sum==target:
			return(num_arr[i],num_arr[j])
		elif sum<target:
			i+=1
		else:
			j-=1
	return -1

ARR=[0, -1, 2, -3, 1]
TARGET=-2

print(get_2_sum_2_pointer(ARR,TARGET))