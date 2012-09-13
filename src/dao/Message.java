package dao;

public enum Message {
    INVALID_SELECT("Select a valid option!!"),
    SUCCESS_RESERVATION("Thank You! Enjoy the book."),
    NO_BOOK_FOUND("Sorry we don't have that book yet."),
    BOOK_UNAVAILABLE("Sorry, this book has already been reserved."),
    FOR_MORE_DETAIL("Please talk to Librarian. Thank you.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Message parseMessage(String info) {
        if( info == "invalidSelect") {
            return INVALID_SELECT;
        }
        if( info == "successReservation") {
            return SUCCESS_RESERVATION;
        }
        if( info == "noBookFound") {
            return NO_BOOK_FOUND;
        }
        if( info == "alreadyReserved") {
            return BOOK_UNAVAILABLE;
        }
        return FOR_MORE_DETAIL;
    }
}
