import sys
input = sys.stdin.readline

def main():
    n, k = map(int, input().split())
    papers = [list(input().split()) for _ in range(k)]
    wheel = ['?'] * n
    indices = dict()
    index = 0
    for count, character in papers:
        count = int(count)
        index = (index + count) % n
        position = indices.get(character, -1)
        if position == -1:
            if wheel[index] != '?':
                return '!'
            indices[character] = index
            wheel[index] = character

        else:
            if position != index:
                return '!'

    answer = []
    for _ in range(n):
        answer.append(wheel[index])
        index -= 1
        if index == -1:
            index += n
    return ''.join(answer)

print(main())