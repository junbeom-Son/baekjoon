MAX = 4000000

def initializePrimeNumbers(MAX):
    isPrime = [True] * (MAX + 5)
    isPrime[0:2] = [False, False]
    for i in range(2, MAX + 1):
        if i * i > MAX:
            break
        if not isPrime[i]:
            continue
        for j in range(i + i, MAX + 1, i):
            isPrime[j] = False

    return [i for i in range(MAX + 1) if isPrime[i]]

def getAnswer(N):
    if N <= 3:
        return N // 2
    primeNumbers = initializePrimeNumbers(N)
    answer = 0
    sum = 5
    j = 1
    for i in range(0, len(primeNumbers)):
        if sum == N:
            answer += 1
            sum -= primeNumbers[i]
            continue
        while sum < N:
            if j == len(primeNumbers) - 1:
                break
            j += 1
            sum += primeNumbers[j]

        if sum == N:
            answer += 1
            sum -= primeNumbers[i]
            continue

        sum -= primeNumbers[i]
        if i + 1 < j:
            sum -= primeNumbers[j]
            j -= 1

            
    return answer

N = int(input())
print(getAnswer(N))