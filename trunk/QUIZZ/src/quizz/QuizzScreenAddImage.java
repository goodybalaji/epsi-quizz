/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static quizz.QuizzScreenShowImage.scaleImage;
import static quizz.QuizzCreationBtn.icon;

/**
 *
 * @author Arc
 */
public class QuizzScreenAddImage extends JFrame {

    public QuizzCreationBtn btnSave = new QuizzCreationBtn("Sauvegarder");
    public QuizzCreationBtn btnReturn = new QuizzCreationBtn("Annuler");

    public JPanel image = new JPanel();
    public JPanel bottom = new JPanel();

    QuizzScreenAddImage() {

        bottom.add(btnReturn);
        bottom.add(btnSave);

        btnSave.addActionListener(btnSave);
        btnReturn.addActionListener(btnReturn);

        if (icon != null) {
            Image zoom = scaleImage(icon.getImage(), 450);
            Icon iconScaled = new ImageIcon(zoom);
            JLabel img = new JLabel(iconScaled);
            image.add(img);
        }

        /**
         * Spécification de la page
         */
        this.setTitle("Ajout d'une image");
        setLayout(new BorderLayout());
        this.setSize(450, 480);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.CENTER, image);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.dispose();
    }

    public static Image scaledImage(Image source, int width, int height) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(source, 0, 0, width, height, null);
        g.dispose();
        return img;
    }

    public static Image scaleImage(Image source, int size) {
        int width = source.getWidth(null);
        int height = source.getHeight(null);
        double f = 0;
        if (width < height) {//portrait
            f = (double) height / (double) width;
            width = (int) (size / f);
            height = size;
        } else {//paysage
            f = (double) width / (double) height;
            width = size;
            height = (int) (size / f);
        }
        return scaledImage(source, width, height);
    }
}
