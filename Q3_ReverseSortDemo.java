import java.util.*;
public class Q3_ReverseSortDemo {
    public static void main(String[] args){
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
        reverseSort(unorderedLetters);
        for (int i = 0 ; i < unorderedLetters.length; i++ )
            System.out.print(unorderedLetters[i]);
    }

    //method that sorts a char array into its reverse alphabetical order
    public static void reverseSort(char[] values){
        int[] test = new int[values.length];
        for(int i= 0; i < values.length; i++){
            test[i] = values[i];
        }
        Arrays.sort(test);
        for(int i= 0,j=values.length-1; i < values.length; i++,j--){
            values[i]= (char) test[j];
        }
    }

}