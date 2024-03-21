import sys
input = sys.stdin.readline

num = '0o' + input().rstrip()
print(bin(int(num, 8))[2:])