import sys
input = sys.stdin.readline

def findGroup(number, failures, grouppers, wants):
    stack = []
    current = set()
    current.add(number)
    stack.append(number)
    while True:
        if wants[number] in failures or wants[number] in grouppers:
            while stack:
                failures.add(stack.pop())
            break

        if wants[number] in current:
            start = wants[number]
            grouppers.add(start)
            while stack:
                number = stack.pop()
                if number == start:
                    break
                grouppers.add(number)

            while stack:
                failures.add(stack.pop())

            break
        stack.append(wants[number])
        current.add(wants[number])
        number = wants[number]

T = int(input())
answers = []
for _ in range(T):
    n = int(input())
    wants = [0] + list(map(int, input().split()))
    grouppers = set()
    for i in range(1, n + 1):
        if wants[i] == i:
            grouppers.add(i)
    
    failures = set()
    current = set()
    stack = []
    for i in range(1, n + 1):
        if i in failures or i in grouppers:
            continue
        findGroup(i, failures, grouppers, wants)
    
    answers.append(len(failures))

print('\n'.join(map(str, answers)))