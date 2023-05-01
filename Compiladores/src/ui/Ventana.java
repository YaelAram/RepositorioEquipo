package ui;

import helpers.Entrada;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ventana extends JFrame implements ActionListener {
  private final Constructor constructor = new Constructor(this);
  private JComboBox<String> programas, configuraciones;
  private JButton procesar, cargar;
  private JTextArea codigo;
  private JTextField delimitador;
  private final Entrada archivo = new Entrada("test.txt");

  public Ventana(){
    constructor.frameEstilo("Programas Compiladores", WindowConstants.EXIT_ON_CLOSE, new int[]{0, 0, 1100, 800});
    construirUI();
    this.setVisible(true);
  }

  private void construirUI(){
    constructor.labelEstilo(new int[]{20, 20, 200, 20}, "Selecciona un programa:");
    programas = constructor.comboBoxEstilo(new int[]{20, 50, 200, 30}, new String[]{"Programa 1", "Programa 2", "Programa 3", "Programa 4"});

    constructor.labelEstilo(new int[]{250, 20, 150, 30}, "Delimitador:");
    delimitador = constructor.textFieldEstilo(new int[]{250, 50, 150, 30});

    constructor.labelEstilo(new int[]{430, 20, 200, 30}, "Configurar:");
    configuraciones = constructor.comboBoxEstilo(new int[]{430, 50, 200, 30}, new String[]{"Mantener Repetidos", "Eliminar Repetidos"});

    procesar = constructor.buttonEstilo(new int[]{660, 50, 150, 30}, "Procesar");
    procesar.addActionListener(this);

    cargar = constructor.buttonEstilo(new int[]{840, 50, 150, 30}, "Cargar");
    cargar.addActionListener(this);

    codigo = constructor.textAreaEstilo(new int[]{20, 100, 1050, 650});
  }

  public void mostrarMensaje(String mensaje){
    JOptionPane.showMessageDialog(null, mensaje, "Exito", JOptionPane.INFORMATION_MESSAGE);
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
    if(evt.getSource() == this.procesar){
      String programa = this.programas.getItemAt(this.programas.getSelectedIndex());
      String configuracion = this.configuraciones.getItemAt(this.configuraciones.getSelectedIndex());
      String delimitadorStr = (this.delimitador.getText().equals("\\n")) ? System.lineSeparator() : this.delimitador.getText();
      String mensaje = "";
      boolean repetidos = (configuracion.equals("Mantener Repetidos")) ? Entrada.MANTENER_REPETIDOS : Entrada.ELIMINAR_REPETIDOS;

      switch(programa){
        case "Programa 1" -> mensaje = this.archivo.leerTodo().obtenerNumeroCaracteres();
        case "Programa 2" -> mensaje = this.archivo.contarCaracteres();
        case "Programa 3" -> mensaje = this.archivo.contador(delimitadorStr, "palabra", "palabras", repetidos);
        case "Programa 4" -> mensaje = this.archivo.contador(delimitadorStr, "linea/parrafo", "lineas/parrafos", repetidos);
      }

      this.codigo.setText(this.archivo.getDatos());
      this.mostrarMensaje(mensaje);
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
