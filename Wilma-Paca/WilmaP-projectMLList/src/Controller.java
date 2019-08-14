package projectList;

import java.util.Iterator;

import java.awt.event.*;

public class Controller {

 private StudentManager model;
 private ViewM view;

 public Controller(StudentManager m, ViewM view) {
  model = m;
  this.view = view;
  initView();
 }

 public void initView() {
     if(model.getLastStudent() != null){
     view.getTextInfoCodeS().setText(model.getLastStudent().getStudentId());
     view.getTextInfoName().setText(model.getLastStudent().getFname());
     view.getTextInfoLName().setText(model.getLastStudent().getLname());
     
    }else{
        view.getTextInfoCodeS().setText("");
        view.getTextInfoName().setText("");
        view.getTextInfoLName().setText("");
    }
     view.setEnableSubjectField(false);
 }

 public void saveData() {
	 if(!view.getTextFieldFirstName().getText().isEmpty() && !view.getTextFieldLastName().getText().isEmpty()) {
	     model.addValuesStudent(view.getTextFieldFirstName().getText(), view.getTextFieldLastName().getText());  
	     System.out.println("Saving... ");
	     if(model.getLastStudent() != null){
	     view.getTextInfoCodeS().setText(model.getLastStudent().getStudentId());
	     view.getTextInfoName().setText(model.getLastStudent().getFname());
	     view.getTextInfoLName().setText(model.getLastStudent().getLname());
	    }else{
	        view.getTextInfoCodeS().setText("");
	        view.getTextInfoName().setText("");
	        view.getTextInfoLName().setText("");
	    }
     
	 }
 }
 
 public void showFoundStudentData() {
     Student st = model.searchStudent(view.getTextFieldrfid().getText());
     System.out.println(view.getTextFieldrfid().getText());
     if(st != null) {	     
	     System.out.println("rer"+st.getStudentId());
	     view.getTextInfoCodeS().setText(st.getStudentId());
	     view.getTextInfoName().setText(st.getFname());
	     view.getTextInfoLName().setText(st.getLname());
     }else {
         view.getTextInfoCodeS().setText("");
         view.getTextInfoName().setText("");
         view.getTextInfoLName().setText("");    	 
     }
     
 }
 public void showFoundSubjectListData(String studentId) {
	 
     DobleLinkedList<SubjectMatter> subjectList = model.getAllSubjectOfStudent(studentId);
     SubjectMatter subject = new SubjectMatter();
     
	 Iterator it = subjectList.iterator();
	 while(it.hasNext()) {
	   subject =  (SubjectMatter) it.next();   
	   view.getShowList().addElement(subject.getSubjectname());
	   
     }     
     
 }
 
 public void showNextData() {
	 String tmp = view.getTextInfoCodeS().getText();
	 
	 if(!tmp.isEmpty()) {	
		 Student aux = model.getNextStudent(tmp);
		 if(aux != null) {
			 view.getTextInfoCodeS().setText(aux.getStudentId());
		     view.getTextInfoName().setText(aux.getFname());
		     view.getTextInfoLName().setText(aux.getLname());
		     
		     System.out.println(view.getShowList().size());
		     view.getShowList().removeAllElements();
		     System.out.println(view.getShowList().size());
		     showFoundSubjectListData(aux.getStudentId());
		     System.out.println(view.getShowList().size());
		 }
	 }
 }
 
 public void showPreviousData() {
	 String tmp = view.getTextInfoCodeS().getText();
	 
	 if(!tmp.isEmpty()) {
		 Student aux = model.getPreviousStudent(tmp);
		 view.getTextInfoCodeS().setText(aux.getStudentId());
	     System.out.println(view.getTextInfoCodeS().getText());
	     view.getTextInfoName().setText(aux.getFname());
	     view.getTextInfoLName().setText(aux.getLname());
	     view.getShowList().removeAllElements();
	     System.out.println(view.getShowList().size());
	     view.getShowList().removeAllElements();
	     System.out.println(view.getShowList().size());
	     showFoundSubjectListData(aux.getStudentId());
	     System.out.println(view.getShowList().size());
	 }
 }
 
 public void print() {
	 model.printStudent();
 }
 
 public void newSubject() {
	 if(view.getSaveSubjectButton().getText().equals("new Subject"));{
		 view.setEnableSubjectField(true);
		 view.getSaveSubjectButton().setText("Add Subject");
		 saveSubjectData();
	 }
 }
 
