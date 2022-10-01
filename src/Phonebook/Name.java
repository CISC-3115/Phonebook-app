package Phonebook;

public class Name {

    private String first, last;

// Constructor with two string parameters 
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }
// Copy constructor
    public Name(Name original) {
        this.first = original.first;
        this.last = original.last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String toString() {
        return first + " " + last;
    }

// Compares two names and returns true if both names are the same
    public boolean isEqualTo(Name other) {
        return this.first.equals(other.first)
                && this.last.equals(other.last);
    }

    public String getInitials() {
        return first.charAt(0) + "." + last.charAt(0) + ".";
    }
}
