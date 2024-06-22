def getWinRate(game, win):
    return win * 100 // game

def getMinCountToChangeWinRate(X, Y):
    Z = getWinRate(X, Y)
    if Z >= 99:
        return -1
    answer = 2000000000
    left = 1
    right = answer
    while left <= right:
        mid = (left + right) // 2
        winRate = getWinRate(X + mid, Y + mid)
        if winRate > Z:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
    
    if answer == 2000000000:
        answer = -1
    return answer

X, Y = map(int, input().split())
print(getMinCountToChangeWinRate(X, Y))