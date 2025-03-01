n = int(input())
v = list(map(int, input().split()))

y = n-1 # 가장 뒤의 속력부터 확인
x = y-1 # 지금 확인하는 속력 바로 앞의 속력
now = 1
ans = now

while x >= 0:
    if v[x] > now:
        now += 1
    else:
        now = v[x]
    ans += now
    y -= 1
    x -= 1


print(ans)