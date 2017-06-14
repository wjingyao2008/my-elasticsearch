package yang.yang.elastic.demo.service;

import yang.yang.elastic.demo.model.Car;

import java.util.List;

/**
 * Created by yanyan on 2017/06/14.
 */
public interface CarService {

    Car findOne(String id);

    long countAll();

    Iterable<Car> findAll();

    Car save(Car car);

    List<Car> findByBrand(String brandName);
}