 public void saveSubjectData() {
	 String tmp = view.getTextInfoCodeS().getText();
     DobleLinkedList<SubjectMatter> subjectList = model.getAllSubjectOfStudent(tmp); 
     if(!view.getTextFieldSubjectName().getText().isEmpty() && !view.getTextFieldSubjectId().getText().isEmpty()) {
		 model.addValuesSubject(tmp, view.getTextFieldSubjectName().getText(), view.getTextFieldSubjectId().getText(), Integer.parseInt(view.getTextFieldSubjectScore().getText()));
		 view.setTextSubjectFieldToEmpty();
		 view.setEnableSubjectField(false);
		 view.getSaveSubjectButton().setText("new Subject");
		 
		 if(subjectList.getSize() > 0) {
			 view.getShowList().clear();
			 showFoundSubjectListData(tmp);
		 }else {
			 view.getShowList().clear();
			 showFoundSubjectListData(tmp);
		 }
     }
 }
 
 
 public void editSubject() {
	 if(!view.getTextFieldSubjectId().getText().isEmpty()) {		 
		 System.out.println(view.getEditButton().getText().equals("Edit Subject"));
		 if(view.getEditButton().getText().equals("Edit Subject")){
			
			view.setEnableSubjectField(true);
			view.getEditButton().setText("Save Subject");
			System.out.println(view.getEditButton().getText());
			System.out.println(view.getTextFieldSubjectId().getDragEnabled());
			saveEditedSubject();
		 }
	 }
 } 
 
 public void saveEditedSubject() {
	 String scodeIdBefore = view.getTextFieldSubjectId().getText();
	 if(view.getEditButton().getText().equals("Save Subject")) {
		 String tmpStudentId = view.getTextInfoCodeS().getText();
		 DobleLinkedList<SubjectMatter> subjectList = model.getAllSubjectOfStudent(tmpStudentId);
		 view.setEnableSubjectField(true);
		 String sname = view.getTextFieldSubjectName().getText(); 
		 String scodeId = view.getTextFieldSubjectId().getText(); 
		 int score = Integer.parseInt(view.getTextFieldSubjectScore().getText());
		 System.out.println("hey........");
		 if(!sname.isEmpty() && !scodeId.isEmpty()) {
			 model.editSubjectChild(subjectList, scodeIdBefore, sname, scodeId, score);
		 }
		 view.setEnableSubjectField(false);
		 view.getEditButton().setText("Edit Subject");
		 if(subjectList.getSize() > 0) {
			 view.getShowList().clear();
			 showFoundSubjectListData(tmpStudentId);
		 }else {
			 view.getShowList().clear();
			 showFoundSubjectListData(tmpStudentId);
		 }
	 }
 }

 public void showSelectedSubject(MouseEvent evt) {
	 
	 System.out.println(view.getJlist().getSelectedValue());
	 String tmpSubject = (String) view.getJlist().getSelectedValue();
	 String tmp = view.getTextInfoCodeS().getText();
     DobleLinkedList<SubjectMatter> subjectList = model.getAllSubjectOfStudent(tmp);
     SubjectMatter subject = new SubjectMatter();
     if(tmpSubject != null) {
	     Iterator it = subjectList.iterator();
		 while(it.hasNext()) {
		   subject =  (SubjectMatter) it.next();   
		   if(subject.getSubjectname().equals(tmpSubject)) {
			   view.getTextFieldSubjectId().setText(subject.getSubjectcode());
			   view.getTextFieldSubjectName().setText(subject.getSubjectname());
			   view.getTextFieldSubjectScore().setText(Integer.toString(subject.getSubjectscore()));
		   }
		   
	     }
     }
 }
 
 public void initController() {
     view.setVisible(true);
     view.getSaveButton().addActionListener(e -> saveData());
     //view.getSaveButton().addActionListener(e -> saveData());
     view.getSearchStudentButton().addActionListener(e -> showFoundStudentData());
     view.getNextStudentButton().addActionListener(e -> showNextData());
     view.getPreviousStudentButton().addActionListener(e -> showPreviousData());
     view.getSaveSubjectButton().addActionListener(e -> newSubject());
     view.getEditButton().addActionListener(e -> editSubject());
     view.getJlist().addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
        	 showSelectedSubject(evt);
         }
     });
     
 }


}
