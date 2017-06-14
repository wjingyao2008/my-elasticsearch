package yang.yang.elastic.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import yang.yang.elastic.demo.model.Car;

import java.util.List;

/**
 * Created by yanyan on 2017/06/14.
 */
public interface CarRepository extends ElasticsearchRepository<Car, String> {

    List<Car> findByBrand(String brandName);

}
