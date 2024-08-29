string = input()
stack = ['C', 'P', 'C', 'U']

for c in string:
    if not stack:
        break
    if c == stack[-1]:
        stack.pop()

if stack:
    print('I hate UCPC')
else:
    print('I love UCPC')