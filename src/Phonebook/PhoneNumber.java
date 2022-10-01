package Phonebook;

public class PhoneNumber {

    private int areaCode, prefix, lineNumber;

    // Constructor that gets the string and splits it into 3 sets of integers
    public PhoneNumber(String x) {
        String arr[] = x.split("-");
        areaCode = Integer.parseInt(arr[0]);
        prefix = Integer.parseInt(arr[1]);
        lineNumber = Integer.parseInt(arr[2]);
    }

    // Constructor that gets 3 sets of integers
    public PhoneNumber(int x, int y, int z) {
        areaCode = x;
        prefix = y;
        lineNumber = z;
    }

    // copy constructor
    public PhoneNumber(PhoneNumber number) {
        this.areaCode = number.areaCode;
        this.prefix = number.prefix;
        this.lineNumber = number.lineNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String toString() {
        return String.format("%03d", areaCode) + "-" + String.format("%03d", prefix) + "-" + String.format("%04d", lineNumber);
    }

    public boolean isEqualTo(PhoneNumber other) {
        return other.toString().equals(areaCode + "-" + prefix + "-" + lineNumber);
    }
}
