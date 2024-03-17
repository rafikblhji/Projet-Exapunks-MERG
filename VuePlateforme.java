
/**
 * Les plateformes du jeu 
 * @since 20/01/2024
 * @version 17/03/2024
 * @author ORCUN Gabriel
 * 
 */


import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.Map;
import java.awt.Point;

public class VuePlateforme extends JPanel {

    private Color couleur;
    private int size;
    private boolean robotPresent;
    private Image robotImage;

    private Map<Integer, Point> fichiers;
    private Image fichierImage;

    private int currentFileX;
    private int currentFileY;

    private String messageHaut;
    private String messageBas;

    public VuePlateforme(Color couleur, int size) {
        this.couleur = couleur;
        this.size = size;
        this.robotPresent = false;
        this.fichiers = new HashMap<>();
        this.messageHaut = "";
        this.messageBas = "";
        setPreferredSize(new Dimension(size * 25, size * 25));
        setBorder(new LineBorder(Color.GREEN, 2));
        setOpaque(true);

        loadRobotImage();
        loadFichierImage();

        currentFileX = size - 1;
        currentFileY = size - 1;
    }

    private void loadRobotImage() {
        try {
            robotImage = new ImageIcon("image/icon.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFichierImage() {
        try {
            fichierImage = new ImageIcon("image/fichier.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dessinerRobot() {
        robotPresent = true;
        repaint();
    }

    public void retirerRobot() {
        robotPresent = false;
        repaint();
    }

    public void dessinerFichier(int id) {
        while (fichiers.containsValue(new Point(currentFileX, currentFileY))) {
            currentFileX--;
            if (currentFileX < 0) {
                currentFileX = size - 1;
                currentFileY--;
                if (currentFileY < 0) {
                    currentFileY = size - 1;
                }
            }
        }

        Point nouveauFichier = new Point(currentFileX, currentFileY);
        fichiers.put(id, nouveauFichier);

        currentFileX--;
        if (currentFileX < 0) {
            currentFileX = size - 1;
            currentFileY--;
            if (currentFileY < 0) {
                currentFileY = size - 1;
            }
        }

        repaint();
    }

    public void supprimerFichier(int id) {
        fichiers.remove(id);
        repaint();
    }

    public void dessinerFichierSurRobot(int id) {
        Point centre = new Point(size / 2, size / 2);
        fichiers.put(id, centre);
        repaint();
    }

    // Méthode pour afficher un message en haut de la plateforme
    public void afficherMessageHaut(String message) {
        this.messageHaut = message;
        repaint();
    }

    // Méthode pour afficher un message en bas de la plateforme
    public void afficherMessageBas(String message) {
        this.messageBas = message;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int col, row;

        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
                int pixelX = col * (width / size);
                int pixelY = row * (height / size);

                g.setColor(couleur);
                g.fillRect(pixelX, pixelY, width / size, height / size);
                g.setColor(Color.WHITE);
                g.drawRect(pixelX, pixelY, width / size, height / size);
            }
        }

        if (robotPresent && robotImage != null) {
            int robotSize = Math.min(width / size + 50, height / size + 50) / 2;
            int robotX = (width - robotSize) / 2;
            int robotY = (height - robotSize) / 2;
            g.drawImage(robotImage, robotX, robotY, robotSize, robotSize, (ImageObserver) this);
        }

        for (Map.Entry<Integer, Point> entry : fichiers.entrySet()) {
            int id = entry.getKey();
            Point fichier = entry.getValue();
            int fichierX = fichier.x * (width / size);
            int fichierY = fichier.y * (height / size);
            int fichierSize = Math.min(width / size + 30, height / size + 30) / 2;

            g.drawImage(fichierImage, fichierX, fichierY, fichierSize, fichierSize, this);
            g.setColor(Color.GREEN);
            g.drawString(String.valueOf(id), fichierX + fichierSize / 2 - 10, fichierY - 5);
        }

        // Dessiner le message en haut si présent
        if (!messageHaut.isEmpty()) {
            g.setColor(Color.YELLOW);
            // Ajuster les coordonnées pour centrer le texte en haut
            int x = (width - g.getFontMetrics().stringWidth(messageHaut)) / 2;
            int y = g.getFontMetrics().getAscent();  // Utiliser l'ascenseur pour l'alignement vertical
            g.drawString(messageHaut, x, y);
        }

        // Dessiner le message en bas si présent
        if (!messageBas.isEmpty()) {
            g.setColor(Color.YELLOW);
            // Ajuster les coordonnées pour aligner le texte en bas
            int x = (width - g.getFontMetrics().stringWidth(messageBas)) / 2;
            int y = height - g.getFontMetrics().getDescent();  // Utiliser la descente pour l'alignement vertical
            g.drawString(messageBas, x, y);
        }
    }

    public boolean robotPresent() {
        return robotPresent;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test de la Plateforme");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Test de dessin de fichiers
        });
    }
}
