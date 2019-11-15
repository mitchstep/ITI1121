public class Arithmetic extends AbstractSeries {

    // instance variables
    private int calls;

    public Arithmetic(){
        super();
        this.calls = 0;
    }

    @Override
    public double next() {
        int s = 1;
        for (int i = 1; i<=this.calls; i++){
            s += i+1;
        }
        this.calls++;
        return s;
    }
}
