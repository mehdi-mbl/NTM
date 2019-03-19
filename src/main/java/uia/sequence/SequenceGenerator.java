package uia.sequence;

import uia.run.TrainingSequence;

public interface SequenceGenerator {
    public TrainingSequence generateSequence (int length, int vectorSize);
}
