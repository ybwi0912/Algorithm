from collections import deque

n, k = map(int, input().split())
q = deque([i for i in range(1, n+1)])
print("<", end='')
for i in range(n-1):
    for j in range(k-1):
        q.append(q.popleft())
    print(q[0], end=', ')
    q.popleft()
print(q[0], end='>')