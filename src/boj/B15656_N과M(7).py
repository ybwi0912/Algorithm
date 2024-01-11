import sys
n, m = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
li.sort()


def func(arr, r):
    if r==m:
        print(' '.join(map(str, arr)))
        return
    for i in range(n):
        arr.append(li[i])
        func(arr, r+1)
        arr.pop()


func([], 0)