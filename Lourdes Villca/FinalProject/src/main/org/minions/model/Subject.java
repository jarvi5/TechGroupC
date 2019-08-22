package org.minions.model;

/**
 * Class that represent the Subject Object.
 */
public class Subject {
    private String name;
    private String id;
    private double finalNote;

    /**
     * Constructor that initialize attributes.
     *
     * @param name      Name subject information.
     * @param id        Id subject information.
     * @param finalNote Final grade information.
     */
    public Subject(String name, String id, double finalNote) {
        this.name = name;
        this.id = id;
        this.finalNote = finalNote;
    }

    /**
     * Method that get the Name information.
     *
     * @return Name information.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the name information.
     *
     * @param name Name subject information.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that get the identifier information.
     *
     * @return the Id information.
     */
    public String getId() {
        return id;
    }

    /**
     * Method that set the Identifier information.
     *
     * @param id Id information.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method that get the Final Note Information
     *
     * @return Final grade information
     */
    public double getFinalNote() {
        return finalNote;
    }

    /**
     * Method that set the Final grade information
     *
     * @param finalNote final grade information.
     */
    public void setFinalNote(int finalNote) {
        this.finalNote = finalNote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
