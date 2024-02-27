import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.image.ImageObserver;

public class VuePlateforme extends JPanel {

    private Color couleur;
    private int size;
    private boolean robotPresent;
    private Image robotImage;

    private boolean fichierPresent;
    private Image fichierImage;

    public VuePlateforme(Color couleur, int size) {
        this.couleur = couleur;
        this.size = size;
        this.robotPresent = false;
        this.fichierPresent = false;
        setPreferredSize(new Dimension(size * 25, size * 25));
        setBorder(new LineBorder(Color.GREEN, 2));
        setOpaque(true);

        // Chargez les images lors de la création de la plateforme
        loadRobotImage();
        loadFichierImage();
    }

    // Charger l'image du robot depuis un fichier
    private void loadRobotImage() {
        try {
            robotImage = new ImageIcon("image/icon.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Charger l'image du fichier depuis un fichier
    private void loadFichierImage() {
        try {
            fichierImage = new ImageIcon("image/fichier.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode pour dessiner le robot au centre de la plateforme
    public void dessinerRobot() {
        robotPresent = true;
        repaint();  // Redessiner la plateforme avec le robot
    }

    // Méthode pour retirer le robot de la plateforme
    public void retirerRobot() {
        robotPresent = false;
        repaint();  // Redessiner la plateforme sans le robot
    }

    // Méthode pour dessiner le fichier en bas à droite de la plateforme
    public void dessinerFichier() {
        fichierPresent = true;
        repaint();  // Redessiner la plateforme avec le fichier
    }

    // Méthode pour retirer le fichier de la plateforme
    public void supprimerFichier() {
        fichierPresent = false;
        repaint();  // Redessiner la plateforme sans le fichier
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

        // Dessiner le robot si présent
        if (robotPresent && robotImage != null) {
            int robotSize = Math.min(width, height) / 2;  // Taille du robot
            int robotX = (width - robotSize) / 2;  // Position X du robot
            int robotY = (height - robotSize) / 2;  // Position Y du robot
            g.drawImage(robotImage, robotX, robotY, robotSize, robotSize, (ImageObserver) this);
        }

        // Dessiner le fichier si présent
        if (fichierPresent && fichierImage != null) {
            int fichierSize = Math.min(width, height) / 2;  // Taille du fichier
            int fichierX = width - fichierSize;  // Position X du fichier
            int fichierY = height - fichierSize;  // Position Y du fichier
            g.drawImage(fichierImage, fichierX, fichierY, fichierSize, fichierSize, (ImageObserver) this);
        }
    }

    // Méthode pour vérifier si un robot est présent sur la plateforme
    public boolean robotPresent() {
        return robotPresent;
    }

    // Méthode pour vérifier si un fichier est présent sur la plateforme
    public boolean fichierPresent() {
        return fichierPresent;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test de la Plateforme");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



            // Utiliser un layout manager pour afficher la plateforme
            JPanel contentPane = new JPanel(new FlowLayout());


            frame.setContentPane(contentPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

