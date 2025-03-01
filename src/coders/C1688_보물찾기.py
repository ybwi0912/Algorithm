t = int(input())
for _ in range(t):
    l, r, s = map(int, input().split())
    lm = s-l
    rm = r-s
    if lm<rm:
        print(lm*2+1)
    elif lm>=rm:
        print(rm*2)