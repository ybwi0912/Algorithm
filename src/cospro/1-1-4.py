#You may use import as below.
#import math

def solution(num):
    now = str(num+1)
    ans=[]
    for i in range(len(now)):
        if now[i]=='0':
            ans.append('1')
        else:
            ans.append(now[i])
    return ''.join(map(str, ans))

#The following is code to output testcase.
num = 9949999;
ret = solution(num)

#Press Run button to receive output.
print("Solution: return value of the function is", ret, ".")