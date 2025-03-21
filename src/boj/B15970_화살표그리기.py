n = int(input())
li = [[] for i in range(n)]
for i in range(n):
    x, c = map(int, input().split())
    li[c-1].append(x)

ans = 0
for i in li:
    i.sort()
    ln = len(i)
    if ln == 1:
        continue
    for j in range(ln):
        if j == 0:
            ans += i[1]-i[0]
        elif j == ln-1:
            ans += i[ln-1]-i[ln-2]
        else:
            ans += min(i[j]-i[j-1], i[j+1]-i[j])

print(ans)