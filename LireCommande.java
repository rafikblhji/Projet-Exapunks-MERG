import java.io.*;

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
    {                               //strng.substring(0, 4) représente la commande.
                                    //strng.substring(5, strng.length())) représente l'argument ou les arguments de la commande.
                                    //strng.length() représente la longueur de la chaine de caractère de la ligne.
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
                                                                                                                          //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                                                                                          //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_COPY. 
                                                                                                                          String[] Str_COPY=strng.substring(5, strng.length()).split(" ", 4);
                                                                                                                          //Affichage des arguments un par un.
                                                                                                                          System.out.println("Argument 1="+Str_COPY[0]);
                                                                                                                          System.out.println("Argument 2="+Str_COPY[1]);
                                                                                                                          //Il faut mettre le premier argument dans une variable String.
                                                                                                                          String arg1=Str_COPY[0];
                                                                                                                          //Il faut mettre le deuxiéme argument dans une variable String.
                                                                                                                          String arg2=Str_COPY[1];
                                                                                                                          break;
                                                                                case "MULI":
                                                                                                                        //Affichage de la commande.
                                                                                                                        System.out.println("Commande=MULI");
                                                                                                                        //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                                                                                        //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_MULI. 
                                                                                                                        String[] Str_MULI=strng.substring(5, strng.length()).split(" ", 4);
                                                                                                                        //Affichage des arguments un par un.
                                                                                                                        System.out.println("Argument 1="+Str_MULI[0]);
                                                                                                                        System.out.println("Argument 2="+Str_MULI[1]);
                                                                                                                        System.out.println("Argument 3="+Str_MULI[2]);
                                                                                                                         //Il faut mettre le premier argument dans une variable String.
                                                                                                                        String arg1_MULI=Str_MULI[0];
                                                                                                                         //Il faut mettre le deuxiéme argument dans une variable String.
                                                                                                                        String arg2_MULI=Str_MULI[1];
                                                                                                                         //Il faut mettre le troisiéme argument dans une variable String.
                                                                                                                        String arg3_MULI=Str_MULI[2];
                                                                                                                        break;
                                                                                case "ADDI":
                                                                                                                      //Affichage de la commande.
                                                                                                                        System.out.println("Commande=ADDI");
                                                                                                                        //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                                                                                        //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_ADDI. 
                                                                                                                        String[] Str_ADDI=strng.substring(5, strng.length()).split(" ", 4);
                                                                                                                         //Affichage des arguments un par un.
                                                                                                                        System.out.println("Argument 1="+Str_ADDI[0]);
                                                                                                                        System.out.println("Argument 2="+Str_ADDI[1]);
                                                                                                                        System.out.println("Argument 3="+Str_ADDI[2]);
                                                                                                                        //Il faut mettre le premier argument dans une variable String.
                                                                                                                        String arg1_ADDI=Str_ADDI[0];
                                                                                                                        //Il faut mettre le deuxiéme argument dans une variable String.
                                                                                                                        String arg2_ADDI=Str_ADDI[1];
                                                                                                                        //Il faut mettre le troisiéme argument dans une variable String.
                                                                                                                        String arg3_ADDI=Str_ADDI[2];
                                                                                                                         break;
                                                                                case "TEST":
                                                                                                                         //Affichage de la commande.
                                                                                                                        System.out.println("Commande=TEST");
                                                                                                                        //Affichage de l'argument.
                                                                                                                        System.out.println("Argument="+strng.substring(5, strng.length()));
                                                                                                                        break;
                                                                                case "SUBI":
                                                                                                                        //Affichage de la commande.
                                                                                                                        System.out.println("Commande=SUBI");
                                                                                                                        //On distingue chaque argument avec la fonction split. split sépare chaque argument
                                                                                                                        //dès qu'il rencontre un espace. split met chaque argument dans l'ordre dans le tableau Str_SUBI. 
                                                                                                                        String[] Str_SUBI=strng.substring(5, strng.length()).split(" ", 4);
                                                                                                                        //Affichage des arguments un par un.
                                                                                                                        System.out.println("Argument 1="+Str_SUBI[0]);
                                                                                                                        System.out.println("Argument 2="+Str_SUBI[1]);
                                                                                                                        System.out.println("Argument 3="+Str_SUBI[2]);
                                                                                                                        //Il faut mettre le premier argument dans une variable String.
                                                                                                                        String arg1_SUBI=Str_SUBI[0];
                                                                                                                        //Il faut mettre le deuxième argument dans une variable String.
                                                                                                                        String arg2_SUBI=Str_SUBI[1];
                                                                                                                        //Il faut mettre le troisiéme argument dans une variable String.
                                                                                                                        String arg3_SUBI=Str_SUBI[2];
                                                                                                                        break;
                                                                                case "MAKE":
                                                                                                                        //Affichage de la commande. 
                                                                                                                          System.out.println("Commande=MAKE");
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
                                                                                                                            System.out.println("Commande=FJMP");
                                                                                                                            //Affichage de l'argument.
                                                                                                                            System.out.println("Argument="+strng.substring(5, strng.length()));
                                                                                                                            break;
                                                                            }                             
  };
}
}
