package MontyHallProblem;

import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;

/**
 Author: Mikhail Tsvik (tsvik@me.com)
 Date: 27.02.14.
 */

public class ParadoxModelImpl implements ParadoxModel {

    private enum DoorState {WIN, LOSE, OPENED}
    private DoorState[] doors = new DoorState[3];
    private final Random rnd;
    private int playerChooseIndex;

    public ParadoxModelImpl(long seed) {
        this.rnd = new Random(seed);
    }

    private void generationDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = DoorState.LOSE;
        }

        int winIndex = rnd.nextInt(3);
        playerChooseIndex = rnd.nextInt(3);
        doors[winIndex] = DoorState.WIN;

        for (int i = 0; i < doors.length; i++) {
            if (doors[i] == DoorState.LOSE && playerChooseIndex != i) {
                doors[i] = DoorState.OPENED;
            }
        }
    }

    private int stayChoose() {
        generationDoors();
        if (doors[playerChooseIndex] == DoorState.WIN) {
            return 1;
        } else return 0;
    }

    private double changeChooseProbability(double stayProbability) {
        return 1 - stayProbability;
    }

    private double countProbability(int repeats) {
        double countWinStayChoose = 0;
        for (int i = 0; i < repeats; i++) {
            countWinStayChoose += stayChoose();
        }
       return  countWinStayChoose / repeats;
    }


    @Override
    public ProbabilityPair getProbability(int repeats) {

        checkArgument(repeats > 0, "Repeats number must be positive");

        double stayChooseProbability = countProbability(repeats);
        double changeChooseProbability = changeChooseProbability(stayChooseProbability);

        return new ProbabilityPairImpl(stayChooseProbability, changeChooseProbability);
    }


    private static class ProbabilityPairImpl implements ProbabilityPair {

        private final double stayProbability;
        private final double changeProbabilty;


        ProbabilityPairImpl(double stayProbability, double changeProbabilty) {
            this.stayProbability = stayProbability;
            this.changeProbabilty = changeProbabilty;
        }

        @Override
        public double getIfChange() {
            return changeProbabilty;
        }

        @Override
        public double getIfNotChange() {
            return stayProbability;
        }
    }
}
