from collections import deque
N, K = map(int, input().split())

commands = input()
hamburgers = deque()
people = deque()
for i in range(N):
    if commands[i] == 'P':
        people.append(i)
    else:
        hamburgers.append(i)

answer = 0
while hamburgers and people:
    hamburger = hamburgers.popleft()
    person = people.popleft()
    if abs(hamburger - person) <= K:
        answer += 1
    else:
        if hamburger < person:
            people.appendleft(person)
        else:
            hamburgers.appendleft(hamburger)
print(answer)