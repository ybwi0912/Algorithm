import sys
n, m = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
li.sort()
isvisited = [False] * n

def func(arr, r):
    if r==m:
        print(' '.join(map(str, arr)))
        return
    for i in range(n):
        if not isvisited[i]:
            isvisited[i]=True
            arr.append(li[i])
            func(arr, r+1)
            arr.pop()
            isvisited[i]=False

func([], 0)