n = int(input())
x = list(map(int, input().split()))
t = list(map(int, input().split()))

ans = 2 * x[n-1]
for i in range(n):
    ans = max(ans, x[i] + t[i])
print(ans)