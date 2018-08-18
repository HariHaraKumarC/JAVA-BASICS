package hari.edu.java.java45;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harih on 8/18/2018.
 */
public class JavaGenerics {
    private static final Logger logger=Logger.getLogger(JavaGenerics.class);

    public static void main(String[] args){
        JavaGenerics obj=new JavaGenerics();
        List<Toyota> toyataCarList=new ArrayList<>();
        toyataCarList.add(new Toyota());
        toyataCarList.add(new Toyota());
        List<Audi> audiCarList=new ArrayList<>();
        audiCarList.add(new Audi());
        audiCarList.add(new Audi());
        obj.printString(toyataCarList);
        obj.printString(audiCarList);
    }

    public void printString(List<? extends Car> cars){
        for(Car car:cars) {
            logger.debug(car.getCarName());
        }
    }
}

interface Car{
    String getCarName();
}

class Toyota implements Car{

    @Override
    public String getCarName() {
        return "Toyota";
    }
}

class Audi implements Car{

    @Override
    public String getCarName() {
        return "Audi";
    }
}