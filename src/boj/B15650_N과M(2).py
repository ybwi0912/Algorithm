n, m = map(int, input().split())
li = [i+1 for i in range(n)]
isvisited = [False for i in range(n+1)]
ans=[]

def perm(arr, r):
    if r==m:
        ans.append(arr[:])
        return
    for i in range(n):
        if isvisited[i]:
            continue
        isvisited[i]=True
        arr.append(li[i])
        perm(arr,r+1)
        isvisited[i] = False
        arr.pop()

def combi(arr, c):
    if c==n:
        if len(arr)==m:
            ans.append(arr[:])
        return
    arr.append(li[c])
    combi(arr, c+1)
    arr.pop()
    combi(arr, c+1)


# perm([], 0)
combi([], 0)

for i in ans:
    for j in i:
        print(j, end=' ')
    print()

import itertools

ans = itertools.combinations(li, m)
for i in list(ans):
    for j in i:
        print(j, end=' ')
    print()