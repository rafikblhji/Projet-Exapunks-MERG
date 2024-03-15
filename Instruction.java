/**
 * Cette classe est utile quand je vais découper le fichier qui contient les instructions
 * elle sert à stocker le nom de l'instruction et ses arguments 
 * @since 18/02/2024
 * @version 15/03/2024
 * @author Belhadji Rafik
 * 
 */

 public class Instruction 
 {


    private String nom; /* le nom de l'instruction  */
    private String[] arguments; /* les arguments de l'instruction  */

    public Instruction(String name, String[] args) {
        nom = name;
        arguments = args;
    }

    public String getNom() {
        return nom;
    }

    public String[] getArguments() {
        return arguments;
    }



 }