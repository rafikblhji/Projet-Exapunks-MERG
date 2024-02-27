import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        // Définir le titre de la fenêtre du menu
        super("Menu");

        // Créer le bouton pour le niveau 1
        JButton niveau1Button = new JButton("Niveau 1");

        // Ajouter un écouteur d'événements au bouton
        niveau1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre principale lorsque le bouton "Niveau 1" est cliqué
                ouvrirNouveauNiveau("Niveau 1");
            }
        });

        // Créer le gestionnaire de disposition pour le menu
        setLayout(new FlowLayout());

        // Ajouter le bouton au menu
        add(niveau1Button);

        // Configurer la JFrame du menu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null); // Centre la fenêtre
        setVisible(true);
    }

    // Méthode pour ouvrir une nouvelle fenêtre principale avec un titre donné
    private void ouvrirNouveauNiveau(String titre) {
        fenetrePrincipale nouvelleFenetre = new fenetrePrincipale();
        nouvelleFenetre.setTitle(titre);
        nouvelleFenetre.setVisible(true);
    }

    public static void main(String[] args) {
        // Démarrer l'application en créant une instance du menu
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu();
            }
        });
    }
}
