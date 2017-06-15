package yang.yang.elastic.demo.service;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yang.yang.elastic.demo.model.Car;
import yang.yang.elastic.demo.model.TweetMessage;
import yang.yang.elastic.demo.repository.CarRepository;
import yang.yang.elastic.demo.repository.TweetMessageRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyan on 2017/06/14.
 */
@Service
public class DemoServiceImpl implements DemoService {

    private CarRepository carRepository;
    private TweetMessageRepository tweetMessageRepository;

    @Autowired
    public DemoServiceImpl(CarRepository carRepository, TweetMessageRepository tweetMessageRepository) {
        this.carRepository = carRepository;
        this.tweetMessageRepository = tweetMessageRepository;
    }

    public Car findOneCar(String id) {
        return this.carRepository.findOne(id);
    }

    @Override
    public long countAllCar() {
        return this.carRepository.count();
    }

    @Override
    public Iterable<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public List<Car> findByCarBrand(String brandName) {
//        return this.carRepository.findByCarBrand(brandName);
//        BoolQueryBuilder q = QueryBuilders.boolQuery();
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                    .must(QueryBuilders.matchQuery("householdId", person.getHouseId()))
//                    .must(QueryBuilders.matchQuery("personId", person.getPersonId()));
//        }
//
//
     return null;
    }

    @Override
    public List<TweetMessage> findByTweetMessage(String message) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("tweet", message);
        List<TweetMessage> list = new ArrayList<>();
        tweetMessageRepository.search(matchQueryBuilder).forEach(it->list.add(it));
        return list;
    }

    @Override
    public List<TweetMessage> findByTag(String tag) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("tag", tag);
        List<TweetMessage> list = new ArrayList<>();
        tweetMessageRepository.search(matchQueryBuilder).forEach(it->list.add(it));
        return list;
    }

}
