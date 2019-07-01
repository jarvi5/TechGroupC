import javax.swing.JOptionPane;

public class Controller {
    private UserManager userManager;
    private View view;

    public Controller(UserManager userManager, View view) {
        this.userManager = userManager;
        this.view = view;
    }

    public void initController() {
        view.getAddBtn().addActionListener(e -> saveUserName());
        view.getSearchBtn().addActionListener(e -> search());
        view.getPrevBtn().addActionListener(e -> previousUser());
        view.getNextBtn().addActionListener(e -> nextUser());
    }

    private void saveUserName() {
        userManager.setModel(new User(view.getFirstNameTextField().getText(), view.getLastNameTextField().getText()));
        view.getTextField().setText(userManager.getLastUserName());
        JOptionPane.showMessageDialog(null, userManager.getLastUserName()
                + " was successful saved", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void search() {
        view.getTextField().setText(
                userManager.searchUser(view.getFirstNameTextField().getText(), view.getLastNameTextField().getText()));
    }

    private void previousUser() {
        if (userManager.getIndex()>0){
            view.enablePrevButton();
            view.getTextField().setText(userManager.previousUser());}
            else {view.disablePrevButton();}
    }

    private void nextUser() {
        if (userManager.getIndex()<userManager.getUserList().size()-1){
            view.enableNextButton();
            view.getTextField().setText(userManager.nextUser());}
        else {view.disableNextButton();}
    }
}