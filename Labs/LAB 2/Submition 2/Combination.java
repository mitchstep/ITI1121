public class Combination {

    // Instance variables.
    private int one, two, three;

    // Constructor
    public Combination( int first, int second, int third ) {
        this.one = first;
        this.two = second;
        this.three = third;
    }

    public static void main(String[] args){
        Combination c1, c2, c3, c4, c5;
        c1 = new Combination(1,2,3);
        c2 = new Combination(1,2,3);
        c3 = new Combination(1,1,1);
        c4 = new Combination(3,2,1);
        c5 = null;
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
        System.out.println(c1.equals(c5));
        System.out.println(c1);
    }
    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        if(other == null){
            return false;
        }else{
            return (this.one== other.one && this.two == other.two && this.three == other.three);
        }
    }

    // Returns a String representation of this Combination.

    public String toString() {
        return this.one+":"+this.two+":"+this.three;
    }

}