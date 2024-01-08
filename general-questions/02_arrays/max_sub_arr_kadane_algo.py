arrays = [
    [1, 2, -3, 4, -1, 2, 1, -5, 4],
    [3, -2, 5, -1, 2, -6, 4, 2, -1],
    [-2, 1, -3, 4, -1, 2, 1, -5, 4],
    [2, 3, -2, -1, 10],
    [-1, -2, -3, -4, -5],
    [5, -1, -2, 5, -1, 2, 1, -5, 4],
    [1, 2, 3, 4, 5],
    [-1, -2, 3, 4, -5, 6],
    [1, -2, 3, -4, 5],
    [-1, 2, -3, 4, -5]
]

# BruteForce complexity: n^3
def brute_n3(arr):
	sub_arr=[]
	max_sum=arr[0]
	for i in range(len(arr)): 
		for j in range(i,len(arr)):
			s=sum(arr[i:j+1])
			if s>max_sum:
				max_sum=s
				sub_arr=arr[i:j+1]
	return sub_arr,max_sum

# BruteForce complexity: n^2
def brute_n2(arr):
	max_sum=arr[0]
	for i in range(len(arr)):
		s=0
		for j in range(i,len(arr)):
			s+=arr[j]
		if s>max_sum:
				max_sum=s
	return max_sum
print(brute_n3(arrays[0]))