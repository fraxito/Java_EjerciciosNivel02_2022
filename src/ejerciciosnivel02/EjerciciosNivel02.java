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
    }
    
}
