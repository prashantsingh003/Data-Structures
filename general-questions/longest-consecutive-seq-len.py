# FIND THE LENGTH OF LONGEST CONSECUTIVE SUBSEQUENCE THAT CAN BE FORMED USING ELEMENTS IN GIVEN ARRAY

# with sorting and elimanating duplicate
def sol_with_sort(nums):
	nums=list(set(nums))
	if len(nums)<2:
		return len(nums)
	nums.sort()
	count=1
	max_c=count
	num=nums[0]
	# print(nums)
	for i in range(1,len(nums)):
		if nums[i]==num+1:
			# print(nums[i],num+1)
			num+=1
			count+=1
		else:
			num=nums[i]
			count=1
		max_c=max(count,max_c)
	return max_c


# using set to make fetch complexity to o(1)
def sol_with_set( nums):
	num_set=set(nums)
	max_count=0
	for n in nums:
		if n-1 not in num_set:
			count=1
			num=n+1
			while num in num_set:
				num+=1
				count+=1
			max_count=max(max_count,count)
	return max_count