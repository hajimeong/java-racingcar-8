package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @Test
    void moveAll_자동차_모두전진_테스트(){
        List<String> names=List.of("aaa","bbb","ccc");
        Cars cars=new Cars(names);

        //RandomMoveStrategy가 항상 5를 반환하도록 오버라이드(항상 이동)
        RandomMoveStrategy moreThanFour=new RandomMoveStrategy(){
            @Override
            public int generate(){
                return 5;
            }
        };

        cars.moveAll(moreThanFour);

        for(Car car: cars.getCars()){
            Assertions.assertThat(car.getLocation()).isEqualTo(1);
        }
    }

    @Test
    void moveAll_자동차_모두정지_테스트(){
        List<String> names=List.of("aaa","bbb","ccc");
        Cars cars=new Cars(names);

        //RandomMoveStrategy가 항상 3를 반환하도록 오버라이드(정지)
        RandomMoveStrategy LessThanFour=new RandomMoveStrategy(){
            @Override
            public int generate(){
                return 3;
            }
        };

        cars.moveAll(LessThanFour);

        for(Car car: cars.getCars()){
            Assertions.assertThat(car.getLocation()).isEqualTo(0);
        }
    }

    @Test
    void findWinner_단일우승자_테스트(){
        Cars cars=new Cars(List.of("aaa","bbb"));

        cars.getCars().get(0).goForward(5); //aaa가 1칸 이동
        cars.getCars().get(1).goForward(3); //bbb는 정지

        List<String> winners=cars.findWinners();

        Assertions.assertThat(winners).containsExactly("aaa");
    }

    @Test
    void findWinner_공동우승자_테스트(){
        Cars cars=new Cars(List.of("aaa","bbb","ccc"));

        //aaa와 bbb가 공동 우승
        cars.getCars().get(0).goForward(5);
        cars.getCars().get(1).goForward(5);
        cars.getCars().get(2).goForward(3);

        List<String> winners=cars.findWinners();

        Assertions.assertThat(winners).containsExactlyInAnyOrder("aaa","bbb");
    }

    @Test
    void moveAll_RandomMove_findWinner_테스트(){
        RandomMoveStrategy randomMove=new RandomMoveStrategy();
        List<String> names=List.of("aaa","bbb","ccc");
        Cars cars=new Cars(names);

        cars.moveAll(randomMove);

        for(Car car:cars.getCars()){
            System.out.println(car.getName()+"의 위치:"+car.getLocation());
        }

        List<String> winners=cars.findWinners();

        for(String winner:winners){
            System.out.print(winner+" ");
        }
    }
}