import sys
n, m = map(int, sys.stdin.readline().split())
ans=[]

def func(arr, r, now):
    if r==m:
        print(' '.join(map(str, arr)))
        return
    for i in range(1, n+1):
        if i>=now:
            arr.append(i)
            func(arr, r+1, i)
            arr.pop()

func([], 0, 0)