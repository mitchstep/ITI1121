
public class Q3_ArrayInsertion{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
        int[] afterArray = new int[beforeArray.length+1];
        int j = 0;
        for(int i = 0; i < beforeArray.length+1;i++){
            if(i == indexToInsert){
                afterArray[i] = valueToInsert;
            }
            else {
                afterArray[i] = beforeArray[j];
                j++;
            }
        }
        return afterArray;
    }
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        int[] array = new int[] {1,5,4,7,9,6};
        System.out.println("Array before insertion:");
        print(array);
        int[] newarray = insertIntoArray(array,3,15);
        System.out.println("Array after insertion:");
        print(newarray);
    }
}