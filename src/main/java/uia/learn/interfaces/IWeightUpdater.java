package uia.learn.interfaces;

import uia.Units.UMatrix;
import uia.Units.UVector;
import uia.Units.Unit;

public interface IWeightUpdater {
    void reset();

    void updateWeight(Unit data);

    @Deprecated void updateWeight(Unit[] data);
    void updateWeight(UVector data);


    default void updateWeight(final UMatrix data) {
        for (UVector v : data.data) {
            updateWeight(v);
        }
    }

    @Deprecated void updateWeight(Unit[][] data);

    void updateWeight(Unit[][][] data);
}


