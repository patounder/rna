package cl.dcc.uchile.rna;

public class RNA {

    public static void main(String args[]){
        ConverterService converterService = new ConverterService();



        String secuenceA = args[0];//"ACC AUG GCA ACG UUU ACC CGC GGC GGG AAA UAG";
        String secuenceB = args[1];//"AUG GCC ACG UUU ACG CGG GGG GGC AAU UAA AAU ACG";

        int[][] costMatrix = {
                {0,2,2,1,3},
                {2,0,1,2,3},
                {2,1,0,2,3},
                {1,2,2,0,3},
                {3,3,3,3,0}};

        double totalCost = converterService.calcCostTranslate(secuenceA, secuenceB, costMatrix);
        System.out.println("Total cost is :"+totalCost);
    }
}
