n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
A.sort(reverse=True)
B.sort(reverse=True)
ans = "DA"
for i in range(n):
    if A[i]>B[i]:
        ans="NE"
        break
print(ans)