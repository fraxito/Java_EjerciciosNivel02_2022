package ejerciciosnivel02;
/**
 * @author Jorge Cisneros
 */
public class EjerciciosNivel02 {

    public boolean esEscaleraPalabras(char[][] listaPalabras){
    
        for (int i=0; i<listaPalabras.length-1; i++){
            int contador = 0;
            for (int j=0; j<listaPalabras[0].length;j++){
                if (listaPalabras[i][j] != listaPalabras[i+1][j]){
                    contador++;
                }
            }
            if (contador != 1){ //si es distinto de uno es porque se diferencian en más de un caracter
                return false;
            }
        }
        return true;
    }
    
    public boolean esEscaleraDePalabras2(char[][] lista){
        for (int j=0; j<lista.length-1; j++){
            int contador = 0;
            for (int i=0; i<lista[0].length; i++){
                if (lista[j][i] != lista[j+1][i]){
                   contador++;
                }
            }
            if (contador != 1){
                return false;
            }
        }
        return true;
    }

    
    private int costeErroresADN (String uno, String dos) {
        int coste = 0;
        for (int i=0; i< uno.length(); i++){
            if (uno.charAt(i) == '-' || dos.charAt(i) == '-'){coste += 2;}
            else{
                if (uno.charAt(i) == 'C' && dos.charAt(i) != 'G'){coste++;}
                if (uno.charAt(i) == 'G' && dos.charAt(i) != 'C'){coste++;}
                if (uno.charAt(i) == 'A' && dos.charAt(i) != 'T'){coste++;}
                if (uno.charAt(i) == 'T' && dos.charAt(i) != 'A'){coste++;}
            }
        }
        return coste;
    }
    
    public int strStr(String str1, String str2){
        //EN LA VIDA REAL SE USA .find PARA QUE TE DEVUELVA EL VALOR 
        int posicion = -1;
        for (int i=0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                posicion = i;
                int j=0;
                while (j < str2.length() && i<str1.length()
                        && str1.charAt(i) == str2.charAt(j)){
                    j++;
                    i++;
                }
                if (j == str2.length()){//ha encontrado la palabra 2 en la 1
                    return posicion;
                }
                if (i == str1.length()){//se ha terminado la palabra 1 y no cabe la 2
                    return -1;
                }
                //si llega aquí es porque ha salido del while
                //porque las letras son distintas
                i = posicion;
                posicion = -1;
            }
        }

        return posicion;
    }
    
    
     public String calculadoraRPN( String [] entrada){
    
        String [] pila  = new String [100];
        int posicionPila = 0; //indica el sitio de la pila en el que toca insertar o leer
        
        for (int i=0; i< entrada.length; i++){
            
            if (entrada[i] != "+" && entrada[i] != "-" &&entrada[i] != "*" &&entrada[i] != "/" ){
                //System.out.print(entrada[i] + " ");
                //es un operando, tengo que meterlo en la pila
                pila[posicionPila] = entrada[i];
                posicionPila++;
            }
            else{ //es una operación
                if (posicionPila - 2 >= 0){
                    double operando1 = Double.valueOf(pila[posicionPila - 1]);
                    double operando2 = Double.valueOf(pila[posicionPila - 2]);
                    if (entrada[i] == "+"){
                        operando1 = operando1 + operando2;
                    }
                    if (entrada[i] == "*"){
                        operando1 = operando1 * operando2;
                    }
                    if (entrada[i] == "-"){
                        operando1 = operando1 - operando2;
                    }
                    if (entrada[i] == "/"){
                        if (operando2 == 0){
                            return "No se puede dividir entre cero, imbécil";
                        }
                        else{
                            operando1 = operando1 / operando2;
                        }
                    }
                    posicionPila = posicionPila - 2;
                    pila[posicionPila] = operando1+"";  //guardo el resultado en la casilla correspondiente
                    posicionPila++;
                } 
                else{
                    return "ERROR";
                }
            }
            
        }
        
        
        
        
        return pila[0];
    }
     
    
    
    public static void main(String[] args) {
        char [][] listaPalabras = { 
            {'P', 'A', 'T', 'A'}, 
            {'P', 'A', 'T', 'O'}, 
            {'R', 'A', 'T', 'O'}, 
            {'R', 'A', 'M', 'O'}, 
            {'G', 'A', 'M', 'O'}, 
            {'G', 'A', 'T', 'O'}, 
            {'M', 'A', 'T', 'O'} 
        };
        EjerciciosNivel02 e = new EjerciciosNivel02();
        System.out.println(e.esEscaleraPalabras(listaPalabras));
        System.out.println(e.esEscaleraDePalabras2(listaPalabras));
        
         System.out.println(e.costeErroresADN("ACGT", "TGCA"));
         System.out.println(e.costeErroresADN("A-C-G-T-ACGT", "TTGGCCAATGCA"));
         System.out.println(e.costeErroresADN("AAAAAAAA", "TTTATTTT"));
         
         System.out.println(e.strStr("HOLA MUNDO", "MU"));
         
         System.out.println(e.strStr("HOLA MUNDO", "ME"));
         System.out.println(e.strStr("HOLA MUNDO", "DO"));
         
         System.out.println(e.calculadoraRPN( new String[]{"3", "2","+", "7", "*","15","21","+","-"} ) );
         System.out.println(e.calculadoraRPN( new String[]{"4", "2","/", "5", "*"} ) );
    }
    
}
