package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    private static final String SEPERATOR=",";

    public static List<String> parser(String input){
        if(input==null||input.isBlank()){
            throw new IllegalArgumentException("자동차 리스트 이름 입력이 비어있습니다.");
        }

        List<String> names= Arrays.stream(input.split(SEPERATOR, -1))
                .map(String::trim)
                .collect(Collectors.toList());

        //System.out.println("names = " + names);

        if(names.stream().anyMatch(String::isEmpty)){
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }
        return names;
    }

}
