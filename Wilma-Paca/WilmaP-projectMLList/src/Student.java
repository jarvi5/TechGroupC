package projectList;
import java.time.LocalDate;
import java.util.Random;

public class Student implements Comparable{
	
    private  String id;
    private  String fname;
    private  String lname;
	
    Student(){
	id = "";
	fname = "";
	lname = "";
    }
        
    public Student(String name,String lastName){
        id = generateID();
        fname = name;
        lname = lastName;
    }
        
    public void setId(String id){
        this.id = id;
    }
    
    public  boolean isValidString(String strvalue) {
	boolean res = true;
	if(!strvalue.matches("^[A-Za-z]*$") ) {
            res = false;
	}
	return res;
    }
	
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
	
    public String getFname() {
        return fname;
    }
	
    public String getLname() {
        return lname;
    }
	
    public String getStudentId() {
        return id;
    }

    @Override
    public int compareTo(Object s) {
        int res = -1; // if the students are not the same
        
        if(((Student) s).getStudentId().equals(this.id)){
            res = 0; // if the students are the same
        }
        return res;
    }

    private String generateID() {
        LocalDate date = LocalDate.now();
        Random r = new Random();
        String res = "";
        if(date.getMonthValue() < 10){
            res = "SIS" + date.getYear() + "0" + date.getMonthValue() + r.nextInt(999);
        } else{
            res = "SIS" + date.getYear() + date.getMonthValue() + r.nextInt(999);
        }
        return res;
    }
}