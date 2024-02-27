import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VueZoneCode extends JPanel {
    private JLabel labelX;
    private JLabel labelY;
    private JLabel labelT;
    private JLabel labelZ;
    private JTextArea xValueTextArea;
    private JTextArea yValueTextArea;
    private JTextArea tValueTextArea;
    private JTextArea zValueTextArea;
    private JTextArea zoneTexte;

    public VueZoneCode(String nom) {
        setLayout(new GridBagLayout());

        // Créer un JLabel centré au centre du JPanel avec le nom du robot
        JLabel labelCentral = new JLabel(nom);
        labelCentral.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = 1;
        gbcLabel.gridwidth = 2;
        add(labelCentral, gbcLabel);

        // Créer un JPanel pour la zone de texte à gauche avec une bordure or
        JPanel textePanel = new JPanel(new BorderLayout());
        textePanel.setBorder(createOrLineBorder());

        zoneTexte = createEditableTextArea();
        JScrollPane scrollPane = new JScrollPane(zoneTexte); // Créer la barre de défilement
        textePanel.add(scrollPane, BorderLayout.CENTER);

        // Avec Gridbag, on gère la position de la zone texte pour la mettre à gauche
        GridBagConstraints gbcTexte = new GridBagConstraints();
        gbcTexte.gridx = 0;
        gbcTexte.gridy = 2;
        gbcTexte.weightx = 0.75;
        gbcTexte.weighty = 0.75;
        gbcTexte.fill = GridBagConstraints.BOTH;
        gbcTexte.gridheight = 1;
        add(textePanel, gbcTexte);

        // Créer le JPanel pour les paramètres X, Y, T, Z à droite avec une bordure or
        JPanel zoneDroitePanel = new JPanel(new GridLayout(4, 2));
        zoneDroitePanel.setBorder(createOrLineBorder());

        labelX = createCenteredLabel("X", new Color(150, 75, 0));
        zoneDroitePanel.add(labelX);
        xValueTextArea = createNonEditableTextArea("0");
        zoneDroitePanel.add(xValueTextArea);

        labelY = createCenteredLabel("Y", new Color(150, 75, 0));
        zoneDroitePanel.add(labelY);
        yValueTextArea = createNonEditableTextArea("0");
        zoneDroitePanel.add(yValueTextArea);

        labelT = createCenteredLabel("T", new Color(150, 75, 0));
        zoneDroitePanel.add(labelT);
        tValueTextArea = createNonEditableTextArea("0");
        zoneDroitePanel.add(tValueTextArea);

        labelZ = createCenteredLabel("M", new Color(150, 75, 0));
        zoneDroitePanel.add(labelZ);
        zValueTextArea = createNonEditableTextArea("0");
        zoneDroitePanel.add(zValueTextArea);

        // Gérer la disposition des éléments avec Gridbag pour les mettre à droite de la zone texte
        GridBagConstraints gbcDroite = new GridBagConstraints();
        gbcDroite.gridx = 1;
        gbcDroite.gridy = 2;
        gbcDroite.weightx = 0.25;
        gbcDroite.weighty = 1.0;
        gbcDroite.fill = GridBagConstraints.BOTH;
        add(zoneDroitePanel, gbcDroite);
    }

    // Création des noms
    private JLabel createCenteredLabel(String text, Color bgColor) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(bgColor);
        label.setOpaque(true);
        return label;
    }

    // Création de la zone de texte éditable
    private JTextArea createEditableTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        return textArea;
    }

    // Création des champs des paramètres X Y... avec mettant leur zone inchangeable par l'utilisateur
    private JTextArea createNonEditableTextArea(String initialValue) {
        JTextArea textArea = new JTextArea(initialValue);
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        return textArea;
    }

    private LineBorder createOrLineBorder() {
        // Créer une bordure avec une couleur or
        Color couleurOr = new Color(255, 215, 0);
        return new LineBorder(couleurOr);
    }

    // Accès à la zone de texte
    public JTextArea getZoneTexte() {
        return this.zoneTexte;
    }

    // ... (ajoutez d'autres méthodes pour mettre à jour X, Y, T, Z selon vos besoins)
    public void setZoneTexte(String text) {
        this.zoneTexte.setText(text);
    }
       public String getXValue() {
        return xValueTextArea.getText();
    }

    public void setXValue(String value) {
        xValueTextArea.setText(value);
    }

    public String getYValue() {
        return yValueTextArea.getText();
    }

    public void setYValue(String value) {
        yValueTextArea.setText(value);
    }

    public String getTValue() {
        return tValueTextArea.getText();
    }

    public void setTValue(String value) {
        tValueTextArea.setText(value);
    }

    public String getZValue() {
        return zValueTextArea.getText();
    }

    public void setZValue(String value) {
        zValueTextArea.setText(value);
    }

    

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Page Principale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);

        VueZoneCode vueZoneCode = new VueZoneCode("Nom du Robot");
        frame.add(vueZoneCode);

        frame.setVisible(true);
    }
}

