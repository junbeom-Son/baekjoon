import sys
input = sys.stdin.readline

def is_foldable(paper, mid):
    if mid == 0:
        return True
    for i in range(mid):
        if paper[mid - i - 1] == paper[i + mid + 1]:
            return False
    return is_foldable(paper, mid // 2)

T = int(input())
papers = list(list(map(int, list(input().rstrip()))) for _ in range(T))
answers = []
for paper in papers:
    foldable = is_foldable(paper, len(paper) // 2)
    answers.append('YES' if foldable else 'NO')

print('\n'.join(answers))