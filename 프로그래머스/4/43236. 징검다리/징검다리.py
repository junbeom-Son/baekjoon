from copy import deepcopy

def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    distances = [rocks[0]]
    for i in range(1, len(rocks)):
        distances.append(rocks[i] - rocks[i-1])
    distances.append(distance - rocks[-1])
    left = 0
    right = distance
    while left <= right:
        mid = (left + right) // 2
        tmp_distances = deepcopy(distances)
        stones_to_remove = get_stones_to_remove(mid, tmp_distances, n)
        if stones_to_remove <= n:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1
    return answer

def get_stones_to_remove(goal, distances, n):
    count = 0
    for i in range(len(distances) - 1):
        if distances[i] < goal:
            count += 1
            distances[i + 1] += distances[i]
    if distances[-1] < goal:
        count += 1
    return count