n = int(input())
a = list(map(int, input().split()))
for i in range(n):
    a[i] = a[i] % 2

x = 0
y = 0
now = 0
now2 = 0
for i in a:
    if i == 0:
        now += 1
        y += now2
    elif i == 1:
        x += now
        now2 += 1

print(min(x,y))