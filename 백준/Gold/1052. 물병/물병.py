def isPossible(N, K):
    return bin(N).count('1') <= K

def solution(N, K):
    count = 0
    while True:
        if isPossible(N, K):
            break
        count += 1
        N += 1

    return count

N, K = map(int, input().split())
print(solution(N, K))