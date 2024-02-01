import java.io.*;

//Déclaration de la classe qui permet la lecture du fichier des commandes.
public class LireCommande{
  public static void main(String[] args) throws Exception {
   //Lecture fichier des commandes saisies par le joueur.
   File doc = new File("./SaisieCommande.txt");
   //Appel de la classe Buffereader qui permet de lire le fichier en entrée et le mettre dans le buffer.
    BufferedReader obj = new BufferedReader(new FileReader(doc));

    String strng;
    //Boucle while qui permet de parser le fichier à la recherche de la commande et de son argument.
    while ((strng = obj.readLine()) != null) 
    {
    							
                                     //J'utilise un switch pour distinguer les commandes et les arguments. 
                                      switch(strng.substring(0, 4)) {
                                        case "LINK":
                                        		    //Affichage de la commande.
                                                          System.out.println("Commande=LINK");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "GRAB":
                                        		    //Affichage de la commande.
                                                          System.out.println("Commande=GRAB");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "DROP":
                                                          //Affichage de la commande.
                                                          System.out.println("Commande=DROP");
                                                          break;
                                        case "COPY":
                                        		    //Affichage de la commande.
                                                          System.out.println("Commande=COPY");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "MULI":
                                        		   //Affichage de la commande.
                                                          System.out.println("Commande=MULI");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "ADDI":
                                                         //Affichage de la commande.
                                                          System.out.println("Commande=ADDI");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "SUBI":
                                        		    //Affichage de la commande.
                                                          System.out.println("Commande=SUBI");
                                                          //Affichage  de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                        case "MAKE":
                                                         //Affichage de la commande. 
                                                          System.out.println("ommande=MAKE");
                                                          break;
                                        case "MARK":
                                                          //Affichage de la commande.
                                                          System.out.println("Commande=MARK");
                                                          break;
                                        case "HALT":
                                                         //Affichage de la commande.
                                                          System.out.println("Commande=HALT");
                                                          break;                   
                                        case "FJMP":
                                          	           //Affichage de la commande.
                                                          System.out.println("ommande=FJMP");
                                                          //Affichage de l'argument.
                                                          System.out.println("Argument="+strng.substring(5, strng.length()));
                                                          break;
                                    }                             
  };
}
}
