
public class Jaccard implements Similarity {

    private double scores;

    public Jaccard(){

    }


    public double score​(WordMap a, WordMap b) throws NullPointerException, ArrayIndexOutOfBoundsException {

        if (a.size()==0 || b.size()==0){
            throw new ArrayIndexOutOfBoundsException();
        }else if (a == null || b==null){
            throw new NullPointerException();
        }

        double score = 0;
        Integer[] A = a.counts();
        Integer[] B = b.counts();
        for (int i= 0; i < a.size(); i++){
            score += Math.abs(A[i]-B[i]);
        }

        return 1/score;
    }
}
