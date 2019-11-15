import java.io.IOException;

public class RandomExceptions {

    public static void main(String args[]) {
        int exceptionNumber = randomNumber();
        try{
            throwException(exceptionNumber);
        }catch (Exception e){
            System.out.print(e);
            System.out.print(", the exceptionNumber is: "+exceptionNumber);
        }
        // Your code here to catch exceptions one by one.
    }

    public static int randomNumber() {
        return (int) (Math.random()*5) + 1;
    }

    public static void throwException(int exceptionNumber) throws Exception, IOException{
        System.out.print("the exception type is: ");
        if(exceptionNumber==1){
            throw new Exception();
        }
        if(exceptionNumber==2){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(exceptionNumber==3){
            throw new IOException();
        }
        if(exceptionNumber==4){
            throw new NullPointerException();
        }
        if(exceptionNumber==5){
            throw new IllegalAccessException();
        }

    }
}