import java.util.*;

class Solution {
    TreeSet<Long> allocatedRoomKeys = new TreeSet<>();
    Set<Long> allocatedRooms = new HashSet<>();
    Map<Long, Long> nextRoomNumber = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; ++i) {
            long requestedRoom = room_number[i];
            answer[i] = getAllocatedRoomNumber(requestedRoom);
        }
        return answer;
    }
    
    long getAllocatedRoomNumber(long requestedRoom) {
        if (!allocatedRooms.contains(requestedRoom)) {
            allocatedRooms.add(requestedRoom);
            Long floor = allocatedRoomKeys.floor(requestedRoom);
            allocatedRoomKeys.add(requestedRoom);
            nextRoomNumber.put(requestedRoom, requestedRoom + 1);
            if (floor == null) { // 더 작은 키가 없으면
                if (allocatedRooms.contains(requestedRoom + 1)) {
                    combineRooms(requestedRoom, requestedRoom + 1);
                }
            } else { // 더 작은 키가 있는 경우
                if (nextRoomNumber.get(floor) == requestedRoom) {
                    combineRooms(floor, requestedRoom);
                    if (allocatedRooms.contains(requestedRoom + 1)) {
                        combineRooms(floor, requestedRoom + 1);
                    }
                } else { // 앞의 키와 합치지는 않는데, 뒤의 키랑만 합치는 경우
                    if (allocatedRooms.contains(requestedRoom + 1)) {
                        combineRooms(requestedRoom, requestedRoom + 1);
                    }
                }
            }
            return requestedRoom;
        }
        
        Long floor = allocatedRoomKeys.floor(requestedRoom);
        Long allocatedNumber = nextRoomNumber.get(floor);
        Long nextNumber = allocatedNumber + 1;
        nextRoomNumber.put(floor, nextNumber);
        allocatedRooms.add(allocatedNumber);
        // 만약 다음 번호가 저장되어 있다면
        if (allocatedRooms.contains(nextNumber)) {
            combineRooms(floor, nextNumber);
        }
        
        return allocatedNumber;
    }
    
    void combineRooms(long room1, long room2) {
        nextRoomNumber.put(room1, nextRoomNumber.get(room2));
        nextRoomNumber.remove(room2);
        allocatedRoomKeys.remove(room2);
    }
}