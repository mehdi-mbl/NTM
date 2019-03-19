package uia.ntm.run.sequence;

import uia.ntm.run.TrainingSequence;

public class SawtoothSequenceGenerator implements SequenceGenerator {

    @Override
    public TrainingSequence generateSequence(int length, int vectorSize) {
        length = length*2+2; //to be consistent with the WTF sequence below

        double[][] input = new double[length][vectorSize];
        double[][] output = new double[length][vectorSize];

        boolean direction = Math.random() < 0.5;


        int j = (int)(Math.random() * 100);
        for (int i = 0;i < length;i++) {
            int index = j % vectorSize;
            int reflected = (vectorSize-1) - index;

            input[i][index] = 1;
            output[i][reflected] = 1;

            if (direction)
                j++;
            else
                j--;

        }

        return new TrainingSequence(input, output);
    }
}
