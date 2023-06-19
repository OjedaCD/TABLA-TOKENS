import java.io.*;//nos servira para comunicarnos fuera del compilador, con el sistema operativo 
import javax.swing.JOptionPane;//Importamos la libreria JOptionPane para imprimir el mensaje del catch

public class Token {//Iniciamos la clase Token

    public static void main(String[] args) {//Declaramos la clase main "principal"
        Tipo p = new Tipo();//Inicializamos el objeto p de la clase Tipo
        File f; //Accedemos a la clase file por medio de un objeto "La clase File se usa para obtener información sobre archivos y directorios. Además la clase File permite crear y eliminar archivos y directorios."
        FileReader r;// Accesamos a la clase FileReader, para leer un archivo externo "FileReader en Java es una clase que usamos para leer datos de un archivo. Está orientado a caracteres y devuelve datos en forma de bytes."
        BufferedReader br;// Accesamos a la clase br por medio del objeto "BufferedReader es una clase cuyas instancias nos permiten hacer lecturas sencillas de texto desde un flujo de caracteres, debido a que esta clase trabaja con su propio buffer provee una lectura eficiente de caracteres, arreglos y líneas de texto."

        try {//Previene las excepciones que puedan surgir al interpretar un simbolo
            f = new File("Depurado.uno");// se manda un nombre a la clase file para leer el archivo
            r = new FileReader(f);//// se accede al archivo para leer el contenido
            br = new BufferedReader(r);// se asigna un espacio en el buffer 

            String linea;// es donde se almacenara el buffer de la cadena
            String aux = "";// guarda el lexema
            int aux1 = 0;// controla el flujo de la cadena a traves de las pisiciones en ascii

            System.out.println("Lexema \t" + "Token\t" + "Tipo");// Imprime el enunciado en la parte superior
            while ((linea = br.readLine()) != null) {// Mientras la linea que se lee, sea diferente de nulo
                for (int i = 0; i < linea.length(); i++) {// Dependiendo de la linea sera el tamaño [For 1]<-
                    
                    
                    aux = aux + linea.charAt(i);// Escribe una posicion x de la cadena linea, tras cada interaccion 
                    aux1 = (int) linea.charAt(i);// Castea para comparar el caracter en ascii
                    
                    //CUANDO DETECTA ESPACIOS EN BLANCO Y FINAL DE CADAENAS [Detecta un espacio en blanco o si el numero de iteracion es igual al numero de linea leida y el caracter sea diferente de "comillas dobles" 
                    if (aux1 == 32 || i == linea.length() - 1 && aux1 != 34) {//Si detecta espacios en blanco o "comillas dobles" al final [if 1]<-
                        p.tipo(aux.trim());// envia la cadena generada aux sin espacios
                        aux = "";//limpia la cadena
                    }// el valor ascii de las comillas dobles es 34 [if 1]<-
                    
                    
                    
                    //CUANDO DETECTAN COMILLAS DOBLES [Detecta la primer comilla, itera para generar la cadena y detecta la segunda comilla para enviarlo]
                    if (aux1 == 34) {//si el cararcter x es igual a 34 "comillas dobles" [if 2]<--

                        for (int j = i + 1; j < linea.length(); j++) {//j es igual al numero de x posicion, del tamaño de la cadena linea [for 2]
                            aux = aux + linea.charAt(j);//Escribe una posicion x de la cadena linea, tras cada interaccion 
                            aux1 = (int) linea.charAt(j);// Castea para comparar el caracter en ascii
                            if (aux1 == 34) {//si el cararcter x es igual a 34 "comillas dobles" [if 3]<---
                                p.tipo(aux.trim());// envia la cadena generada aux sin espacios
                                aux = "";

                                if (j == linea.length() - 1) {// Si x posicion es igual a la posicion de la linea leida
                                    i = j;// Iteracion de x linea [for1] es igual a iteracion dentro del [for 1]
                                } else {
                                    i = j + 1;// Iteracion de x linea [for 1] es igual a la suma de la posicion [for 2] mas uno
                                }
                                break;
                            }//[if 3]<---
                        }
                    }//[if 2]<--

                    // el valos ascci del espacio vacio es 32
                    // el valor ascii de "" es 34
                }// se cierra el [for 1]<-

            }
            r.close();//cierra la lectura
            br.close();// libera el buffer de la lectura 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error " + e);// Muestra la excepcion en una ventana
        }

    }

}
