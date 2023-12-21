from itertools import combinations

def diff(str1, str2):
    ans = 0
    for i in range(4):
        if str1[i] != str2[i]:
            ans += 1
    return ans

def distance(str1, str2, str3):
    return diff(str1, str2) + diff(str2, str3) + diff(str1, str3)


T = int(input())
for _ in range(T):
    N = int(input())
    li = list(map(str, input().split()))
    length = len(li)
    if length>32:
        print(0)
        continue

    ans = 10000

    # itertools 라이브러리 사용하지 않는 풀이
    # 38964 KB, 516 ms
    for i in range(length):
        for j in range(i+1, length):
            for k in range(j+1, length):
                # if i==j or j==k or i==k:
                #     continue
                now = distance(li[i], li[j], li[k])
                ans = min(ans, now)
                if ans == 0:
                    break

    # itertools 라이브러리 사용하는 풀이
    # 38964 KB, 496 ms
    # for x, y, z in combinations(li, 3):
    #     now = distance(x, y, z)
    #     ans = min(ans, now)
    #     if ans==0:
    #         break

    print(ans)