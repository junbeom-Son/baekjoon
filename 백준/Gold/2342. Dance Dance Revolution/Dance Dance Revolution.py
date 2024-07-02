import sys
input = sys.stdin.readline

def getNextDistance(a, b):
    if a == 0:
        return 2
    if a == b:
        return 1
    if a % 2 == b % 2: # 반대편
        return 4
    return 3 # 인접한 부분

INF = 10000000

commands = [0] + list(map(int, input().split()))
commands.pop()

length = len(commands)
answer = INF
distances = [[[INF for _ in range(5)] for _ in range(5)] for _ in range(length)]
distances[0][0][0] = 0

for i in range(1, length):
    command = commands[i]
    for left in range(5):
        for right in range(5):
            if distances[i-1][left][right] == INF:
                continue
            fromLeft = getNextDistance(left, command)
            fromRight = getNextDistance(right, command)
            distances[i][left][command] = min(distances[i][left][command], distances[i-1][left][right] + fromRight)
            distances[i][command][right] = min(distances[i][command][right], distances[i-1][left][right] + fromLeft)


for i in range(5):
    answer = min(answer, min(distances[-1][i]))

print(answer)