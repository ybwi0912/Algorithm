import sys
from collections import deque

n = int(sys.stdin.readline())
li = [[]] # 인접 리스트
ans = [0 for i in range(n+1)]
m = 0 # 최대값
for _ in range(n):
    li.append(list(map(int, sys.stdin.readline().split()))[1:])
# input

def bfs(s, idx):
    isVisited[s] = True
    ans[idx] += 1
    q = deque()
    q.append(s)
    while len(q)!=0:
        n = q.pop()
        for i in li[n]:
            if not isVisited[i]:
                isVisited[i] = True
                q.append(i)
                ans[idx] += 1

for i in range(1, n+1):
    isVisited = [False for i in range(n+1)]
    bfs(i, i)
# operation
m = max(ans)
for i in range(n+1):
    if ans[i]==m:
        print(i, end=' ')
# output