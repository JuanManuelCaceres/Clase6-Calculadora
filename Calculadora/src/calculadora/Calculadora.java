package calculadora;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Calculadora {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cadena, resultado="0";
        boolean continuar = true;
        
        
        Operacion operacion = new Operacion();
        System.out.println("Iniciando calculadora...\n");
        System.out.println("Operaciones permitidas:\n"+
                           "\t 1.Suma(+)\t 2.resta(-)\n"+
                           "\t 3.Mult.(*)\t 4.Div.(/)\n"+
                           "Comandos: \n"+
                           "\t1.Borrar Resultado: clear\n"+
                           "\t2.Salir: exit\n"+
                           "Ejemplo: \t -2*(-8*-2)/-(6*-7)+14 = 13.238095238095237"+"\n");
        
        
        while (continuar) {            
            System.out.print("Calcular: ");
            cadena = in.nextLine();
            if(cadena.equals("clear")){
                resultado="0";
            } else{
                if (cadena.equals("exit")) {
                    continuar=false;
                } else{
                    String char0 = String.valueOf(cadena.charAt(0));
                    if (char0.equals("-") || char0.equals("+") || char0.equals("*") || char0.equals("/")) {
                        cadena = resultado.concat(cadena);
                    }

                    while (cadena.contains("(")) {
                        cadena = operacion.operacionCombinada(cadena);
                    }


                    resultado = operacion.operacionSimple(cadena);

                    System.out.println("Resultado: " + resultado);
                }
            }
        }
        
    }
}
