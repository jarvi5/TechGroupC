package projectList;

import java.util.Random;

public class SubjectMatter implements Comparable{
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
    
    public SubjectMatter(String subjectname,String subjectcode,int subjectscore){
        id = generateId();
	this.subjectname = subjectname;
	this.subjectcode = subjectcode;
	this.subjectscore = subjectscore;
    }
    
    public static boolean isValidSname(String strvalue) {
	boolean res = true;	
        if(!strvalue.matches("^[a-zA-Z]*$") ) {
            res = false;
	}
		
	return res;
    }
	
    public boolean isValidScore(int score) {
	boolean res = true;
        if(!Integer.toString(score).matches("^[0-9]*$") ) {
            res = false;
	}	
	return res;		
    }
	
    public boolean isValidScode(String strvalue) {
        boolean res = false;
        if(strvalue.matches("^[a-zA-Z0-9]*$")) {
            res = true;
		}
        return res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public int getSubjectscore() {
        return subjectscore;
    }

    public void setSubjectscore(int subjectscore) {
        this.subjectscore = subjectscore;
    }

    private int generateId(){
        Random r = new Random();
        return r.nextInt(999);
    }
    
    @Override
    public int compareTo(Object t) {
        int res = -1;
        if(((SubjectMatter)t).getSubjectcode().equals(this.getSubjectcode())){
            res = 0;
        }
        return res;
    }
}
