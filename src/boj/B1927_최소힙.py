import heapq
import sys

n = int(sys.stdin.readline())
heap = []

for i in range(n):
    a = int(sys.stdin.readline())
    if a==0:
        if not heap:
            print(0)
        else:
            now = heapq.heappop(heap)
            print(now)
    else:
        heapq.heappush(heap, a)