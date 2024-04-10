# CODERS 1221 문제 (BOJ 1918번에서 모든 식에 괄호가 추가된 버전)
# 중위 표기식 -> 후위 표기식 변환
# 중위 표기식의 앞쪽부터 쭉 훑으면서..
# 1) '('가 나왔을 때 : 스택에 push한다
# 2) 알파벳이 나왔을 때 : 출력한다
# 3) 연산자가 나왔을 때 :
#     - 우선순위가 높을 때(*, /) : 스택에 push 
#     - 우선순위가 낮을 때(+, -) : 스택의 맨위 요소를 pop하여 출력한 뒤 연산자를 스택에 push
# 4) ')'가 나왔을 때 : 여는 괄호가 나올 때까지 pop하여 출력
# 5) 처음부터 끝까지 훑은 뒤 스택 내부에 남은 요소들을 모두 pop하여 출력한다

k = list(input())
answer = []
stack = []
rank = { '(':1, '+':2, '-':2, '*':3, '/':3} # 우선순위 저장
for i in k:
    if i=='(':
        stack.append(i)
    elif i==')':
        while stack[-1] != '(':
            answer.append(stack.pop())
        stack.pop()
    elif i in rank.keys():
        if len(stack)!=0 and rank[i] <= rank[stack[-1]]:
            answer.append(stack.pop())
            stack.append(i)
        else:
            stack.append(i)
    else:
        answer.append(i)

while len(stack)!=0:
    if stack[-1]!='(':
        answer.append(stack.pop())
    else:
        stack.pop()

for i in answer:
    print(i, end='')