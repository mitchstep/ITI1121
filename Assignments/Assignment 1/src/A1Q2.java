public class A1Q2 {
    public static void main(String[] args){}
    public static boolean hasLengthTwoRun(double[] nums){
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
