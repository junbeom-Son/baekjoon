import sys
input = sys.stdin.readline

people = []
while True:
    info = input().split()
    if info[0] == '#' and info[1] == '0' and info[2] == '0':
        break
    name, age, weight = info
    age = int(age)
    weight = int(weight)
    if age > 17 or weight >= 80:
        people.append(f'{name} Senior')
    else:
        people.append(f'{name} Junior')

print('\n'.join(people))