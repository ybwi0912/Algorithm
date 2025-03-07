n, m, t = map(int, input().split())
come = [[] for _ in range(t+1)]
go = [[] for _ in range(t+1)] # 각 사람이 회의를 오고 떠나는 시각
for i in range(n):
    a, b = map(int, input().split())
    come[a].append(i)
    go[b].append(i)

f = [[] for i in range(n)] # 친한 사람의 정보
for i in range(m): # 서로 친한 두 사람의 번호
    c, d = map(int, input().split())
    f[c-1].append(d-1)
    f[d-1].append(c-1)

time = [] # 답
people = [False for _ in range(n)] # 회의에 참석한 사람 목록
#input
now = 0
for i in range(t): # 회의에 사람이 참석하고 떠날 때마다 친구 쌍 계산해 반영하기
    for j in go[i]: # j번 사람이 떠나면 j와 친한 친구들이 people에 있는지 확인
        people[j] = False
        for k in f[j]:
            if people[k]:
                now -= 1

    for j in come[i]: # j번 사람이 도착하면 j와 친한 친구들이 people에 있는지 확인
        for k in f[j]:
            if people[k]:
                now += 1
        people[j] = True
    time.append(now)

#operation

for i in time:
    print(i)
#output: 0.5초 단위로 즐거운 대화를 나누고 있는(친하면서 참석 시간대 겹치는) 사람들이 몇 쌍일까?
