package uia.ntm.run.sequence;

import uia.ntm.run.TrainingSequence;

public interface SequenceGenerator {
    public TrainingSequence generateSequence (int length, int vectorSize);
}
