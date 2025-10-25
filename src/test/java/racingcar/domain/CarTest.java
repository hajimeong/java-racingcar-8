package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차의_숫자_4이상일때(){
        Car car=new Car("pobi");
        car.goForward(4);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    void 자동차_숫자_4미만일때(){
        Car car=new Car("pobi");
        car.goForward(3);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_5자_초과할때(){
        assertThatThrownBy(()->new Car("aaaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 5자를 초과했습니다.");
    }

    @Test
    void 자동차_이름_null일때(){
        assertThatThrownBy(()->new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }

    @Test
    void 자동차_이름_공백일때(){
        assertThatThrownBy(()->new Car("    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }
}