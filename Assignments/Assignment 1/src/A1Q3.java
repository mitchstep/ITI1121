public class A1Q3 {
    public static void main(String[] args){}
    public static int getLongestRun(double[] nums){
        int longest = 0, run = 1;
        if(nums.length>0) longest = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                run++;
                if(run>longest){
                    longest = run;
                }
            }
            else{
                run = 1;
            }
        }
        return longest;
    }
}
