package se.lexicon.model;

import java.util.Arrays;

public class Person {
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private Book[] books = new Book[0];

    public Person(String firstName, String lastName) {
        this.id = Person.getNextId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public int getId() {
        return this.id;
    }

    public static int getNextId() {
        return ++sequencer;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("Firstname should not be null or empty.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Lastname should not be null or empty.");
        this.lastName = lastName;
    }

    public void loanBook(Book book) {
        if (!book.getAvailable()) throw new IllegalArgumentException("Book '" + book.getTitle() + "' is not available.");
        book.setBorrower(this);
        this.books = addBook(books, book);
    }

    public void returnBook(Book book) {
        book.setBorrower(null);
        this.books = removeBook(book);
    }

    public Book[] getBooks() {
        return books;
    }

    private static Book[] addBook(Book[] array, Book addBook) {
        Book[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = addBook;

        return newArray;
    }

    private Book[] removeBook(Book removeBook) {
        Book[] newArray = new Book[books.length - 1];
        int newIndex = 0;

        for (Book book : books) {
            if (!book.getId().equals(removeBook.getId())) {
                newArray[newIndex] = book;
                newIndex++;
            }
        }
        return newArray;
    }

    public String getPersonInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", name: ").append(firstName).append(" ").append(lastName);
        if (books.length > 0) {
            sb.append(", books: ");
            for (Book book: books) {
                sb.append(book.getTitle()).append(", ");
            }
        }
        return sb.toString();
    }
}