import sys
n, m = map(int, sys.stdin.readline().split())
li = [i+1 for i in range(n)]
ans = []
isvisited = [False] * len(li)
def perm(arr, c):
    if c==m:
        ans.append(arr[:])
        return
    for i in range(len(li)):
        if not isvisited[i]:
            isvisited[i] = True
            arr.append(li[i])
            perm(arr, c+1)
            arr.pop()
            isvisited[i] = False

perm([], 0)
for i in ans:
    for j in i:
        print(j, end=' ')
    print()
