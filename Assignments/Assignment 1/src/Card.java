public class Card {

    private int suit;
    private int rank;

    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean equils(Object object){
        if(!(object instanceof Card)){
            return false;
        }
        Card other;
        other = (Card) object;

        if(this.rank==other.rank&&this.suit==other.rank){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "{"+getSuit()+","+getRank()+"}";
    }

    public static void main(String[] args){

    }
}
