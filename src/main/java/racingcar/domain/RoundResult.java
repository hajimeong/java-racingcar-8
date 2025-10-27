package racingcar.domain;

import java.util.List;
import java.util.Map;

public class RoundResult {
    private final int roundNumber;
    private final List<Map<String, Integer>> carsStatus;

    public RoundResult(int roundNumber, List<Map<String, Integer>> carsStatus) {
        this.roundNumber = roundNumber;
        this.carsStatus = carsStatus;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<Map<String, Integer>> getCarsStatus() {
        return carsStatus;
    }
}
