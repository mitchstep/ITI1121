public class Iterative {

    public static BitList complement( BitList in ) {
        BitList complement = new BitList();
        Iterator i = in.iterator();
        int temp;
        while (i.hasNext()){
            temp = i.next();
            if (temp == 1){
                temp = 0;
            }else {
                temp = 1;
            }
            complement.addFirst(temp);
        }
        return complement;
    }

    public static BitList or( BitList a, BitList b ) {
        Iterator A = a.iterator();
        Iterator B = b.iterator();
        String temp = "";
        int atemp;
        int btemp;
        while (A.hasNext() && B.hasNext()){
            atemp = A.next();
            btemp = B.next();
            if (atemp ==1 || btemp==1){
                temp += "1";
            }else {
                temp += "0";
            }
        }
        temp = reverse(temp);
        return new BitList(temp);
    }

    public static BitList and( BitList a, BitList b ) {
        Iterator A = a.iterator();
        Iterator B = b.iterator();
        String temp = "";
        int atemp;
        int btemp;
        while (A.hasNext() && B.hasNext()){
            atemp = A.next();
            btemp = B.next();
            if (atemp ==1 && btemp==1){
                temp += "1";
            }else {
                temp += "0";
            }
        }
        temp = reverse(temp);
        return new BitList(temp);
    }

    public static BitList xor( BitList a, BitList b ) {
        Iterator A = a.iterator();
        Iterator B = b.iterator();
        String temp = "";
        int atemp;
        int btemp;
        while (A.hasNext() && B.hasNext()){
            atemp = A.next();
            btemp = B.next();
            if (atemp ==0 && btemp==1||atemp ==1 && btemp == 0){
                temp += "1";
            }else {
                temp += "0";
            }
        }
        temp = reverse(temp);
        return new BitList(temp);
    }

    public static String reverse(String forward){
        String rev = "";
        for (int i = forward.length(); i >0 ; i-- ){
            rev += forward.substring(i-1,i);
        }
        return rev;
    }
}