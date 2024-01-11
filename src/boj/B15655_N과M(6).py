import sys
n, m = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
li.sort()

def combi(arr, r):
    if r==n:
        if len(arr)==m:
            print(' '.join(map(str, arr)))
        return
    arr.append(li[r])
    combi(arr, r+1)
    arr.pop()
    combi(arr, r+1)

combi([], 0)