package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RoundResult;

import java.util.List;
import java.util.Map;

class RacingCarRepositoryTest {

    @Test
    void 라운드결과_저장_및_조회_테스트(){
        RacingCarRepository repository = new RacingCarRepository();
        RoundResult round1 = new RoundResult(1, List.of(Map.of("aaaa",2)));
        RoundResult round2 = new RoundResult(2, List.of(Map.of("aaaa",3)));

        repository.saveRoundResult(round1);
        repository.saveRoundResult(round2);

        List<RoundResult> results=repository.findAllRounds();

        Assertions.assertThat(results).hasSize(2);
        Assertions.assertThat(results.get(0).getRoundNumber()).isEqualTo(1);
        Assertions.assertThat(results.get(1).getRoundNumber()).isEqualTo(2);
    }

    @Test
    void 라운드_비어있을때_테스트(){
        RacingCarRepository repository = new RacingCarRepository();

        List<RoundResult> results = repository.findAllRounds();

        Assertions.assertThat(results).isEmpty();
    }
}