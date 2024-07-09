class Solution {
    public double averageWaitingTime(int[][] c) {
    int[] ans=new int[c.length];
    int time=c[0][0]+c[0][1];
    int diff=0;
    ans[0]=time-c[0][0];
    for(int i=1;i<c.length;i++){
           time=time<c[i][0]?c[i][0]+c[i][1]:time+c[i][1];
           diff=time-c[i][0];
           ans[i]=diff;
    }
double avg=0;
double sum=0;

  for(int i=0;i<ans.length;i++){
sum=sum+(double)ans[i];

  }
  avg=sum/ans.length;
  return avg;
    }
}