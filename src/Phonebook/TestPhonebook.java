package Phonebook;

import java.io.FileNotFoundException;

public class TestPhonebook {

    public static void main(String[] args) throws FileNotFoundException {
        testNoArgConstructor();
        testParameterizedConstructor();
        testGetNumEntries();
        testIsFull();

        testContainsName();
        testReverseLookup();
        testLookup();

        testAddEntry1();
        testAddEntry2();
        testChangeNumber();
        testReadFromCsvFile();
        testPrintToCsvFile();
    }

    private static void testNoArgConstructor() {
        System.out.println("testing no-arg constructor");
        Phonebook phonebook = new Phonebook();
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Gloria", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Diane", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Ryan", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Luna", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Laura", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Mark", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("David", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.getNumEntries()); // expected: 10
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));
        System.out.println(phonebook.getNumEntries()); // expected: 10
        System.out.println();
    }

    private static void testParameterizedConstructor() {
        System.out.println("testing parameterized constructor");
        Phonebook phonebook = new Phonebook(2);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.getNumEntries()); // expected: 2
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));
        System.out.println(phonebook.getNumEntries()); // expected: 2
        System.out.println();
    }

    private static void testGetNumEntries() {
        System.out.println("testing getNumEntries");

        Phonebook phonebook = new Phonebook(25);
        System.out.println(phonebook.getNumEntries()); // expected: 0
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebook.getNumEntries()); // expected: 1
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.getNumEntries()); // expected: 2

        phonebook = new Phonebook();
        System.out.println(phonebook.getNumEntries()); // expected: 0
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebook.getNumEntries()); // expected: 1
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.getNumEntries()); // expected: 2

        System.out.println();
    }

    private static void testIsFull() {
        System.out.println("testing isFull");

        Phonebook phonebook = new Phonebook(2);
        System.out.println(phonebook.isFull()); // expected: false
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(phonebook.isFull()); // expected: false
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.isFull()); // expected: true

        System.out.println();
    }

    private static void testLookup() {
        System.out.println("testing lookup");

        Phonebook phonebook = new Phonebook(25);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));

        PhoneNumber phoneNumber = phonebook.lookup(new Name("Jane", "Doe"));
        System.out.println(phoneNumber.toString()); // expected: 123-456-7890
        phoneNumber = phonebook.lookup(new Name("John", "Smith"));
        System.out.println(phoneNumber.toString()); // expected: 444-444-4444
        phoneNumber = phonebook.lookup(new Name("Fred", "Carlson"));
        System.out.println(phoneNumber.toString()); // expected: 555-555-5555

        phoneNumber = phonebook.lookup(new Name("John", "Doe"));
        System.out.println(phoneNumber == null); // expected: true

        System.out.println();
    }

    private static void testReverseLookup() {
        System.out.println("testing reverseLookup");

        Phonebook phonebook = new Phonebook(25);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));

        Name name = phonebook.reverseLookup(new PhoneNumber("123-456-7890"));
        System.out.println(name.toString()); // expected: Jane Doe
        name = phonebook.reverseLookup(new PhoneNumber("444-444-4444"));
        System.out.println(name.toString()); // expected: John Smith
        name = phonebook.reverseLookup(new PhoneNumber("555-555-5555"));
        System.out.println(name.toString()); // expected: Fred Carlson

        name = phonebook.reverseLookup(new PhoneNumber("222-222-2222"));
        System.out.println(name == null); // expected: true

        System.out.println();
    }

    private static void testContainsName() {
        System.out.println("testing containsName");

        Phonebook phonebook = new Phonebook(25);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));

        System.out.println(phonebook.containsName(new Name("Jane", "Doe"))); // expected: true
        System.out.println(phonebook.containsName(new Name("John", "Smith"))); // expected: true
        System.out.println(phonebook.containsName(new Name("Fred", "Carlson"))); // expected: true

        System.out.println(phonebook.containsName(new Name("John", "Doe"))); // expected: false

        System.out.println();
    }

    private static void testAddEntry1() {
        System.out.println("testing addEntry 1");

        Phonebook phonebook = new Phonebook(2);
        boolean result = phonebook.addEntry(new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890")));
        System.out.println(result); // expected: true
        System.out.println(phonebook.lookup(new Name("Jane", "Doe")).toString()); // expected: 123-456-7890
        result = phonebook.addEntry(new PhonebookEntry(new Name("Jane", "Doe"), new PhoneNumber("777-777-7777")));
        System.out.println(result); // expected: false
        System.out.println(phonebook.lookup(new Name("Jane", "Doe")).toString()); // expected: 123-456-7890

        result = phonebook.addEntry(new PhonebookEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444")));
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 444-444-4444
        result = phonebook.addEntry(new PhonebookEntry(new Name("John", "Smith"), new PhoneNumber("666-666-6666")));
        System.out.println(result); // expected: false
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 444-444-4444

        result = phonebook.addEntry(new PhonebookEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555")));
        System.out.println(result); // expected: false
        System.out.println(phonebook.containsName(new Name("Fred", "Carlson"))); // expected: false
        System.out.println(phonebook.lookup(new Name("Fred", "Carlson"))); // expected: null

        System.out.println();
    }

    private static void testAddEntry2() {
        System.out.println("testing addEntry 2");

        Phonebook phonebook = new Phonebook(2);
        boolean result = phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        System.out.println(result); // expected: true
        System.out.println(phonebook.lookup(new Name("Jane", "Doe")).toString()); // expected: 123-456-7890
        result = phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("777-777-7777"));
        System.out.println(result); // expected: false
        System.out.println(phonebook.lookup(new Name("Jane", "Doe")).toString()); // expected: 123-456-7890

        result = phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 444-444-4444
        result = phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("666-666-6666"));
        System.out.println(result); // expected: false
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 444-444-4444

        result = phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));
        System.out.println(result); // expected: false
        System.out.println(phonebook.containsName(new Name("Fred", "Carlson"))); // expected: false
        System.out.println(phonebook.lookup(new Name("Fred", "Carlson"))); // expected: null

        System.out.println();
    }

    private static void testChangeNumber() {
        System.out.println("test change num");
        Phonebook phonebook = new Phonebook(25);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555"));

        boolean result = phonebook.changeNumber(new Name("John", "Smith"), new PhoneNumber("666-666-6666"));
        System.out.println(result); // expected: true
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 666-666-6666

        result = phonebook.changeNumber(new Name("John", "Doe"), new PhoneNumber("777-777-7777"));
        System.out.println(result); // expected: false
        System.out.println(phonebook.containsName(new Name("John", "Doe"))); // expected: false
        System.out.println(phonebook.lookup(new Name("John", "Doe"))); // expected: null

        System.out.println();
    }

// entries_input.txt:
/*
Jane Doe,123-456-7890
John Smith,444-444-4444
Fred Carlson,555-555-5555
John Smith,666-666-6666
     */
    private static void testReadFromCsvFile() throws FileNotFoundException {
        System.out.println("testing readFromCsvFile");
        Phonebook phonebook = new Phonebook(4);
        phonebook.readFromCsvFile("input.txt");
        System.out.println(phonebook.getNumEntries()); // expected: 3
        System.out.println(phonebook.lookup(new Name("John", "Smith")).toString()); // expected: 444-444-4444
        System.out.println();
    }

    private static void testPrintToCsvFile() throws FileNotFoundException {
        System.out.println("testing printToCsvFile");
        Phonebook phonebook = new Phonebook(25);
        phonebook.addEntry(new Name("Jane", "Doe"), new PhoneNumber("123-456-7890"));
        phonebook.addEntry(new Name("John", "Smith"), new PhoneNumber("444-444-4444"));
        phonebook.addEntry(new Name("Fred", "Carlson"), new PhoneNumber("555-555-5555")); 
        phonebook.printToCsvFile("entries_output.txt");
        System.out.println();
    }

}
