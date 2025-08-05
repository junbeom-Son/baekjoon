LENGTH = 13

def initialize():
    ISBN = input().strip()
    total = 0
    location = LENGTH - 1
    for i in range(LENGTH - 1):
        if ISBN[i] == '*':
            location = i
            continue
        if i % 2 == 0:
            total += int(ISBN[i])
        else:
            total += int(ISBN[i]) * 3
    return total, location, ISBN[LENGTH - 1]

def getM(total, location, m):
    if location == LENGTH - 1:
        return 10 - (total % 10)
    m = int(m)
    weight = 1
    if location % 2 == 1:
        weight = 3
    for i in range(10):
        number = (total + (i * weight)) % 10
        if (m + number) % 10 == 0:
            return i


total, location, m = initialize()
print(getM(total, location, m))