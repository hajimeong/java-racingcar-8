package racingcar.repository;

import racingcar.domain.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRepository {
    private final List<RoundResult> raceResults=new ArrayList<>();

    public void saveRoundResult(RoundResult roundResult){
        raceResults.add(roundResult);
    }

    public List<RoundResult> findAllRounds() {
        return new ArrayList<>(raceResults);
    }

}
