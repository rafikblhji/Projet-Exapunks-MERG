/**
* Cette classe est la classe Robot , qui en effet représente le robot du jeu Exapunks qui se déplace à travers les pièces
* et manipule les fichiers dans la pièce 
* il peut aussi créer des fichiers , les déplacer , prendre , déposer
*
*@author BELHADJI Rafik
*@since 20/01/2024
*@version 26/01/2024
*/

/**
 * j'ai choisi de mettre import java.util.* afin de simplifier le travail importer tout 
 * et ne pas avoir à importer à chaque fois les outils que j'utilise 
 * comme ArrayList , Collection,.....etc
 */

import java.util.*;

public class Robot {
    /* déclaration des attributs nécessaires pour la classe robot  */
    private String nomR; /* le nom du robot  */
    private boolean peutTransporter ; 
    /**  
     * si il est à true on peut transporter fichier sinon on ne peut pas le transporter   
     * Je voudrais répondre à la remarque de Monsieur Breuvart à propos de cette variable : 
     * je suis d'accord avec vous sur le faite qu'un robot peut toujour transporter un fichier
     * c'est juste dans le jeu , un fichier ne peut transporter un fichier seulement si il n'a rien entre les mains
     * par contre si on fait par exemple GRAB 200 ensuite GRAB 400 ( 200 et 400 sont les identifiants de deux fichiers qui existent dans la pièce
     * courante du fichier ) , le GRAB 200 va marcher parcontre GRAB 400 non car en effet il faut d'abord faire un DROP
     * pour déposer le fichier d'identifiant 200 sinon on ne pourra pas porter le fichier d'identifiant 400
     * 
     * */
    private ArrayList <Piece> lp;  /* liste de pièce  */
    private int indexPieceCourante; /* l'index de la pièce courante elle est initialisé à 0our le moment */
    private String X,T; /** ce sont les registres X, T du robot  
    * je les ai déclaré comme String car on peut manipuler dans un fichier sois un String , sois un entier 
    * donc on peut simplifier les choses en les déclarant comme String ensuite 
    * si on a besoin de savoir si ce sont des entiers , ou bien manipuler ces registres en tant qu'entier 
    * on utilisera des méthodes qui vont nous permettre de faciliter la vérification et savoir si c'est des entiers et si oui on
    * va récupérer leur valeur en entier 
    */
    private Fichier F ; 
    /**
     * F réprésentre le fichier que le robot tient entre ses mains , dans le jeu 
     * c'est le registre F qui contient l'id du fichier entre les mains du robot
     * parcontre pour des raisons de programmation et afin de faciliter l'implémentation des méthodes COPY,ADDI..
     * j'ai besoin de l'attribut F en tant que fichier et bien sur à partir de ce F on peut obtenir l'id du fichier
     * que le robot tient entre ses mains il suffit de faire F.getId()
     */
    private int compteurFichierCréé; 
    /** j'ai remarqué que dans le jeu , quand on créé un fichier , avec make , le premier aura un identfiant 400
    * le deuxième 401 , le 3ème 402.....etc
    *donc je créé cette variable qui est initialisé à 0 au début et à chaque fois qu'on crée un fichier
    * son identifiant est compteurFichierCréé+400 ensuite make va surement augmenter compteurFichierCréé de 1 
    */
    private int indexFichier; 
    /**
     * c'est l'indice qui pointe vers le début du fichier
     * dans le jeu on peut voir ça comme le registre F qui à chaque fois qu'on utilise
     * COPY,ADDI,MULI,SUBI avec le fichier... cet index pointe vers le suivant 
     */


    /**  Note très importante : 
     *  j'ai remarqué dans le jeu , que à chaque fois qu'on crée un robot , ( un exa )
     * il est toujours positionné dans la pièce d'index 0 ( la première pièce )
     * et le nombre maximum de robot qu'on peut créer est égal à la taille de la pièce 
     * qui est égale à la longueur * longueur ( regardez s'il vous plaît la classe Piece )
     * 
     */

