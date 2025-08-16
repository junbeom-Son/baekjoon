answers = []
while True:
    try:
        a, b = map(int, input().split())
        answers.append(b // (a + 1))
    except:
        break

print('\n'.join(map(str, answers)))