/**
 * classe d'exécution du jeu 
 * 
 *@since 01/02/2024
 *@version 18/02/2024
 *@author  BELHADJI Rafik  
 *
 * Je voudrais remercier BOUGHRARA Mohamed qui nous a donné l'idée de mettre les instructions dans un fichier
 * ensuite il faut les parser .. merci aussi à tout le groupe pour vos efforts !
 * *merci aussi au tuteur et à Monsieur Breuvart
 *
 */
import java.io.*;
import java.util.*;

public class Game {
  
    
    public static void main(String[] args )
    {   
         int numNiveau=0;
         Level levelOfGame;
         int registreCountInstruction=0;

         /**
          * j'ai décide de mettre level=0 , juste parce que level est initialisé dans le bloc if 
          * le compilateur va m'afficher erreur car pour lui le bloc if peut ne pas s'exécuter et donc level peut ne pas avoir 
          * une valeur ( initialisé ) donc je mets à 0 , mais dans tous les cas , on aura jamais le niveau 0 
          * car en cas ou l'utilisateur ne fait pas rentrer un niveau , on va quitter surement avec une erreur
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
         * c'est là qu'on a initialisé robot ,les pièces.... c'est là que ça devient intéressant 
         */

         /**
          * maintenant on lit les instructions 
          */

          String nomFichier = "ligne.txt"; 
          /**
           * 
           * Chemin vers le fichier à lire 
           * le chargé de l'interface graphique et le chargé de sortie et entrée textuelle doivent me 
           * communiquer au plus vite le répertoire ou se trouve le fichier
           * 
           * */ 
          String commande=""; /* je les ai initialisé avec des chaines vides juste pour éviter des erreurs de compilateur */
        
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
                
                String[] arguments; /* je l'utiliserai quand y a des instructions à plusieurs arguments  */

                switch(commande)
                {
                    case "LINK":
                    /**
                     * LINK doit avoir un argument entier , il sera surement stocké dans tokens[1]
                     */
                    /* j'ai déjà défini une fonction isInteger dans robot qui vérifie
                    *si un string peut etre parsé en entier donc je l'utilise
                    */
                    if(!(levelOfGame.getRobot().isInteger(tokens[1]))) 
                    {
                        System.err.println("LINK doit avoir un entier en argument");
                        System.exit(1);
                    }
                    /* si c'est un entier super! */

                    levelOfGame.getRobot().LINK(Integer.parseInt(tokens[1]));
                    registreCountInstruction++;
                                       
                     break;
                    /**
                     * le bloc suivant contient les instructions qui sont sans arguments 
                     */
                    case "HALT": 
                        System.exit(0);
                        break;
                    
                    case "DROP":
                    levelOfGame.getRobot().DROP();
                    break;

                    case "MAKE":
                    levelOfGame.getRobot().MAKE();
                    break;

                    case "TEOF":
                    levelOfGame.getRobot().TEOF();
                    break;



                    /* fin du bloc d'instruction sans arguments  */

                    




                }

             
                
            }
            
            lecteur.close(); /*  Fermeture du lecteur une fois la lecture terminée */
        } catch (IOException e) {
            /*
             * gestion des erreurs entrées sorties 
             */
            e.printStackTrace();
        }
    
    

    }




    /* méthode très importante  */

}


        




        






    



