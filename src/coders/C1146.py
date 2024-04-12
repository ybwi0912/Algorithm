import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
li = [[] for _ in range(n+1)]
isVisited = [False for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    li[x].append(y)
    li[y].append(x)

def bfs(s):
    q = deque()
    q.append(s)
    isVisited[s] = True
    while len(q)!=0:
        n = q.popleft()
        for i in li[n]:
            if not isVisited[i]:
                q.append(i)
                isVisited[i] = True

ans = 0

for i in range(1, n+1):
    if not isVisited[i]:
        ans += 1
        bfs(i)

print(ans)