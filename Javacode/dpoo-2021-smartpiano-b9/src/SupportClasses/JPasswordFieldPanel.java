package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Class created especifically for generating password
 * field panels with a variety of components inside of it
 *
 * @author Group B9
 * @version ?
 * @since 2021 -03-01
 */
public class JPasswordFieldPanel {
    /**
     * The Panel.
     */
    private JPanel panel;
    /**
     * The Password field.
     */
    private JPasswordField passwordField;
    /**
     * The Label.
     */
    private JLabel label;
    /**
     * The Checkbox.
     */
    private JCheckBox checkbox;

    /**
     * Constructor in which the previously mentioned panels
     * there are not only a JPasswordField, but also JLabels
     * and JCheckboxes that allow us to display or not our
     * password
     *
     * @param labelname String custom word we pass to the
     *                  constructor so we can refer that
     *                  particular password to the user's
     */
    public JPasswordFieldPanel(String labelname){
        // BorderLayout para Register Password
        panel = new JPanel(new BorderLayout());
        panel.setSize(new Dimension(300, 100));
        panel.setMaximumSize(new Dimension(6000, 100));
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        // Textfield de password
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordField.setMaximumSize( passwordField.getPreferredSize() );

        // Label de password
        label = new JLabel(labelname);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        label.setForeground(Color.GRAY);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(null);
        label.setLabelFor(label);

        // Checkbox de password
        checkbox = new JCheckBox("(Show)");
        checkbox.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        checkbox.setBackground(Color.WHITE);

        checkbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('•');
                }
            }
        });

        // Adición de Label y Textfield de password a diferentes BorderLayout's
        panel.add(label, BorderLayout.NORTH);
        panel.add(passwordField, BorderLayout.CENTER);
        panel.add(checkbox, BorderLayout.EAST);
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
     * Getter that returns the text typed on the password field
     *
     * @return String related to the password typed in the field
     */
    public String getText(){
        return String.valueOf(passwordField.getPassword());
    }

    /**
     * Method in charge of setting the password field text to
     * nothing, meaning that is resetting it
     */
    public void resetText(){
        passwordField.setText("");
    }
}
