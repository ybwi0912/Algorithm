n = int(input())
l = list(map(int, input().split()))
oil = list(map(int, input().split()))
now = oil[0]
ans = 0
for i in range(n-1):
    if now <= oil[i]: # 다음 도시의 기름값이 더 비싼 경우
        ans += (now * l[i])
    else: # 다음 도시의 기름값이 더 싼 경우
        now = oil[i]
        ans += (now * l[i])
print(ans)