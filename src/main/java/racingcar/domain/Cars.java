package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames){
        this.cars=carNames.stream().map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAll(RandomMoveStrategy strategy){
        for(Car car:cars){
            car.goForward(strategy.generate());
        }
    }

    public int findMaxLocation(){
        return cars.stream().mapToInt(Car::getLocation).max().orElse(0);
    }

    public List<String> findWinners(){
        int maxLocation =findMaxLocation();
        return cars.stream().filter(c->c.getLocation()== maxLocation).map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars(){
        return cars;
    }
}
