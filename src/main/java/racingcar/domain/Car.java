package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD=4;

    private final String name;
    private int location =0;

    public Car(String name){
        validateName(name);
        this.name=name;
    }

    private void validateName(String name){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
        }
    }

    //주어진 숫자에 따라 전진 여부 판단
    public void goForward(int randomNumber){
        if(randomNumber>=MOVE_THRESHOLD){
            location++;
        }
    }

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }
}
