package version4;

import java.util.Objects;

public class Name implements Cloneable {
    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        this.middleName = "";
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName == null) ? "" : firstName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null) ? "" : middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName == null) ? "" : lastName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix.trim();
    }

    public String getMiddleInitial() {
        if (middleName.isEmpty() || middleName.equals("N/A")) {
            return "";
        }
        return Character.toUpperCase(middleName.charAt(0)) + ".";
    }

    public String getFullName() {
        if (firstName.equals("N/A") && lastName.equals("N/A")) {
            return "N/A";
        }

        String fullName = lastName + ", " + firstName;
        if (!getMiddleInitial().isEmpty()) {
            fullName += " " + getMiddleInitial();
        }
        if (!suffix.isEmpty()) {
            fullName += " " + suffix;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), middleName.toLowerCase(),
                lastName.toLowerCase(), suffix.toLowerCase());
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
