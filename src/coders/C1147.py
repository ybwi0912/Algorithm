import sys

n = int(sys.stdin.readline())
li = []
for _ in range(n):
    new = list(sys.stdin.readline().strip())
    for i in range(len(new)):
        new[i] = int(new[i])
    li.append(new)
# input

num = 0
ans = []
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
isVisited = [[False for i in range(n)] for j in range(n)]

def dfs(x, y, idx):
    isVisited[x][y] = True
    ans[idx] += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<n and 0<=ny<n:
            if not isVisited[nx][ny] and li[nx][ny]==1:
                dfs(nx, ny, idx)

idx = 0

for i in range(n):
    for j in range(n):
        if not isVisited[i][j] and li[i][j]==1:
            ans.append(0)
            dfs(i, j, idx)
            idx += 1


# operation

print(len(ans))
ans.sort()
for i in ans:
    print(i)
# output