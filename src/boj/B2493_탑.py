n = int(input())
top = list(map(int, input().split()))
ans = [0 for i in range(n)]
st = [] # [값, 인덱스]
idx = 0
for i in range(n):
    while st and st[-1][0]<top[i]:
        st.pop()
    if st:
        ans[i] = st[-1][1]
    st.append([top[i], i+1])
for i in ans:
    print(i, end=' ')