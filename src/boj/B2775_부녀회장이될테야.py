import sys
T = int(sys.stdin.readline())
d = [[0 for i in range(15)] for j in range(15)]
for i in range(15):
    d[0][i] = i+1
    d[i][0] = 1
for i in range(1, 15):
    for j in range(1, 15):
        d[i][j] = d[i][j-1] + d[i-1][j]
for _ in range(T):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    print(d[k][n-1])
# for i in d:
#     print(i)

