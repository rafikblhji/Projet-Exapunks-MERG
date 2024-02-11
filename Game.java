/**
 * classe d'exécution du jeu 
 * 
 *@since 01/02/2024
 *@version 11/02/2024
 *@author  BELHADJI Rafik 
 *
 * Je voudrais remercier BOUGHRARA Mohammed qui nous a donné l'idée de mettre les instructions dans un fichier
 * ensuite il faut les parser .. merci aussi à tout le groupe pour vos efforts !
 *
 */
import java.io.*;
import java.util.*;

public class Game {
  

    public static void main(String[] args )
    {   
         ArrayList<Piece> listePieceDeJeu = new ArrayList<Piece>(3);
         int numNiveau=0;
         Level levelOfGame;
         /**
          * j'ai décide de mettre level=0 , juste parce que level est initialisé dans le bloc if 
          * le compilateur va m'afficher erreur car pour lui le bloc if peut ne pas s'écuter et donc level peut ne pas avoir 
          * une valeur ( initialisé ) donc je mets à 0 , mais dans tous les cas , on aura jamais le niveau 0 
          */
         

         if (args.length > 0) {
            /*  Récupérer le premier argument (le 0-index) */
            String argument = args[0];
            
            try {
                /*  Convertir la chaîne en un entier */
                 numNiveau = Integer.parseInt(argument);

                            
            } catch (NumberFormatException e) {
                /*  Gérer l'exception si l'argument n'est pas un entier valide */
                System.err.println("L'argument n'est pas un entier valide !, Veuillez choisir un niveau pour le jeu ");
                System.exit(1);

            }
        } else {
            /* Gérer le cas où aucun argument n'est fourni */
            System.err.println("Aucun argument n'a été fourni !");
            System.exit(1);

        }

        levelOfGame= new Level(numNiveau);
        /**
         * c'est là qu'on a initialisé robot ,les pièces.... c'est là que ça devient marrant 
         */

         /**
          * maintenant on lit les instructions 
          */

          String nomFichier = "ligne.txt"; /* Chemin vers le fichier à lire */ 
          String argument="",commande=""; /* je les ai initialisé avec des chaines vides juste pour éviter des erreurs de compilateur */
        
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            
            /* Lecture ligne par ligne */ 
                
            while ((ligne = lecteur.readLine()) != null) {
                /*Diviser la ligne en tokens en utilisant l'espace comme délimiteur*/
                String[] tokens = ligne.split(" ");
                
                /*  Récupérer le nom de la commande (le premier token) */
                 commande = tokens[0];
                
                /*Récupérer l'argument s'il y en a un */
                 argument = null;
                if (tokens.length > 1) {
                    argument = tokens[1];
                }
                
                
            }
            
            lecteur.close(); /*  Fermeture du lecteur une fois la lecture terminée */
        } catch (IOException e) {
            /*
             * gestion des erreurs entrées sorties 
             */
            e.printStackTrace();
        }
    

        switch(commande)
        {
            case "LINK":  
            if(argument.equals(null))
                System.out.println("LINK a besoin d'argument ");

                /**
                 * ici faire appel à link par le robot 
                 */



             break;

             case "GRAB":
                if(argument.equals(null))
                    System.out.println("GRAB a besoin d'argument ");
                    
            break;

             case "MAKE":
                if(!argument.equals(null))
                    System.out.println("MAKE n'a pas besoin d'argument");


                    
            break;
            
            case "DROP":
                if(!argument.equals(null))
                   System.out.println("DROP n'a pas besoin d'argument");



            break;
            
            case "HALT":
                if(!argument.equals(null))
                System.out.println("HALT n'a pas besoin d'argument");



            break;

        }
    }
}


        




        






    



