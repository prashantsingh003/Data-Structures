# calculate the amount of water that'll be trapped in a series of block each of varying height.
# input is the array of length n
def cal_trapped_water_vol(arr):
	l_max_arr=[arr[0]]
	r_max_arr=[arr[-1]]
	for i in range(1,len(arr)):
		l_max_arr.append(max(l_max_arr[-1],arr[i]))
		r_max_arr.insert(0,max(r_max_arr[0],arr[len(arr)-1-i]))
	trapped_vol=0
	for i in range(len(arr)):
		trapped_vol+=min(l_max_arr[i],r_max_arr[i])-arr[i]
	return trapped_vol

ARR=[3,1,2,4,0,1,3,2]
print(cal_trapped_water_vol(ARR))