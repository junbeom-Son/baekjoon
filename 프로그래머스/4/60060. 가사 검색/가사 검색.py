def starts_with(start, words, length):
    count = 0
    for word in words:
        if word[:length] == start:
            count += 1
    
    return count

def ends_with(end, words, length):
    count = 0
    for word in words:
        if word[-length:] == end:
            count += 1
            
    return count

def get_by_length(words):
    count = 0
    for key in words:
        count += len(words[key])
    return count

def remove_question_mark(word):
    value = []
    for c in word:
        if c != '?':
            value.append(c)
    return ''.join(value)

def solution(words, queries):
    answer = []
    cash = dict()
    by_length = dict()
    by_first = dict()
    by_last = dict()
    for word in words:
        length = len(word)
        if length not in by_length:
            by_length[length] = dict()
            by_first[length] = dict()
            by_last[length] = dict()
            
        first = word[0]
        last = word[-1]
        if first not in by_length[length]:
            by_length[length][first] = []
            by_first[length][first] = []
        if last not in by_last[length]:
            by_last[length][last] = []
        by_length[length][first].append(word)
        by_first[length][first].append(word)
        by_last[length][last].append(word)
        
    for query in queries:
        if query in cash:
            answer.append(cash[query])
            continue
        length = len(query)
        if length not in by_length:
            answer.append(0)
            cash[query] = 0
            continue
        if query[0] == '?' and query[-1] == '?':
            count = get_by_length(by_length[length])
            cash[query] = count
            answer.append(count)
        elif query[0] == '?': # ?로 시작하는 것.
            fined_query = remove_question_mark(query)
            count = ends_with(fined_query, by_last[length][fined_query[-1]], len(fined_query))
            answer.append(count)
            cash[query] = count
        else:
            fined_query = remove_question_mark(query)
            count = starts_with(fined_query, by_first[length][fined_query[0]], len(fined_query))
            answer.append(count)
            cash[query] = count
            
    return answer