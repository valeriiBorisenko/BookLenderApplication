package se.lexicon.model;

import java.util.UUID;

public class Book {
    private final String id;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.setTitle(title);
        this.setAuthor(author);
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        if (borrower != null) this.available = false;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title should not be null or empty.");
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author should not be null or empty.");
        this.author = author;
    }

    public String getBookingInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", book: ").append(title);
        sb.append(", author: ").append(author);
        sb.append(", available: ").append(available);
        return sb.toString();
    }
}
