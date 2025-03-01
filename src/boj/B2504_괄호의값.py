s = list(input())
st = []
ans = 0
now = 1
for i  in range(len(s)):
    if s[i] == '(':
        now *= 2
        st.append('(')
    elif s[i] == '[':
        now *= 3
        st.append('[')
    elif s[i] == ')':
        if len(st)==0 or st[-1]!='(':
            ans = 0
            break
        elif s[i-1]=='(':
            ans += now
            now //= 2
            st.pop()
        elif s[i-1]!='(':
            now //= 2
            st.pop()
    elif s[i] == ']':
        if len(st)==0 or st[-1]!='[':
            ans = 0
            break
        elif s[i-1]=='[':
            ans += now
            now //= 3
            st.pop()
        elif s[i-1]!='[':
            now //= 3
            st.pop()
if len(st)!=0:
    ans = 0
print(ans)