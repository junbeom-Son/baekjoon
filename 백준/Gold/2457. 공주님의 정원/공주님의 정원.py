import sys
input = sys.stdin.readline

def solution():
    N = int(input())
    flowers = list(list(map(int, input().split())) for _ in range(N))
    flowers.sort(key = lambda x : (x[0], x[1]))
    startMonth, startDay = 3, 1
    count = 0
    i = 0
    while startMonth < 12:
        lastMonth, lastDay = -1, -1
        while i < N:
            month, day, endMonth, endDay = flowers[i]
            if month > startMonth or (month == startMonth and day > startDay):
                break
            if endMonth > lastMonth or (endMonth == lastMonth and endDay > lastDay):
                lastMonth, lastDay = endMonth, endDay
            i += 1
        if lastMonth == -1 and lastDay == -1:
            return 0
        startMonth, startDay = lastMonth, lastDay
        count += 1
    return count

print(solution())