package se.lexicon;

import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Snow");
        Person person2 = new Person("Bran", "Stark");

        System.out.println(person1.getPersonInformation());
        System.out.println(person2.getPersonInformation());

        Book book1 = new Book("Game of Thrones", " George R. R. Martin");
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", person1);

        System.out.println(book1.getBookingInformation());
        System.out.println(book2.getBookingInformation());
    }
}