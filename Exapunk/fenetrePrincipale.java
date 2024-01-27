// cette classe reprrsente la fenetre principale du jeux avec ses 3 zones celle de code du joueur, celle du le jeux
// et la zone de bas avec les bouton. Ceci est une premiere version il manque a implementer les fonction des bouton pas et stop



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class fenetrePrincipale extends JFrame {

    public fenetrePrincipale() {
        // Définir le titre de la fenêtre
        super("Exapunks simulator");

        // Créer un dégradé de gris pour l'arrière-plan
        Color color1 = Color.DARK_GRAY;
        Color color2 = Color.LIGHT_GRAY;
        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);

        // Utiliser un JPanel personnalisé avec le dégradé de gris comme arrière-plan
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Ajouter les panels pour les zones gauche, droite et en dessous
        JPanel zoneDroite = createDrawingPanel();
        JPanel zoneEnDessous = createPanel(Color.BLACK);
        JPanel zoneGauche = new JPanel(new GridBagLayout());
        zoneGauche.setBackground(Color.BLACK);
        zoneGauche.setBorder(new LineBorder(Color.GRAY, 3));
        //creer la zone code pour le robot exa a la disposer dans le panel de gauche en haut
        VueZoneCode vueZoneCode = new VueZoneCode("exa");
        GridBagConstraints gbcPage = new GridBagConstraints();
        gbcPage.gridx = 0;
        gbcPage.gridy = 0;
        gbcPage.gridwidth = 1;
        gbcPage.gridheight = 1;
        gbcPage.weightx = 1.0; // Utiliser toute la largeur disponible
        gbcPage.weighty = 0.25; // 25% de la hauteur disponible
        gbcPage.fill = GridBagConstraints.HORIZONTAL;
        gbcPage.anchor = GridBagConstraints.PAGE_START;
        zoneGauche.add(vueZoneCode, gbcPage);

        // Ajouter des boutons en haut à gauche du JPanel du bas (zoneEnDessous)
        JButton boutonPas = new JButton(">");
        JButton boutonStop = new JButton("||");
        

        // Définir le gestionnaire de disposition pour le JPanel du bas
        zoneEnDessous.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Ajouter les boutons en haut à gauche du JPanel du bas
        zoneEnDessous.add(boutonPas);
        zoneEnDessous.add(boutonStop);

        // Définir le gestionnaire de disposition BorderLayout pour la fenêtre principale
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        // Ajouter la zone gauche (25% largeur, 100% hauteur)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(zoneGauche, gbc);

        // Ajouter la zone droite (75% largeur, 50% hauteur)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.75;
        gbc.weighty = 0.5;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(zoneDroite, gbc);

        // Ajouter la zone en dessous (75% largeur, 50% hauteur)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(zoneEnDessous, gbc);

        // Ajouter le panel principal avec le dégradé de gris comme arrière-plan
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.insets = new java.awt.Insets(0, 0, 0, 0);
        add(mainPanel, gbc);

        // Configurer la JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Taille arbitraire
        setLocationRelativeTo(null); // Centre la fenêtre
        setVisible(true);
    }
    // creer le jpanel du dessou avec les caracteristique qui lui correspond
    private JPanel createPanel(Color color) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        // Ajouter une bordure non vide et grise
        panel.setBorder(new LineBorder(Color.GRAY, 3));
        return panel;
    }
    // creer le jpanel du jeux avec une fonction qui va dessiner limage de fond que je lui est passer dans mon repertoir image
   private JPanel createDrawingPanel() {
    JPanel panel = new JPanel() {
        private Image image;

        {
            try {
                // Charger l'image depuis un fichier
                image = ImageIO.read(new File("image/fond.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Dessiner l'image 
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }

            // Dessiner la bordure
            g.setColor(Color.GRAY);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new java.awt.BasicStroke(3));
            g.drawRect(0, 0, getWidth(), getHeight());
        }
    };

    // Ajouter une bordure grise 
    panel.setBorder(new LineBorder(Color.GRAY, 3));

    // Définir la taille préférée pour s'assurer que le dessin fonctionne correctement
    panel.setPreferredSize(new Dimension(1, 1));

    return panel;
}

    public static void main(String[] args) {
        fenetrePrincipale frame = new fenetrePrincipale();
    }
}



