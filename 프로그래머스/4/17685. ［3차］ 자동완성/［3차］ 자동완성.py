def solution(words):
    answer = 0
    root = dict()
    for word in words:
        trie = root
        for c in word:
            if c not in trie:
                trie[c] = dict()
                trie[c]['.'] = 0 # .은 count를 의미
            trie[c]['.'] += 1
            trie = trie[c]
            
    for word in words:
        trie = root
        for c in word:
            answer += 1
            trie = trie[c]
            if trie['.'] == 1:
                break
                
    return answer