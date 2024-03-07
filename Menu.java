import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private fenetrePrincipale niveau;
    private int numNiv;

    public Menu() {
        // Définir le titre de la fenêtre du menu
        super("Menu");

        // Créer les boutons pour les niveaux 1, 2 et 3
        JButton niveau1Button = new JButton("Niveau 1");
        JButton niveau2Button = new JButton("Niveau 2");
        JButton niveau3Button = new JButton("Niveau 3");

        // Ajouter des écouteurs d'événements aux boutons
        niveau1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 1");
                numNiv = 1;
                
            }
        });

        niveau2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 2");
                numNiv = 2;
            }
        });

        niveau3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ouvrirNouveauNiveau("Niveau 3");
                numNiv = 3;
            }
        });

        // Créer le gestionnaire de disposition pour le menu
        setLayout(new FlowLayout());

        // Ajouter les boutons au menu
        add(niveau1Button);
        add(niveau2Button);
        add(niveau3Button);

        // Configurer la JFrame du menu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Centre la fenêtre
        setVisible(true);
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu();
            }
        });
    }
}


