import sys
sys.setrecursionlimit(10**7)
def dfs(x, y, now):
    isVisited[x][y] = True
    canbus[x][y] = c
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<h and 0<=ny<w:
            if not isVisited[nx][ny] and canbus[nx][ny] == now:
                dfs(nx, ny, now)


w, h = map(int, sys.stdin.readline().split())
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
canbus = []
for _ in range(h):
    canbus.append(list(map(int, sys.stdin.readline().split())))

n = int(sys.stdin.readline())
for _ in range(n):
    x, y, c = map(int, sys.stdin.readline().split())
    isVisited = [[False for i in range(w)] for j in range(h)]
    now = canbus[y][x]
    dfs(y, x, now)

for i in canbus:
    for j in i:
        print(j, end=' ')
    print()