import java.util.Arrays;
import java.util.Scanner;

public class Q6{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a ten grades.");
        double[] grades = new double[10];
        for (int i = 0; i < 10; i++){
            System.out.println("Enter a grade: ");
            grades[i] = scan.nextDouble();
        }
        System.out.println("Average: "+ calculateAverage(grades));
        System.out.println("Median: "+ calculateMedian(grades));
        System.out.println("Classes failed: "+ calculateNumberFailed(grades));
        System.out.println("Classes passed: "+ calculateNumberPassed(grades));
    }

    public static double calculateAverage(double[] notes){
        int mean = 0;
        for (int i = 0; i < 10; i++){
            mean += notes[i];
        }
        mean /=10;
        return mean;
    }

    public static double calculateMedian(double[] notes){
        Arrays.sort(notes);
        return (notes[5]+notes[4])/2;
    }

    public static int calculateNumberFailed(double[] notes){
        int failed = 0;
        for (int i = 0; i < 10; i++){
            if(notes[i]<50){
                failed++;
            }
        }
        return failed;
    }

    public static int calculateNumberPassed(double[] notes){
        return 10-calculateNumberFailed(notes);
    }

}