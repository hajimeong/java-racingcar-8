package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy{
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
