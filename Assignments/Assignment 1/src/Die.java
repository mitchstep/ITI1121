import java.util.Random;

public class Die {

    public static final int MAXVALUE = 6;
    private int value;
    private Random rand = new Random();


    public Die(){
        this.value = rand.nextInt(MAXVALUE)+1;
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        this.value = rand.nextInt(MAXVALUE)+1;
    }

    public String toString(){
        return "Die {value:"+this.getValue()+"}";
    }

    public static void main(String[] args){
        Die d;
        d = new Die();
        System.out.println(d.getValue());
        d.roll();
        System.out.println(d.getValue());
        System.out.println(d);
    }

}
