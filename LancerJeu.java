/**
 * classe d'exécution du jeu
 * @since 18/02/2024
 * @version 26/02/2024
 * @author BELHADJI Rafik
 * les instructions qui contiennent des appels à la partie graphique du jeu ont été rajoutées par ORCUN Gabriel
 */
import java.io.*;
import java.util.*;


 public class LancerJeu 
 {

    public static void main(String[] args) {
        LancerJeu programme= new LancerJeu();
        // int numNiveau=0;
        Menu menu =new Menu();
        while (menu.getNiveau() == null) {
    try {
        Thread.sleep(100); // Attendez 100 millisecondes avant de vérifier à nouveau
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
        boolean continuer=false;
         Level levelOfGame;
         int registreCountInstruction=0;
         boolean testJMP=false; /* cette variable permet l'execution de JMP une fois dans le programme  */
         List<Instruction> instructions = new ArrayList<>();


         /**
          * j'ai décide de mettre level=0 , juste parce que level est initialisé dans le bloc if 
          * le compilateur va m'afficher erreur car pour lui le bloc if peut ne pas s'exécuter et donc level peut ne pas avoir 
          * une valeur ( initialisé ) donc je mets à 0 , mais dans tous les cas , on aura jamais le niveau 0 
          * car en cas ou l'utilisateur ne fait pas rentrer un niveau , on va quitter surement avec une erreur
          */
         




        levelOfGame= new Level(menu.getNumNiv());
        /**
         * c'est là qu'on a initialisé robot ,les pièces.... c'est là que ça devient intéressant 
         */

        
         /**
          * maintenant on lit les instructions 
          */
        
              while (menu.getNiveau().getPeutContinuer() != true) {
    try {
        Thread.sleep(100); // Attendez 100 millisecondes avant de vérifier à nouveau
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

          String nomFichier = "ligne.txt"; 
          /**
           * 
           * Chemin vers le fichier à lire 
           * le chargé de l'interface graphique et le chargé de sortie et entrée textuelle doivent me 
           * communiquer au plus vite le répertoire ou se trouve le fichier contenant la commande
           * 
           * */         
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

    while(registreCountInstruction<instructions.size()){
                /* on execute les instructions avec une boucle while tant que y a toujours une instruction à exxécuter on execute*/
                             while (menu.getNiveau().getPeutContinuer() != true) {
    try {
        Thread.sleep(100); // Attendez 100 millisecondes avant de vérifier à nouveau
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
                    tmp=instructions.get(registreCountInstruction); /* récupérer l'instruction à exécuter tel que GRAB 200  */

                    /* implémentation de JMP et FJMP  */
                    if(tmp.getNom().equals("JMP"))

                {       /*
                         * dans ma version de JMP je veux qu'elle soit exécuter une fois c'est tout pas plus c'est pour cela je vais utiliser une variable booléenne afin d'éviter que
                         * le programme tourne infiniment et avoir des problèmes 
                         * on applique notre JMP une fois , et puis c'est bon si on en arrive une autre fois on la saute pour continuer notre programme 
                        */
                     if(testJMP) /* si cette variable est à vrai donc on a déjà  exécuté JMP  donc cette fois faut la sauter */
                        {

                            registreCountInstruction++;
                            continue; 
                        }
                        String[] arg= tmp.getArguments(); /* récupéreation des arguments de l'instruction  */
                        if(!(levelOfGame.getRobot().isInteger(arg[0]))) /* tester si l'argument est bien un entier en utilisant la méthode définit dans la classe Robot */
                        {
                            System.err.println("JMP a besoin d'un entier comme argument ");
                            System.exit(1);
                        }
                        int pas= Integer.parseInt(arg[0]); /* transformer la chaine en entier tel que "10" en entier 10 par exemple  */

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
                        registreCountInstruction+=pas; /* on peut rajouter tant que ça dépasse pas  par exemple on a 5 instruction on est à la 3em on rajoute 2 on sera à la  5em */
                    }
                    else
                    {
                        registreCountInstruction=instructions.size()-1;
                        /**
                         *  sinon on saute à la dernière instruction dans le cas ou ça dépasse 
                         * par exemple on a 5 instruction et on a un JMP 5 et on est à la 3em instruction on va juste sauter à la 5em vu qu'il y a que 5
                         * */
                    }

                    testJMP=true;

                }





                    /* fin de JMP */
                    
                    else if ( tmp.getNom().equals("TEST")) 
                    {   /**
                        * dans le cas ou le nom de l'instruction est TEST donc l'instruction est de la forme
                        * par exemple TEST X = 10 
                        * ce qui est aussi sûr c'est que la prochaine instruction est FJMP nombrePas
                        * on va revenir en arrière de nombrePas tant que le TEST est faux 
                        */
                        String[] tabArguments= tmp.getArguments(); /* récupéreation des arguments de l'instruction  */
                        boolean testTemporaire=levelOfGame.getRobot().TEST(tabArguments[0],tabArguments[1],Integer.parseInt(tabArguments[2]));
                        /* ici attention le 3em argument de test doit etre un entier vous le donnez sous forme
                        * de chaine de caractère bien sûr mais il doit etre possible de le convertir en entier 
                        */

                        if(testTemporaire) /* si le test est vrai on saute l'instruction d'après qui est FJMP car elle sert à rien dans ce cas  */
                        {
                            
                            registreCountInstruction+=2;
                        }
                        else
                        { 
                            /* dans le cas ou le test de TEST est faux on doit appliquer le FJMP  */

                        
                        /*
                        * on a maintenant besoin de récupérer l'argument de FJMP qui est la prochaine instruction
                        */
                        Instruction prochaineInstruction=instructions.get(++registreCountInstruction);
                        String[] tabArgFJMP=prochaineInstruction.getArguments();
                        /**
                         * elle sera de la forme FJMP -4 .. 
                         */
                        int nombrePas=Integer.parseInt(tabArgFJMP[0]); 
                        if(nombrePas>=0)
                        {
                            System.err.println("FJMP doit avoir un entier négatif comme argument");
                            System.exit(1);
                        }
                        /* là on récupère le nombre de pas 
                        * ce nombre on s'est mis d'accord pour qu'il sois toujours négative 
                        * car on va revenir vers l'arrière et non avancer 
                        * 
                        */

                        
                            if(-1 * registreCountInstruction >nombrePas)
                            {
                                registreCountInstruction=0;
                            }
                            else
                            {
                                registreCountInstruction=registreCountInstruction+nombrePas;
                            }

                            continue;

                        


                        




                    } 
                } /* fin de else if  */
                    else
                    {
                            /*
                             * comme expliqué avant , en effet j'ai implémenté JMP FJMP et test à part , maintenant on va traiter le cas si l'instruction est une autre à part ces 3 
                             */
                        programme.lireInstruction(tmp, levelOfGame, menu);
                        registreCountInstruction++; /* il faut incrémenter après chaque registreCountInstruction */
                
                    }/* fin de if  */
 


            menu.getNiveau().setPeutContinuer(false);

            }/* fin de la boucle while   */

    
    } /* fin de main  */



/* méthode utile  */

public void lireInstruction(Instruction executMe, Level levelOfGame,Menu menu) 
{   
    String[] tabArguments=executMe.getArguments();

    /*
     * les deux instructions JMP et FJMP sont un peu spéciales ils servent à déplacer
     * le curseur qui pointe vers l'instruction suivante 
     *
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
                    menu.getNiveau().deplacerRobott(levelOfGame.getRobot().getIndexPieceCourante());
                    if(levelOfGame.getRobot().peutTransporterFichier()){
                        menu.getNiveau().suprimerTouTFichierr(levelOfGame);
                        menu.getNiveau().dessinerToutFichier(levelOfGame);
                    }
                    else{
                        menu.getNiveau().dessinerToutFichier(levelOfGame);
                        menu.getNiveau().suprimerlefichier(levelOfGame.getRobot().getIndexPieceCourante(),levelOfGame.getRobot().getFileRobot().getId());
                    }
                    // menu.getNiveau().suprimerTouTFichierr(levelOfGame);                                       
                     break;
                    /**
                     * le bloc suivant contient les instructions qui sont sans arguments 
                     */
                    case "HALT": 
                        System.exit(0);
                        break;
                    
                    case "DROP":
                    levelOfGame.getRobot().DROP();
                    menu.getNiveau().dessinerToutFichier(levelOfGame);

                    break;

                    case "MAKE":
                    levelOfGame.getRobot().MAKE();
                    menu.getNiveau().dessinerlefichier(levelOfGame.getRobot().getIndexPieceCourante(),levelOfGame.getRobot().getFileRobot().getId());
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

                    levelOfGame.getRobot().ADDI(tabArguments[0],tabArguments[1],tabArguments[2]);
                    /* par exemple l'appel ici est de la forme ADDI T X X  */
                    menu.getNiveau().getZoneCode().setXValue(levelOfGame.getRobot().getValueOfRegisterX());
                    menu.getNiveau().getZoneCode().setTValue(levelOfGame.getRobot().getValueOfRegisterT());
                    menu.getNiveau().getZoneCode().setMValue(levelOfGame.getRobot().getValueOfRegisterM());
                    break;
                 

                    case "SUBI": 

                    levelOfGame.getRobot().SUBI(tabArguments[0],tabArguments[1],tabArguments[2]);
                    /**
                     * attention dans ce cas vous appelez SUBI comme suit  : SUBI X F T mais le F on va l'ignorer dans notre programme on passe directement au
                     * T
                     */
                    menu.getNiveau().getZoneCode().setXValue(levelOfGame.getRobot().getValueOfRegisterX());
                    menu.getNiveau().getZoneCode().setTValue(levelOfGame.getRobot().getValueOfRegisterT());
                    menu.getNiveau().getZoneCode().setMValue(levelOfGame.getRobot().getValueOfRegisterM());

                    break;
                 

                    case "MULI": 

                    levelOfGame.getRobot().MULI(tabArguments[0],tabArguments[1],tabArguments[2]);
                    menu.getNiveau().getZoneCode().setXValue(levelOfGame.getRobot().getValueOfRegisterX());
                    menu.getNiveau().getZoneCode().setTValue(levelOfGame.getRobot().getValueOfRegisterT());
                    menu.getNiveau().getZoneCode().setMValue(levelOfGame.getRobot().getValueOfRegisterM());
                    break;

                   

                    case "COPY":

                    levelOfGame.getRobot().COPY(tabArguments[0],tabArguments[1]);
                    menu.getNiveau().getZoneCode().setXValue(levelOfGame.getRobot().getValueOfRegisterX());
                    menu.getNiveau().getZoneCode().setTValue(levelOfGame.getRobot().getValueOfRegisterT());
                    menu.getNiveau().getZoneCode().setMValue(levelOfGame.getRobot().getValueOfRegisterM());
                    break;

                  

                    /* à continuer les instructions qui restent  */

                    case "GRAB":
                    /**
                     * GRAB doit avoir un argument entier , il sera surement stocké dans tabArguments[0]
                     */
                    /* j'ai déjà défini une fonction isInteger dans robot qui vérifie
                    *si un string peut etre parsé en entier donc je l'utilise
                    */
                    if(!(levelOfGame.getRobot().isInteger(tabArguments[0])))
                    {
                        System.err.println("GRAB doit avoir un entier en argument");
                        System.exit(1);
                    }
                    /* si c'est un entier super! */

                    levelOfGame.getRobot().GRAB(Integer.parseInt(tabArguments[0]));
                    // menu.getNiveau().suprimerrrfichier(levelOfGame.getRobot().getIndexPieceCourante(),levelOfGame.getRobot().get)
                    // menu.getNiveau().deplacerFichierr(levelOfGame);                                      
                     break;


                    default : 
                    /* le cas ou on fait appel à une instruction bizarre  */
                    System.err.println("Nom d'instruction inconnu ");
                    System.exit(1);
                   



    }



}
    }












   
