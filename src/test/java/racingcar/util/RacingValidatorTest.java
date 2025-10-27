package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingValidatorTest {

    @Test
    void 시도횟수_정상_입력_테스트(){
        String tryCount="5";
        Assertions.assertThatCode(()->RacingValidator.validateTryCount(tryCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_0_예외발생_테스트(){
        assertThatThrownBy(()->RacingValidator.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도횟수_음수_예외발생_테스트(){
        assertThatThrownBy(()->RacingValidator.validateTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도횟수_입력_문자_테스트(){
        assertThatThrownBy(()->RacingValidator.validateTryCount("t"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자이어야 합니다.");
    }

}