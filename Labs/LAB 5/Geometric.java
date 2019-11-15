public class Geometric extends AbstractSeries {

    private int calls;

    public Geometric(){
        super();
        this.calls = 0;
    }

    public double next() {
        double s = 0;
        for (int i = 1; i<=this.calls; i++){
            s += 1/(Math.pow(2,i));
        }
        this.calls++;
        return s;

    }
}