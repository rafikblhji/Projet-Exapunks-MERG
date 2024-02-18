/**
 * classe d'exécution du jeu
 * @since 18/02/2024
 * @version 18/02/2024
 * @author BELHADJI Rafik
 */
import java.io.*;
import java.util.*;


 public class Jeu 
 {

    public static void main(String[] args) {
        Jeu programme= new Jeu();
        int numNiveau=0;
         Level levelOfGame;
         int registreCountInstruction=0;
         List<Instruction> instructions = new ArrayList<>();


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


            while ((ligne = lecteur.readLine()) != null) {
                // Diviser la ligne en tokens en utilisant l'espace comme délimiteur
                String[] tokens = ligne.split(" ");

                // Récupérer le nom de l'instruction (le premier token)
                String nomInstruction = tokens[0];

                // Créer un tableau pour stocker les arguments de l'instruction
                String[] arguments = new String[tokens.length - 1];

                // Ajouter les arguments à la liste, à partir du deuxième token
                for (int i = 1; i < tokens.length; i++) {
                    arguments[i - 1] = tokens[i];
                }

                // Ajouter l'instruction à la liste
                instructions.add(new Instruction(nomInstruction, arguments));
            }

     lecteur.close(); 
    }catch (IOException e) {
        /*
         * gestion des erreurs entrées sorties 
         */
        e.printStackTrace();
    }

    Instruction tmp;

    while(registreCountInstruction<instructions.size())
    {
        tmp=instructions.get(registreCountInstruction);

        /* implémentation de JMP et FJMP  */
        if(tmp.getNom().equals("JMP"))
        {
            String[] arg= tmp.getArguments();
            if(!(levelOfGame.getRobot().isInteger(arg[0])))
            {
                System.err.println("JMP a besoin d'un entier comme argument ");
                System.exit(1);
            }
            int pas= Integer.parseInt(arg[0]);

        if(pas <0){
        if((-1 * registreCountInstruction) > pas ) /* si on est a l'instruction 1 par exemple et on a JMP -2 je reviens par convention juste au début */
        {
            registreCountInstruction=0;
        }

        registreCountInstruction+=pas; /* sinon on enlève la quantité et c'est tout */
        /**
         * par exemple si on a le pas est -2 et on est à l'instruction 1 on revient au début et c'est tout 
         * si on est  à l'instruction 5 et on a le pas est -2 on revient à l'instruction 3
         */


        }

        /*
         * le cas ou pas est >0 
         */

         if(registreCountInstruction+pas<=(instructions.size()-1)) /* c'est dans ce cas qu'on peut avancer  */
         {
            registreCountInstruction+=pas; /* on peut rajouter tant que ça dépasse pas  */
         }
         else
         {
            registreCountInstruction=instructions.size()-1; /* sinon on saute à la dernière instruction dans le cas ou ça dépasse */
         }





        /* fin de JMP */
        }





    }

    









}

public void lireInstruction(Instruction executMe, Level levelOfGame) 
{   
    String[] tabArguments=executMe.getArguments();

    /*
     * les deux instructions JMP et FJMP sont un peu spéciales ils servent à déplacer
     * le curseur qui pointe vers l'instruction suivante 
     */
    switch(executMe.getNom())
    {
                 case "LINK":
                    /**
                     * LINK doit avoir un argument entier , il sera surement stocké dans tokens[1]
                     */
                    /* j'ai déjà défini une fonction isInteger dans robot qui vérifie
                    *si un string peut etre parsé en entier donc je l'utilise
                    */
                    if(!(levelOfGame.getRobot().isInteger(tabArguments[0])))
                    {
                        System.err.println("LINK doit avoir un entier en argument");
                        System.exit(1);
                    }
                    /* si c'est un entier super! */

                    levelOfGame.getRobot().LINK(Integer.parseInt(tabArguments[0]));                                       
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
                    /**
                     * j'invite le chargé de l'interface graphique et 
                     * le responsable d'entrées et sorties textuels à suivre cette convention avec moi : 
                     * dans la classe robot les instructions qui font l'addition, la soustraction et la multiplication
                     * j'ai défini pour chacune de ces instructions deux types
                     * une ou le deuxième argument est un entier , et une autre version ou le deuxième argument est un fichier
                     * comme pour ADDI X 1 T ( c'est la version ou le deuxième élément est un entier )
                     * y a aussi la version ADDI X F T  ou on prend la valeur de registre X et la valeur vers quelle l'index courant
                     * pointe dans le fichier et on met le résultat de l'addition de ces deux valeurs dans le registre T
                     * maintenant je vous invite à prendre la convetion suivante avec moi , vous allez tapez sur la fenetre
                     * du jeu ADDIf en rajoutant f cela veut dire on va utiliser la version ou y a 
                     * le fichier comme deuxième paramètre , si on rajoute pas le f on va utiliser la version ou y a un entier comme deuxième paramètre 
                     */

                    case "ADDI": 

                    levelOfGame.getRobot().ADDI(tabArguments[0],Integer.parseInt(tabArguments[1]),tabArguments[2]);

                    break;

                    case "SUBI": 

                    levelOfGame.getRobot().SUBI(tabArguments[0],levelOfGame.getRobot().getFileRobot(),tabArguments[2]);
                    /**
                     * attention dans ce cas vous appelez SUBI comme suit  : SUBI X F T mais le F on va l'ignorer dans notre programme on passe directement au
                     * T
                     */

                    break;

                    case "MULI": 

                    levelOfGame.getRobot().MULI(tabArguments[0],levelOfGame.getRobot().getFileRobot(),tabArguments[2]);

                    break;

                    case "COPY":

                    levelOfGame.getRobot().COPY(tabArguments[0],tabArguments[1]);

                    break;

                    case "fCOPY": /* juste pour distinguer COPY qui copie d'un fichier envers un registre COPY F X  */

                    levelOfGame.getRobot().COPY(levelOfGame.getRobot().getFileRobot(),tabArguments[1]);

                    break;

                    case "COPYf": /* juste pour distinguer COPY qui copie d'un registre vers le fichier  COPY  X F */
                    levelOfGame.getRobot().COPY(tabArguments[0],levelOfGame.getRobot().getFileRobot());

                    break;


                  


                    












    }



}



 }










   