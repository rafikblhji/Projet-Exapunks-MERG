/**
 * 
 * 
 */

 public class Instruction 
 {


    private String nom; /* le nom de l'instruction  */
    private String[] arguments; /* les arguments de l'instruction  */

    public Instruction(String nom, String[] arguments) {
        this.nom = nom;
        this.arguments = arguments;
    }

    public String getNom() {
        return nom;
    }

    public String[] getArguments() {
        return arguments;
    }



 }