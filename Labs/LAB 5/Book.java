public class Book {

    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year){
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return getAuthor()+": "+getTitle()+" ("+getYear()+")";
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }
}
