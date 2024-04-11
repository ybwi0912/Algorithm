import sys
from collections import deque

n, m, v = map(int, input().split()) # 정점의 개수, 간선의 개수, 탐색 시작 위치
li = [[] for i in range(n+1)] # 인접 리스트
isVisited = [False for i in range(n+1)] # 방문 여부 표시 리스트
for i in range(m):
    x, y = map(int, input().split())
    li[x].append(y)
    li[y].append(x)
for i in li:
    i.sort()
# input

def bfs(s):
    ans = ''
    q = deque()
    q.append(s)
    isVisited[s] = True
    while len(q)!=0:
        now = q.popleft()
        ans += (str(now) + ' ')
        for next in li[now]:
            if not isVisited[next]:
                isVisited[next] = True
                q.append(next)
    return ans

ans = bfs(v)

# operation

print(ans)
# output