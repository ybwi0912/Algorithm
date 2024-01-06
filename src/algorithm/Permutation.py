li = [1, 2, 3]
isvisited = [False] * len(li)
ans = []
def permutation(arr, n):
    if n == len(li):
        print(arr)
        ans.append(arr[:])
        return
    for i in range(len(li)):
        if not isvisited[i]:
            isvisited[i] = True
            arr.append(li[i])
            permutation(arr, n+1)
            arr.pop()
            isvisited[i] = False

permutation([], 0)
print(ans)
