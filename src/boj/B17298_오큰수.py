import sys
n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
st = []
ans = [-1]*n
for i in range(len(li)-1, -1, -1): # 수열의 마지막 수부터 역순으로 확인하면서
    while st and st[-1] <= li[i]: # 스택에서 지금 확인하는 수보다 작은 수를 모두 제거
        st.pop()
    if st: # li[i]보다 작은 모든 수를 제거하고도 스택에 수가 존재한다면 오큰수가 존재한다는 의미
        ans[i] = st[-1] # li[i]의 오큰수를 ans[i]에 저장
    st.append(li[i]) # 방금 확인한 수를 스택에 저장
print(*ans)
