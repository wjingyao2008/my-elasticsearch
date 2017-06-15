package yang.yang.elastic.demo.service;

import yang.yang.elastic.demo.model.Car;
import yang.yang.elastic.demo.model.TweetMessage;

import java.util.List;

/**
 * Created by yanyan on 2017/06/14.
 */
public interface DemoService {

    Car findOneCar(String id);

    long countAllCar();

    Iterable<Car> findAllCars();

    Car saveCar(Car car);

    List<Car> findByCarBrand(String brandName);

    List<TweetMessage> findByTweetMessage(String message);

    List<TweetMessage> findByTag(String tag);

}
