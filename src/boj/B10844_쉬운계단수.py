n = int(input())

arr = [[0]*10 for i in range(n)]

for i in range(1, 10):
    arr[0][i] = 1

for i in range(1, n):
    arr[i][0] = arr[i-1][1]
    for j in range(1, 9):
        arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1]
    arr[i][9] = arr[i-1][8]

ans = sum(arr[n-1]) % 1000000000
print(ans)