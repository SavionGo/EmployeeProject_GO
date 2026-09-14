package version2;

public class Name {
    public Name() {
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = "";
    }

    public Name(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    private String firstName;
    private String middleName;
    private String lastName;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void displayName() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " " + middleName.charAt(0) + ".";
    }
}
