import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();
    
    public Book getBook(int i){
        return library.get(i);
    }

    public int getSize(){
        return library.size();
    }

    public void addBook(Book b){
        library.add(b);
    }

    public void sort(){
        //Collections.sort();
    }


    public void printLibrary(){
        for(int i = 0; i < getSize();i++){
            System.out.println(getBook(i));
        }
    }
}