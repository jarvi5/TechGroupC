package view.user;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    GridBagConstraints constraints;
    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
    static final int NORTHWEST = GridBagConstraints.NORTHWEST;
    static final int NORTHEAST = GridBagConstraints.NORTHEAST;
    static final int WEST = GridBagConstraints.WEST;
    static final int EAST = GridBagConstraints.EAST;
    static final int CENTER = GridBagConstraints.CENTER;


    UserPanel() {
        super(new GridBagLayout());
        constraints = new GridBagConstraints();
    }

    GridBagConstraints getConstraints(int x, int y, int anchor, boolean growx, boolean fillx) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.weightx = growx ? 1.0 : 0.0;
        constraints.fill = fillx ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        constraints.anchor = anchor;
        constraints.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        return constraints;
    }
}
