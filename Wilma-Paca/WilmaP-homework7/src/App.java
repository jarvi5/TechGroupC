public class App {

 public static void main(String[] args) {
  // Assemble all the pieces of the MVC
  Model m = new Model();
  View view = new View();
  Controller c = new Controller(m,view);
  c.initController();
 }

}