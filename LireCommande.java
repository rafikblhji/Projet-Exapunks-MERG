import java.io.*;
import java.util.*;

//Déclaration de la classe qui permet la lecture du fichier des commandes.

public class LireCommande{
  public static void main(String[] args) throws Exception {
   //Lecture fichier des commandes saisies par le joueur.
   File doc = new File("./SaisieCommande.txt");
   //Appel de la classe Buffereader qui permet de lire le fichier en entrée et le mettre dans le buffer.
    BufferedReader obj = new BufferedReader(new FileReader(doc));

    String strng;
    //obj.readLine() permet de lire une ligne du fichier.
    //Tant que la ligne n'est pas null le programme continue de lire le fichier.
    //Boucle while qui permet de parser le fichier à la recherche de la commande et de son argument.
    while ((strng = obj.readLine()) != null) 
    { 
            //strng.substring(0, 4) représente la commande.
            //strng.substring(5, strng.length())) représente l'argument ou les arguments de la commande.
            //strng.length() représente la longueur de la chaine de caractère de la ligne.
            //J'utilise un switch pour distinguer les commandes et les arguments. 
                      switch(strng.substring(0, 4)) {
                                case "LINK":
                                                      //Affichage de la commande.
                                                      System.out.println("Commande=LINK");
                                                      //Affichage de l'argument.
                                                      System.out.println("Instruction("+strng.substring(5, strng.length())+")"); 
                                                      
                                                      String arg_LINK=strng.substring(5, strng.length());

                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg_LINK);
                                                         System.out.println(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }

                                                      break;
                                case "GRAB":
                                                      //Affichage de la commande.
                                                      System.out.println("Commande=GRAB");
                                                      //Affichage de l'argument.
                                                      System.out.println("Instruction("+strng.substring(5, strng.length())+")");
                                                      break;
                                case "DROP":
                                                      //Affichage de la commande.
                                                      System.out.println("Instruction(DROP)");
                                                      break;
                                case "COPY":
                                                      //Affichage de la commande.
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_COPY. 
                                                      String[] Str_COPY=strng.substring(5, strng.length()).split(" ", 4);
                                                      //Affichage des arguments un par un.
                                                      //Il faut mettre le premier argument dans une variable String.
                                                      //Il faut mettre le deuxiéme argument dans une variable String.

                                                      String arg1_COPY=Str_COPY[0];

                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg1_COPY);
                                                         System.out.println(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }

                                                     String arg2_COPY=Str_COPY[1];
                                                     
                                                      System.out.println("Instruction(COPY,"+Str_COPY[0]+","+Str_COPY[1]+")");                                                          
                                                      break;
                                case "MULI":
                                                      //Affichage de la commande.
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_MULI. 
                                                      String[] Str_MULI=strng.substring(5, strng.length()).split(" ", 4);
                                                      //Affichage des arguments un par un.
                                                      //Il faut mettre le premier argument dans une variable String.
                                                      String arg1_MULI=Str_MULI[0];

                                                      //Il faut mettre le deuxiéme argument dans une variable String.
                                                      String arg2_MULI=Str_MULI[1];

                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg2_MULI);
                                                         System.out.println(number);
                                                     }
                                                     //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                     //n'est pas une valeur numérique. 
                                                     catch (NumberFormatException ex){
                                                         ex.printStackTrace();
                                                     }
                                                      //Il faut mettre le troisiéme argument dans une variable String.
                                                      String arg3_MULI=Str_MULI[2];    
                                                      
                                                      System.out.println("Instruction(MULI,"+arg1_MULI+","+arg2_MULI+","+arg3_MULI+")");
                                                      break;
                                case "ADDI":
                                                      //Affichage de la commande.
                                                      //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                      //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_ADDI. 
                                                      String[] Str_ADDI=strng.substring(5, strng.length()).split(" ", 4);
                                                      //Affichage des arguments un par un.
                                                      //Il faut mettre le premier argument dans une variable String.
                                                      String arg1_ADDI=Str_ADDI[0];
                                                      //int num1 = Integer.valueOf(Str_ADDI[0]);

                                                      String str = Str_ADDI[0];
                                                      
                                                      //Il faut mettre le deuxiéme argument dans une variable String.
                                                      String arg2_ADDI=Str_ADDI[1];

                                                      String str1 = Str_ADDI[1];
                                                      try{
                                                          //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                         // en entier.
                                                          int number = Integer.parseInt(str1);
                                                          System.out.println(number); 
                                                      }
                                                      //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                      //n'est pas une valeur numérique.
                                                      catch (NumberFormatException ex){
                                                          ex.printStackTrace();
                                                      }
                                                      //Il faut mettre le troisiéme argument dans une variable String.
                                                      String arg3_ADDI=Str_ADDI[2];
                                                      String str2 = Str_ADDI[2];
                    								
                                                      System.out.println("Instruction(ADDI,"+str+","+str1+","+str2+")");
                                                      break;
                                case "TEST":
                                                      //Affichage de la commande.
                                                      //Affichage de l'argument.
                                                                                                                        
                                                      String[] Str_TEST=strng.substring(5, strng.length()).split(" ", 4);
                                                      String arg1_TEST=Str_TEST[0];

                                                      String arg2_TEST=Str_TEST[1];

                                                      String arg3_TEST=Str_TEST[2]; 
                                                      
                                                      try{
                                                        //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                        // en entier.
                                                         int number = Integer.parseInt(arg3_TEST);
                                                         System.out.println(number);
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
                                                      String[] Str_SUBI=strng.substring(5, strng.length()).split(" ", 4);
                                                      //Affichage des arguments un par un.
                                                      //Il faut mettre le premier argument dans une variable String.
                                                      //Il faut mettre le deuxième argument dans une variable String.
                                                      //Il faut mettre le troisiéme argument dans une variable String.         
                                                      String arg1_SUBI=Str_SUBI[0];
                                                        
                                                    String arg2_SUBI=Str_SUBI[1];

                                                    try{
                                                      //On utilise parseInt qui permet de convertir une chaine de caractère de valeur numérique
                                                     // en entier.
                                                      int number = Integer.parseInt(arg2_SUBI);
                                                      System.out.println(number); 
                                                  }
                                                  //catch permet de capter le message d'erreur "warning" et l'erreur compte la chaine de caractère 
                                                  //n'est pas une valeur numérique.
                                                  catch (NumberFormatException ex){
                                                      ex.printStackTrace();
                                                  }

                                                  String arg3_SUBI=Str_SUBI[2];

                                                      System.out.println("Instruction(SUBI,"+Str_SUBI[0]+","+Str_SUBI[1]+","+Str_SUBI[2]+")");
                                                      break;
                                case "MAKE":
                                                      //Affichage de la commande. 
                                                      System.out.println("Instructio(MAKE)");
                                                      break;
                                case "MARK":
                                                      //Affichage de la commande.
                                                      System.out.println("Instruction(MARK)");
                                                      break;
                                case "HALT":
                                                      //Affichage de la commande.
                                                      System.out.println("Instruction(HALT)");
                                                      break;                   
                                case "FJMP":
                                                      //Affichage de la commande.
                                                      System.out.println("Instruction(FJMP,"+strng.substring(5, strng.length())+")");
                                                      //Affichage de l'argument.
                                                      break;
                                                      }                             
  };
}
}
