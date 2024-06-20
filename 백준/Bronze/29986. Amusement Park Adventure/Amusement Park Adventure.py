N, H = map(int, input().split())
heights = list(filter(lambda x : x <= H, list(map(int, input().split()))))
print(len(heights))