package cl.dcc.uchile.rna;

public class LetterEnum {
    enum Letter{
        A(0), //
        C(1), //
        G(2), //
        U(3), //
        DELETE(4), //
        INSERT(4), //
        SPACE(-1);

        private int indexCostMatrix;

        Letter(int indexCostMatrix) {
            this.indexCostMatrix = indexCostMatrix;
        }

        public int getIndexCostMatrix(){
            return this.indexCostMatrix;
        }

    }
}
