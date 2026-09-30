package version6;

import java.util.Objects;

// final: Name cannot be subclassed.
public final class Name implements Cloneable {
    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
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
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.firstName = firstName.trim();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName == null) {
            throw new NullPointerException("Middle name cannot be null");
        }
        this.middleName = middleName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.lastName = lastName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        if (suffix == null) {
            throw new NullPointerException("Suffix cannot be null");
        }
        this.suffix = suffix.trim();
    }

    public String getMiddleInitial() {
        if (middleName.isEmpty()) {
            return "";
        }
        return Character.toUpperCase(middleName.charAt(0)) + ".";
    }

    public String getFullName() {
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