    /** Constructeur de la classe Robot , elle initialise un robot 
     * @param name nom du robot 
     * @param c collection de piece ou le robot peut se déplacer  
     * @requires c!=null && !c.contains(null)
     * @requires name!=null
     * @ensures indexPieceCourante==0 && peutTransporter && F==0 && X==T && T==null
     * @ensures lp.size()==c.size() &&  c.containsAll(lp) && lp.containsAll(c)
     * @ensures compteurFichierCréé==0
     * @throws NullPointerException() si le nom du robot est null ou bien la collection est null ou contient null
     * 
     *  */    
    public Robot (String name , Collection <? extends Piece> c )
    {   

        nomR=name ;
        indexPieceCourante=0;
        indexFichier=0;
        peutTransporter=true;
        lp = new ArrayList<Piece>(c);
        F=null;
        X="0";
        T="0";
        compteurFichierCréé=0;
        /**
         * X , T je les ai initialisé à null mais c'est facultatif car 
         * meme si je le fais pas , ça aurait été fait automatiquement car c'est la valeur par défaut 
         * meme chose compteurFichierCréé,indexFichier et  indexPieceCourante meme si je ne les avais pas initialisé à 0 
         * ça aurait été fait automatiquement on a vu ça au Semestre 1 en POO
         * ce sont les valeurs par défaut
         */
        
    }
    /**
     *  c'est une méthode qui retourne le nom du robot 
     * @return nom du robot 
     */
    public String getName()
    {
        return nomR;
    }
    /**
     *  cette méthode renvoie l'indice de la pièce courante 
     * qui sera très importante pendant le jeu pour le robot 
     * 
     * @return indice de pièce courante 
     */

    public int getIndexPieceCourante()
    {
        return indexPieceCourante;

    }

    /**
     * méthode qui permet de tester si un robot peut transporter un fichier ou pas 
     * @return vrai si le robot peut transporter le fichier , faux sinon 
     */
    public boolean peutTransporterFichier()
    {
        if(peutTransporter)
            return true;
        
        return false;
    }
    
    /**
     * cette méthode permet de déplacer le robot 
     *dans le jeu LINK 800 elle fait  avancer le robot  dans la pièce suivante 
     *  si on est dans la dernière pièce elle aura aucun effet car y a pas de pièce suivante 
     * et LINK -1 elle déplace le robot vers la pièce d'avant  si on est dans la première pièce ( d'indice 0) elle a aucun effet car y
     * y a pas une pièce avant  
     * j'ai aussi remarqué dans le jeu que si on donne une valeur numérique différente de -1 ou 800 , ça affiche  LINK ID NOT FOUND  et le programme 
     * s'arrete donc le a doit etre égal sois à 800 sois à -1 
     * 
     * @param a l'entier que la fonction prend en paramètre  ( l'id de la pièce )
     * @requires a==800 || a==-1
     * @throws IllegalArgumentException() si a n'est pas ègal à 800 et n'est pas égale à -1 
     */
    public void LINK(int a )
    {   if(a!=800 && a!=-1)
            throw new IllegalArgumentException("LINK ID NOT FOUND");

        if(a==800)
        {   /* comme j'ai explique si on doit avancer et y a pas de pièce suivante ells va rien faire  */
            if(!(getIndexPieceCourante()==lp.size()-1))
            {
                indexPieceCourante++;

            }
        }
        else
        {   /* le cas ou a ==-1  */
            if(!(getIndexPieceCourante()==0))
            {
                indexPieceCourante--;
            }

        }

    }

    /* FIN DE FONCTION LINK  */

    /**
     * la méthode MAKE permet de créer un fichier entre les mains d'un robot 
     * la méthode MAKE marche seulement si le robot n'a aucun fichier entre ses mains 
     * c'est à dire seulement si il peut transporter un fichier sinon ça va s'arreter directement et il affiche CANNOT GRAB A SECOND FILE 
     * j'ai aussi remarqué que à chaque fois qu'on créé un fichier dans le jeu , il est vide à l'intérieur 
     *  donc on peut l'initialiser avec une arrayList vide et l'identifiant est toujours 400+compteurFichierCréé
     * @requires peutTransporterFichier 
     * @throws UnsupportedOperationException() si le robot ne peut pas créer le fichier car il ne peut pas le transporter 
     */
    public void MAKE()
    {
        if(!peutTransporterFichier())
        {
            throw new UnsupportedOperationException("CANNOT GRAB A SECOND FILE");
        }
        F = new Fichier(400+compteurFichierCréé,new ArrayList<String>());
        compteurFichierCréé++; /* il faut l'augmenter comme ça l'id du prochain fichier  sera mis à jour  */
        peutTransporter=false;
        /**
         * c'est dans cette méthode qu'on remarque l'utilité de la variable booléenne , 
         * que j'ai déclarée en effet c'est elle qui permet de savoir directement si 
         * ce robot a déjà un fichier entre les mains et donc il ne peut pas transporter un autre fichier
         * si c'est false , s'il peut cette variable sera à true 
         */


    }

    /* fin de la méthode MAKE  */

