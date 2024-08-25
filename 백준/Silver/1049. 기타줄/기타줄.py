import sys
input = sys.stdin.readline

n, m = map(int, input().split())
packages = []
units = []
for _ in range(m):
    package, unit = map(int, input().split())
    packages.append(package)
    units.append(unit)

package = min(packages)
unit = min(units)
minPackageValue = min(package, unit * 6)
answer = n // 6 * minPackageValue
restPrice = min(package, unit * (n % 6))
answer += restPrice
print(answer)