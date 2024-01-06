li = [1, 2, 3, 4, 5]

ans = []
def combination(arr, n, r):
    if n == len(li):
        if len(arr)==r:
            print(arr)
            ans.append(arr[:])
        return
    arr.append(li[n])
    combination(arr, n+1, r)
    arr.pop()
    combination(arr, n+1, r)

combination([], 0, 3)
print(ans)