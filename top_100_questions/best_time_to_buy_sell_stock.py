# BEST TIME TO BUY AND SELL STOCK FOR MAXIMUM PROFIT

# BUY AND SELL JUST ONCE
def max_profit(arr):
	min_val=arr[0]
	max_profit=0
	l=r=0
	for i,val in enumerate(arr[1:]):
		if val<min_val:
			min_val=val
			l=i
		elif max_profit<val-min_val:
			max_profit=val-min_val
			r=i
	return max_profit

def via_aux_arr(arr):
	aux_arr=[]
	max_sofar=0
	for i in range(1,len(arr)+1):
		if(arr[-i]>max_sofar):
			max_sofar=arr[-i]
		aux_arr.insert(0,max_sofar)
	max_sofar=0
	for i in range(len(arr)):
		max_sofar=max(max_sofar,aux_arr[i]-arr[i])
	return max_sofar


# CAN BUY AND SELL MULTIPLE TIMES BUT CAN HAVE ONLY ONE STOCK

#	trick is to calculat only the positive direction of line (when values are graphed)

def get_total_profit(values):
	profit=0
	for i in range(1,len(values)):
		profit+= values[i]-values[i-1] if values[i]-values[i-1]>0 else 0
	return profit

ARR=[7, 1, 5, 6, 4]
# print(max_profit(ARR))
print(get_total_profit(ARR))