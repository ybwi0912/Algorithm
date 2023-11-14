S = input()
T = input()

ans = 0

while len(T) > 0:
    if T[-1] == 'A':
        # T.pop()
        T = T[0:len(T)-1]
    elif T[-1] == 'B':
        # T.pop()
        T = T[0:len(T)-1]
        # T.reverse()
        T = T[::-1]
    print(T)
    if T == S:
        ans = 1
        break

print(ans)