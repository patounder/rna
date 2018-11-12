package cl.dcc.uchile.rna;

/**
 * entregue como salida la distancia entre las palabras texto1 y texto2 medida como el número de cambios de letra que
 * hay que hacer para ir de texto1 a texto2 luego de sobrelapar una con otra al máximo
 *
 * texto1=ACC AUG GCA ACG UUU ACC CGC GGC GGG AAA UAG
 * texto2=AUG GCC ACG UUU ACG CGG GGG GGC AAU UAA AAU ACG
 */
public class ConverterService {
    public double translate(String firstSecuence, String secondSecuence, int[][] matrix){

        char[] firstSecuenceArray = firstSecuence.toCharArray();

        for(char letter : firstSecuenceArray){
            System.out.println(LetterEnum.Letter.valueOf(Character.toString(letter)));
        }


        return 0;
    }
}
