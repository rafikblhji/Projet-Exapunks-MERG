import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VueFichier extends JPanel {
    private JLabel labelNomFichier;
    private JTextArea contenuTextArea;

    public VueFichier(String nomFichier, String cheminFichier) {
        setLayout(new BorderLayout());

        // Créer un JLabel centré en haut avec le nom du fichier
        labelNomFichier = new JLabel(nomFichier);
        labelNomFichier.setHorizontalAlignment(SwingConstants.CENTER);
        labelNomFichier.setBackground(Color.GRAY);
        labelNomFichier.setOpaque(true);

        // Ajouter le JLabel à la partie supérieure du JPanel
        add(labelNomFichier, BorderLayout.NORTH);

        // Créer la zone de texte pour le contenu
        contenuTextArea = new JTextArea();
        contenuTextArea.setEditable(false);
        contenuTextArea.setBackground(Color.BLACK);
        contenuTextArea.setForeground(Color.WHITE);

        // Ajouter la zone de texte à la partie centrale du JPanel
        add(contenuTextArea, BorderLayout.CENTER);

        // Charger le contenu à partir du fichier
        chargerContenuFichier(cheminFichier);
    }

    // Méthode pour accéder à la zone de texte du contenu
    public JTextArea getContenuTextArea() {
        return contenuTextArea;
    }

    // Méthode pour charger le contenu d'un fichier texte
    private void chargerContenuFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            StringBuilder contenu = new StringBuilder();
            String ligne;
            while ((ligne = br.readLine()) != null) {
                contenu.append(ligne).append("\n");
            }
            contenuTextArea.setText(contenu.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
