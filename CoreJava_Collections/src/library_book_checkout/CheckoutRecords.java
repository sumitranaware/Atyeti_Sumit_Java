package library_book_checkout;

import java.time.LocalDate;

public class CheckoutRecords {
  private String username;
  private String bookTitle;
  private LocalDate checkoutDate;

    public CheckoutRecords(String username, String bookTitle, LocalDate checkoutDate) {
        this.username = username;
        this.bookTitle = bookTitle;
        this.checkoutDate = checkoutDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public String toString() {
        return "CheckoutRecords{" +
                "username='" + username + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", checkoutDate=" + checkoutDate +
                '}';
    }
}
