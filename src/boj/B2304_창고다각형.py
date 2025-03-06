n = int(input())
li = []
for i in range(n):
    li.append(list(map(int, input().split())))
li.sort(key=lambda x:x[0])
p = [0 for i in range(li[-1][0]+1)]
for i in li:
    p[i[0]] = i[1]
m = max(p)
idx = p.index(m)
a = 0 # 왼쪽부터 가장 높은 기둥까지의 넓이
t = 0 # 현재 기둥의 높이
for i in range(idx):
    t = max(t, p[i])
    a += t

b = 0 # 오른쪽부터 가장 높은 기둥까지의 넓이
t = 0 # 현재 기둥의 높이
for i in range(len(p)-1, idx-1, -1):
    t = max(t, p[i])
    b += t

print(a+b)