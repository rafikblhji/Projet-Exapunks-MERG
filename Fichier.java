/**
*Cette classe est la classe fichier qui réprésente les fichiers du jeu Exapunks qu'on peut créer déplacer et 
*manipuler leur valeurs 
*
*@author BELHADJI Rafik
*@since 20/01/2024
*@version 8/02/2024
*/

/**
 * j'ai choisi de mettre import java.util.* afin de simplifier le travail importer tout 
 * et ne pas avoir à importer à chaque fois les outils que j'utilise 
 * comme ArrayList , Collection,.....etc
 */

import java.util.*;


public class Fichier 
{
    /* déclaration des attributs nécessaires pour la classe robot  */
    private int id; /* identifiant de fichier  */
    private ArrayList <String> list; /* car le fichier il a un contenu dedans   */

    /**
     *  En effet j'ai remarqué dans le jeu que chaque fichier a un identifiant 
     *  et que chaque fichier a un contenu qui peut etre sois un int sois un String
     * j'ai choisi alors de déclarer une arraylist de String tel que je considère meme les entier
     * comme des String mais bien sûr , je sais bien que parfois dans le jeu on doit savoir si l'élément du fichier est un entier ou pas 
     * comme par exemple pour pouvoir faire une addition , donc en première vu , je considère tout comme String
     * mais ensuite je vais rajouter les méthodes nécessaires dans la classe robot afin de pouvoir distinguer un string s'il représente un entier
     * ou pas par exemple si le fichier contient "Move","this","file ","15","ok","super","2"
     * je dois créer une méthode qui peut vérifier si l'élément représente un entier ou pas comme ça si on fait une addition
     * comme dans le jeu on vérifiera si c'est possible ( si un entier ), par exemple dans le niveau 1 de jeu  si on essaye de faire
     * une addition ça va bloquer car le fichier d'identifiant 200 ne contient pas des entiers 
     */


    /**
     * Constructeur de la classe fichier
     * @param id identifiant de fichier
     * @param c Collection d'élements
     * @requires c!=null && !c.contains(null)
     * @requires id >0 
     * @ensures list.size()==c.size()
     * @ensures list.containsAll(c) && c.containsAll(list)
     * @throws NullPointerException si c est null ou contient un éléments null
     * @throws IllegalArgumentException si identifiant est inférieur à 0 , 
     * la condition de identifiant >0 est facultatif mais en effet j'ai remarqué dans le jeu que 
     * les identifiants sont toujours positifs donc j'aimerai bien garder ça ici 
     */
     public Fichier ( int id , Collection <String> c )
     {
        if( id<0)
            throw new IllegalArgumentException();
        
        if ( c==null || c.contains(null))
            throw new NullPointerException();

        this.id=id;
        
        this.list=new ArrayList<String >(c); 
        /** 
         * ici j'ai préféré créer une nouvelle instance de classe comme ça list ne sera pas dépendante de la collection c
         * en cas ou elle est modifiée 
         */

     }
     /**
     * deuxième Constructeur de la classe fichier qui initialise un fichier vide 
     * @param id identifiant de fichier
     * @requires id >0 
     * @throws IllegalArgumentException si identifiant est inférieur à 0 , 
     * la condition de identifiant >0 est facultatif mais en effet j'ai remarqué dans le jeu que 
     * les identifiants sont toujours positifs donc j'aimerai bien garder ça ici 
     */
     public Fichier ( int id )
     {
        if ( id<0)
            throw new IllegalArgumentException();
        
            this.id=id;
        this.list = new ArrayList<String>();
     }

     public int getId()
     {
        return id;
     }

     
     public ArrayList <String> getElementsOfFile()
     {
         return list;
     }

    public boolean equals (Object o )
    {

        if (!(o instanceof Fichier ))
            return false;
        
        Fichier f = (Fichier) o;
        if( f.id != id)
            return false;
        
        ArrayList <String> fList = new ArrayList<String>(f.list);

        if(fList.size()!=list.size())
            return false;

        for( int i=0;i<list.size();i++)
        {
            if(!(fList.remove(list.get(i))))
                return false;

        }

        return fList.isEmpty();

    }
    /**
     * c'est une classe modifiable je dois redéfinir clone , hashCode, toString si je redéfini équals ( c'est à voir après )
     */
    /**
     * 
     */

     public Fichier Clone()
     {
        Object o=null;
        try 
        {
            o=super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError("CLONE ECHEC");
        }
        Fichier fichierNew=(Fichier) o;
        fichierNew.list= new ArrayList<String>(list);
        return fichierNew;


     }

     public int hashCode()
     {

        int code=id;
        code=code*31+list.hashCode();
        return code;


     }

     public String toString()
     {
        String s;
        s="Fichier : { " +id + list.toString() + "}";
        return s;


     }
    






}
