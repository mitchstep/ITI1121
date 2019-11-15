import java.util.Stack;

/**
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

public class Balanced {

    public static boolean algo1( String s ){

        int curly = 0;
        int square = 0;
        int round = 0;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
                case '{':
                    curly++;
                    break;
                case '}':
                    curly--;
                    break;
                case '[':
                    square++;
                    break;
                case ']':
                    square--;
                    break;
                case '(':
                    round++;
                    break;
                case ')':
                    round--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }

    public static boolean algo2( String s ){

        Stack<Integer> stack = new Stack<>();

        int curly = 0;
        int square = 1;
        int round = 2;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
                case '{':
                    stack.push(curly);
                    break;
                case '}':
                    if(stack.pop()!=curly) return false;
                    break;
                case '[':
                    stack.push(square);
                    break;
                case ']':
                    if(stack.pop()!=square) return false;
                    break;
                case '(':
                    stack.push(round);
                    break;
                case ')':
                    if(stack.pop()!=round) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main( String[] args ) {
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo1( args[ i ] ) );
        }
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo2( \"" + args[ i ] + "\" ) -> " + algo2( args[ i ] ) );
        }
    }
}