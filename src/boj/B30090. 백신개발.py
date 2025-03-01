n = int(input())
s = []
for _ in range(n):
    s.append(input())
v = [False for i in range(n)]
ans = 999999

def check(a, b):
    for i in range(len(a), -1, -1):
        x = a[:i]
        y = b[len(b)-i:]

        if x==y:
            return b+a[i:]

def dfs(depth, st):
    global ans
    if depth == n:
        ans = min(ans, len(st))
        return
    for i in range(n):
        if not v[i]:
            v[i] = True
            new = check(s[i], st)
            dfs(depth+1, new)
            v[i] = False

dfs(0,'')
print(ans)
