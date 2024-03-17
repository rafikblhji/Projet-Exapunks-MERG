import java.io.*;
import java.util.*;
// @Author: Mohamed Amine BOUGHRARA
// Since: 15/01/2024

// Déclaration de la classe qui permet la lecture du fichier des commandes.

public class LireCommandeBack{
  public static void main(String[] args) throws Exception {
   //Lecture fichier des commandes saisies par le joueur.
   File doc = new File("./ligne.txt");
   //Appel de la classe BufferedReader qui permet de lire le fichier en entrée et le mettre dans le buffer.
    BufferedReader obj = new BufferedReader(new FileReader(doc));
    String strng;
    Piece a=new Piece(5);
    Piece b=new Piece(5);
    ArrayList<Piece> c=new ArrayList<Piece>();
    c.add(a);
    c.add(b);
    Robot robot=new Robot("xa",c);
    //obj.readLine() permet de lire une ligne du fichier.
    //Tant que la ligne n'est pas null le programme continue de lire le fichier.
    //Boucle while qui permet de parser le fichier à la recherche de la commande et de son argument.
    while ((strng = obj.readLine()) != null) 
    { 
            //strng.substring(0, 4) représente la commande.
            //strng.substring(5, strng.length())) représente l'argument ou les arguments de la commande.
            //strng.length() représente la longueur de la chaine de caractère de la ligne.
            //J'utilise un switch pour distinguer les commandes et les arguments. 
                      //String[] argument=strng.substring(5, strng.length()).split(" ",4); 
                      
                      switch(strng.substring(0, 3)) {
                                 
                
                                case "LINK":
                                                      
                                                      
                                                     String arg_LINK=strng.substring(5, strng.length());

                                                      try{
		                                                //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
		                                                // en entier.
		                                                 int number = Integer.parseInt(arg_LINK);
		                                                 //System.out.println(number);
		                                                 robot.LINK(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }
                                                      break;
                                case "GRAB":
                                                     String arg_GRAB=strng.substring(5, strng.length());
                                                    
                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg_GRAB);
                                                         
                                                         robot.GRAB(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }
                                                      break;
                                case "DROP":
                                                      robot.DROP();
                                                      break;
                                case "COPY":
                                                       String[] arg_COPY=strng.substring(5, strng.length()).split(" ",4);
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_COPY. 
                                                    

                                                      robot.COPY(arg_COPY[0],arg_COPY[1]);
                                                                                                           
                                                      break;
                                case "MULI":
                                                      //Affichage de la commande.
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_MULI. 
                                                      
                                        		 String[] arg_MULI=strng.substring(5, strng.length()).split(" ",4);
                                                     robot.MULI(arg_MULI[0],arg_MULI[1],arg_MULI[2]);
                                                      
                                                      break;
                                case "ADDI":
                                                      
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_ADDI. 
                                                       
                                                      String[] arg_ADDI=strng.substring(5, strng.length()).split(" ",4);
                                                      
                                                      try{
		                                                  //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
		                                                 // en entier.
		                                                  int number = Integer.parseInt(arg_ADDI[1]);
		                                                  robot.ADDI(arg_ADDI[0],number,arg_ADDI[2]); 
                                                      }
                                                      //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                      //n'est pas une valeur numérique.
                                                      catch (NumberFormatException ex){
                                                          ex.printStackTrace();
                                                      }
                                                      //Il faut mettre le troisiéme argument dans une variable String.
                                                    
                    								
                                                     
                                                      break;
                                case "TEST":
                                                      //Affichage de la commande.
                                                      //Affichage de l'argument.
                                                                                                                        
                                                      
                                                     
                                                       String[] arg_TEST=strng.substring(5, strng.length()).split(" ",4);
                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg_TEST[2]);
                                                         //System.out.println(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }
                                                     
                                                      break;
                                case "SUBI":
                                                      //Affichage de la commande
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_SUBI. 
                                                     
                                                       String[] arg_SUBI=strng.substring(5, strng.length()).split(" ",4);

                                                    try{
				                                      //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
				                                     // en entier.
				                                      int number = Integer.parseInt(arg_SUBI[1]);
				                                      
                                                  }
                                                  //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                  //n'est pas une valeur numérique.
                                                  catch (NumberFormatException ex){
                                                      ex.printStackTrace();
                                                  }

                                                 
                                                        robot.SUBI(arg_SUBI[0],arg_SUBI[1],arg_SUBI[2]);
                                                      
                                                      break;
                                case "MAKE":
                                                      //Affichage de la commande. 
                                                      robot.MAKE();
                                                      break;
                                case "MARK":
                                                      //Affichage de la commande.
                                                     // robot.MARK();
                                                      break;
                                case "HALT":
                                                      //Affichage de la commande.
                                                      //robot.HALT();
                                                      break;                   
                                case "FJMP":
                                                      //Affichage de la commande.
                                                      //Affichage de l'argument.
                                                      break;
                                                      }                             
  };
}
}
