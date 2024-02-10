res_arr=[]
options=[1,2,3,4,5,6] # n=length of this array
selected_number=3 # r

ALLOW_DUPLICATES=True

def getCombinations(cross,strt=0,temp_arr=[]):
	for i in range(0 if ALLOW_DUPLICATES else strt,len(options)):
		if cross==0:
			constructed_arr=[x for x in temp_arr]
			constructed_arr.append(options[i])
			res_arr.append(constructed_arr)
		else:
			temp_arr.append(options[i])
			getCombinations(cross-1,i+1,temp_arr)
			temp_arr.pop()

getCombinations(selected_number-1)
for arr in res_arr:
	print(arr)