/**
 * Classe qui réprésente  le niveau du robot 
*@author BELHADJI Rafik
*@since 6/02/2024
*@version 8/02/2024
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

    public Level ( int a )
    {
        num=a;
        fichInt=new Fichier(200);
        ArrayList<Piece> listePiece = new ArrayList<Piece>();
        int i=1;
        /* dans notre jeu on a 3 pièce ou le robot se déplace car on a que les niveau ou y a un seul robot  */
        while(i<=3)
        {
        listePiece.add(new Piece(5));
        }

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
            fichInt.getElementsOfFile().add("ECHO");
            fichInt.getElementsOfFile().add("9780");
            case 4 :
            fichInt.getElementsOfFile().add("9");

            default : 
                /* à réfléchir ce que je dois mettre ici ? */



        }

        exapunks.getListPieceRobot().get(1).getListFichiers().add(fichInt);
        /**
         * on rajoute le fichier identifiant 200 à deuxième pièce ( pièce du milieu dans le jeu )
         * ce qui est toujours fait dans le jeu automatiquement quelque soit le niveau
         * 
         */

        
    }

    














}