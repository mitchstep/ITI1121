public class A1Q1 {
    public static void main(String[] args){}
    public static int countPositive(double[] nums){
        int positive = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>0){
                positive++;
            }
        }
        return positive;
    }
}
