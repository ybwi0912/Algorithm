n, p = map(int, input().split())
t = n
s = set()
l = []
while True:
    t = (t * n) % p
    if t not in s:
        s.add(t)
    else:
        if t in l:
            print(len(l))
            print(l)
            break
        else:
            l.append(t)

