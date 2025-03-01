from collections import deque
import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    li = list(map(int, sys.stdin.readline().split()))
    q = deque(li)
    idx = deque([i for i in range(n)])
    ans = 0
    while q:
        if q[0] == max(q):
            ans += 1
            if idx[0] == m:
                print(ans)
                break
            else:
                idx.popleft()
                q.popleft()
        else:
            idx.append(idx.popleft())
            q.append(q.popleft())