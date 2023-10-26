public class Solution {
    public static String oddEven(int N){
        // Write your code here.
        int res = N & 1;
        return res == 1 ? "odd" : "even";
    }
}
