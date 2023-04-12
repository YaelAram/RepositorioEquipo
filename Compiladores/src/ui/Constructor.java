package ui;

import javax.swing.*;
import java.awt.*;
/*
Clase que genera los elementos a usar en la ventana de la interfaz
 */
public class Constructor {
  //Se declara un JFrame
  private final JFrame jFrame;
  //Se declaran fuentes y tamaños de letra
  private final Font primaryFont = new Font("Roboto", Font.PLAIN, 16);
  private final Font secondaryFont = new Font("Roboto", Font.PLAIN, 14);
  private final Font primaryFontBold = new Font("Roboto", Font.BOLD, 16);

  public Constructor(JFrame jFrame){
    this.jFrame = jFrame;
  }

  // Se estiliza Frame
  public void frameEstilo(String title, int exitMode, int[] bound){
    this.jFrame.setBounds(bound[0], bound[1], bound[2], bound[3]);
    this.jFrame.setTitle(title);
    this.jFrame.setLayout(null);
    this.jFrame.setDefaultCloseOperation(exitMode);
    this.jFrame.setLocationRelativeTo(null);
  }

  // Se estiliza los Buttons
  public JButton buttonEstilo(int[] bound, String text){
    JButton jButton = new JButton(text);
    jButton.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jButton.setFocusable(false);
    jButton.setFont(this.primaryFontBold);
    jFrame.add(jButton);

    return jButton;
  }

  // Se estiliza la "caja" (ComboBox) donde se pondrán las opciones de programa a elegir
  public JComboBox<String> comboBoxEstilo(int[] bound, String[] opciones){
    JComboBox<String> jComboBox = new JComboBox<>(opciones);
    jComboBox.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jComboBox.setFont(this.primaryFont);
    this.jFrame.add(jComboBox);

    return jComboBox;
  }

  // Se estiliza las etiquetas (Label)
  public void labelEstilo(int[] bound, String texto){
    JLabel jLabel = new JLabel(texto);
    jLabel.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jLabel.setFont(this.secondaryFont);
    this.jFrame.add(jLabel);
  }

  // Se estiliza el area de texto
  public JTextArea textAreaEstilo(int[] bound){
    JTextArea jTextArea = new JTextArea();
    jTextArea.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jTextArea.setFont(this.primaryFont);
    jTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    jTextArea.setLineWrap(true);
    this.jFrame.add(jTextArea);

    return jTextArea;
  }

  // Se estiliza el TextField
  public JTextField textFieldEstilo(int[] bound){
    JTextField jTextField = new JTextField();
    jTextField.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jTextField.setFont(this.primaryFont);
    this.jFrame.add(jTextField);

    return jTextField;
  }
}
