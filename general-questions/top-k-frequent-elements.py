# RETURN LIST OF LENGTH k THAT HAS TOP MOST FREQUENT ELEMENTS

# using map and then sorting the map acc to freq nlog(n)
def topKFrequent(nums, k):
	counter={}
	for n in nums:
		if counter.get(n):
			counter[n]+=1
		else:
			counter[n]=1
	res=counter.items()
	res.sort(key=lambda x : x[1])
	return [x[0] for x in res[-k:]]

# TRICK
def topKFrequent(nums, k):
		counter={}
		for n in nums:
				if counter.get(n):
						counter[n]+=1
				else:
						counter[n]=1
		res=[0] * (len(nums)+1)
		for num,freq in counter.items():
				if res[freq]:
						res[freq].append(num)
				else:
						res[freq]=[num]
		return [ x for y in res if y for x in y ][-k:]