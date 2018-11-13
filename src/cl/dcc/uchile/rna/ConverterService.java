package cl.dcc.uchile.rna;

import java.util.ArrayList;
import java.util.List;

import static cl.dcc.uchile.rna.LetterEnum.Letter.SPACE;

/**
 * entregue como salida la distancia entre las palabras texto1 y texto2 medida como el número de cambios de letra que
 * hay que hacer para ir de texto1 a texto2 luego de sobrelapar una con otra al máximo
 *
 * texto1=ACC AUG GCA ACG UUU ACC CGC GGC GGG AAA UAG
 * texto2=AUG GCC ACG UUU ACG CGG GGG GGC AAU UAA AAU ACG
 */
public class ConverterService {
    public double calcCostTranslate(String firstSecuence, String secondSecuence, int[][] matrix){

        char[] firstSecuenceArray = firstSecuence.replace(" ","").toCharArray();
        char[] secondSecuenceArray = secondSecuence.replace(" ", "").toCharArray();

        RNAsSampleDTO rnAsSampleDTO = normalizeRNAsSample(firstSecuenceArray, secondSecuenceArray);

        int totalCost = 0;
        int cost;
        for(int i = 0; i < rnAsSampleDTO.getSampleA().size(); i++){
            LetterEnum.Letter selectedALetter = rnAsSampleDTO.getSampleA().get(i);
            LetterEnum.Letter selectedBLetter = rnAsSampleDTO.getSampleB().get(i);

            if(LetterEnum.Letter.SPACE == selectedALetter || LetterEnum.Letter.SPACE == selectedBLetter){
                cost = matrix[0][4];
            }else{
                cost = matrix[selectedALetter.getIndexCostMatrix()][selectedBLetter.getIndexCostMatrix()];
            }
            totalCost = totalCost + cost;
        }

        return totalCost;
    }


    //Create lists with both samples to equals size
    public RNAsSampleDTO normalizeRNAsSample(char[] sampleA, char[] sampleB){
            int greaterSampleIndex = getGreaterSampleIndex(sampleA, sampleB);
            int sampleAIndex = 1;

            if(greaterSampleIndex == sampleAIndex){
                return buildRNAsSampleDTO(sampleA, sampleB);
            }

            return buildRNAsSampleDTO(sampleB, sampleA);
    }

    public int getGreaterSampleIndex(char[] sampleA, char[] sampleB){
        if(sampleA.length >= sampleB.length){
            return 1;
        }

        return 2;
    }

    public RNAsSampleDTO buildRNAsSampleDTO(char[] largerSample, char[] smallerSample){

        List<LetterEnum.Letter> listLetterSampleA = getSpaceLetterList(largerSample.length);
        List<LetterEnum.Letter> listLetterSampleB = getSpaceLetterList(largerSample.length);

        replaceSpaceLetters(listLetterSampleA, largerSample);
        replaceSpaceLetters(listLetterSampleB, smallerSample);

        return new RNAsSampleDTO(listLetterSampleA, listLetterSampleB);
    }

    public List<LetterEnum.Letter> getSpaceLetterList(int listSize){
        List<LetterEnum.Letter> spaceLetterList = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; i++){
            spaceLetterList.add(i, SPACE);
        }
        return spaceLetterList;
    }

    public void replaceSpaceLetters(List<LetterEnum.Letter> letterList, char[] sample){

        for(int i = 0; i < sample.length; i++){
            char letterSelected = sample[i];
            LetterEnum.Letter letter = LetterEnum.Letter.valueOf(Character.toString(letterSelected));
            letterList.set(i, letter);
        }
    }
}
