def get_paths(n,m):
    if(n==1 or m==1):
        return 1
    return get_paths(n-1,m)+get_paths(n,m-1)
print(get_paths(5,5))