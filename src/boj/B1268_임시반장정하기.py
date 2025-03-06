n = int(input())
ans = [set() for i in range(n)]
stu = []
for i in range(n):
    stu.append(list(map(int, input().split())))

for i in range(n):
    for j in range(i+1, n):
        for k in range(5):
            if stu[i][k] == stu[j][k]:
                ans[i].add(j+1)
                ans[j].add(i+1)
                break

a = 0
b = 0
for i in range(n):
    if len(ans[i]) > a:
        a = len(ans[i])
        b = i+1
print(b if b != 0 else 1)