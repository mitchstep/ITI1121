import java.util.Arrays;
import java.util.Scanner;

public class Q6{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ten grades:");
        double[] grades = new double[10];
        for (int i = 0; i < 10; i++){
            System.out.println("Enter grade "+(i+1)+": ");
            grades[i] = scan.nextDouble();
        }
        System.out.println("Average: "+ calculateAverage(grades));
        System.out.println("Median: "+ calculateMedian(grades));
        System.out.println("Classes failed: "+ calculateNumberFailed(grades));
        System.out.println("Classes passed: "+ calculateNumberPassed(grades));
    }

    public static double calculateAverage(double[] notes){
        int mean = 0;
        for (int i = 0; i < notes.length; i++){
            mean += notes[i];
        }
        mean /=notes.length;
        return mean;
    }

    public static double calculateMedian(double[] notes){
        Arrays.sort(notes);
        if(notes.length%2==0){
            int index = notes.length/2;
            double median = (notes[index]+notes[index-1])/2;
            return(median);
        }
        else {
            return (notes[notes.length/2]);
        }
    }

    public static int calculateNumberFailed(double[] notes){
        int failed = 0;
        for (int i = 0; i < notes.length; i++){
            if(notes[i]<50){
                failed++;
            }
        }
        return failed;
    }

    public static int calculateNumberPassed(double[] notes){
        return notes.length-calculateNumberFailed(notes);
    }

}