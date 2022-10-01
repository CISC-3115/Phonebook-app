package Phonebook;

class PhonebookEntry {

    private Name name;
    private PhoneNumber number;

// Contructor that recieves the name object and the phonenumber object
    public PhonebookEntry(Name x, PhoneNumber y) {

        name = x;
        number = y;

    }

// Copy constructor
    public PhonebookEntry(PhonebookEntry x) {

        this.name = x.name;
        this.number = x.number;

    }

    public PhoneNumber getPhoneNumber() {

        return number;
    }

    public Name getName() {

        return name;
    }

    public void setPhoneNumber(PhoneNumber num) {

        number = num;

    }

    public void setName(Name name) {

        this.name = name;

    }

    public String toString() {

        return name + ": " + number;

    }

    public String toCsvString() {

        return name + "," + number;

    }

    public boolean isEqualTo(PhonebookEntry x) {

        return this.name.isEqualTo(x.name) && this.number.isEqualTo(x.number);

    }
}
