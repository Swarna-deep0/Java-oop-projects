package com;

import java.util.ArrayList;
import java.util.Date;

/* Created a library management system which is capable of issuing books to the students.
Book should have info like:
Book name
Book Author
Issued to
Issued on
User should be able to add books, return issued books, issue books
Assume that all the users are registered with their names in the central database
 */
class Book{
    String bookname,author,issuedto;
    Date Issuedon;
    boolean isissued;

    public Book(String bookname , String author){
        this.bookname=bookname;
        this.author=author;
        this.isissued = false;
    }
}
class library{
    ArrayList<Book> b1 = new ArrayList<>(); // It acts like a garage ( Memory )

    public void addbook(String bookname , String author){
        b1.add(new Book(bookname,author)); // It create new car ( Book object ) for the garage to store.
        System.out.println(bookname + " by " + "author " + "added to library");
    }

    public void issuebooks(String bookname , String author , String Studentname){
        for (Book book : b1){
            if (book.bookname.equals(bookname) && book.isissued == false){
                book.issuedto = Studentname;
                book.isissued = true;
                book.Issuedon = new Date();
                System.out.println(bookname + " issued to " + Studentname + " on ");
                return;
            }
        }
        System.out.print("The " + bookname + " book not available .");
    }

    public void returnbook(String bookname , String author){
        for(Book book : b1) {
            if (book.bookname.equals(bookname) && book.isissued && book.author.equals(author)) {
                book.issuedto = null;
                book.Issuedon = null;
                book.isissued = false;
                return;
            }
        }
        System.out.println(bookname + "not found");
    }

    public void showbooks(){
        for (Book book : b1){
            System.out.print(book.bookname + " : " + book.author);
            if (book.isissued){
                System.out.print("[ Book issued to " + book.issuedto + " on " + book.Issuedon + "]");
            }
            else {
                System.out.println(" [ Available ]");
            }
        }
    }
}

public class library_management {
    public static void main(String[] args) {
        library l1 = new library();
        l1.addbook("reach and poor","david slingh");
        l1.addbook("Happy days","deep");
        l1.addbook("harry potter","jhonny waker");
        l1.issuebooks("kuwait","hurray","rahul");
        l1.showbooks();

    }
}
