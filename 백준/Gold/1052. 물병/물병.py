def initialize(N):
    counts = set()
    
    while N > 0:
        num = 1
        while num <= N:
            num <<= 1
        num >>= 1
        counts.add(num)
        N -= num

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