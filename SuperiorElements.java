import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        List<Integer> list = new ArrayList<>();
        int max = a[a.length - 1];
        list.add(a[a.length - 1]);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > max) {
                list.add(a[i]);
                max = a[i];
            }
        }
        return list;
    }
}
