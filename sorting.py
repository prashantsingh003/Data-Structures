import random
def bubble_sort(arr):
	for i in range(len(arr)-1):
		for j in range(i,len(arr)-i-1):
			if arr[j]<arr[j+1]:
				arr[j+1],arr[j]=arr[j],arr[j+1]

# start with a sorted part and unsorted part
# keep moving the first element of unsorted to the sorted part by moving it 1 place per turn untill its reacted its position
def insertion_sort(arr):
	for i in range(1,len(arr)):
		temp=arr[i]
		j=i
		while j>0 and arr[j-1]>temp:
			arr[j]=arr[j-1]
			j-=1
		arr[j]=temp

# start with a sorted part and unsorted part
# find the smallest number in the unsorted part
# replace it with the pivot tracking sorted part and increase pivot value by 1
def selection_sort(arr):
	for i in range(0,len(arr)-1):
		min_ind=i
		for j in range(i+1,len(arr)):
			if arr[j]<arr[min_ind]:
				min_ind=j
		arr[min_ind],arr[i]=arr[i],arr[min_ind]

def quick_sort(arr):
	def partition(arr,l,r):
		pivot=arr[l]
		while i<j:
			i=l+1
			j=r
			for k in range(l+1,r):
				if arr[k]>pivot:
					i=k
					break
			for k in range(l+1,r):
				if arr[r-1-k]<pivot:
					j=k
					break
			if i<j:
				arr[i],arr[j]=arr[j],arr[i]
		arr[l],arr[j]=arr[j],arr[l]
		return j
	def sort(arr,l,r):
		if not l<r:
			return
		piv=partition(arr,l,r)
		sort(arr,l,piv-1)
		sort(arr,piv+1,r)
	sort(arr,0,len(arr))

def outer_function():
    outer_variable = "I am outer"

    def inner_function():
        print(outer_variable)  # Accessing outer_variable from the outer function's scope

    return inner_function 
import ipdb
ipdb.set_trace()
arr= [random.randint(0,200) for x in range(random.randint(5,11))]
print(arr)
quick_sort(arr)
print(arr)