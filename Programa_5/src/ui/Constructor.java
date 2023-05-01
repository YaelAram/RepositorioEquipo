package ui;

import javax.swing.*;
import java.awt.*;

public class Constructor {
  private final JFrame jFrame;
  //Se le da estilo a la fuente que se usará
  private final Font primaryFont = new Font("Roboto", Font.PLAIN, 16);
  private final Font primaryFontBold = new Font("Roboto", Font.BOLD, 16);

  public Constructor(JFrame jFrame){
    this.jFrame = jFrame;
  }

  // Se estilizan los Frames
  public void frameEstilo(String title, int exitMode, int[] bound){
    this.jFrame.setBounds(bound[0], bound[1], bound[2], bound[3]);
    this.jFrame.setTitle(title);
    this.jFrame.setLayout(null);
    this.jFrame.setDefaultCloseOperation(exitMode);
    this.jFrame.setLocationRelativeTo(null);
  }

  // Se estilizan los Buttons
  public JButton buttonEstilo(int[] bound, String text){
    JButton jButton = new JButton(text);
    jButton.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jButton.setFocusable(false);
    jButton.setFont(this.primaryFontBold);
    jFrame.add(jButton);

    return jButton;
  }

  // Se le da formato al TextArea
  public JTextArea textAreaEstilo(int[] bound){
    JTextArea jTextArea = new JTextArea();
    jTextArea.setBounds(bound[0], bound[1], bound[2], bound[3]);
    jTextArea.setFont(this.primaryFont);
    jTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    jTextArea.setLineWrap(true);
    this.jFrame.add(jTextArea);

    return jTextArea;
  }
}
