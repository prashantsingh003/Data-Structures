# BACKTRACKING Complexity n*n
BOARD =[
		[3, 0, 6, 5, 0, 8, 4, 0, 0],
		[5, 2, 0, 0, 0, 0, 0, 0, 0],
		[0, 8, 7, 0, 0, 0, 0, 3, 1],
		[0, 0, 3, 0, 1, 0, 0, 8, 0],
		[9, 0, 0, 8, 6, 3, 0, 0, 5],
		[0, 5, 0, 0, 9, 0, 6, 0, 0],
		[1, 3, 0, 0, 0, 0, 2, 5, 0],
		[0, 0, 0, 0, 0, 0, 0, 7, 4],
		[0, 0, 5, 2, 0, 6, 3, 0, 0]
]

GET_SET=lambda:set(range(1,10))

def print_grid(g):
	for i in range(9):
		for j in range(9):
			print(g[i][j],end=' ')
			if (j+1)%3==0 and j!=8:
				print('|',end=' ')
		if (i+1)%3==0 and i!=8:
			print()
			for j in range(9):
				print('--',end="")
			print('---',end="")
		print()
	print()

def check_box(grid,p,q,num):
	for i in range(3):
		for j in range(3):
			if grid[p+i][q+j]==num:
				return False
	return True

def used_in_col(grid, col, num):
	for i in range(9):
		if(grid[i][col] == num):
			return True
	return False

def used_in_row(grid, row, num):
	for i in range(9):
		if(grid[row][i] == num):
			return True
	return False

def pos_valid(grid,i,j,num):
	valid=not used_in_col(grid,j,num) and not used_in_row(grid,i,num) and check_box(grid,i-i%3,j-j%3,num)
	return valid


def find_empty(grid):
	for i in range(9):
		for j in range(9):
			if grid[i][j]==0:
				return i,j
	return [None,None]
	
def solve_sudoku(grid):
	i,j=find_empty(grid)
	if i is None or j is None:
		return True
	for num in range(1,10):
		if pos_valid(grid,i,j,num):
			grid[i][j]=num
			if(solve_sudoku(grid)):
				return True
			grid[i][j] = 0
	return False

print_grid(BOARD)
print()
solve_sudoku(BOARD)
print_grid(BOARD)