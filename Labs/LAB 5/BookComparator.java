import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }

    public ArrayList<Book> sort(ArrayList<Book> lib) {
        List<Book> books = new ArrayList<Book>();
        books = lib;
        //Collections.sort(books);
        return lib;
    }
    // Implement the comparator method for books.

}