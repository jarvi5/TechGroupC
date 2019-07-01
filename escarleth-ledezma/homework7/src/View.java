import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;


public class View {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton addBtn;
    private JButton searchBtn;
    private JButton prevBtn;
    private JButton nextBtn;
    private JTextArea textField;

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        initializeComponents();
        addLayout();
    }

    private void initializeComponents() {
        firstNameLabel = new JLabel("Name :");
        lastNameLabel = new JLabel("Lastname :");
        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        addBtn = new JButton("Save");
        searchBtn = new JButton("Search");
        prevBtn = new JButton("Prev");
        nextBtn = new JButton("Next");
        textField = new JTextArea();
        textField.setEditable(false);
    }

    private void addLayout() {
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstNameLabel).addComponent(lastNameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstNameTextField).addComponent(lastNameTextField).addComponent(textField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addBtn).addComponent(searchBtn).addComponent(prevBtn).addComponent(nextBtn))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstNameLabel).addComponent(firstNameTextField).addComponent(addBtn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel).addComponent(lastNameTextField).addComponent(searchBtn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textField)
                        .addGroup(layout.createSequentialGroup().addComponent(prevBtn).addComponent(nextBtn)))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, nextBtn, prevBtn);
        frame.getContentPane().setLayout(layout);
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getSearchBtn() {
        return searchBtn;
    }

    public JButton getPrevBtn() {
        return prevBtn;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public JTextArea getTextField() {
        return textField;
    }

    public void disablePrevButton() {
        prevBtn.disable();

    }

    public void enablePrevButton() {
        prevBtn.enable();

    }

    public void disableNextButton() {
        nextBtn.disable();
    }

    public void enableNextButton() {
        prevBtn.enable();
    }
}