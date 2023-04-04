package ui;

import model.Entrada;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ventana extends JFrame implements ActionListener {
  private final Constructor constructor = new Constructor(this);
  private JButton procesar, cargar;
  private JTextArea codigo;
  private final Entrada archivo = new Entrada("test.txt");

  public Ventana(){
    constructor.frameEstilo("Programas Compiladores", WindowConstants.EXIT_ON_CLOSE, new int[]{0, 0, 500, 400});
    construirUI();
    this.setVisible(true);
  }

  private void construirUI(){
    procesar = constructor.buttonEstilo(new int[]{20, 20, 150, 30}, "Procesar");
    procesar.addActionListener(this);

    cargar = constructor.buttonEstilo(new int[]{200, 20, 150, 30}, "Cargar");
    cargar.addActionListener(this);

    codigo = constructor.textAreaEstilo(new int[]{20, 70, 450, 270});
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource() == this.procesar) {
      this.archivo.analizar();
      this.codigo.setText(this.archivo.getCodigo());
    }
    else if (evt.getSource() == this.cargar) {
      JFileChooser jFileChooser = new JFileChooser();
      jFileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de texto", "txt"));
      jFileChooser.showOpenDialog(this);
      File archivo = jFileChooser.getSelectedFile();

      if(archivo != null) this.archivo.setRuta(archivo.getAbsolutePath());
    }
  }
}
