N = int(input())
trees = list(map(int, input().split()))

trees.sort()
for i in range(1, len(trees) + 1):
    trees[-i] = i + 1 + trees[-i]

print(max(trees))