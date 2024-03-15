/**
 * Classe qui réprésente  le niveau du robot 
*@author BELHADJI Rafik
*@since 6/02/2024
*@version 15/03/2024
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
     *@requires a >0
     @param a le numéro du niveau 
     */
    public Level ( int a )
    {
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
                /* ici le cas ou c'est 1 ou bien > 3 */
                /* si l'utilisateur fait rentrer un niveau > 3 on va automatiquement initialiser comme le niveau 1  */
                fichInt.getElementsOfFile().add("MOVE");
                    fichInt.getElementsOfFile().add("THIS");
                    fichInt.getElementsOfFile().add("FILE");
                    fichInt.getElementsOfFile().add("TO");
                    fichInt.getElementsOfFile().add("THE");
                    fichInt.getElementsOfFile().add("OUTBOX");
                    break;



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
