package calculadora;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Calculadora {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cadena, resultado="0";
        Operacion operacion = new Operacion();
        System.out.println("Calculadora:");
        cadena = in.nextLine();
        
        String char0 = String.valueOf(cadena.charAt(0));
        if (char0.equals("-")||char0.equals("+")||char0.equals("*")||char0.equals("/")) {
            cadena=resultado.concat(cadena);
        }
        
        while(cadena.contains("(")){
            cadena = operacion.operacionCombinada(cadena);
        }
        
        System.out.println(cadena);
        
        resultado = operacion.operacionSimple(cadena);
        
        System.out.println("El resultado es: " + resultado);
        
    }
}
