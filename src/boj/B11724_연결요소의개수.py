import sys

def dfs(c):
    isVisited[c] = True
    for new in li[c]:
        if not isVisited[new]:
            dfs(new)

n, m = map(int, sys.stdin.readline().split())
li = [[] for _ in range(n+1)]
isVisited = [False for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    li[u].append(v)
    li[v].append(u)
ans = 0
for i in range(1, n+1):
    if not isVisited[i]:
        ans+=1
        dfs(i)
print(ans)