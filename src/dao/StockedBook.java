package dao;

public class StockedBook {
    private String bookName;
    private int version;
    private String authorName;
    private String publisher;
    private User reserver;
    private boolean checkedStatus;

    public StockedBook(String bookName, int version, String authorName, String publisher) {
        this.bookName = bookName;
        this.version = version;
        this.authorName = authorName;
        this.publisher = publisher;
        checkedStatus = false;
    }

    public String getBookName() {
        return bookName;
    }

    public int getVersion() {
        return version;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean getCheckedStatus() {
        return checkedStatus;
    }


    public void setCheckedStatus(boolean status) {
        checkedStatus = status;
    }

    public void setReserver(User user) {
        reserver = user;
    }

    public User getReserver() {
        return reserver;
    }

    public void printBookInfo() {
        System.out.println(bookName + "\t" + version + "\t" + authorName + "\t" + publisher+ "\n");
    }
}
