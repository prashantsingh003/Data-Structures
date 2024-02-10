# from either side 
# O(N^2) complexity
def shortestPalindrome(s: str) -> str:
	if len(s)<2:
			return s
	is_palindrome = lambda x: x==x[::-1]
	max_len_palindrome=0
	m=n=-1
	i=j=0
	while(i<len(s)):
			if is_palindrome(s[i:j]):
					if j-i>max_len_palindrome:
							m,n=i,j
							max_len_palindrome=j-i
			if(j==len(s)):
					i+=1
			else:
					j+=1
	print(s[m:n])
	if m==0:
			return s[n:][::-1]+s
	elif n==len(s):
			return s+s[:m][::-1]

# Add in front side 
# O(N^2) complexity
def shortestPalindrome2(s: str) -> str:
	is_palindrome = lambda x: x==x[::-1]
	pivot=0
	i=0
	for i in range(len(s)+1):
			if is_palindrome(s[:i]):
					if i>pivot:
							pivot=i
			i+=1
	return s[pivot:][::-1]+s


# Add in front side 
# O(N) complexity
def shortestPalindrome3(self, s: str) -> str:
	t=s[::-1]
	for i in range(len(s)):
			if s.startswith(t[i:]):
					return t[:i]+s
	return t+s