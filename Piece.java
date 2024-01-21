/**
*Cette classe est la classe Pièce , elle réprésente les pièces du jeu exapunks ou le robot  peut se déplacer
*et on peut mettre des fichiers , les ajouter ou les retirer 
*
*@author BELHADJI Rafik
*@since 20/01/2024
*/
import java.util.ArrayList;

public class Piece {

    /* déclaration des attributs nécessaires pour la classe pièce  */
    private ArrayList <Fichier> listFichier ; /* une list  de fichier contenu dans la classe */
    int taillePiece; 
    /** la taille de la pièce réprésente le nombre de case 
     * si taillePiece=2 , donc le nombre de case est 4 (taillePiece  x taille Piece )
     * le nombre maximum de fichier qu'une pièce peut porter est taillePiece x Taille Piece -1 
     * pourquoi? en effet j'ai remarqué dans le jeu que on peut créer autant de fichier qu'on veut
     * et faire DROP pour les laisser dans la pièce mais à condition que il y a au moins une case vide dans la pièce
     * car il faut toujours laisser au moins une case vide
    */
    /**
 
     * @param longueur c'est la longueur de la pièce 
     * @requires longueur>0
     * @ensures listFichier.isEmpty()
     * @throws IllegalArgumentException si longueur <0 
     * @ensures taillePiece==longueur*longueur
     * 
     * 
     */
    public Piece ( int longueur )
    {
        if(longueur<0)  
            throw new IllegalArgumentException();

        taillePiece=longueur*longueur;



    }
    /**
     * Cette méthode teste si on peut rajouter un fichier dans la pièce ou pas 
     * 
     * @return true si on peut rajouter un fichier false sinon 
     * 
     */
    public boolean peutRajouterFicher()
    {  /**
        *on a vu qu'il nous faut au moins de case vide dans la pièce pour pouvoir rajouter un fichier s'il reste qu'une seule c'est bon on 
        * ne peut plus rajouter un fichier car on laisse la case qui reste pour le déplacement du robot  
        */
        if(taillePiece-listFichier.size()>=2)
            return true;
        
        return false;
    }




















}
