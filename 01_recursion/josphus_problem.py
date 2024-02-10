# count number of ways to navigate from (0,0) to (n,m) in (n,m) matrix
def get_no_of_paths(n,m):
	if(n==1 or m==1):
		return 1
	return get_no_of_paths(n-1,m)+get_no_of_paths(n,m-1)

# print(get_no_of_paths(6,6))

#hophus_problem
def get_n(n,step):
	last_rem=n%step
	return last_rem

def jos(n,step):
	if(n==1):
		return 0
	return (jos(n-1,step)+step)%n
print(jos(5,3))