import sys
input = sys.stdin.readline

commands = list(int(input()) for _ in range(10))
direction = 0
for command in commands:
    direction = (direction + command) % 4

directions = ['N', 'E', 'S', 'W']
print(directions[direction])