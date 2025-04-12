t = int(input())
ans = ''
for i in range(t):
    s = input()
    if s[::]==s[::-1]: # 회문인지 판단
        ans += '0'+'\n'
    else: # 유사회문인지, 회문이 아닌지 판단
        x = 0
        y = len(s)-1
        n = 0
        while x < y:
            if s[x] != s[y]:
                if s[x+1:y+1] == s[x+1:y+1][::-1] or s[x:y] == s[x:y][::-1]:
                    ans += '1' + '\n'
                    break
                else:
                    ans += '2' + '\n'
                    break
            x += 1
            y -= 1
print(ans)

