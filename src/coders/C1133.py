import sys
n = int(sys.stdin.readline())
st=[]
for _ in range(n):
    now = sys.stdin.readline().rstrip()
    m=now[0:3]
    if m=='pop':
        if len(st)==0:
            print(-1)
        else:
            print(st.pop())
    elif m=='top':
        if len(st)==0:
            print(-1)
        else:
            print(st[len(st)-1])
    elif m=='pus':
        st.append(now[5:len(now)])
    elif m=='siz':
        print(len(st))
    elif m=='emp':
        if len(st)==0:
            print(1)
        else:
            print(0)