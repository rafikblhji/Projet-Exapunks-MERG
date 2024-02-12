import java.util.*;


/**
 * Test
 */
public class Test {
    
    public static void main (String [] args)
    {
        Level niveauJeu = new Level(1);
    niveauJeu.getRobot().MAKE();
    niveauJeu.getRobot().DROP();
    niveauJeu.getRobot().LINK(800);

    niveauJeu.getRobot().GRAB(200);

    niveauJeu.getRobot().DROP();
    
    System.out.println("bonjour");
    niveauJeu.getRobot().LINK(-1);
    System.out.println("DE RETOUR A LA PIECE DAVANT ");
    }
    
    
    

    
    







}