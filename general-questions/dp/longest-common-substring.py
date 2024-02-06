
def get_longest_subtring(x,y):
	data_map=[[0 for n in range(len(y)+1)] for m in range(len(x)+1)]
	res_i=res_j=0
	for i in range(len(x)+1):
		for j in range(len(y)+1):
			if(i==0 or j==0):
				continue
			elif x[i-1]==y[j-1]:
				data_map[i][j]=data_map[i-1][j-1]+1
				if(data_map[i][j]>data_map[res_i][res_j]):
					res_i=i
					res_j=j
			else:
				data_map[i][j]=0
	for i in range(len(data_map)):
		for j in range(len(data_map[i])):
			if(data_map[i][j]!=0):
				print(data_map[i][j],end=" ")
			else:
				print("_",end=" ")
		print()
	def getStr(s,i,j):
		if(data_map[i][j]==0):
			return ""
		return getStr(s,i-1,j-1)+s[i-1]
	print(getStr(x,res_i,res_j))
	return data_map[res_i][res_j]

a="dayumtlolistrstingisn"
b="istestlolistringneces"
print(get_longest_subtring(a,b))