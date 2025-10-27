package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResultMessage(){
        System.out.println("실행 결과");
    }

    public static void printRoundResult(int round, List<Map<String, Integer>>carsStatus){
        for(Map<String, Integer> carStatus:carsStatus){
            for(Map.Entry<String, Integer> entry:carStatus.entrySet()){
                System.out.println(entry.getKey() + ": " + "-".repeat(entry.getValue()));
            }
        }

        System.out.println();
    }

    public static void printWinners(List<String> winners){
        System.out.println("최종 우승자: "+String.join(", ", winners));
    }
}
