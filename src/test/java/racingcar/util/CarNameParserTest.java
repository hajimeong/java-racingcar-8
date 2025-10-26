package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarNameParserTest {

    @Test
    void 정상_입력_테스트(){
        String input="aaaa,bbbb,cccc";

        List<String> result=CarNameParser.parser(input);

        Assertions.assertThat(result).containsExactly("aaaa","bbbb","cccc");
    }

    //자동차 이름 리스트 사이에 쉼표가 연속으로 있는 경우 예외 확인
    @Test
    void 비정상_입력_예외_테스트1(){
        Assertions.assertThatThrownBy(()->CarNameParser.parser("aaaa,,bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    //쉼표로 시작하는 입력이 들어온 경우
    @Test
    void 비정상_입력_예외_테스트2(){
        Assertions.assertThatThrownBy(()->CarNameParser.parser(",bbbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    @Test
    void 비정상_입력_예외_테스트3(){
        Assertions.assertThatThrownBy(()->CarNameParser.parser(",,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    //쉼표로 끝나는 입력이 들어온 경우
    @Test
    void 비정상_입력_예외_테스트4(){
        Assertions.assertThatThrownBy(()->CarNameParser.parser("bbbb,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    @Test
    void 입력이_비어있는_경우_테스트(){
        Assertions.assertThatThrownBy(()->CarNameParser.parser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 리스트 이름 입력이 비어있습니다.");
    }
}