T = int(input())
N = int(input())
candies = list(map(int, input().split()))
cry = 'Happy' if sum(candies) >= T else 'Cry'
print(f'Padaeng_i {cry}')