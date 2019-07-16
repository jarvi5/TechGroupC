package proyectolist;

public class Student {
	
	private static int id;
	private  String fname;
	private  String lname;
	
	Student(){
		id = 0;
		fname = "";
		lname = "";
	}
	
	public  void addStudent(String fname, String lname) {
		
		try {
			if((!fname.isEmpty() && !lname.isEmpty()) || (fname != null && lname != null)) {
				if(isValidString(fname) && isValidString(lname)) {
					id = id + 1;
					this.fname = fname;
					this.lname = lname;
				}
			}
		}catch  (Exception e){
			System.out.println("Frist name and last name required and they should only contains alfabetic character"); 
	     }
		
	}
	
	private static boolean isValidString(String strvalue) {
		
		if(!strvalue.matches("^[a-zA-Z]*$") ) {
			return false;
		}
		
		return true;
	}
	
	public void setFname(String fname) {
		try {
			if(isValidString(fname)) {
				this.fname = fname;
			}
		}catch  (Exception e){
			System.out.println("First name should only contains alfabetic character"); 
	    }
	}
	
	public void setLname(String lname) {
		try {
			if(isValidString(lname)) {
				this.lname = lname;
			}
		}catch  (Exception e){
			System.out.println("Last name should only contains alfabetic character"); 
	    }
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
	
		Student st = new Student();
		st.addStudent("maria", "pat");
		System.out.println(st.getFname());
		st.setFname("we54");
		System.out.println(st.getFname());
		st.setFname("");
		
		
	}

}
