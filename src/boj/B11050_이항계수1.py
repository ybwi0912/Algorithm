import sys
n, k = map(int, sys.stdin.readline().split())
d = [[0 for i in range(n+1)] for j in range(n+1)]
for i in range(n+1):
    d[i][1] = i
    d[i][0] = 1
    d[i][i] = 1

for i in range(2, n+1):
    for j in range(1, i):
        d[i][j] = d[i-1][j] + d[i-1][j-1]
#        d[i][j] %= 10007 -> 이항 계수 2 문제

print(d[n][k])
