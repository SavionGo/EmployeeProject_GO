package version2;

public class Name {
    public Name() {
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
    }

    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        this.middleName = "";
    }

    public Name(String firstName, String lastName, String middleName) {
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
    }

    private String firstName;
    private String middleName;
    private String lastName;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null) ? "" : middleName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName == null) ? "" : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName == null) ? "" : lastName.trim();
    }

    public String getMiddleInitial() {
        if (middleName.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(middleName.charAt(0)) + ".";
    }

    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty() && middleName.isEmpty()) {
            return "N/A";
        }

        String fullName = lastName + ", " + firstName;
        if (!middleName.isEmpty()) {
            fullName += " " + getMiddleInitial();
        }
        return fullName;
    }

    public void displayName() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
