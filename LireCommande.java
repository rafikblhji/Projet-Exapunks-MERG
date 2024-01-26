import java.io.*;

public class LireCommande{
  public static void main(String[] args) throws Exception {
   String MAKE;
   String LINK,argLINK;
   String GRAB,agrGRAB;
   String MULI,argMULI;
   String ADDI,argADDI;
   String SUBI,argSUBI;
   String DROP;
   String COPY,argCOPY;
   String FJMP,argFJMP;
   String MARK,argMARK;
   String HALT;
    File doc = new File("./Commandes.txt");

    BufferedReader obj = new BufferedReader(new FileReader(doc));

    String strng;
    while ((strng = obj.readLine()) != null) 
    {
    
                                      
                                        
                                    switch(strng) {
                                      case "LINK":
                                                        System.out.println("\nC'est LINK.");
                                                        break;
                                      case "GRAB":
                                                        System.out.println("\nC'est GRAB.");
                                                        break;
                                      case "DROP":
                                                        System.out.println("\nC'est DROP.");
                                                        break;
                                      case "COPY":
                                                        System.out.println("\nC'est COPY.");
                                                        break;
                                      case "MULI":
                                                        System.out.println("\nC'est MULI.");
                                                        break;
                                      case "ADDI":
                                                        System.out.println("\nC'est ADDI.");
                                                        break;
                                      case "SUBI":
                                                        System.out.println("\nC'est SUBI.");
                                                        break;
                                      case "MAKE":
                                                        System.out.println("\nC'est MAKE.");
                                                        break;
                                      case "MARK":
                                                        System.out.println("\nC'est MARK.");
                                                        break;
                                      case "HALT":
                                                        System.out.println("\nC'est HALT.");
                                                        break;                   
                                      case "FJMP":
                                                        System.out.println("\nC'est FJMP.");
                                                        break;
                                      default:
                                                        System.out.println("I don't know which one to order.");
                                                        break;
                                    }
                                    System.out.println(strng);
    }
}

}
