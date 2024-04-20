import sys
from collections import deque

def dfs(s):
    isVisited[s] = True
    ans1.append(str(s))

    for i in li[s]:
        if not isVisited[i]:
            dfs(i)

def bfs(s):
    q = deque()
    q.append(s)
    isVisited[s] = True
    ans2.append(s)
    while len(q)!=0:
        now = q.popleft()
        for i in li[now]:
            if not isVisited[i]:
                isVisited[i] = True
                q.append(i)
                ans2.append(i)

n, m, v = map(int, sys.stdin.readline().split())
li = [[] for _ in range(n+1)]
isVisited = [False for _ in range(n+1)]
for i in range(m):
    x, y = map(int, sys.stdin.readline().split())
    li[x].append(y)
    li[y].append(x)

for i in li:
    i.sort()
print(li)
ans1 = []
ans2 = []

dfs(v)
isVisited = [False for _ in range(n+1)]
bfs(v)

print(*ans1)
print(*ans2)