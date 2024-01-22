/**
*Cette classe est la classe fichier qui réprésente les fichiers du jeu Exapunks qu'on peut créer déplacer et 
*manipuler leur valeurs 
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


public class Fichier 
{
    /* déclaration des attributs nécessaires pour la classe robot  */
    private int id; /* identifiant de fichier  */
    private ArrayList <Object> list; /* car le fichier il a un contenu  */

    /**
     *  En effet j'ai remarqué dans le jeu que chaque fichier a un identifiant 
     *  et que chaque fichier a un contenu dans le niveau 1 il contient des String
     *  dans le niveau 2 il contient des entier 
     * donc je déclare une ArrayList de type objet  et je l'initialise selon le niveau 
     * c'est à dire dans le niveau  ça sera une arrayList de String
     * dans le niveau  2 ça sera une arrayList d'entier 
     * je parle précisément du fichier d'identifiant 200 qui contient des String au niveau 1
     * et des entiers au niveau 2 
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
     public Fichier ( int id , Collection <? extends Object> c )
     {
        if( id<0)
            throw new IllegalArgumentException();
        
        if ( c==null || c.contains(null))
            throw new NullPointerException();

        this.id=id;
        
        this.list=new ArrayList<Object >(c); 
        /** 
         * ici j'ai préféré créer une nouvelle instance de classe comme ça list ne sera pas dépendante de la collection c
         * en cas ou elle est modifiée 
         */

     }

     public int getId()
     {
        return id;
     }

    public Collection <? extends Object> getElementsOfFile()
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
        
        ArrayList <Object> fList = new ArrayList<Object>(f.list);

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
    






}
