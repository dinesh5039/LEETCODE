class Solution {
    public int minOperations(String[] logs) {
        int x=0;
        for(String s: logs){
            if(s.charAt(0)=='.'&&s.charAt(1)=='/')  continue;
            else if(s.charAt(0)==s.charAt(1)&&s.charAt(0)=='.'){
                if(x!=0)    x--;
            }
            else{
                x++;
            }
        }
        return x;
    }
}