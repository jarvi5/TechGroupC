package ui2.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ViewManager {
    private JFrame frame;
    private JLabel image;
    private AddUserPanel userPanel;
    private AddSubjectPanel subjectPanel;

    public ViewManager(String title) {
        setFrame(new JFrame(title));
        getFrame().setSize(1100, 900);
        getFrame().setLayout(null);
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getFrame().setLocationRelativeTo(null);

        setUserPanel(new AddUserPanel());
        setSubjectPanel(new AddSubjectPanel());

        getFrame().add(getUserPanel());
        getFrame().add(getSubjectPanel());

        configImage();

        getFrame().setVisible(true);
        getFrame().setResizable(false);
    }


    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public AddUserPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(AddUserPanel userPanel) {
        this.userPanel = userPanel;
    }

    private void configImage() {
        try {
            ImageFrame imageFrame = new ImageFrame(ImageIO.read(new File("image.jpg")));
            JPanel panel = (JPanel) getFrame().getContentPane();
            panel.setBorder(imageFrame);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(getFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public AddSubjectPanel getSubjectPanel() {
        return subjectPanel;
    }

    public void setSubjectPanel(AddSubjectPanel subjectPanel) {
        this.subjectPanel = subjectPanel;
    }
}
