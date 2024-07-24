class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
     /*   int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            String s=Integer.toString(nums[i]);
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<s.length();j++){
                int m=s.charAt(j)-48;
                 sb.append(Integer.toString(mapp[m]));
            }
         String ans=new String(sb);
            arr[i]=Integer.parseInt(ans);
        }
       
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    int temp1=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp1;
                }
            }
        }
        return nums;*/


    int max = -1 ;
   
     for(int x : nums)
     {
        if(x > max) max = x ;
     }  

      int [] ans = nums;

     for(int place = 1 ; max/place > 0 ; place *= 10 )   
     {
       
     ans = CountSort( ans, place , mapping);
       
     }
    
    return ans;
    }


static int[] CountSort(int [] arr , int place, int[] mapping)
{
    int n = arr.length;

    if( n <= 1 )return arr;

    int[] ans = new int[n];

    int[] freqArr = new int[10];

    for(int x : arr)
    {    
        if(x/place != 0 || x==0)
        { int val = (x/place) % 10 ;
        
          freqArr[ mapping[val] ]++;        }
        else
        {
          freqArr[ 0 ]++;        
        }
    }


    for(int i = 1 ; i<10 ; i++)       // converting frequency array into prefix sum array;
    {
        freqArr[i] += freqArr[i-1];
    }

    for(int i = n - 1 ; i >= 0 ; i--)
    {
        if( arr[i]/place != 0 || arr[i]== 0)
        {
        int val = ( arr[i]/place )%10;

         ans[ freqArr[mapping[val]] - 1 ] = arr[i] ;
         
          freqArr[mapping[val]]--;
        }
        else
        {
            ans[ freqArr[0] - 1] = arr[i];
            freqArr[0]--;
        }
    }

return ans;
}


}
    
