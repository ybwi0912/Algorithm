import heapq
import sys

def heappush(heap, data):
    heap.append(data)

    now = len(heap) - 1

    while now > 0:
        parent = (now - 1) // 2
        if heap[parent] > heap[now]:
            heap[parent], heap[now] = heap[now], heap[parent]
            now = parent
        else:
            break

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