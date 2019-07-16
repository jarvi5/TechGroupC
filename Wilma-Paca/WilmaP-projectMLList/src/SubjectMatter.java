package proyectolist;

public class SubjectMatter {
	private int id;
	private String subjectname;
	private String subjectcode;
	private int subjectscore;
	
	SubjectMatter(){
		id = 0;
		subjectname = "";
		subjectcode = "";
		subjectscore = 0;
		
	}
	
	public void addSubjectMatter(String sname, String scode, int score) {
		try {
			if(!sname.isEmpty() && !scode.isEmpty()) {
				if((sname != null && scode != null)) {
					if(isValidSname(sname) && isValidScode(scode)) {
						id = id +1;
						addSname(sname);
						addScode(scode);
						addScore(score);
						
					}
				}
			}
			
		}catch  (Exception e){
			System.out.println("Subject matter name and  subject matter code are required "); 
	    }
	}
	
	private void addSname(String sname) {
		try {
			if(isValidSname(sname)) {
				subjectname = sname;
			}
		}catch  (Exception e){
			System.out.println("Subject matter name should contain only alphabetic character "); 
	    }
	}
	
	private void addScode(String scode) {
		try {
			if(isValidScode(scode)) {
				subjectcode = scode;
			}
		}catch  (Exception e){
			System.out.println("Subject matter name should contain only alphabetic character "); 
	    }
	}
	
	private void addScore(int score) {
		try {
			if(isValidScore(score) && score >= 0) {
				subjectscore = score;
			}
		}catch  (Exception e){
			System.out.println("Score should contain only numbers and should be equal or more than 0"); 
	    }
	}
	
	private static boolean isValidSname(String strvalue) {
		
		if(!strvalue.matches("^[a-zA-Z]*$") ) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isValidScore(int score) {
		
		if(!Integer.toString(score).matches("^[0-9]*$") ) {
			return false;
		}
		
		return true;
		
	}
	
	private static boolean isValidScode(String strvalue) {
		
		if(strvalue.matches("^[a-zA-Z0-9]*$")) {
			return true;
		}
		
		return false;
	}
	
	public String getSname() {
		return subjectname;
	}
	
	public String getScode() {
		return subjectcode;
	}
	
	public int getScore() {
		return subjectscore;
	}
	
	public int getSmatterId() {
		return id;
	}
	
	public static void main(String[] args) {
		SubjectMatter materia = new SubjectMatter();
		materia.addSubjectMatter("mate","fgt3",45);
		materia.addSname("ret323");
		System.out.println(" materia "+materia.getSname());
		System.out.println(" codigo "+materia.getScode());
		System.out.println(" score "+materia.getScore());
		System.out.println(" id "+materia.getSmatterId());
	}

}
/*
^                 # start-of-string
(?=.*[0-9])       # a digit must occur at least once
(?=.*[a-z])       # a lower case letter must occur at least once
(?=.*[A-Z])       # an upper case letter must occur at least once
(?=.*[@#$%^&+=])  # a special character must occur at least once
(?=\S+$)          # no whitespace allowed in the entire string
.{8,}             # anything, at least eight places though
$                 # end-of-string */