    /**
     * la méthode GRAB c'est la méthode qui permet au robot de prendre un fichier ,
     * y a une condition vraiment nécessaire que j'ai remarqué , dans le jeu si on est dans une pièce et on fait appel à GRAB X 
     * si la pièce ne contient aucun fichier qui a comme identifiant X donc on va arreter et on affiche FILE ID NOT FOUND
     * Y a aussi une condition très importante , GRAB marche seulement si le robot peut transporter le fichier si par exemple le robot porte déjà un fichier
     * et qu'on fait un GRAB le programme arrete et on affiche  CANNOT GRAB A SECOND FILE 
     * @param id identifiant de fichier qu'on doit attraprer
     * @requires peutTransporter==true
     * @throws UnsupportedOperationException() si le robot ne peut pas transporter un fichier
     * @throws IllegalArgumentException() si la pièce courante ne contient aucun fichier qui a comme identifiant l'id passé en paramètre 
     */
    public void GRAB ( int id ) 
    {
        if(!peutTransporterFichier())
            throw new UnsupportedOperationException("CANNOT GRAB A SECOND FILE ");

        
        /**
         * listFichierTemp contient la liste de fichier contenu dans la pièce courante ou se trouve le robot 
         * j'ai utilisé celle là pour ne pas toucher à la liste de fichier elle meme 
         * donc j'ai renvoyé une nouvelle instance qui contient cette liste de fichier , sans toucher la liste de fichier elle meme 
         * 
         */
        ArrayList <Fichier> listFichierTemp= new ArrayList<Fichier> (lp.get(indexPieceCourante).getListFichiers());
        
        /**
         * on vérifie d'abord si la pièce ne contient aucun fichier donc pas la peine de chercher si y a un fichier qui ce id 
         */
        if(listFichierTemp.isEmpty())
            throw new IllegalArgumentException("FILE ID NOT FOUND");
            
        for(int i=0;i<listFichierTemp.size();i++)
        {
            if(listFichierTemp.get(i).getId()==id)/* si les deux fichiers ont le meme id c'est qu'ils sont pareil */
            {
                F= new Fichier(id,listFichierTemp.get(i).getElementsOfFile());
                lp.get(indexPieceCourante).getListFichiers().remove(F);
                /**
                 * vous allez vous demander pourquoi le faite de prendre le fichier entre les mains du robot
                 * donc il est plus dans la pièce, en effet en suivant la logique de jeu 
                 * on sait qu'une pièce peut contenir un fichier si et seulement si y a au moins deux cases vide
                 * et on sait que GRAB c'et à dire le robot va prendre le fichier entre ses mains 
                 * j'ai remarqué qu'on peut bien créer un fichier avec MAKE  / ou bien  déplacer le robot
                 * portant un fichier   vers une pièce qui contient une unique case vide donc dans ce cas il n'est pas considéré
                 * comme rajouté dans la liste des fichiers contenu dans la pièce 
                 * donc je suis la logique de: GRAB un fichier donc on l'a enlevé de la pièce , 
                 * car je vais suivre la convention : un fichier est considéré dans la pièce si et seulement 
                 * sois on le crée avec un MAKE et on le DROP
                 * sois on le déplace d'une autre pièce vers cette pièce et on met DROP
                 * 
                 *
                 */

                peutTransporter=false;
                break; 
                /**
                 * une fois qu'on a trouvé le fichire c'est bon ce n'est plus la peine de continuer la boucle
                 * car on l'a trouvé et on a fait ce qu'on avait à faire donc faire le break c'est pour
                 * avoir de meilleure performance et gagner en temps dans le cas ou on rentre dans la structure conditionnelle if
                 */
            }
        }
        /**
         * on sait que si on rentre dans GRAB c'est que peutTransporter doit etre true
         * et on sait que peutTransporter sera false si et seulement si 
         * on a trouvé le fichier dans la pièce
         * donc si peutTransporter reste faux donc on a pas trouvé le fichier
         * donc on doit lancer l'exception IllegalArgumentException avec le message FILE ID NOT FOUND 
         */
        if(peutTransporter) /* c'est à dire peutTransporter est toujours vrai  */
            throw new IllegalArgumentException("FILE ID NOT FOUND ");

    

    }

