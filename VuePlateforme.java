// cette classe creer une platforme avec une couleur et une taille , comme la taille piece qui prend en entrer une taille on aura donc taille * taille 
// cases dans la platforme

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VuePlateforme extends JPanel {

    private Color couleur;
    private int size;

    public VuePlateforme(Color couleur, int size) {
        this.couleur = couleur;
        this.size = size;
        setPreferredSize(new Dimension(size * 25, size * 25));
        setBorder(new LineBorder(Color.GREEN, 2));
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int col, row; // Déplacer la déclaration de col et row ici

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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test de la Plateforme");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPane = new JPanel(new FlowLayout());
            frame.setContentPane(contentPane);


            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}



