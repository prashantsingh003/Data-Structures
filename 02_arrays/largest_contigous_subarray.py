def sol_n2(nums):
	max_sum=0
	for i in range(len(nums)):
		s=0
		for j in range(i,len(nums)):
			s+=nums[j]
		max_sum=max(max_sum,s)
	return max_sum

def kadane_algo(nums):
	max_so_far=nums[0]
	curr_sum=max_so_far
	for i in range(1,len(nums)):
		curr_sum+=nums[i]
		if curr_sum<0:
			curr_sum=0
		max_so_far=max(max_so_far,curr_sum)
	return max_so_far

arrays = [
    [-2, 1, -3, 4, -1, 2, 1, -5, 4],  # Expected maximum subarray sum: 6
    [1, 2, 3, 4, -10, 6, 7],           # Expected maximum subarray sum: 13
    [-1, -2, -3, -4, -5],              # Expected maximum subarray sum: -1
    [10, -3, -7, 4, -2, 5],            # Expected maximum subarray sum: 10
    [5, -2, 3, 2, 4, -3, 5],           # Expected maximum subarray sum: 14
    [1, 2, -4, 3, 2, -3, 5, 4]         # Expected maximum subarray sum: 11
]
print([kadane_algo(x) for x in arrays])