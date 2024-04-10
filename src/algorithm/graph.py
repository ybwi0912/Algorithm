import sys
n, m = map(int, input().split())
arr=[[0 for i in range(n)] for j in range(n)] # 인접 행렬
li = [[] for i in range(n)]
for _ in range(m):
    x, y = map(int, input().split())
    arr[x-1][y-1] = 1
    arr[y-1][x-1] = 1
    li[x-1].append(y)
    li[y-1].append(x)
for i in range(n):
    li[i].sort()
for i in arr:
    for j in i:
        print(j, end=' ')
    print()
print()
for i in li:
    for j in i:
        print(j, end=' ')
    print()