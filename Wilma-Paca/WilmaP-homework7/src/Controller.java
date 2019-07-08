import javax.swing.JOptionPane;

public class Controller {

 private Model model;
 private View view;

 public Controller(Model m, View view) {
  model = m;
  this.view = view;
  initView();
 }

 public void initView() {
  //view.getFirstnameTextfield().setText(model.getFirstname());
  //view.getLastnameTextfield().setText(model.getLastname());
 }

 public void saveData() {
	 model.setFirstname(view.getTextFieldFirstName().getText());
	 System.out.println("firstname saved: " + model.getFirstname());
	 model.setLastname(view.getTextFieldLastName().getText());
	 System.out.println("lastname saved: " + model.getLastname());
	 view.getShowLabel().setText(model.getFirstname()+"   "+model.getLastname());
 }
 
 public void showFoundData() {
	 view.getShowLabel().setText("<html>"+model.searhByFirstName(view.getTextFieldFirstName().getText())+"<br>"+model.searhByLastName(view.getTextFieldLastName().getText())+"</html>");
	 
 }
 
 public void showNextData() {
	 view.getTextFieldFirstName().setText(model.getNextFirstName());
	 view.getTextFieldLastName().setText(model.getNextLastName());	 
 }
 
 public void showPreviousData() {
	 view.getTextFieldFirstName().setText(model.getPreviousFirstName());
	 view.getTextFieldLastName().setText(model.getPreviousLastName());
 }
 
 public void initController() {
	 view.setVisible(true);
	 view.getSaveButton().addActionListener(e -> saveData());
	 view.getSearchButton().addActionListener(e -> showFoundData());
	 view.getNextButton().addActionListener(e -> showNextData());
	 view.getPreviousButton().addActionListener(e -> showPreviousData());
	 
 }


}