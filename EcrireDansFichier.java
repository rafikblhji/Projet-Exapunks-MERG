 
import java.io.FileWriter;
import java.io.IOException;
 
/**
 * This program demonstrates how to write characters to a text file.
 * @author www.codejava.net
 *
 */
public class EcrireDansFichier {
 
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("./MonFichier.txt", true);
            writer.write("Bonjour le Monde");
            writer.write("\r\n");   // Ecrire une nouvelle ligne
            writer.write("Bon chance!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}
