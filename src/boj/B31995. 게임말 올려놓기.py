n = int(input())
m = int(input())
ans = 0
if n == 1 or m == 1:
    ans = 0
    # 가로, 세로 중 하나라도 길이가 1이라면 돌을 대각선으로 둘 수 없다
else:
    ans = 2*(n-1)*(m-1)
print(ans)