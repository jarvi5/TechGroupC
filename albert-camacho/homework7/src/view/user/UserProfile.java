package view.user;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserProfile extends UserPanel {
    private UserTable userTable;
    private JLabel userFirstNameLabel;
    private JLabel userLastNameLabel;
    private JButton previousButton;
    private JButton nextButton;

    private final static int IMG_HEIGHT = 80;
    private final static int IMG_WIDTH = 70;
    private static final String IMG_PATH = "src/images/user_icon.png";

    public UserProfile() {
        super();
        init();
    }

    private void init() {
        JLabel userIconLabel = new JLabel(userIcon());
        constraints = getConstraints(0, 0, NORTHWEST, false, false);
        constraints.gridheight = 2;
        this.add(userIconLabel, constraints);


        JLabel firstNameLabel = new JLabel("First Name:");
        constraints = getConstraints(1, 0, NORTHWEST, false, false);
        this.add(firstNameLabel, constraints);

        JLabel lastNameLabel = new JLabel("Last Name:");
        constraints = getConstraints(1, 1, NORTHWEST, false, false);
        this.add(lastNameLabel, constraints);

        userFirstNameLabel = new JLabel("", JLabel.LEFT);
        constraints = getConstraints(2, 0, NORTHWEST, true, false);
        this.add(userFirstNameLabel, constraints);

        userLastNameLabel = new JLabel("", JLabel.LEFT);
        constraints = getConstraints(2, 1, NORTHWEST, true, false);
        this.add(userLastNameLabel, constraints);

        previousButton = new JButton("Previous");
        constraints = getConstraints(1, 2, WEST, false, false);
        this.add(previousButton, constraints);

        nextButton = new JButton("Next");
        constraints = getConstraints(2, 2, WEST, false, false);
        constraints.ipadx = 28;
        this.add(nextButton, constraints);

        userTable = new UserTable();
        constraints = getConstraints(4, 0, NORTHEAST, true, false);
        constraints.gridheight = 3;
        constraints.fill = GridBagConstraints.BOTH;
        //userTable.setSize(150,150);
        this.add(new JScrollPane(userTable.getTable()), constraints);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setUserFirstNameLabel(String name) {
        userFirstNameLabel.setText(name);
    }

    public void setUserLastNameLabel(String lastName) {
        userLastNameLabel.setText(lastName);
    }

    public UserTable getUserTable() {
        return userTable;
    }

    private ImageIcon userIcon() {
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(resize(img, IMG_HEIGHT, IMG_WIDTH));
            return icon;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
