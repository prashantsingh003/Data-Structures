import numpy as np
def n_queen(n):
	def recurse(row,arr):
		if row==len(arr):
			return True
		for j in range(len(arr)):
			if is_pos_valid(row,j,arr):
				arr[row][j]=1
				if recurse(row+1,arr):
					return True
				arr[row][j]=0
		return False

	def is_pos_valid(i,j,arr):
		y_axis=np.array([x[j] for x in arr])
		x_axis=np.array(arr[i])
		d1=np.array([arr[i][i] for i in range(0,len(arr))])
		d2=np.array([arr[i][len(arr)-i-1] for i in range(0,len(arr))])
		return not np.any([y_axis,x_axis,d1,d2])
	
	board=[[0 for j in range(n)] for i in range(n)]
	recurse(0,board)
	for i in range(n):
		print(board[i])
	return board

n_queen(10)
