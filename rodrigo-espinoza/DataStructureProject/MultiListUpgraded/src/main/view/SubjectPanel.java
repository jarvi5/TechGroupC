package view;

import javax.swing.*;

public class SubjectPanel {
    private JPanel subjectPanel;

    private JLabel subjectLabel;
    private JTextArea subjectTextArea;
    private JButton saveSubjectButton;
    private JButton searchSubjectButton;
    private JButton previousSubjectButton;
    private JButton nextSubjectButton;
    private JButton addSubjectButton;
    private JButton removeSubjectButton;
    private JButton editSubjectButton;
    private JTextField detailSubject;
    private JTextField subjectDetail;
    private JTextField idSubjectDetail;
    private JTextField finalGradeDetail;

    public SubjectPanel() {
        this.subjectPanel = new JPanel();
    }

    public JPanel getSubjectPanel() {
        return subjectPanel;
    }

}
