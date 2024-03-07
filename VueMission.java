import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VueMission extends JPanel {

    private JTextArea missionTextArea;

    public VueMission(String cheminFichierMission) {
        setLayout(new BorderLayout());

        // Créer la zone de texte pour le contenu de la mission
        missionTextArea = new JTextArea();
        missionTextArea.setEditable(false);
        missionTextArea.setBackground(Color.BLACK);
        missionTextArea.setForeground(Color.WHITE);

        // Ajouter la zone de texte à la partie centrale du JPanel
        add(missionTextArea, BorderLayout.CENTER);

        // Charger le contenu de la mission à partir du fichier
        chargerMission(cheminFichierMission);
    }

    // Méthode pour accéder à la zone de texte de la mission
    public JTextArea getMissionTextArea() {
        return missionTextArea;
    }

    // Méthode pour charger le contenu d'une mission à partir d'un fichier texte
    public void chargerMission(String cheminFichierMission) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichierMission))) {
            StringBuilder mission = new StringBuilder();
            String ligne;
            while ((ligne = br.readLine()) != null) {
                mission.append(ligne).append("\n");
            }
            missionTextArea.setText(mission.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Spécifiez le chemin du fichier de mission
            String cheminFichierMission = "ligne.txt";

            VueMission vueMission = new VueMission(cheminFichierMission);

            // Exemple d'utilisation dans une JFrame
            JFrame frame = new JFrame();
            frame.setTitle("Test VueMission");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.add(vueMission);
            frame.setVisible(true);
        });
    }
}
