import javax.swing.JOptionPane;
public class Controller {
    private Model model;
    private View view;
    private ArrayListModelData listModel;
    public Controller(Model m, View v) {
        model = m;
        view = v;
        listModel = new ArrayListModelData();
        initView();
    }
    public void initView() {
        view.getFirstnameTextfield().setText(model.getFirstname());
        view.getLastnameTextfield().setText(model.getLastname());
    }
    public void initController() {
        view.getAddButton().addActionListener(e -> addPerson());
        view.getSearchButton().addActionListener(e -> searchResult());
        view.getNextButton().addActionListener(e -> nextResult());
        view.getPreviousButton().addActionListener(e -> previousResult());
    }

    private void addPerson(){
        listModel.setLinkedListModel(new Model(view.getFirstnameTextfield().getText(),view.getLastnameTextfield().getText()));JOptionPane.showMessageDialog(null, "Person: " + view.getFirstnameTextfield().getText() + " " + view.getLastnameTextfield().getText() + " was added", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void nextResult(){
        String result = listModel.searchNext();
        view.getNavigationResultLabel().setText(result);
    }
    private void previousResult(){
        String result = listModel.searchPrevious();
        view.getNavigationResultLabel().setText(result);
    }

    private void searchResult(){
        String result = listModel.searchAPersonInToCollection(view.getFirstnameTextfield().getText()+ ' ' +view.getLastnameTextfield().getText());
        view.getSearchResultLabel().setText(result);
    }
}