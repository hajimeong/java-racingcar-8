package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    //자동차 이름 입력
    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    //게임 시도 횟수 입력
    public String inputTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
