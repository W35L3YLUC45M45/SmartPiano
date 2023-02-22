package SupportClasses;

import javax.swing.*;
import java.awt.*;

/**
 * Class created especifically for generating text
 * field panels with a variety of components inside of it
 *
 * @author Group B9
 * @version ?
 * @since 2021 -03-01
 */
public class JTextFieldPanel {
    /**
     * The Panel.
     */
    private JPanel panel;
    /**
     * The Text field.
     */
    private JTextField textField;
    /**
     * The Label.
     */
    private JLabel label;

    /**
     * Constructor in which the previously mentioned panels
     * there are not only a JTextField, but also complementary
     * JLabels
     *
     * @param labelname String custom word we pass to the
     *                  constructor so we can refer that
     *                  particular text field panel
     */
    public JTextFieldPanel(String labelname){
        panel = new JPanel(new BorderLayout());
        panel.setSize(new Dimension(300, 100));
        panel.setMaximumSize(new Dimension(6000, 100));
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        // TextField de User
        textField = new JTextField();
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setMaximumSize(textField.getPreferredSize());

        // Label de User
        label = new JLabel(labelname);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        label.setForeground(Color.GRAY);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(null);
        label.setLabelFor(label);

        // Adición de Label y Textfield de User a diferentes BorderLayout's
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
    }

    /**
     * Getter that returns the custom panel previously mentioned
     *
     * @return JPanel with all of the information previously passed
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Getter that returns the text typed on the text field
     *
     * @return String related to the text typed in the field
     */
    public String getText(){
        return textField.getText();
    }

    /**
     * Method in charge of setting the text field text to
     * nothing, meaning that is resetting it
     */
    public void resetText(){
        textField.setText("");
    }
}
