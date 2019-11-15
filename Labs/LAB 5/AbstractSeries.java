public abstract class AbstractSeries implements Series {

    private double a1;

    public AbstractSeries(){
        this.a1 = 1;
    }

    public double[] take(int k){
        double[] sums = new double[k];
        for(int i = 0; i < k; i++){
            sums[i] = this.a1 + next();
        }
        return sums;
    }
}
