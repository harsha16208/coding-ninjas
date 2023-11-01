public class Solution {

    static int getXor(int n) {
        if (n%4==1) return 1;
        if (n%4==2) return n+1;
        if (n%4==3) return 0;
        return n; // if n%4==0
    }

    public static int findXOR(int L, int R){
        // Write your code here.
        return getXor(R) ^ getXor(L - 1);
    }
}
