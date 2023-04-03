package ui;

import javax.swing.*;
import java.awt.*;

public class Constructor {
  private final JFrame jFrame;
  private final Font primaryFont = new Font("Roboto", Font.PLAIN, 16);
  private final Font secondaryFont = new Font("Roboto", Font.PLAIN, 14);
  private final Font primaryFontBold = new Font("Roboto", Font.BOLD, 16);

  public Constructor(JFrame jFrame){
    this.jFrame = jFrame;
  }

  // Frame
  public void frameEstilo(String title, int exitMode, int[] bound){
    this.jFrame.setBounds(bound[0], bound[1], bound[2], bound[3]);
    this.jFrame.setTitle(title);
    this.jFrame.setLayout(null);
    this.jFrame.setDefaultCloseOperation(exitMode);
    this.jFrame.setLocationRelativeTo(null);
  }

  // Button
  public JButton buttonEstilo(int[] bound, String text){
    JButton jButton = new JButton(text);
    jButton.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jButton.setFocusable(false);
    jButton.setFont(this.primaryFontBold);
    jFrame.add(jButton);

    return jButton;
  }

  // ComboBox
  public JComboBox<String> comboBoxEstilo(int[] bound, String[] opciones){
    JComboBox<String> jComboBox = new JComboBox<>(opciones);
    jComboBox.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jComboBox.setFont(this.primaryFont);
    this.jFrame.add(jComboBox);

    return jComboBox;
  }

  // Label
  public void labelEstilo(int[] bound, String texto){
    JLabel jLabel = new JLabel(texto);
    jLabel.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jLabel.setFont(this.secondaryFont);
    this.jFrame.add(jLabel);
  }

  // TextArea
  public JTextArea textAreaEstilo(int[] bound){
    JTextArea jTextArea = new JTextArea();
    jTextArea.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jTextArea.setFont(this.primaryFont);
    jTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    jTextArea.setLineWrap(true);
    this.jFrame.add(jTextArea);

    return jTextArea;
  }

  // TextField
  public JTextField textFieldEstilo(int[] bound){
    JTextField jTextField = new JTextField();
    jTextField.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jTextField.setFont(this.primaryFont);
    this.jFrame.add(jTextField);

    return jTextField;
  }
}
