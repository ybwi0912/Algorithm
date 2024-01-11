import sys
n, m = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
li.sort()
def func(arr, r, now):
    if len(arr)==m:
        print(' '.join(map(str, arr)))
        return
    for i in range(n):
        if i>=now:
            arr.append(li[i])
            func(arr, r+1, i)
            arr.pop()

func([], 0, 0)