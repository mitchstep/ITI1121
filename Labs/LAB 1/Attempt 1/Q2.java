public class Q2 {
    public static void main(String[] args){
        for(int i = 1; i <=30; i++){
            if(i%15==0){
                System.out.println(i+" FizzBizz");
            }
            else if(i%3==0){
                System.out.println(i+" Fizz");
            }
            else if(i%5==0){
                System.out.println(i+" Buzz");
            }
        }
    }
}
