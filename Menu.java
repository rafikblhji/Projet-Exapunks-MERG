/**
 * Le menu du jeu 
 * @since 20/01/2024
 * @version 17/03/2024
 * @author ORCUN Gabriel
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private fenetrePrincipale niveau;
    private int numNiv;

    public Menu() {
        super("Menu");

        // Création des boutons pour les niveaux 1, 2 et 3
        JButton niveau1Button = createButton("Niveau 1");
        JButton niveau2Button = createButton("Niveau 2");
        JButton niveau3Button = createButton("Niveau 3");
        JButton niveau4Button = createButton("Niveau Libre");
        

        // Ajout des écouteurs d'événements aux boutons
        niveau1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 1");
                numNiv = 1;
                getNiveau().getFichier().chargerContenuFichier("niveau1.txt");
                getNiveau().getMission().chargerMission("mission1.txt");
                // Insérez ici le chargement du contenu et de la mission pour le niveau 1
            }
        });

        niveau2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 2");
                numNiv = 2;
                // Insérez ici le chargement du contenu et de la mission pour le niveau 2
            }
        });

        niveau3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 3");
                numNiv = 3;
                getNiveau().getFichier().chargerContenuFichier("niveau3.txt");
                getNiveau().getMission().chargerMission("mission3.txt");// Insérez ici le chargement du contenu et de la mission pour le niveau 3
            }
        });

        niveau4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau LIBRE");
                numNiv = 4;
                getNiveau().getFichier().chargerContenuFichier("niveau4.txt");
                getNiveau().getMission().chargerMission("mission4.txt");
                // Insérez ici le chargement du contenu et de la mission pour le niveau 3
            }
        });

        // Création du conteneur pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.BLACK); // Fond noir
        buttonPanel.add(niveau1Button);
        buttonPanel.add(niveau2Button);
        buttonPanel.add(niveau3Button);
        buttonPanel.add(niveau4Button);

        // Ajout du conteneur au menu
        add(buttonPanel);

        // Configuration de la JFrame du menu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrage de la fenêtre
        setVisible(true);
    }

    // Méthode utilitaire pour créer un bouton avec une apparence personnalisée
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(Color.RED); // Couleur rouge
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false); // Supprimer l'effet de focus
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordure noire
        button.setPreferredSize(new Dimension(200, 50)); // Taille personnalisée
        return button;
    }

    // Méthode pour ouvrir une nouvelle fenêtre principale avec un titre donné
    private void ouvrirNouveauNiveau(String titre) {
        // Fermer la fenêtre principale précédente s'il y en a une
        if (niveau != null) {
            niveau.dispose();
        }

        // Ouvrir une nouvelle fenêtre principale
        niveau = new fenetrePrincipale();
        niveau.setTitle(titre);
        niveau.setVisible(true);
    }

    public int getNumNiv() {
        return this.numNiv;
    }

    public fenetrePrincipale getNiveau() {
        return this.niveau;
    }

    public static void main(String[] args) {
        // Démarrer l'application en créant une instance du menu
        SwingUtilities.invokeLater(Menu::new);
    }
}





