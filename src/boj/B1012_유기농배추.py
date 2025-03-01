import sys
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
    isVisited[y][x] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<m and 0<=ny<n:
            if li[ny][nx] == 1 and not isVisited[ny][nx]:
                dfs(nx, ny)

p = []
t  = int(sys.stdin.readline())
for _ in range(t):
    m, n, k = map(int, sys.stdin.readline().split())
    ans = 0
    li = [[0 for i in range(m)] for j in range(n)]
    isVisited = [[False for i in range(m)] for j in range(n)]
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        li[y][x] = 1
    for i in range(n):
        for j in range(m):
            if li[i][j]==1:
                if not isVisited[i][j]:
                    ans += 1
                    dfs(j, i)
    p.append(ans)
print(*p, sep='\n')