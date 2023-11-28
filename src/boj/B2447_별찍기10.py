N=int(input())

def func(l):
    if l==1:
        return ['*']

    stars = func(l//3)
    li=[]

    for s in stars:
        li.append(s*3)
    for s in stars:
        li.append(s + " "*(l//3) + s)
    for s in stars:
        li.append(s*3)

    return li

print('\n'.join(func(N)))