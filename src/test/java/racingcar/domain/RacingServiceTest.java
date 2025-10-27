package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.repository.RacingCarRepository;

import java.util.List;

class RacingServiceTest {

    @Test
    void playRace_정상동작_테스트(){
        RacingCarRepository repository = new RacingCarRepository();
        RacingService service=new RacingService("aaaa,bbbb", repository);

        service.playRace(3);

        List<RoundResult> results=repository.findAllRounds();

        Assertions.assertThat(results).hasSize(3)
                .extracting(RoundResult::getRoundNumber)
                .containsExactly(1,2,3);
    }

    @Test
    void 잘못된_입력값_예외테스트() {
        RacingCarRepository repository = new RacingCarRepository();

        Assertions.assertThatThrownBy(() ->
                        new RacingService("aaaa,,bbbb", repository)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    @Test
    void 라운드별_자동차_위치_누적확인() {
        RacingCarRepository repository = new RacingCarRepository();
        RacingService service = new RacingService("aaaa", repository);

        service.playRace(2);

        List<RoundResult> results = repository.findAllRounds();
        int firstRoundLocation = results.get(0).getCarsStatus().get(0).get("aaaa");
        int secondRoundLocation = results.get(1).getCarsStatus().get(0).get("aaaa");

        System.out.println("firstRoundLocation = " + firstRoundLocation);
        System.out.println("secondRoundLocation = " + secondRoundLocation);

        Assertions.assertThat(secondRoundLocation).isGreaterThanOrEqualTo(firstRoundLocation);
    }

    @Test
    void 단일우승자_테스트(){
        RacingCarRepository repository = new RacingCarRepository();
        RandomMoveStrategy MoreThanFour=new RandomMoveStrategy(){
            @Override
            public int generate(){
                return 5;
            }
        };

        RacingService service = new RacingService("aaaa", MoreThanFour,  repository);

        service.playRace(3);
        List<String> winners=service.findWinners();

        Assertions.assertThat(winners).containsExactly("aaaa");
    }

    @Test
    void 다중우승자_테스트(){
        RacingCarRepository repository = new RacingCarRepository();
        RandomMoveStrategy MoreThanFour=new RandomMoveStrategy(){
            @Override
            public int generate(){
                return 5;
            }
        };

        RacingService service = new RacingService("aaaa,bbbb,cccc", MoreThanFour, repository);

        service.playRace(3);
        List<String> winners=service.findWinners();

        Assertions.assertThat(winners).containsExactlyInAnyOrder("aaaa","bbbb","cccc");
    }

}