package projectList;

import java.util.Iterator;


public class StudentManager {
	MultipleLinkedList<Student,DobleLinkedList<SubjectMatter>> listStudent ;
	CompoundNode<Student ,DobleLinkedList<SubjectMatter>> mnode;
	DobleLinkedList<SubjectMatter> subjectList;

	public StudentManager() {
		 listStudent = new MultipleLinkedList<Student ,DobleLinkedList<SubjectMatter> >();
	 }
	
	public void addValuesStudent(String fname, String lname) {
		System.out.println(fname +"  "+ lname);
		Student st = new Student();
		if(st.isValidString(fname) && st.isValidString(lname)) {			
			listStudent.addEnding(new Student(fname,lname),new DobleLinkedList<SubjectMatter>());
		}		
		
	}
	
	public void addValuesSubject(String studentId,String sname,String scode, int score) {
		
		SubjectMatter subject = new SubjectMatter();
		Student studentAux = new Student();
		studentAux.setId(studentId);
		if(!studentId.isEmpty()) {
			subjectList = listStudent.findDataByKey(studentAux);
			if((subject.isValidSname(sname) && subject.isValidScode(scode)) || subject.isValidScore(score)) {
				subjectList.addLast(new SubjectMatter(sname,scode,score));
			}
			
		}
	}
	
	public Student searchStudent(String studentId) {
		System.out.println(studentId);
		String tmp = "";
		if(!studentId.isEmpty()) {
			Iterator it = listStudent.iterator();
			while(it.hasNext()) {
				mnode =   (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();

				System.out.println("---"+mnode.getKey().getStudentId());
				if((mnode.getKey().getStudentId()).toLowerCase().equals(studentId.toLowerCase())) {
				    System.out.println("found "+studentId);
					return mnode.getKey();
				}
			}
		}		
		return null;
	}
	
		
	public Student getNextStudent(String studentId) {
		Student tmp = null;
		if(listStudent.size() > 1) {
			Iterator it = listStudent.iterator();
			while(it.hasNext()) {
				mnode =   (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
	
				System.out.println("---"+mnode.getKey().getStudentId());
				if((mnode.getKey().getStudentId()).toLowerCase().equals(studentId.toLowerCase())) {
				    System.out.println("found "+studentId);
				    if(mnode.getNext() != null) {
				    	tmp = mnode.getNext().getKey();
				    }
					
				}
			}
		}else {
			tmp = listStudent.getFirst().getKey();
		}
		return tmp;
	}
	
	public Student getPreviousStudent(String studentId) {
		Student tmp = null;
		if(listStudent.size() > 1) {
			Iterator it = listStudent.iterator();
			while(it.hasNext()) {
				mnode =   (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
	
				System.out.println("---"+mnode.getKey().getStudentId());
				if((mnode.getKey().getStudentId()).toLowerCase().equals(studentId.toLowerCase())) {
				    System.out.println("found "+studentId);
				    if(mnode.getBefore() != null) {
				    	tmp = mnode.getBefore().getKey();
				    }else {
				    	tmp = listStudent.getFirst().getKey();
				    }
					
				}
			}
		}else {
			tmp = listStudent.getFirst().getKey();
		}
			
		return tmp;
	}
	
	public DobleLinkedList<SubjectMatter> getAllSubjectOfStudent(String studentId){

		if(!studentId.isEmpty()) {
			Iterator it = listStudent.iterator();
			while(it.hasNext()) {
				mnode = (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
				if((mnode.getKey().getStudentId()).equals(studentId)) {
					return mnode.getData();
				}
			}
		}
		return null;
		
	}
	
	public void editStudent(String studentId, String fname, String lname) {
		Iterator it = listStudent.iterator();
		while(it.hasNext()) {
			mnode =  (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
			if((mnode.getKey().getStudentId()).equals(studentId)) {
				mnode.getKey().setFname(fname);
				mnode.getKey().setLname(lname);
			}
		}
	}
	/*
	public void editSubject(String studentId,String sidBefore, String sname,String scode, int score) {
		String tmp = "";
		Iterator it = listStudent.iterator();
		while(it.hasNext()) {
			mnode = (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
			if((mnode.getKey().getStudentId()).toLowerCase().equals(studentId.toLowerCase())) {
				editSubjectChild(mnode.getData(), sidBefore, sname, scode,  score);
			}
		}
	}*/
	
	public void editSubjectChild(DobleLinkedList<SubjectMatter> children , String idCodeBefore, String sname,String scode, int score) {
		DobleLinkedList<SubjectMatter> nchild = new DobleLinkedList<SubjectMatter>();
		SubjectMatter subject = new SubjectMatter();
		Iterator it = children.iterator();
		while(it.hasNext()) {
			subject =    (SubjectMatter) it.next();
			if(subject.getSubjectcode().equals(idCodeBefore)) {
				subject.setSubjectname(sname);
				subject.setSubjectcode(scode);
				subject.setSubjectscore(score);
			}
		}
	}
	
	
	public Student getLastStudent() {
	    Student res = null;
		if(listStudent.getLast() !=null){
	        res = listStudent.getLast().getKey();
	    }
	    return res;
	}
	
	public MultipleLinkedList<Student, DobleLinkedList<SubjectMatter>> getList(){
		return listStudent;
	}
	
	public void printStudent() {
		System.out.println("student :::");
		Iterator it = listStudent.iterator();
		while(it.hasNext()) {
			mnode =  (CompoundNode<Student, DobleLinkedList<SubjectMatter>>) it.next();
			System.out.println("student ->:::");
			System.out.println(mnode.getKey().getStudentId());
			System.out.println(mnode.getKey().getFname());
			System.out.println(mnode.getKey().getLname());
			if(mnode.getKey().getFname().equals("paty")) {
				System.out.println("Es igual");
			}
		}
	}
	
	public static void main(String a[]){
        
		StudentManager m=new StudentManager();
		m.addValuesStudent("paty", "mari");
		m.addValuesStudent("mary", "matrtri");
		m.addValuesStudent("mau", "mariwq");
		m.printStudent();
		System.out.println(m.getLastStudent().getFname());
	}
}
