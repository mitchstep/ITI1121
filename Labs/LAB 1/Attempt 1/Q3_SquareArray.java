public class Q3_SquareArray {
    public static int[] createArray(int size){
        int[] array = new int[size];
        for (int i=1; i <= size; i++){
            array[i-1] = i*i;
        }
        return array;
    }
    public static void main(String[] args){
        int[] arr = createArray(12);
        for(int i=1; i<=12; i++){
            System.out.println("The square of "+ i + " is "+ arr[i-1]);
        }
    }
}
