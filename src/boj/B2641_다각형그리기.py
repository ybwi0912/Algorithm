import sys
from collections import deque

num = int(sys.stdin.readline())
ex = list(map(int, sys.stdin.readline().split()))
exq = deque(ex)
exq2 = []
for i in range(num-1, -1, -1):
    if ex[i] == 1:
        exq2.append(3)
    if ex[i] == 2:
        exq2.append(4)
    if ex[i] == 3:
        exq2.append(1)
    if ex[i] == 4:
        exq2.append(2)
exq2 = deque(exq2)
t = int(sys.stdin.readline())
ans1 = 0
ans2 = []
for _ in range(t):
    now = list(map(int, sys.stdin.readline().split()))
    q = deque(now)
    for _ in range(num):
        q.append(q.popleft())
        if q == exq or q == exq2:
            ans1 += 1
            ans2.append(now)
            break
print(ans1)
for i in ans2:
    for j in i:
        print(j, end=' ')
    print()