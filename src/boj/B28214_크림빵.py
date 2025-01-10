n, k, p = map(int, input().split())
li = list(map(int, input().split()))
ans = 0
for i in range(n):
    b = li[i*k:(i+1)*k]
    s = sum(b)
    if k-s < p:
        ans += 1

print(ans)