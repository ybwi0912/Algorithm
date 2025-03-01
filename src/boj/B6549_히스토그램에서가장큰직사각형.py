import sys
m = ''
while True:
    l, *li = list(map(int, sys.stdin.readline().split()))
    li.append(0)
    if l == 0:
        break
    mx = 0
    st = []
    for i in range(len(li)):
        # i번째 막대를 포함시켰을 때 가능한 직사각형의 최대 너비를 계산.
        # 직사각형에 포함시킬 수 있는 막대들의 인덱스를 스택에 저장.
        while len(st)>0 and li[st[-1]] > li[i]:
            # 스택에 값이 존재하고, 지금 확인하는 막대 앞에 있는 막대들의 높이가 현재 막대의 높이보다 크다면
            now = st.pop()

            if len(st) == 0:
                w = i
            else:
                w = i - st[-1] - 1
            mx = max(mx, w*li[now])
        st.append(i) # 인덱스를 저장
    m += str(mx)+'\n'
print(m)