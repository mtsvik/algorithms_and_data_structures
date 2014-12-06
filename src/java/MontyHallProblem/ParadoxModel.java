package MontyHallProblem;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 27.02.14.
 */

public interface ParadoxModel {

    ProbabilityPair getProbability(int repeats);

    interface ProbabilityPair {
        double getIfChange();

        double getIfNotChange();
    }
}