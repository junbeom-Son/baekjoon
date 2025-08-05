import sys
input = sys.stdin.readline

N, L = map(int, input().split())
signals = list(list(map(int, input().split())) for _ in range(N))

def get_departure_time(time, red):
    cycle = red + green
    left_time = time % cycle
    if left_time >= red:
        return time
    waiting_time = red - left_time
    return time + waiting_time

last_position = 0
departure_time = 0
arrival_time = 0
for current_position, red, green in signals:
    arrival_time = departure_time + (current_position - last_position)
    departure_time = get_departure_time(arrival_time, red)
    last_position = current_position

print(departure_time + (L - last_position))