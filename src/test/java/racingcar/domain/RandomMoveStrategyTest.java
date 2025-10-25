package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {

    @Test
    void generate_0이상_9이하의_값_반환_테스트(){
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        for(int i=0;i<50;i++){
            int value= randomMoveStrategy.generate();
            //System.out.println(value);
            Assertions.assertThat(value).isBetween(0,9);
        }
    }

    @Test
    void 여러번_호출시_값_랜덤으로_변경되는지_테스트(){
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        int first=randomMoveStrategy.generate();
        int second=randomMoveStrategy.generate();

        //System.out.println("first = " + first);
        //System.out.println("second = " + second);

        Assertions.assertThat(first).isBetween(0,9);
        Assertions.assertThat(second).isBetween(0,9);

    }

}