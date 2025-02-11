n, k = map(int, input().split())
d = k
li = list(input())
ans = []
for i in range(n):
    while ans and k:
        if k > 0:
            if ans[-1]<li[i]:
                ans.pop()
                k-=1
            else:
                break
        else:
            break
    ans.append(li[i])
print(''.join(ans[:n-d]))
