import java.util.*;

class Solution {
    private TreeSet<Integer> leftRounds = new TreeSet<>();
    private TreeSet<Integer> leftFoods = new TreeSet<>();
    private Map<Integer, List<Integer>> removedAt = new HashMap<>();
    
    public int solution(int[] food_times, long k) {
        long totalFoods = initialize(food_times, k);
        if (totalFoods <= k) { // 다먹어도 k가 다가오는 시간이 이후라면
            return -1;
        }
        int round = 0;
        while (!leftRounds.isEmpty()) {
            int nextRound = leftRounds.pollFirst();
            int leftFoodCount = leftFoods.size();
            long thisRoundFoodCount = (long)(nextRound - round) * leftFoodCount;
            if (isFinalRound(thisRoundFoodCount, k)) {
                return getFoodToEat(k) + 1;
            }
            // 이번 라운드에서 끝나지 않는 경우
            k -= thisRoundFoodCount;
            finishRound(nextRound);
            round = nextRound;
        }
        
        return -1;
    }
    
    private int getFoodToEat(long k) {
        int foodToEat = -1;
        int size = leftFoods.size();
        k %= size;
        while (k-- >= 0) {
            foodToEat = leftFoods.pollFirst();
        }
        return foodToEat;
    }
    
    private void finishRound(int round) {
        for (int food : removedAt.get(round)) {
            leftFoods.remove(food);
        }
        removedAt.remove(round);
        leftRounds.remove(round);
    }
    
    private boolean isFinalRound(long thisRoundFoodCount, long k) {
        return k < thisRoundFoodCount;
    }
    
    private long initialize(int[] food_times, long k) {
        long totalFoods = 0;
        for (int i = 0; i < food_times.length; ++i) {
            leftFoods.add(i);
            int food = food_times[i];
            totalFoods += food;
            if (!removedAt.containsKey(food)) {
                removedAt.put(food, new ArrayList<>());
            }
            removedAt.get(food).add(i);
            leftRounds.add(food);
        }
        return totalFoods;
    }
}