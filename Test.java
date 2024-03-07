import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        int num = 0;
    Level levelofgame;
    

    if (args.length > 0) {
        /*  Récupérer le premier argument (le 0-index) */
        String argument = args[0];
        
        try {
            /*  Convertir la chaîne en un entier */
             num = Integer.parseInt(argument);

                        
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

    levelofgame = new Level(num);
    //Fichier unfichier = levelofgame.getRobot().getListPieceRobot().get(1).getListFichiers().get(0);
     String registreX = "X";
    String registreF = "F";
    switch(num){
        case 1 :
            Scanner scanner = new Scanner(System.in);

        // Afficher un message pour l'utilisateur
            System.out.print("Veuillez entrer un entier : ");

        // Lire l'entrée utilisateur sous forme d'entier
            int entier = scanner.nextInt();

            System.out.println("Quel test voulez vous voir ? 1 ou 2 ?");

            switch(entier){
                case 1 :
                System.out.println("Ce test correspond a une esquisse de solution du niveau 1 ");
               levelofgame.getRobot().LINK(800);
                System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                levelofgame.getRobot().GRAB(200);
                lireFichier(levelofgame.getRobot().getFileRobot());
                lireIdFichier(200, levelofgame);
                levelofgame.getRobot().LINK(-1);
                System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                levelofgame.getRobot().DROP();
                //lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().MAKE();
                lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().DROP();
                //lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().MAKE();
                lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().DROP();
                //lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().GRAB(400);
                lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().LINK(800);
                System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                levelofgame.getRobot().DROP();
                //lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().LINK(-1);
                System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                levelofgame.getRobot().GRAB(401);
                lireFichier(levelofgame.getRobot().getFileRobot()); 
            break;
            
            /* */
                case 2 :
                    /**Permet de verifier si  un fichier a ete correctement deplace  d'une piece à une autre et s'il ne reste pas dans son emplacement precedent */
                    levelofgame.getRobot().LINK(800);
                    System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                    levelofgame.getRobot().GRAB(200);
                    
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(0), 0);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(1), 1);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(2), 2);
                    levelofgame.getRobot().DROP();
                    System.out.println("le fichier est dans la piece d'indice 1");
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(0), 0);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(1), 1);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(2), 2);
                    System.out.println("le fichier est recuppere dans la piece 1 puis deposer dans la piece 2");  
                    levelofgame.getRobot().GRAB(200);
                    levelofgame.getRobot().LINK(800);
                    levelofgame.getRobot().DROP();
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(0), 0);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(1), 1);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(2), 2);
                    System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                    levelofgame.getRobot().DROP();
                    levelofgame.getRobot().LINK(-1);
                    levelofgame.getRobot().MAKE();
                    levelofgame.getRobot().DROP();
                    levelofgame.getRobot().LINK(-1);
                    levelofgame.getRobot().MAKE();
                    levelofgame.getRobot().DROP();
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(0), 0);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(1), 1);
                    lirePiece(levelofgame.getRobot().getListPieceRobot().get(2), 2);
                break;

                    default:
                        System.exit(1);
            } 

            break;

            case 2 :
                System.out.println("Ce test correspond a une esquisse de solution du niveau 2 ");
                levelofgame.getRobot().LINK(800);
                System.out.println("Piece courante du robot : " + levelofgame.getRobot().getIndexPieceCourante());
                levelofgame.getRobot().GRAB(200);
                lireFichier(levelofgame.getRobot().getFileRobot());
            
                levelofgame.getRobot().COPY(levelofgame.getRobot().getFileRobot(), registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                levelofgame.getRobot().ADDI(registreX, levelofgame.getRobot().getFileRobot(), registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                levelofgame.getRobot().MULI(registreX, levelofgame.getRobot().getFileRobot(), registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                String str = "10";
                levelofgame.getRobot().SUBI(registreX, str, registreX);
                levelofgame.getRobot().ADDI(registreX, str, registreX);
                levelofgame.getRobot().MULI(str, levelofgame.getRobot().getFileRobot(), registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                levelofgame.getRobot().COPY(registreX, levelofgame.getRobot().getFileRobot());
                lireFichier(levelofgame.getRobot().getFileRobot());
                
                break;
            case 3 :
                System.out.println("Ce test correspond a une esquisse de solution du niveau 3 ");
                levelofgame.getRobot().COPY("5", registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                levelofgame.getRobot().MAKE();
                levelofgame.getRobot().COPY("500", levelofgame.getRobot().getFileRobot());
                lireFichier(levelofgame.getRobot().getFileRobot());
                levelofgame.getRobot().ADDI(registreX, "2" , registreX);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                levelofgame.getRobot().TEST(registreX, "=", 10);
                System.out.println("valeur du registre X : " + levelofgame.getRobot().getValueOfRegisterX());
                lireFichier(levelofgame.getRobot().getFileRobot());
                Jeu unJeu = new Jeu();

                break;
            default : 

            break;





    } 
   
    }

/**la méthode affiche le contenu du fichier entre en parametre */
   public static void lireFichier(Fichier f){
        System.out.println("Contenu du fichier avec l'identifiant " + f.getId());
        ArrayList<String> elements = f.getElementsOfFile();
        for(String str : elements){
            System.out.println(str);
        }
   }

    public static void lireArrayPiece(ArrayList <Piece> p){
        System.out.println("Contenu de la piece avec l'identifiant " );
        
        for(Piece f : p){
            System.out.println(f);
        } 
    } 

    public static void lirePiece(Piece p, int index){
        System.out.println("Contenu de la piece avec l'identifiant " + index);
        ArrayList<Fichier> elements = p.getListFichiers();
        for(Fichier f : elements){
            System.out.println(f);
        } 
    } 

   public static void lireIdFichier(int idFichier, Level niveau){
    Fichier fichier = null;
        for (Piece piece : niveau.getRobot().getListPieceRobot()) {
            for (Fichier fich : piece.getListFichiers()) {
                if (fich.getId() == idFichier) {
                    fichier = fich;
                    break;
                }
            }
            if (fichier != null) {
                break;
            }
        }

        // Vérification si le fichier existe
        if (fichier != null) {
            // Affichage du contenu du fichier
            System.out.println("Contenu du fichier avec l'identifiant " + idFichier + ":");
            ArrayList<String> elements = fichier.getElementsOfFile();
            for (String element : elements) {
                System.out.println(element);
            }
        } else {
            System.out.println("Le fichier avec l'identifiant " + idFichier + " n'existe pas dans ce niveau.");
        }
    }

}

