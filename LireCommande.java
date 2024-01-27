import java.io.*;

//Déclaration de la classe qui permet la lecture du fichier des commandes.
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
   //Lecture fichier des commandes saisies par le joueur.
   File doc = new File("./Commandes.txt");
    
    BufferedReader obj = new BufferedReader(new FileReader(doc));

    String strng;
    //Boucle while qui permet de parser le fichier à la recherche de la commande et de son argument.
    while ((strng = obj.readLine()) != null) 
    {

                                      switch(strng) {
                                        case "LINK":
                                                          System.out.println("\nCommande=LINK");
                                                          break;
                                        case "GRAB":
                                                          System.out.println("\nCommande=GRAB");
                                                          break;
                                        case "DROP":
                                                          System.out.println("\nCommande=DROP");
                                                          break;
                                        case "COPY":
                                                          System.out.println("\nCommande=COPY");
                                                          break;
                                        case "MULI":
                                                          System.out.println("\nCommande=MULI");
                                                          break;
                                        case "ADDI":
                                                          System.out.println("\nCommande=ADDI");
                                                          break;
                                        case "SUBI":
                                                          System.out.println("\nCommande=SUBI");
                                                          break;
                                        case "MAKE":
                                                          System.out.println("\nCommande=MAKE");
                                                          break;
                                        case "MARK":
                                                          System.out.println("\nCommande=MARK");
                                                          break;
                                        case "HALT":
                                                          System.out.println("\nCommande=HALT");
                                                          break;                   
                                        case "FJMP":
                                                          System.out.println("\nCommande=FJMP");
                                                          break;
                                        default:
                                                          System.out.println("Commande="+strng.substring(0, 4)+" "+"Argument="+strng.substring(5, strng.length()));
                                                          break;
                                    }                             
  }
  //Affichage de chaque commande et de son argument s'il est présent.
  //En cas de non présence de commande et d'argument on envoi null.
  System.out.println(strng);
}

}
