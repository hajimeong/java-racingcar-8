package racingcar.util;

public class RacingValidator {

    public static void validateTryCount(String tryCount) {
        if(tryCount==null || tryCount.isBlank()){
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }

        try{
            int count=Integer.parseInt(tryCount);
            if(count<=0){
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다.");
        }
    }
}
