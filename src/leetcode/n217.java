package leetcode;
import java.util.*;

public class n217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            if(entry.getValue() > 1) return true;
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
