import java.util.List;
import java.util.*;
public class Solution {
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here
        Map<Integer, Integer> rankMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr);

        int rank = 0;
        while(!minHeap.isEmpty()) {
            int ele = minHeap.poll();

            if (!rankMap.containsKey(ele)) {
                rank++;
                rankMap.put(ele, rank);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int ele : arr) {
            res.add(rankMap.get(ele));
        }
        return res;
    }
}
