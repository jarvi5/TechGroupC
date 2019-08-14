package projectList;

public class Main {

	public static void main(String a[]) {
		ViewM v = new ViewM();
		StudentManager m = new StudentManager();
		Controller c = new Controller(m,v);
		c.initController();
	}

}