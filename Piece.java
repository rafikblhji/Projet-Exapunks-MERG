/**
*Cette classe est la classe Pièce , elle réprésente les pièces du jeu exapunks ou le robot  peut se déplacer
*et on peut mettre des fichiers , les ajouter ou les retirer 
*
*@author BELHADJI Rafik
*@since 20/01/2024
*@version 22/01/2024
*/

/**
 * j'ai choisi de mettre import java.util.* afin de simplifier le travail importer tout 
 * et ne pas avoir à importer à chaque fois les outils que j'utilise 
 * comme ArrayList , Collection,.....etc
 */
import java.util.*;

public class Piece {

    /* déclaration des attributs nécessaires pour la classe pièce  */
    private ArrayList <Fichier> listFichier ; /* une list  de fichier contenu dans la classe */
    private int taillePiece; 
    /** la taille de la pièce réprésente le nombre de case 
     * si taillePiece=2 , donc le nombre de case est 4 (taillePiece  x taille Piece )
     * le nombre maximum de fichier qu'une pièce peut porter est taillePiece x Taille Piece -1 
     * pourquoi? en effet j'ai remarqué dans le jeu que on peut créer autant de fichier qu'on veut
     * et faire DROP pour les laisser dans la pièce mais à condition que il y a au moins une case vide dans la pièce
     * car il faut toujours laisser au moins une case vide
    */
    /**
 
     * @param longueur c'est la longueur de la pièce ( la longueur = la largeur car la pièce a la forme d'un carré )
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
        *on a vu qu'il nous faut au moins deux case vide dans la pièce pour pouvoir rajouter un fichier s'il reste qu'une seule c'est bon on 
        * ne peut plus rajouter un fichier car on laisse la case qui reste pour le déplacement du robot  
        */
        if(taillePiece-listFichier.size()>=2)
            return true;
        
        return false;
    }
    /**
     * je crée cette méthode pour retourner arrayList de fichier de cette pièce qui sera utilisée par la méthode
     * GRAB ET DROP de la classe robot , car on ne peut pas accéder à l'attribut listFichiers car il est private
     * donc la solution est de créer cette méthode public qui permet d'avoir la meme liste de fichier 
     * @return renvoyer arraylist de fichier contenu dans la classe Robot
     */
    public ArrayList<Fichier> getListFichiers()
    {
        return listFichier;
    }



















}
