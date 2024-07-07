class Solution {
    public int numWaterBottles(int n, int e) {
        int ans=n;
        while(n>=e){
            int m=n/e;
            int rb= n -m*e;
            ans=ans+m;
            n=m+rb;
        }
        return ans;
    }
}