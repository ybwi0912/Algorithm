import sys
sys.setrecursionlimit(10**7)

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

T = int(sys.stdin.readline())
for _ in range(T):
    m, n, k = map(int, sys.stdin.readline().split()) # 가로 길이, 세로 길이, 고구마의 개수
    li = [[0 for i in range(m)] for j in range(n)]
    isVisited = [[False for i in range(m)] for j in range(n)]
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        li[y][x] = 1
    # input

    def dfs(x, y):
        isVisited[x][y] = True
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if not isVisited[nx][ny] and li[nx][ny]==1:
                    dfs(nx, ny)

    ans = 0
    for i in range(n):
        for j in range(m):
            if not isVisited[i][j] and li[i][j]==1:
                ans += 1
                dfs(i, j)

    print(ans)