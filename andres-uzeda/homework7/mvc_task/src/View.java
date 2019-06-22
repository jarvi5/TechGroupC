import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class View {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel searchLabel;
    private JLabel searchResultLabel;
    private JLabel navigationLabel;
    private JLabel navigationResultLabel;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JButton addButton;
    private JButton searchButton;
    private JButton nextButton;
    private JButton previousButton;
    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create UI elements
        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        searchLabel =  new JLabel("Search Result :");
        searchResultLabel = new JLabel("");
        navigationLabel = new JLabel("Navigation :");
        navigationResultLabel = new JLabel("");
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameLabel)
                        .addComponent(lastnameLabel).addComponent(searchLabel).addComponent(navigationLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield).addComponent(searchResultLabel).addComponent(navigationResultLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addButton)
                        .addComponent(searchButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(nextButton)
                        .addComponent(previousButton)));
        //second group label
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstnameLabel)
                        .addComponent(firstnameTextfield).addComponent(addButton).addComponent(nextButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastnameLabel)
                        .addComponent(lastnameTextfield).addComponent(searchButton).addComponent(previousButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(searchLabel).addComponent(searchResultLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(navigationLabel).addComponent(navigationResultLabel))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, addButton, searchButton);
        layout.linkSize(SwingConstants.HORIZONTAL, nextButton, previousButton);
        frame.getContentPane().setLayout(layout);
    }
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }
    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }
    public void setTestLabel(String text) {
        this.searchLabel = new JLabel(text);
    }
    public JLabel getTestLabel() {
        return searchLabel;
    }
    public JLabel getSearchResultLabel() {
        return searchResultLabel;
    }
    public JLabel getNavigationResultLabel() {
        return navigationResultLabel;
    }
    public JLabel getLastnameLabel() {
        return lastnameLabel;
    }
    public void setLastnameLabel(JLabel lastnameLabel) {
        this.lastnameLabel = lastnameLabel;
    }
    public JTextField getFirstnameTextfield() {
        return firstnameTextfield;
    }
    public void setFirstnameTextfield(JTextField firstnameTextfield) {
        this.firstnameTextfield = firstnameTextfield;
    }
    public JTextField getLastnameTextfield() {
        return lastnameTextfield;
    }
    public void setLastnameTextfield(JTextField lastnameTextfield) {
        this.lastnameTextfield = lastnameTextfield;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }
    public JButton getSearchButton() {
        return searchButton;
    }
    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }
    public JButton getNextButton() {
        return nextButton;
    }
    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }
    public JButton getPreviousButton() {
        return previousButton;
    }
    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }
}