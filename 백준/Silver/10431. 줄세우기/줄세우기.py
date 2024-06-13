n = int(input())
for _ in range(n):
    students = list(map(int, input().split()))
    t = students[0]
    count = 0
    for i in range(1, 20):
        for j in range(i + 1, 21):
            if students[i] > students[j]:
                count += 1
    print(t, count)