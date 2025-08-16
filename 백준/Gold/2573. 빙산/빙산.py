import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def initialize_ice_positions(original_map, N, M):
    ice_positions = []
    for i in range(1, N - 1):
        for j in range(1, M - 1):
            if original_map[i][j] > 0:
                ice_positions.append(i * M + j)

    return ice_positions

def initialize_adjacent_water_counts(original_map, N, M):
    adjacent_water_counts = list(list(0 for _ in range(M)) for _ in range(N))
    for i in range(1, N - 1):
        for j in range(1, M - 1):
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if original_map[nx][ny] == 0:
                    adjacent_water_counts[i][j] += 1
    return adjacent_water_counts

def get_group_counts(ice_positions, original_map, M):
    visited = set()
    count = 0
    for position in ice_positions:
        if position in visited:
            continue
        queue = deque([position])
        while queue:
            current_position = queue.popleft()

            i = current_position // M
            j = current_position % M

            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if original_map[nx][ny] == 0:
                    continue
                next_position = nx * M + ny
                if next_position not in visited:
                    queue.append(next_position)
                    visited.add(next_position)

        count += 1

    return count

def lower_ice(ice_positions, adjacent_water_counts, original_map, M):
    for position in ice_positions:
        i = position // M
        j = position % M
        original_map[i][j] = max(original_map[i][j] - adjacent_water_counts[i][j], 0)

def eliminate_ice(ice_positions, adjacent_water_counts, original_map, M):
    remaining_ice_positions = []
    for position in ice_positions:
        i = position // M
        j = position % M
        if original_map[i][j] > 0:
            remaining_ice_positions.append(position)
            continue
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            adjacent_water_counts[nx][ny] += 1

    return remaining_ice_positions

def melt_ice(ice_positions, adjacent_water_counts, original_map, M):
    lower_ice(ice_positions, adjacent_water_counts, original_map, M)
    return eliminate_ice(ice_positions, adjacent_water_counts, original_map, M)

def solution():
    N, M = map(int, input().split())
    original_map = list(list(map(int, input().split())) for _ in range(N))

    ice_positions = initialize_ice_positions(original_map, N, M)
    adjacent_water_counts = initialize_adjacent_water_counts(original_map, N, M)
    year = 0

    while ice_positions and get_group_counts(ice_positions, original_map, M) == 1:
        ice_positions = melt_ice(ice_positions, adjacent_water_counts, original_map, M)
        if not ice_positions:
            year = 0
            break
        year += 1

    return year

print(solution())