package cl.dcc.uchile.rna;

import java.util.List;

public class RNAsSampleDTO {

    private List<LetterEnum.Letter> sampleA;
    private List<LetterEnum.Letter> sampleB;

    public RNAsSampleDTO() {
        super();
    }

    public RNAsSampleDTO(List<LetterEnum.Letter> sampleA, List<LetterEnum.Letter> sampleB) {
        super();
        this.sampleA = sampleA;
        this.sampleB = sampleB;
    }

    public List<LetterEnum.Letter> getSampleA() {
        return sampleA;
    }

    public void setSampleA(List<LetterEnum.Letter> sampleA) {
        this.sampleA = sampleA;
    }

    public List<LetterEnum.Letter> getSampleB() {
        return sampleB;
    }

    public void setSampleB(List<LetterEnum.Letter> sampleB) {
        this.sampleB = sampleB;
    }

    @Override
    public String toString() {
        return "RNAsSampleDTO{" +
                "sampleA=" + sampleA +
                ", sampleB=" + sampleB +
                '}';
    }
}
