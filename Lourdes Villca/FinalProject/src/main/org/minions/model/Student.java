package org.minions.model;

/**
 * Class that represent the Student Object.
 */
public class Student {
    private String name;
    private String lastName;
    private String rfid;

    /**
     * Constructor that initialize the attributes.
     *
     * @param name     Name of the Student.
     * @param lastName Last Name Information
     * @param rfid     Rfid Information.
     */
    public Student(String name, String lastName, String rfid) {
        this.name = name;
        this.lastName = lastName;
        this.rfid = rfid;
    }

    /**
     * Method that get the Student Name information.
     *
     * @return the Student Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the Name.
     *
     * @param name Name information.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that get the Last Name.
     *
     * @return the Last Name information.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that set the Last Name.
     *
     * @param lastName last name information.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method that get the Rfid.
     *
     * @return the rfid information.
     */
    public String getRfid() {
        return rfid;
    }

    /**
     * Method that set the rfid.
     *
     * @param rfid rfid information.
     */
    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (((Student) o).getRfid().equals(rfid) &&
                ((Student) o).getLastName().equals(lastName) &&
                ((Student) o).getName().equals(name)) {
            return true;
        }
        return false;
    }
}
