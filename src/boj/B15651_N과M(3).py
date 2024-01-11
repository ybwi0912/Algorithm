n, m = map(int, input().split())
li = [i+1 for i in range(n)]
ans=[]
def func(arr, r):
    if r==m:
        # ans.append(arr[:])
        print(' '.join(map(str, arr)))
        return
    for i in range(n):
        arr.append(li[i])
        func(arr, r+1)
        arr.pop()

func([], 0)
# for i in ans:
#     for j in i:
#         print(j, end=' ')
#     print()