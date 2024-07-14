import sys
input = sys.stdin.readline

vowels = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
answers = []
while True:
    sentence = input().rstrip()
    if sentence == '#':
        break
    count = 0
    for c in sentence:
        if c in vowels:
            count += 1
    answers.append(str(count))

print('\n'.join(answers))