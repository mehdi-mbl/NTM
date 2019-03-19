package uia.memory.address.content;

import uia.Units.Unit;

public interface ISimilarityFunction   
{
    Unit calculate(Unit[] u, Unit[] v);

    void differentiate(Unit similarity, Unit[] u, Unit[] v);
}


