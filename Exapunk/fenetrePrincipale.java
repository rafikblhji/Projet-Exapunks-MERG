// seconde version avec le bouton pas implmeneter et les platforme de jeux qui sont ajouter dans la zone qui leur correspond
// il manque le bouton stop l'affichage de la mission a effectuer pour chaque niveau et la zone ou sera affichier le contenu du fichier
// attraper par le joueur

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fenetrePrincipale extends JFrame {

    private int index = 0;
    private JTextArea messageArea;
    private VuePlateforme plateforme1 = new VuePlateforme(Color.BLACK, 5);
    private VuePlateforme plateforme2 = new VuePlateforme(Color.RED, 5);
    private VuePlateforme plateforme3 = new VuePlateforme(Color.RED, 5);
    

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

        VueFichier fichier =new VueFichier("200","EntréeQuestion2.txt");
        VueMission mission=new VueMission("Question2.txt");

        // cretattion des platforme pour le niveau
        // VuePlateforme plateforme1 = new VuePlateforme(Color.BLACK, 5);
        // VuePlateforme plateforme2 = new VuePlateforme(Color.RED, 5);
        // VuePlateforme plateforme3 = new VuePlateforme(Color.RED, 5);

        this.dessinerRobotPlateforme1();
        this.dessinerFichierPlateforme2();


        // disposition des platforme 
        GridBagConstraints gbcDroite = new GridBagConstraints();
        zoneDroite.setLayout(new GridBagLayout());
        gbcDroite.gridx = 0;
        gbcDroite.gridy = 2;
        gbcDroite.insets = new Insets(0, 0, 10, 0);
        zoneDroite.add(plateforme1, gbcDroite);
        gbcDroite.gridx = 1;
        gbcDroite.gridy = 1;
        zoneDroite.add(plateforme2, gbcDroite);
        gbcDroite.gridx = 2;
        gbcDroite.gridy = 0;
        zoneDroite.add(plateforme3, gbcDroite);
        



        // Créer la zone de code pour le robot exa à la disposer dans le panel de gauche en haut
        VueZoneCode vueZoneCode = new VueZoneCode("XA");
        GridBagConstraints gbcPage = new GridBagConstraints();
        gbcPage.gridx = 0;
        gbcPage.gridy = 0;
        gbcPage.gridwidth = 1;
        gbcPage.gridheight = 1;
        gbcPage.weightx = 1.0; // Utiliser toute la largeur disponible
        gbcPage.weighty = 1.0; // 25% de la hauteur disponible
        gbcPage.fill = GridBagConstraints.HORIZONTAL;
        gbcPage.anchor = GridBagConstraints.PAGE_START;
        zoneGauche.add(vueZoneCode, gbcPage);

        // Ajouter des boutons en haut à gauche du JPanel du bas (zoneEnDessous)
        JButton boutonPas = new JButton(">");
        JButton boutonStop = new JButton("||");
        // creation des composante du bouton pas lorsque on appuis dessus il decoupe une ligne puis la copie dans le
        // fichier ligne.txt et incremente l'index de sorte que la prochaine fois qu'on appuis dessus il passe a la procjaine ligne
        boutonPas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le texte de la zone de texte
                String texteZoneCode = vueZoneCode.getZoneTexte().getText();

                // Diviser le texte en lignes
                String[] lignes = texteZoneCode.split("\\n");

                // S'assurer que l'index est valide
                if (index < lignes.length) {
                    // Récupérer la ligne actuelle
                    String ligneActuelle = lignes[index];

                    // Copier la ligne dans un fichier
                    copierTexteDansFichier(ligneActuelle, "ligne.txt");

                    // Incrémenter l'index pour la prochaine fois
                    index++;

                    // Rendre la zone de texte non éditable
                    vueZoneCode.getZoneTexte().setEditable(false);
                }
            }
        });



        boutonStop.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         JTextArea zoneTexte = vueZoneCode.getZoneTexte();
        zoneTexte.setEditable(true);

        // Effacer le contenu de la zone de texte
        zoneTexte.setText("");
        
        // Réinitialiser l'index
        index = 0;

        // Effacer le contenu du fichier ligne.txt
        effacerContenuFichier("ligne.txt");

       
        plateforme2.retirerRobot();
        plateforme3.retirerRobot();
        plateforme1.dessinerRobot();
        plateforme1.supprimerFichier();
        plateforme3.supprimerFichier();
        plateforme2.dessinerFichier();

    }
});

        // Définir le gestionnaire de disposition pour le JPanel du bas
        zoneEnDessous.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Ajouter les boutons en haut à gauche du JPanel du bas
        zoneEnDessous.add(boutonPas);
        zoneEnDessous.add(boutonStop);

        zoneEnDessous.add(mission, BorderLayout.SOUTH);

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

        GridBagConstraints gbcFichier = new GridBagConstraints();
        gbcFichier.gridx = 0;
        gbcFichier.gridy = 1;
        gbcFichier.gridwidth =1;
        gbcFichier.gridheight = 1;
        gbcFichier.weightx = 1.0; // Utiliser toute la largeur disponible
        gbcFichier.weighty = 0.75; // 75% de la hauteur disponible
        gbcFichier.fill = GridBagConstraints.BOTH;
        gbcFichier.anchor = GridBagConstraints.PAGE_START;
        zoneGauche.add(fichier, gbcFichier);

        // Ajouter la zone droite 
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.75;
        gbc.weighty = 0.5;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(zoneDroite, gbc);

        // Ajouter la zone en dessous 
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

    // Créer le JPanel du dessous avec les caractéristiques qui lui correspondent
    private JPanel createPanel(Color color) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        // Ajouter une bordure non vide et grise
        panel.setBorder(new LineBorder(Color.GRAY, 3));
        return panel;
    }

    // Créer le JPanel du jeux avec une fonction qui va dessiner l'image de fond que je lui est passé dans mon répertoire image
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
        panel.setPreferredSize(new Dimension(400, 300));

        return panel;
    }

    private void copierTexteDansFichier(String texte, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, false))) {
            // Écrire le texte dans le fichier (false écrase le fichier pour écrire seulement la ligne)
            writer.write(texte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dessinerRobotPlateforme1(){
        this.getPlateforme1().dessinerRobot();
    }
    public void dessinerRobotPlateforme2(){
        this.getPlateforme2().dessinerRobot();
    }
    public void dessinerRobotPlateforme3(){
        this.getPlateforme3().dessinerRobot();
    }

    public void dessinerFichierPlateforme1(){
        this.getPlateforme1().dessinerFichier();
    }
     public void dessinerFichierPlateforme2(){
        this.getPlateforme2().dessinerFichier();
    }
     public void dessinerFichierPlateforme3(){
        this.getPlateforme3().dessinerFichier();
    }

    public void supprimerFichierPlateforme1(){
        this.getPlateforme1().supprimerFichier();
    }
    public void supprimerFichierPlateforme2(){
        this.getPlateforme2().supprimerFichier();
    }
    public void supprimerFichierPlateforme3(){
        this.getPlateforme3().supprimerFichier();
    }

    public void supprimerRobotPlateforme1(){
        this.getPlateforme1().retirerRobot();
    }
    public void supprimerRobotPlateforme2(){
        this.getPlateforme2().retirerRobot();
    }
    public void supprimerRobotPlateforme3(){
        this.getPlateforme3().retirerRobot();
    }

    public VuePlateforme getPlateforme1(){
        return plateforme1;
    }
    public VuePlateforme getPlateforme2(){
        return plateforme2;
    }
    public VuePlateforme getPlateforme3(){
        return plateforme3;
    }
 
 

    private void effacerContenuFichier(String cheminFichier) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, false))) {
        // Écrire une chaîne vide dans le fichier (efface le contenu)
        writer.write("");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        fenetrePrincipale frame = new fenetrePrincipale();
    }
}