    /* FIN DE MÉTHODE GRAB  */ 
    /**
     * la méthode DROP permet de déposer le fichier transporté par le robot dans la pièce actuel
     * j'ai remarqué dans le jeu que si on fait un DROP et que le robot n'a rien entre ses mains
     * cela va afficher NO FILE IS HELD ensuite le programme s'arrete 
     * pour savoir si le robot a un truc entre les mains ou pas il suffit de voit si peutTransporter est faux ou vrai 
     * s'il est vrai donc il n'a rien , s'il est faux donc il a quelque chose 
     * j'ai remarqué aussi une chose très importante qui est si la pièce ne peut plus prendre un fichier
     * cette méthode ne fait rien 
     * @requires !peutTransporter Fichier()
     * @throws UnsupportedOperationException() si le robot ne transporte rien 
     */
    public void DROP ()
    {
        if(peutTransporterFichier())
            throw new UnsupportedOperationException("NO FILE IS HELD ");
        
        Piece pTmPiece=lp.get(getIndexPieceCourante()); /* la pièce courante ou se trouve le robot  */
        boolean verite=pTmPiece.peutRajouterFicher(); /* verite est vrai si on peut rajouter un fichier dans la pièce faux sinon  */
        if(verite)   
        {
            /** dans le cas ou on peut rajouter 
             * 
             *on rajoute le fichier dans la pièce courante 
             */
            pTmPiece.getListFichiers().add(F);
            F=null; /* le F doit etre null maintenant car il va lâcher son fichier  */
            peutTransporter=true;

            

        }  
        




    }

    /* FIN DE MÉTHODE DROP */

    /**
     * Partie 2 : 26 JANVIER 2024
     */
    /**
     * test si on est arrivé a la fin du fichier entre les mains du robot 
     * @requires F!=null
     * @return vrai si on est à la fin du fichier faux sinon 
     */
    public boolean testEndOfFile()
    {
        if(indexFichier+1>=F.getElementsOfFile().size())
        return true;

        return false;
    
    } 
    
     /**
      * Implémentation de la commande COPY
      * 
      * dans le jeu on a deux types de COPY on a une qui prend une valeur d'un registre , et le stocke dans le fichier 
      * on a l'autre qui prend la valeur du fichier d'indice courant dans le fichier et le stocke dans le registre
      * donc on aura deux COPY qui ont deux formes différentes mais qui se ressemblent vraiment 
      *
      * quelques propriété importante de COPY : 
      * 1- si le robot n'a aucun fichier entre ses mains on ne peut rien faire on arrete le jeu en affichant le
      * message qui indique qu'aucun fichier est entre les mains du robot NO FILE IS HELD 
      *2- si l'indice du fichier arrive à la fin de fichier on s'arrete aussi car on ne peut rien faire 
      *  on affiche CANNOT READ PAST END OF FILE 
      *
      *
      */

     

      /**
       * 
       * 
       * @param registre registre ou la valeur est stockée 
       * @param file fichier ou on va mettre la valeur 
       * @requires peutTransporterFichier()
       * @throws UnsupportedOperationException() si le robot n'a rien entre ses mains 
       * dans cette méthode on a pas de condition de testEndOfFile() car on peut toujours rajouter une valeur à un fichier
       * si on arrive à la fin bah on la rajoute simplement à la fin parcontre dans la méthode suivante 
       * si on arrive à la fin du fichier y aura une erreur 
       * y a pas de condition aussi sur le String registre car dans le jeu
       * on aura pas à faire à des registre qui seront null 
       * comme vous avez remarqué dans le constructeur du robot les registres X ET T  sont 
       * initialisé à "0" 
       */

      public void COPY (String registre, Fichier fic)
     {
        if(peutTransporterFichier()) /* si le robot n'a rien entre ses mains  */
            throw new UnsupportedOperationException("NO FILE IS HELD ");
        
        
        fic.getElementsOfFile().add(indexFichier, registre); /* on met la valeur dans l'indice courante du fichier  */

        indexFichier++;
     }
     /**
      * 
      * @param fic fichier d'ou on va prendre la valeur 
      * @param registre ou on va stocker la valeur 
      * @requires peutTransporterFichier() && testEndOfFile()
      * @throws UnsupportedOperationException() si le robot n'a rien entre ses mains ou bien si l'indice arrive à la fin du fichier 
      */
     public void COPY(Fichier fic , String registre  )
     {
        if(peutTransporterFichier()) /* si le robot n'a rien entre ses mains  */
            throw new UnsupportedOperationException("NO FILE IS HELD ");

        if(testEndOfFile())
            throw new UnsupportedOperationException("CANNOT READ PAST END OF FILE ");

        registre=fic.getElementsOfFile().get(indexFichier);
        indexFichier++;
        

     }
     /**
      * avant de commencer à implémenter les méthodes qui manipulent les entiers contenus dans un fichier
      * comme addition , multiplication , division ,soustraction..
      * je dois définir des méthodes utiles qui permettent de savoir si l'élément d'un fichier est un entier ou pas
      * car les méthodes d'addition,multiplication , division et soustraction ne peuvent pas marcher sur les String 
      * d'ailleurs si ....( à compléter )
      */












}
