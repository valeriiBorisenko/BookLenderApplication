package se.lexicon.model;

public class Person {
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;

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
        if (firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("Firstname should not be null or empty.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Lastname should not be null or empty.");
        this.lastName = lastName;
    }

    public String getPersonInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", name: ").append(firstName).append(" ").append(lastName);
        return sb.toString();
    }
}
