import java.util.Iterator;
import java.util.LinkedList;

public class Model {

 private LinkedList<String> firstname;
 private LinkedList<String> lastname;
 private int maximunlenght = 20;
 private int size;
	 
 public Model(String fname, String lname) {
	 firstname = new LinkedList<String>();
	 lastname = new LinkedList<String>();
	 setFirstname(fname);
	 setLastname(lname);
 }
 
 public Model() {
	 firstname = new LinkedList<String>();
	 lastname = new LinkedList<String>();
 }

 public String getFirstname() {
	 return firstname.getLast();
 }

 public void setFirstname(String fname) {
	 try {
		 if(validatePersonalInformation(fname)) {
			 firstname.add(fname.toLowerCase());
			 
		 }
		 
	 }catch (Exception e){
			System.out.println("Missing the value.");
		 
	 }
	 
 }

 public String getLastname() {
	 return lastname.getLast();
 }

 public void setLastname(String lname) {
	 try {
		 if(validatePersonalInformation(lname)) {
			 lastname.add(lname.toLowerCase());
			 
		 }
		 		 
	 }catch (Exception e){
			System.out.println("Missing the value");
	 }
	 
 }
 
 private boolean validatePersonalInformation(String data) {
	 try {
		 if(!data.isEmpty()) {
			 if(data.length()< maximunlenght) {
				 return true;
			 }
		 }
	 }catch (Exception e){
			System.out.println("Invalid value");
	 }
	 return false;
 }
 
 public String searhByFirstName(String fname) {
	 try {
		 if(!fname.isEmpty()) {
			 return findElementFirstName(fname);
			 
		 }
		 
	 }catch (Exception e){
			System.out.println("Invalid value");
	 }
	 
	 return "    ";
 }
 
 public String searhByLastName(String lname) {
	 try {
		 if(!lname.isEmpty()) {
			 return findElementLastName(lname);
			 
		 }
		 
	 }catch (Exception e){
			System.out.println("Invalid value");
	 }
	 
	 return "  ";
 }
 
 private String findElementFirstName(String fname) {
	 	 
	 try {
		 for(int i = 0; i<firstname.size();i++) {
			 if(firstname.get(i).equals(fname.toLowerCase())) {
				 return firstname.get(i)+"  "+lastname.get(i);
			 }
		 }
	 }catch (Exception e){
			System.out.println("Invalid value"); 
	 }
	 
	 return "NOT FOUND";
 }
 
 private String findElementLastName(String lname) {
 	 
	 try {
		 for(int i = 0; i<lastname.size();i++) {
			 if(lastname.get(i).equals(lname.toLowerCase())) {
				 return firstname.get(i)+"  "+lastname.get(i);
			 }
		 }
	 }catch (Exception e){
			System.out.println("Invalid value"); 
	 }
	 
	 return "NOT FOUND";
 }
 
 private void getSize() {
	 size = firstname.size();
 }
 
 public String getPreviousFirstName() {
	 if((size -1)>=0) {
		 return firstname.get(size-1);
	 }
	 return firstname.get(size);
 }
 
 public String getPreviousLastName() {
	 if((size -1)>=0) {
		 size = size-1;
		return  firstname.get(size-1);
	 }
	 	 
	 return firstname.get(size);
 }
 
 public String getNextFirstName() {
	 if((size+1)<firstname.size()) {
		 return firstname.get(size+1);
	 }
	 return firstname.get(size);
 }
 
 public String getNextLastName() {
	 if((size+1)<lastname.size()) {
		 size = size+1;
		 return lastname.get(size+1);
	 }
	 return lastname.get(size);
 }

}