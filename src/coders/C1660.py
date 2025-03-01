# import sys
#
# n, q = map(int, sys.stdin.readline().split())
# li = list(map(int, sys.stdin.readline().split()))
# d = {}
# for i in range(n):
#     d[li[i]] = i + 1
#
# ans=''
#
# def check(n, arr):
#     t = 0
#     for i in range(n - 1):
#         if abs(arr[i] - arr[i + 1]) != 1:
#             t += 1
#             if t > 1:
#                 return False
#     return True
#
#
# for _ in range(q):
#     x, y = map(int, sys.stdin.readline().split())
#     # 자리를 바꾼 학생 2명의 카드번호 정보가 주어짐
#     d[x], d[y] = d[y], d[x]
#     # 자리 바꾸는 코드 수정 필요 ;;
#     std = sorted(d.items(), key=lambda d: d[1])
#     new=[]
#     for i in std:
#         new.append(i[0])
#     t = check(n, new)
#
#     ans += "DA\n" if t else "NE\n"
#
# print(ans)

import sys

n, q = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
ans=''
def check(n, arr):
    t=0
    for i in range(n-1):
        if abs(arr[i]-arr[i+1])!=1:
            t+=1
            if t>1:
                return False
    return True
for _ in range(q):
    x, y = map(int, sys.stdin.readline().split())
    # 자리를 바꾼 학생 2명의 카드번호 정보가 주어짐
    a = li.index(x)
    b = li.index(y)
    li[a], li[b] = li[b], li[a]
    # 자리 바꾸는 코드 수정 필요 ;;

    t = check(n, li)
    ans += "DA\n" if t else "NE\n"

print(ans)