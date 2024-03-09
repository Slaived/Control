import java.io.*;
import java.util.regex.*;
import javax.swing.*;
public class Control {
    Ventana v;
  public Control(Ventana v) {
        this.v = v;
    }
    public void buscar(){
        // TODO add your handling code here:
        JFileChooser fc=new JFileChooser();
        if(fc.showDialog(null,"Abrir")==JFileChooser.APPROVE_OPTION)
        {
            File fichero=fc.getSelectedFile();
           if(fichero.canRead())
           {
            try(FileReader fr=new FileReader(fichero)){
             BufferedReader br=new BufferedReader(fr);
             v.getjTextArea1().setText("");
             String linea=br.readLine();
             while (linea!=null){
              v.getjTextArea1().append(linea+"\n");
              linea=br.readLine();
                }
            }catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "No está el archivo");
            }catch (Exception e) {
              JOptionPane.showMessageDialog(null, "No funcionó");
             }
           }
        } else {
            JOptionPane.showMessageDialog(null, "Archivo no compatible");
        }
    }
    public void separar(){
  String contenido = v.getjTextArea1().getText();
    // Limpiar el JTextArea donde mostraremos el resultado
    v.getjTextArea3().setText("");
    // Expresión regular para encontrar identificadores de variables y números
    Pattern pattern = Pattern.compile("\\b[a-zA-Z_]\\w*\\b|\\b\\d+\\b");
    Matcher matcher = pattern.matcher(contenido);
    while (matcher.find()) {
        // Obtener el identificador o número encontrado
        String token = matcher.group();
        // Mostrar el token en el JTextArea
        v.getjTextArea3().append(token + "\n");
    }
}
}