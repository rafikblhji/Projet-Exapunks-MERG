/**
 * La classe qui represente le niveau du jeu chaque niveau commence presque pareil seul 
 * les fichier et les mission change
 * @since 20/01/2024
 * @version 16/03/2024
 * @author ORCUN Gabriel
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class fenetrePrincipale extends JFrame {

    private int index = 0;
    private VueZoneCode vueZoneCode = new VueZoneCode("XA");
    public boolean continuer=false;
    private JTextArea messageArea;
    private VuePlateforme plateforme1 = new VuePlateforme(Color.GRAY, 5);
    private VuePlateforme plateforme2 = new VuePlateforme(Color.RED, 5);
    private VuePlateforme plateforme3 = new VuePlateforme(Color.RED, 5);
    public VueFichier fichier =new VueFichier("200","EntréeQuestion2.txt");
    public VueMission mission=new VueMission("mission2.txt");
    

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
        plateforme1.afficherMessageHaut("800");
        plateforme2.afficherMessageBas("-1");
        plateforme3.afficherMessageBas("-1");
        plateforme2.afficherMessageHaut("800");

        // VueFichier fichier =new VueFichier("200","EntréeQuestion2.txt");
        // VueMission mission=new VueMission("Question2.txt");
        

        // cretattion des platforme pour le niveau
        // VuePlateforme plateforme1 = new VuePlateforme(Color.BLACK, 5);
        // VuePlateforme plateforme2 = new VuePlateforme(Color.RED, 5);
        // VuePlateforme plateforme3 = new VuePlateforme(Color.RED, 5);

        this.dessinerRobotPlateforme1();
        this.dessinerFichierPlateforme2(200);
        


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
        // VueZoneCode vueZoneCode = new VueZoneCode("XA");
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
                for (String ligne : lignes) {
                // S'assurer que la ligne n'est pas vide
                    if (!ligne.trim().isEmpty()) {
                // Copier la ligne dans un fichier
                         copierTexteDansFichier(ligne, "ligne.txt");
                        }
                }
                vueZoneCode.getZoneTexte().setEditable(false);
                continuer=true;
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
        

        // Effacer le contenu du fichier ligne.txt
        effacerContenuFichier("ligne.txt");
        for(int i=0;i<25;i++){
            supprimerFichierPlateforme1(400+i);
            supprimerFichierPlateforme2(400+i);
            supprimerFichierPlateforme3(400+i);
        }
       
        plateforme2.retirerRobot();
        plateforme3.retirerRobot();
        plateforme1.dessinerRobot();
        supprimerFichierPlateforme1(200);
        supprimerFichierPlateforme3(200);
        supprimerFichierPlateforme2(200);

        plateforme2.dessinerFichier(200);
        vueZoneCode.setXValue("0");
        vueZoneCode.setTValue("0");

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, true))) {
            // Écrire le texte dans le fichier 
            writer.write(texte);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public VueMission getMission(){
        return this.mission;
    }
    public VueZoneCode getZoneCode(){
        return this.vueZoneCode;
    }
    public VueFichier getFichier(){
        return this.fichier;
    }
    public void setPeutContinuer(boolean a){
        this.continuer=a;
    }
    public boolean getPeutContinuer(){
        return continuer;
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

    public void dessinerFichierPlateforme1(int id){
        this.getPlateforme1().dessinerFichier(id);
    }
     public void dessinerFichierPlateforme2(int id){
        this.getPlateforme2().dessinerFichier(id);
    }
     public void dessinerFichierPlateforme3(int id){
        this.getPlateforme3().dessinerFichier(id);
    }

    public void supprimerFichierPlateforme1(int id){
        this.getPlateforme1().supprimerFichier(id);
    }
    public void supprimerFichierPlateforme2(int id){
        this.getPlateforme2().supprimerFichier(id);
    }
    public void supprimerFichierPlateforme3(int id){
        this.getPlateforme3().supprimerFichier(id);
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
    public void reussirNiveau() {
        JOptionPane.showMessageDialog(null, "Bravo ! Vous avez réussi le niveau !");
       
    }
    public void raterNiveau() {
        JOptionPane.showMessageDialog(null, "OH non ! Vous avez raté le niveau ! Essayez de nouveau !");
       
    }
    public void deplacerRobott(int id){
        supprimerRobotPlateforme1();
        supprimerRobotPlateforme2();
        supprimerRobotPlateforme3();
        if(id==0){
            dessinerRobotPlateforme1();
        }
        if(id==1){
            dessinerRobotPlateforme2();
        }
        if(id==2){
            dessinerRobotPlateforme3();
        }
    }

    public void suprimerTouTFichierr(Level levelOf){
        int i,j,k;
        for(i=0;i<3;i++){
            if(i==0){
                k=levelOf.getRobot().getListPieceRobot().get(0).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        supprimerFichierPlateforme1(levelOf.getRobot().getListPieceRobot().get(0).getListFichiers().get(j).getId());
                    }
                }
            }
            if(i==1){
                k=levelOf.getRobot().getListPieceRobot().get(1).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        supprimerFichierPlateforme2(levelOf.getRobot().getListPieceRobot().get(1).getListFichiers().get(j).getId());
                        
                    }
                }
            }
            if(i==2){
                k=levelOf.getRobot().getListPieceRobot().get(2).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        supprimerFichierPlateforme3(levelOf.getRobot().getListPieceRobot().get(2).getListFichiers().get(j).getId());
                    }
                }
            }

        }
    }
public void dessinerToutFichier(Level levelOf){
    int i,j,k;
         for(i=0;i<3;i++){
            if(i==0){
                k=levelOf.getRobot().getListPieceRobot().get(0).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        dessinerFichierPlateforme1(levelOf.getRobot().getListPieceRobot().get(0).getListFichiers().get(j).getId());
                    }
                }
            }
            if(i==1){
                k=levelOf.getRobot().getListPieceRobot().get(1).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        dessinerFichierPlateforme2(levelOf.getRobot().getListPieceRobot().get(1).getListFichiers().get(j).getId());
                        
                    }
                }
            }
            if(i==2){
                k=levelOf.getRobot().getListPieceRobot().get(2).getListFichiers().size();
                if(k!=0){
                    for(j=0;j<k;j++){
                        dessinerFichierPlateforme3(levelOf.getRobot().getListPieceRobot().get(2).getListFichiers().get(j).getId());
                    }
                }
            }

        }


        }

    public void suprimerlefichier(int index,int id){
        if(index==0){
            supprimerFichierPlateforme3(id);
            supprimerFichierPlateforme2(id);
        }
        if(index==1){
            supprimerFichierPlateforme1(id);
            supprimerFichierPlateforme3(id);
        }
        if(index==2){
            supprimerFichierPlateforme1(id);
            supprimerFichierPlateforme2(id);
        }
    }

    public void dessinerlefichier(int index, int id){
        if(index==0){
            dessinerFichierPlateforme1(id);
        
        }
        if(index==1){
            dessinerFichierPlateforme2(id);
        }
        if(index==2){
            dessinerFichierPlateforme3(id);
        }
    }
    public void suprimerrobotplt(int index){
        if(index==0){
            supprimerRobotPlateforme1();
        }
        if(index==1){
            supprimerRobotPlateforme2();
        }
        if(index==2){
            supprimerRobotPlateforme3();
        }
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


