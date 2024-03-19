# Breath First Search Greedy
def numSquares( n: int) -> int:
	sqs=[]
	k=1
	res=[]
	while k*k<=n:
		sqs.append(k*k)
		k+=1
	sqs=sqs[::-1]
	if sqs[0]==n:
		return 1

	def recurse(ind,n,count):
		if n == 0:
			res.append(count)
			return count
		for i in range(ind,len(sqs)):
			if n-sqs[i]>=0:
				recurse(i,n-sqs[i],count+1)
		return -1
	recurse(0,n,0)
	return min(res)

print(numSquares(1))