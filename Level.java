/**
 * Classe qui réprésente  le niveau du robot 
*@author BELHADJI Rafik
*@since 6/02/2024
*@version 16/03/2024
 */
import java.util.*;

public class Level {

    private int num; /* le numéro du niveau  */
    private Fichier fichInt; /* le fichier contenu dans la deuxième pièce de chaque niveau  */
    private Robot exapunks; /* le robot du niveau  */ 
    /**
     * notre groupe est un groupe de 4 donc on est dans le cas ou on joue toujours avec un seul robot et non 
     * 2 ou 3 ....... 
    */
    /**
     @param a le numéro du niveau 
     */
    public Level ( int a )
    {   
        /* j'ai décidé de gérer les erreurs possibles par l'utilsiateur moi même comme si a=0 ou a<0 afin de simplifier le travail du chargé du graphique  */
        if(a==0)
            a++; /* c'est juste j'ai pas envie d'avoir un niveau 0 le minimum est le niveau 1  */
        
        if(a<0)
            a=-a; /* afin de le rendre positif c'est juste une convention  */

        num=a;
        fichInt=new Fichier(200);
        ArrayList<Piece> listePiece = new ArrayList<Piece>();
        /* dans notre jeu on a 3 pièce ou le robot se déplace car on a que les niveau ou y a un seul robot  */
       
        listePiece.add(new Piece(5));
        listePiece.add(new Piece(5));
        listePiece.add(new Piece(5));

        

        exapunks= new Robot ( "xa",listePiece);

        switch(num)
        {   

            case 1 : 
                   fichInt.getElementsOfFile().add("MOVE");
                    fichInt.getElementsOfFile().add("THIS");
                    fichInt.getElementsOfFile().add("FILE");
                    fichInt.getElementsOfFile().add("TO");
                    fichInt.getElementsOfFile().add("THE");
                    fichInt.getElementsOfFile().add("OUTBOX");
                    break;
            case 2 : 
            fichInt.getElementsOfFile().add("72");
            fichInt.getElementsOfFile().add("52");
            fichInt.getElementsOfFile().add("4");
            fichInt.getElementsOfFile().add("60");
            break;

            case 3 : 
            fichInt.getElementsOfFile().add("2003");
            break;
                

            default : 
                /* si l'utilisateur fait rentrer un niveau > 3 on va automatiquement initialiser un niveau libre  */
                /* le but du niveau libre c'est de permettre au prof de tester le jeu comme il veut  */
                    fichInt.getElementsOfFile().add("15");
                    fichInt.getElementsOfFile().add("12");
                    fichInt.getElementsOfFile().add("13");
                    fichInt.getElementsOfFile().add("150");
                    fichInt.getElementsOfFile().add("120");
                    fichInt.getElementsOfFile().add("17");



        }

        exapunks.getListPieceRobot().get(1).getListFichiers().add(fichInt); 
        /**  
         * ici on peut surement ajouter le fichier dans la pièce
         *car elle contient aucun fichier pour le moment  donc pas la peine de vérifier la condition if peutRajouterFichier  */
        /**
         * on rajoute le fichier identifiant 200 à deuxième pièce ( pièce du milieu dans le jeu )
         * ce qui est toujours fait dans le jeu automatiquement quelque soit le niveau
         * 
         */

        
    }

    public Robot getRobot()
    {
        return exapunks;
    }

    public int getNumLevel()
    {
        return num;
    }

    














}
