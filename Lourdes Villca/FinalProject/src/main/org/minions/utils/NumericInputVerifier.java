package org.minions.utils;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * Class that help with the input verification.
 */
public class NumericInputVerifier extends InputVerifier {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String decimalPattern = "(\\d*\\.?\\d+)";
        return Pattern.matches(decimalPattern, textField.getText());
    }
}

