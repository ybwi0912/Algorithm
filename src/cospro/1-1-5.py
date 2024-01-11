# You may use import as below.
# import math
dx=[1,0,-1,0] # 오른쪽, 아래, 왼쪽, 위
dy=[0,1,0,-1]
def solution(n):
    # Write code here.
    li=[[0 for i in range(n)] for j in range(n)]
    x=0
    y=0
    li[0][0]=1
    w=0
    for i in range(2,n*n+1):
        if x+dx[w]==n or y+dy[w]==n:
            w+=1
        elif li[x+dx[w]][y+dy[w]]!=0:
            w+=1
        if w==4:
            w=0
        x+=dx[w]
        y+=dy[w]

        li[x][y]=i
        print(i, w, x, y, li[x][y])
    for i in li:
        print(' '.join(map(str, i)))
    answer = 0
    for i in range(n):
        answer += li[i][i]
    return answer


# The following is code to output testcase.
n1 = 3
ret1 = solution(n1)

# Press Run button to receive output.
print("Solution: return value of the function is", ret1, ".")

n2 = 2
ret2 = solution(n2)

# Press Run button to receive output.
print("Solution: return value of the function is", ret2, ".")
