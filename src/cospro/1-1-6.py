#You may use import as below.
#import math

def solution(pos): # 8 * 8 board
    # Write code here.
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]
    answer = 0
    x = ord(pos[0])-ord('A')+1
    y=int(pos[1])
    for i in range(8):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<nx<=8 and 0<ny<=8:
            answer+=1
    return answer

#The following is code to output testcase.
pos = "A7"
ret = solution(pos)

#Press Run button to receive output.
print("Solution: return value of the function is", ret, ".")