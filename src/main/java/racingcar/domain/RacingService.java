package racingcar.domain;

import racingcar.repository.RacingCarRepository;
import racingcar.util.CarNameParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingService {
    private final Cars cars;
    private final RandomMoveStrategy moveStrategy;
    private final RacingCarRepository repository;

    public RacingService(String inputCarsNames, RacingCarRepository repository) {
        List<String> names = CarNameParser.parser(inputCarsNames);
        this.cars=new Cars(names);
        this.moveStrategy=new RandomMoveStrategy();
        this.repository=repository;
    }

    //시도 횟수 동안 경수를 실행하며 라운드별 자동차들의 상태 저장
    public void playRace(int count){
        for(int round=1;round<=count;round++){
            cars.moveAll(moveStrategy);
            List<Map<String,Integer>> status=getCarsStatus();
            repository.saveRoundResult(new RoundResult(round, status));
        }
    }

    //변환된 자동차들의 상태를 가져오는 메서드
    private List<Map<String, Integer>> getCarsStatus() {
        return cars.getCars().stream()
                .map(car -> Map.of(car.getName(), car.getLocation()))
                .collect(Collectors.toList());
    }

    public List<String> findWinners(){
        return cars.findWinners();
    }
}
