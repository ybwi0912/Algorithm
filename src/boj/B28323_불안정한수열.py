n = int(input())
a = list(map(int, input().split()))
ans1 = 0 # 짝, 홀, 짝, 홀
c1 = False # 홀수 찾으면 false, 짝수 찾으면 true
t1 = 0
ans2 = 0
c2 = False # 홀수
t2 = 0
for i in range(len(a)):
    if a[i] % 2 == 0 and c1 == False:
        ans1 += a[i]
        c1 = True
        t1 += 1
    elif a[i] % 2 == 1 and c1 == True:
        ans1 += a[i]
        c1 = False
        t1 += 1
    if a[i] % 2 == 1 and c2 == False:
        ans2 += a[i]
        c2 = True
        t2 += 1
    elif a[i] % 2 == 0 and c2 == True:
        ans2 += a[i]
        c2 = False
        t2 += 1
print(max(t1, t2))