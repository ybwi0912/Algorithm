m, n = map(int, input().split())
g = [] # 가중치, 출력값
for i in range(m):
    l = list(input())
    l = (lambda x:list(map(int, x)))(l)
    g.append(l)
s = [[0 for i in range(n)] for j in range(m)] # 저장값
for i in range(1, n): # 세로 두 번째 줄부터 돌면서 출력값 기반으로 저장값 찾기, 출력값에 반영
    if m == 1:
        break
    # 출력값의 i-1번째 세로줄을 확인해 저장값의 i번째 줄에 저장
    for j in range(m):
        if j == 0: # i번째줄의 맨윗칸
            s[0][i] = max(g[0][i-1], g[1][i-1])
        elif j == m-1: #i번째줄의 맨아랫칸
            s[m-1][i] = max(g[m-1][i-1], g[m-2][i-1])
        else:
            s[j][i] = max(g[j-1][i-1], g[j][i-1], g[j+1][i-1])
        g[j][i] += s[j][i]

ans = 0
if m == 1:
    ans = sum(g[0])-g[0][-1]
else:
    for i in s:
        ans = max(i[-1], ans)
print(ans)