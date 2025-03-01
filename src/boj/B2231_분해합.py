n = int(input())
t = False
for i in range(1, n+1):
    s = i
    now = str(i)
    for j in now:
        s += int(j)
    if s == n:
        print(i)
        t = True
        break
if t == False:
    print(0)