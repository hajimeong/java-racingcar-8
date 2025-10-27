package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class RoundResultTest {

    @Test
    void 생성자_정상동작_테스트(){
        int roundNum=1;

        List<Map<String, Integer>> status=List.of(
                Map.of("aaaa", 2),
                Map.of("bbbb",2),
                Map.of("cccc", 0)
                );

        RoundResult roundResult=new RoundResult(roundNum, status);

        Assertions.assertThat(roundResult.getRoundNumber()).isEqualTo(1);
        Assertions.assertThat(roundResult.getCarsStatus()).hasSize(3);
        Assertions.assertThat(roundResult.getCarsStatus().get(0)).containsEntry("aaaa", 2);
        Assertions.assertThat(roundResult.getCarsStatus().get(1)).containsEntry("bbbb", 2);
        Assertions.assertThat(roundResult.getCarsStatus().get(2)).containsEntry("cccc", 0);

    }
}