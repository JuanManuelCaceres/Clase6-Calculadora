package calculadora;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Operacion {
    String[] terminosSeparados,terminosSeparadosAux;
    String[] cadena;
        
        
    public Operacion(){}    
    
    public String operacionCombinada(String cadena){
        cadena = cadena.replace(" ", "");
        String cadenaOperacion = cadena;
        String aux1 = cadenaOperacion.substring(cadena.indexOf("("),cadena.indexOf(")")+1);
        
        
        String aux2 = aux1.substring(aux1.lastIndexOf("(")+1,aux1.lastIndexOf(")"));
        
        
        cadenaOperacion = cadenaOperacion.replace(aux1, this.operacionSimple(aux2));
        cadenaOperacion = cadenaOperacion.replace("--","");
        
        
        
        return cadenaOperacion;
    }
    
    public String operacionSimple(String cadena){
        String resultado="0";
        String char0 = String.valueOf(cadena.charAt(0));
        if (char0.equals("-")||char0.equals("+")||char0.equals("*")||char0.equals("/")) {
            cadena=resultado.concat(cadena);
        }
        int cont =0;
        String texto1,texto2;
        terminosSeparadosAux = cadena.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        
        int longitud = terminosSeparadosAux.length-(this.contieneCantidad(terminosSeparadosAux, ".")*2);
        
        String[] terminosSeparados = new String[longitud];
        
        for (int i = 0; i< terminosSeparados.length; i++) {
            
            try {
                if (terminosSeparadosAux[i + cont + 1].equals(".")) {
                    terminosSeparados[i] = terminosSeparadosAux[i + cont].concat(".").concat(terminosSeparadosAux[i + cont + 2]);
                    cont += 2;
                } else {
                    terminosSeparados[i] = terminosSeparadosAux[i + cont];
                }
            } catch (Exception e) {
                terminosSeparados[i] = terminosSeparadosAux[i + cont];
            }
        }
        
        for (int i = 1; i < terminosSeparados.length; i+=1) {
            switch (terminosSeparados[i]){
                case "*":
                    if(terminosSeparados.length>3){
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])*Double.parseDouble(terminosSeparados[i+1]));
                        if(terminosSeparados[i-2].equals("-")){
                            terminosSeparados[i]="-";
                        } else{
                            terminosSeparados[i]="+";
                        }
                        terminosSeparados[i-1]="0";
                        break;


                    } else{
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])*Double.parseDouble(terminosSeparados[i+1]));
                        terminosSeparados[i]="+";
                        terminosSeparados[i-1]="0";
                        break;
                    }
                case "*-":
                    if(terminosSeparados.length>3){
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])*Double.parseDouble(terminosSeparados[i+1]));
                        if(terminosSeparados[i-2].equals("-")){
                            terminosSeparados[i]="+";
                        } else{
                            terminosSeparados[i]="-";
                        }
                        terminosSeparados[i-1]="0";
                        break;


                    } else{
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])*Double.parseDouble(terminosSeparados[i+1]));
                        terminosSeparados[i]="-";
                        terminosSeparados[i-1]="0";
                        break;
                    }
                case "/":
                    if(terminosSeparados.length>3){
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])/Double.parseDouble(terminosSeparados[i+1]));
                        if(terminosSeparados[i-2].equals("-")){
                            terminosSeparados[i]="-";
                        } else{
                            terminosSeparados[i]="+";
                        }
                        terminosSeparados[i-1]="0";
                        break;


                    } else{
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])/Double.parseDouble(terminosSeparados[i+1]));
                        terminosSeparados[i]="+";
                        terminosSeparados[i-1]="0";
                        break;
                    }
                case "/-":
                    if(terminosSeparados.length>3){
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])/Double.parseDouble(terminosSeparados[i+1]));
                        if(terminosSeparados[i-2].equals("-")){
                            terminosSeparados[i]="+";
                        } else{
                            terminosSeparados[i]="-";
                        }
                        terminosSeparados[i-1]="0";
                        break;


                    } else{
                        terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])/Double.parseDouble(terminosSeparados[i+1]));
                        terminosSeparados[i]="-";
                        terminosSeparados[i-1]="0";
                        break;
                    }
                default:
                    break;
            }

        }
        
        for (int i = 1; i < terminosSeparados.length; i+=1) {
                
                
            switch (terminosSeparados[i]){
                case "+":
                    terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])+Double.parseDouble(terminosSeparados[i+1]));
                    terminosSeparados[i]="+";
                    terminosSeparados[i-1]="0";
                    break;
                case "-":
                    terminosSeparados[i+1]=String.valueOf(Double.parseDouble(terminosSeparados[i-1])-Double.parseDouble(terminosSeparados[i+1]));
                    terminosSeparados[i]="+";
                    terminosSeparados[i-1]="0";
                    break;

                default:
                    break;

            }
        }
        
        
        
        return resultado=terminosSeparados[terminosSeparados.length-1];
    }
    
    public boolean contiene(String[] operacion,String operador){
        for (String e : operacion) {
            if( e.equals(operador)){
                return true;
            }
        }
        return false;
    }
    
    
    
    public int contieneCantidad(String[] cadena, String caracter){
        int cantidad=0;
        
        for(String e : cadena){
            if (e.equals(caracter)) {
                cantidad++;
            }
        }
        return cantidad;  
    }
}

    
    

