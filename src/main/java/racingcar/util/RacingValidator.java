package racingcar.util;

public class RacingValidator {

    public static void validateTryCount(int tryCount) {
        if(tryCount<=0){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
