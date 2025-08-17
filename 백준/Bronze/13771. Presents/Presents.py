import sys
input = sys.stdin.readline

n = int(input())
prices = list(float(input()) for _ in range(n))
prices.sort()
print('%.2f' % prices[1])