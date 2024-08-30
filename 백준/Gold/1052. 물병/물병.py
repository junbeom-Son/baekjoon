def initialize(N):
    counts = set()
    num = 1
    while num <= N:
        if num & N > 0:
            counts.add(num)
        num <<= 1

    return counts

def addBottle(bottles):
    bottle = 1
    while True:
        if bottle not in bottles:
            break
        bottles.remove(bottle)
        bottle <<= 1

    bottles.add(bottle)

def solution(N, K):
    bottles = initialize(N)
    count = 0
    while len(bottles) > K:
        addBottle(bottles)
        count += 1

    return count


N, K = map(int, input().split())
print(solution(N, K))