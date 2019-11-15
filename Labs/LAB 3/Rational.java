public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    // getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
        int gcd = gcd(this.denominator,other.denominator);
        if(this.denominator==other.denominator) {
            return new Rational(this.numerator + other.numerator, this.denominator);
        }
        else{
            return new Rational(this.numerator*other.denominator + other.numerator*this.denominator, this.denominator*other.denominator);
        }
    }

    public static Rational plus(Rational a, Rational b) {
        return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
        int gcd = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcd;
        this.denominator = this.denominator/gcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    public int compareTo(Rational other) {
        if(this.equals(other)){
            return 0;
        }
        else if(this.numerator/this.denominator>other.numerator/other.denominator){
            return 1;
        }
        else{
            return -1;
        }

    }

    public boolean equals(Rational other) {
        if(this.numerator == other.numerator && this.denominator == other.denominator){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        String result;
        if (getDenominator() == 1) {
            result = ""+getNumerator();
        }else{
            result = getNumerator()+"/"+getDenominator();
        }
        return result;
    }
    public static void main(String[] args){
        Rational r1, r2, r3;
        r1 = new Rational(1,3);
        r2 = new Rational(1,3);
        r3 = new Rational(3,6);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(plus(r1,r2));
        System.out.println(r1.compareTo(r2));
        System.out.println(r1.compareTo(r3));

    }
}