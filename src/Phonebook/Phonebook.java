/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

class Phonebook {

    private PhonebookEntry[] entry;
    private int numOfEntrys;
    public static final int min = 10;
// Constructor w/o paramaters

    public Phonebook() {

        entry = new PhonebookEntry[min];

    }
// Constructor with a capacity constructor

    public Phonebook(int capacity) {

        entry = new PhonebookEntry[capacity];
        numOfEntrys = 0;
    }

    public int getNumEntries() {

        return numOfEntrys;
    }

    public boolean isFull() {

        return (numOfEntrys >= entry.length);

    }

// Lookup method that returns the index of the number if found
    public PhoneNumber lookup(Name name) {

        int index = -1;

        for (int i = 0; i < numOfEntrys; i++) {

            if (entry[i].getName().isEqualTo(name)) {
                index = i;

            }

        }

        if (index != -1) {
            return entry[index].getPhoneNumber();
        }

        return null;
    }
// Lookup method that returns the index of the name if found

    public Name reverseLookup(PhoneNumber phoneNumber) {
        int index = -1;

        for (int i = 0; i < numOfEntrys; i++) {

            if (entry[i].getPhoneNumber().isEqualTo(phoneNumber)) {
                index = i;

            }

        }

        if (index != -1) {
            return entry[index].getName();
        }

        return null;
    }

    public boolean containsName(Name name) {

        for (int i = 0; i < numOfEntrys; i++) {

            if (entry[i].getName().isEqualTo(name)) {
                return true;

            }

        }

        return false;
    }
// Boolean that adds entry if true

    public boolean addEntry(PhonebookEntry Entry) {

        if (isFull()) {

            return false;
        }
        if (containsName(Entry.getName())) {

            return false;
        }

        entry[numOfEntrys] = Entry;
        numOfEntrys++;

        return true;
    }
// Boolean that creates a new object and sends it to the addEntry with the PhonebookEntry parameter

    public boolean addEntry(Name name, PhoneNumber phoneNumber) {

        PhonebookEntry book = new PhonebookEntry(name, phoneNumber);

        return addEntry(book);

    }

    // Another way
//        public boolean addEntry(Name name, PhoneNumber phoneNumber) {
//
//        if (isFull()) {
//
//            return false;
//        }
//
//        if (containsName(name)) {
//
//            return false;
//        }
//
//        entry[numOfEntrys] = new PhonebookEntry(name, phoneNumber);
//
//        numOfEntrys++;
//
//        return true;
//
//    }
    // Method that changes the number if the name is found in the array
    public boolean changeNumber(Name name, PhoneNumber phoneNumber) {
        for (int i = 0; i < numOfEntrys; i++) {

            if (entry[i].getName().isEqualTo(name)) {
                PhonebookEntry book = new PhonebookEntry(name, phoneNumber);
                entry[i] = book;
                return true;

            }

        }
        return false;

    }

    // Method that reads from a file is CSV format
    public void readFromCsvFile(String x) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(x));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] full = line.split(",");
            String total = full[0] + " " + full[1];
            String totalSure[] = total.split(" ");

            PhonebookEntry book = new PhonebookEntry(new Name(totalSure[0], totalSure[1]), new PhoneNumber(totalSure[2]));
            addEntry(book);
        }

    }
// Creates a printWriter object and prints output to file in CSV format

    public void printToCsvFile(String filename) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(filename);
        for (int i = 0; i < numOfEntrys; i++) {
            printWriter.println(entry[i].toCsvString());
        }
        printWriter.close();
    }
}
