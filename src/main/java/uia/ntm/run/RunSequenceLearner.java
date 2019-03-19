package uia.ntm.run;


import uia.ntm.NeuralTuringMachine;
import uia.ntm.run.sequence.SequenceGenerator;


public class RunSequenceLearner extends SequenceLearner {

    /** print every frame in all sequences, in the order they are trained */
    boolean printSequences = true;
    SequenceGenerator sequenceGenerator;
    double errorThreshold;

    public void runNTM(boolean verbose) throws Exception {
        //SequenceLearner s = new RunSequenceLearner(16);
        while (mean(errors)>errorThreshold) {
            this.run(verbose);
            //System.out.println(this.machine.memory.toString());
            //System.out.println(Arrays.toString(this.machine.getOutput()));

        }
    }

    public RunSequenceLearner(int vectorSize, int memoryWidth, int memoryHeight, int numHeads, int controllerSize, SequenceGenerator sequneceGenerator, double errorThreshold) {
        super(vectorSize, memoryWidth, memoryHeight, numHeads, controllerSize);
        this.sequenceGenerator=sequneceGenerator;
        this.errorThreshold=errorThreshold;
    }

    public RunSequenceLearner(int vectorSize) {
        super(vectorSize, 8, 32, 1, 64);
    }

    @Override
    protected TrainingSequence nextTrainingSequence() {
        return this.sequenceGenerator.generateSequence(rand.nextInt(10) + 1, vectorSize);

    }

    public void onTrained(int sequenceNum, TrainingSequence sequence, NeuralTuringMachine[] output, long trainTimeNS, double avgError, boolean verbose) {

        double[][] ideal = sequence.ideal;
        int slen = ideal.length;

        if (printSequences) {
            for (int t = 0; t < slen; t++) {
                double[] actual = output[t].getOutput();
                System.out.println("\t" + sequenceNum + "#" + t + ":\t" + toNiceString(ideal[t]) + " =?= " + toNiceString(actual));
            }
        }

        if ((sequenceNum+1) % statisticsWindow == 0) {
            System.out.format("@ %d :       avgErr: %f       time(s): %f", i,
                    mean(errors), mean(times)/1.0e9);
            if (verbose) System.out.println(super.machine.memory.toString());
            System.out.println();
        }


    }



}
