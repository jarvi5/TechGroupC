package projectList;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane; // paquete necesario para el Mostrar y administrarla lista


public class ViewM extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private JLabel rfidLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel showLabel;
    private JTextField rfidTextfield;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JButton previousStudentButton;
    private JButton nextStudentButton;
    private JButton searchStudentButton;
    private JButton saveButton;
    
    //Subject section
    private JLabel subjectIdLabel;
    private JLabel subjectNameLabel;
    private JLabel subjectScoreLabel;
    private JTextField subjectIdTextField;
    private JTextField subjectNameTextField;
    private JTextField subjectScoreTextField;
    private JButton editButton;
    private JButton saveSubjectButton;
    
    private static JList subjectlist; //component list
    private static DefaultListModel model;
    private JScrollPane jScrollPane;
    
    
    private JPanel panel; //component JPanel and graylayout
    private GridLayout grid;
    JTextArea textCodeStudent;
    JTextArea textName;
    JTextArea textLName;
    JTextArea textInfoCodeS;
    JTextArea textInfoName;
    JTextArea textInfoLName;
    
    public ViewM() {
        super("STUDENT - app");
        init(); 
    }
    
    public JList getJlist() {
    	return subjectlist;
    }
    
    public JButton getSaveButton(){
        return saveButton;
    }
    
    public JTextField getTextFieldrfid() {
        return rfidTextfield;
    }
    
    public JTextField getTextFieldFirstName() {
        return firstnameTextfield;
    }
    
    public JTextField getTextFieldLastName() {
        return lastnameTextfield;
    }
    
    public JButton getSearchStudentButton() {
        return searchStudentButton;
    }
    
    public JButton getNextStudentButton() {
        return nextStudentButton;
    }
    
    public JButton getPreviousStudentButton() {
        return previousStudentButton;
    }
    
    public JLabel getShowLabel() {
        return showLabel;
    }
    
    public DefaultListModel getShowList() {
        return model;
    }
    
    // Subject section
    public JTextField getTextFieldSubjectName() {
        return subjectNameTextField;
    }
    
    public JTextField getTextFieldSubjectScore() {
        return subjectScoreTextField;
    }
    
    public JTextField getTextFieldSubjectId() {
        return subjectIdTextField;
    }
    
    public JButton getSaveSubjectButton(){
        return saveSubjectButton;
    }
    
    public JButton getEditButton() {
        return editButton;
    }
    
    
    public JTextArea getTextInfoCodeS() {
    	return textInfoCodeS;
    }
    
    public JTextArea getTextInfoName() {
    	return textInfoName;
    }
    
    public JTextArea getTextInfoLName() {
    	return textInfoLName;
    }
    
    public void setEnableSubjectField(boolean editable) {
    	subjectIdTextField.setEditable(editable);
    	subjectScoreTextField.setEditable(editable);
    	subjectNameTextField.setEditable(editable);
    }
    
    public void setTextSubjectFieldToEmpty() {
    	subjectIdTextField.setText("");
    	subjectScoreTextField.setText("");
    	subjectNameTextField.setText("");
    }
    
    private void init() {
        this.setLayout(null);
        this.setBounds(0, 0, 700, 500);
        
        subjectlist = new JList(); //
        model = new DefaultListModel();// modelo de la  lista
        //model.addElement("juan");  // agregar elemento al modelo de la lista
        // modelo.removeElement("juan");  // eliminar elemento al modelo de la lista  //
        subjectlist.setModel(model);
        // lista.getSelectedValue()    // para obtener el elemento seleccionado en la lista
        // lista.getSelectedIndex()    // para obtener el index selexxionado, si no esta selecionado ningun item devuelve -1
        
     // the JPanel that contains the components        
        panel = new JPanel();
        panel.setBounds(20, 80, 300, 95);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Student Info"));
        // set the rows and cols of the grid, as well the distances between them
        grid = new GridLayout(3, 2, 5, 5);
        // what layout we want to use for our frame
        panel.setLayout(grid);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
         
        // add a text field with a specified text to the frame
        textCodeStudent = new JTextArea();
        textCodeStudent.setText("Student code: ");
        textCodeStudent.setEditable(false);
        panel.add(textCodeStudent);
        
        textInfoCodeS = new JTextArea(); //field to display student code
        //textInfoCodeS.setText("sis434");
        textInfoCodeS.setEditable(false);
        panel.add(textInfoCodeS);
        
        textName = new JTextArea();
        textName.setText("First name: ");
        textName.setEditable(false);
        panel.add(textName);
            
        textInfoName = new JTextArea(); // field to display student first name
        //textInfoName.setText("maria ");
        textInfoName.setEditable(false);
        panel.add(textInfoName);
        
        textLName = new JTextArea();
        textLName.setText("Last name: ");
        textLName.setEditable(false);
        panel.add(textLName);
                
        textInfoLName = new JTextArea(); // field to display student last name
        //textInfoLName.setText("pat ");
        textInfoLName.setEditable(false);
        panel.add(textInfoLName);
        
        this.add(panel);
        
        jScrollPane = new JScrollPane(); //Subject list of a student
        jScrollPane.setBounds(20, 200,210, 80);
        jScrollPane.setViewportView(subjectlist);  // the list is into the scroll 
        this.add(jScrollPane);
        
        showLabel = new JLabel();
        showLabel.setText("SUBJECT MATTER");
        showLabel.setBounds(20,180,200,25);
        
        rfidLabel = new JLabel();
        rfidLabel.setText("RFID");
        rfidLabel.setBounds(10,10,100,25);
        
        firstnameLabel = new JLabel();
        firstnameLabel.setText("first name");
        firstnameLabel.setBounds(130,10,150,25);
                    
        lastnameLabel = new JLabel();
        lastnameLabel.setText("last name");
        lastnameLabel.setBounds(300,10,80,25);
        
        rfidTextfield = new JTextField();
        rfidTextfield.setText("");
        rfidTextfield.setBounds(10,40,100,25);
        
        firstnameTextfield = new JTextField();
        firstnameTextfield.setText("");
        firstnameTextfield.setBounds(130,40,150,25);
        
        
        lastnameTextfield = new JTextField();
        lastnameTextfield.setText("");
        lastnameTextfield.setBounds(300,40,150,25);
        
        saveButton = new JButton();
        saveButton.setText("Add Student");
        saveButton.setBounds(500,80,80,25);
        
        previousStudentButton = new JButton();
        previousStudentButton.setText("<");
        previousStudentButton.setBounds(500,40,80,25);
        
        nextStudentButton = new JButton();
        nextStudentButton.setText(">");
        nextStudentButton.setBounds(600,40,80,25);
        
        searchStudentButton = new JButton();
        searchStudentButton.setText("Search Student");
        searchStudentButton.setBounds(600,80,80,25);
        
        // Subject section
        subjectIdLabel = new JLabel();
        subjectIdLabel.setText("Code Subject");
        subjectIdLabel.setBounds(380,180,100,25);
        
        subjectNameLabel = new JLabel();
        subjectNameLabel.setText("Subject name");
        subjectNameLabel.setBounds(380,230,150,25);
                    
        subjectScoreLabel = new JLabel();
        subjectScoreLabel.setText("Score");
        subjectScoreLabel.setBounds(380,280,80,25);
        
        subjectIdTextField = new JTextField();
        subjectIdTextField.setText("");
        subjectIdTextField.setBounds(380,200,100,25);
        
        subjectNameTextField = new JTextField();
        subjectNameTextField.setText("");
        subjectNameTextField.setBounds(380,250,150,25);
                
        subjectScoreTextField = new JTextField();
        subjectScoreTextField.setText("");
        subjectScoreTextField.setBounds(380,300,150,25);
        
        saveSubjectButton = new JButton();
        saveSubjectButton.setText("new Subject");
        saveSubjectButton.setBounds(240,220,120,25);
            
        editButton = new JButton();
        editButton.setText("Edit Subject");
        editButton.setBounds(240,290,120,25);
        
        this.add(rfidLabel);
        this.add(rfidTextfield);
        this.add(firstnameLabel);
        this.add(firstnameTextfield);
        this.add(lastnameLabel);
        this.add(lastnameTextfield);
        this.add(previousStudentButton);
        this.add(nextStudentButton);
        this.add(searchStudentButton);
        this.add(saveButton);
        
        this.add(subjectIdLabel);
        this.add(subjectIdTextField);
        this.add(subjectNameLabel);
        this.add(subjectNameTextField);
        this.add(subjectScoreLabel);
        this.add(subjectScoreTextField);
        this.add(saveSubjectButton);

        this.add(editButton);
        this.add(showLabel);
        this.setLocationRelativeTo(this);
    }
    
    public static void main(String arg[]) {
        ViewM v = new ViewM();
        v.setVisible(true);
        
    }
    
    
}

