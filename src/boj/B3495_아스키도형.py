h, w = map(int, input().split())
ans = 0
for i in range(h):
    l = list(input())
    t = False
    a=0
    for j in range(w):
        if t==False and (l[j]=='/' or l[j]=='\\'):
            t=True
            a += 0.5
        elif t==True and (l[j]!='/' and l[j]!='\\'):
            a += 1
        elif t==True and (l[j]=='/' or l[j]=='\\'):
            a += 0.5
            t=False
    ans += a

print(int(ans))
