package uia.ntm.run.sequence;


import uia.ntm.run.TrainingSequence;

public class XORSequenceGenerator implements SequenceGenerator {

    double[][] input;
    double[][] output;

    @Override
    public TrainingSequence generateSequence(int length, int vectorSize) {
        //length = length*1+2; //to be consistent with the WTF sequence below

        length = (int)(vectorSize * (1.0 + Math.random()));

        input = new double[length][vectorSize];
        output = new double[length][vectorSize];


        int j = (int)(Math.random() * 153) % (vectorSize/2) + vectorSize/2;

        for (int i = 0;i < length;i++) {
            int index = ((j)^(i)) % vectorSize;
            //int reflected = (vectorSize-1) - index;

            if (i < vectorSize/2)
                input[i][i] = 1;
            input[i][j] = 1;
            output[i][index] = 1;


        }

        return new TrainingSequence(input, output);
    }

    public double[][] getInput() {
        return input;
    }

    public double[][] getOutput() {
        return output;
    }
}
