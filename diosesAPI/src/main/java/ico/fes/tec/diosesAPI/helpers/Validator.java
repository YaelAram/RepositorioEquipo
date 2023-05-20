package ico.fes.tec.diosesAPI.helpers;

public class Validator {
  public static String validarImg(String img, String defaultImg){
    return (img.matches("[a-zA-Z0-9-_/:.]+.(png|jpg|jpeg)")) ? img : defaultImg;
  }

  public static String validarTexto(String name, String defaultName){
    return (name.matches("[a-zA-ZñÑ ]+")) ? name : defaultName;
  }
}
