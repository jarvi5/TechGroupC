package view;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel rfidLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel courseLabel;
    private JLabel detailCourseLabel;
    private JTextField rfidTextfield;
    private JTextField firstNameTextfield;
    private JTextField lastNameTextfield;
    private JTextField courseTextfield;
    private JTextField detailCourseTextfield;
    private JButton manageStudentButton;
    private JButton nextStudentButton;
    private JButton previousStudentButton;
    private JButton manageCourseButton;
    private JButton nextCourseButton;
    private JButton previousCourseButton;
    /****/
    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create UI elements
        rfidLabel = new JLabel("RFID");
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        courseLabel = new JLabel("Course");
        detailCourseLabel = new JLabel("Detail Course");
        rfidTextfield = new JTextField();
        firstNameTextfield = new JTextField();
        lastNameTextfield = new JTextField();
        courseTextfield = new JTextField();
        detailCourseTextfield = new JTextField();
        manageStudentButton = new JButton("Manage Student");
        nextStudentButton = new JButton(">");
        previousStudentButton = new JButton("<");
        manageCourseButton = new JButton("Manage Course");
        nextCourseButton = new JButton(">");
        previousCourseButton = new JButton("<");
        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(rfidLabel).addComponent(rfidTextfield).addComponent(courseLabel).addComponent(previousCourseButton).addComponent(courseTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstNameLabel).addComponent(firstNameTextfield).addComponent(nextCourseButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lastNameLabel).addComponent(lastNameTextfield).addComponent(detailCourseLabel).addComponent(detailCourseTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(manageStudentButton).addComponent(previousStudentButton).addComponent(nextStudentButton).addComponent(manageCourseButton))
                );
        //second group label
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(rfidLabel).addComponent(firstNameLabel).addComponent(lastNameLabel).addComponent(manageStudentButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(rfidTextfield).addComponent(firstNameTextfield).addComponent(lastNameTextfield).addComponent(previousStudentButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(courseLabel).addComponent(detailCourseLabel).addComponent(nextStudentButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(previousCourseButton).addComponent(nextCourseButton).addComponent(manageCourseButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(courseTextfield).addComponent(detailCourseTextfield))
        );
        frame.getContentPane().setLayout(layout);
    }
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getRfidLabel() {
        return rfidLabel;
    }

    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public JLabel getCourseLabel() {
        return courseLabel;
    }

    public JLabel getDetailCourseLabel() {
        return detailCourseLabel;
    }

    public JTextField getRfidTextfield() {
        return rfidTextfield;
    }

    public JTextField getFirstNameTextfield() {
        return firstNameTextfield;
    }

    public JTextField getLastNameTextfield() {
        return lastNameTextfield;
    }

    public JTextField getCourseTextfield() {
        return courseTextfield;
    }

    public JTextField getDetailCourseTextfield() {
        return detailCourseTextfield;
    }

    public JButton getManageStudentButton() {
        return manageStudentButton;
    }

    public JButton getNextStudentButton() {
        return nextStudentButton;
    }

    public JButton getPreviousStudentButton() {
        return previousStudentButton;
    }

    public JButton getManageCourseButton() {
        return manageCourseButton;
    }

    public JButton getNextCourseButton() {
        return nextCourseButton;
    }

    public JButton getPreviousCourseButton() {
        return previousCourseButton;
    }

    public void setRfidLabel(JLabel rfidLabel) {
        this.rfidLabel = rfidLabel;
    }

    public void setFirstNameLabel(JLabel firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public void setCourseLabel(JLabel courseLabel) {
        this.courseLabel = courseLabel;
    }

    public void setDetailCourseLabel(JLabel detailCourseLabel) {
        this.detailCourseLabel = detailCourseLabel;
    }

    public void setRfidTextfield(JTextField rfidTextfield) {
        this.rfidTextfield = rfidTextfield;
    }

    public void setFirstNameTextfield(JTextField firstNameTextfield) {
        this.firstNameTextfield = firstNameTextfield;
    }

    public void setLastNameTextfield(JTextField lastNameTextfield) {
        this.lastNameTextfield = lastNameTextfield;
    }

    public void setCourseTextfield(JTextField courseTextfield) {
        this.courseTextfield = courseTextfield;
    }

    public void setDetailCourseTextfield(JTextField detailCourseTextfield) {
        this.detailCourseTextfield = detailCourseTextfield;
    }

    public void setManageStudentButton(JButton manageStudentButton) {
        this.manageStudentButton = manageStudentButton;
    }

    public void setNextStudentButton(JButton nextStudentButton) {
        this.nextStudentButton = nextStudentButton;
    }

    public void setPreviousStudentButton(JButton previousStudentButton) {
        this.previousStudentButton = previousStudentButton;
    }

    public void setManageCourseButton(JButton manageCourseButton) {
        this.manageCourseButton = manageCourseButton;
    }

    public void setNextCourseButton(JButton nextCourseButton) {
        this.nextCourseButton = nextCourseButton;
    }

    public void setPreviousCourseButton(JButton previousCourseButton) {
        this.previousCourseButton = previousCourseButton;
    }
}