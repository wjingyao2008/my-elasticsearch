package yang.yang.elastic.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import yang.yang.elastic.demo.model.Car;
import yang.yang.elastic.demo.service.CarService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	CarService carService;

	@Autowired
	private ElasticsearchTemplate esTemplate;

	@Before
	public void before() {
		esTemplate.deleteIndex(Car.class);
		esTemplate.createIndex(Car.class);
		esTemplate.putMapping(Car.class);
		esTemplate.refresh(Car.class);
	}


	@Test
	public void testSave() {
		Car car = new Car("1001", 100000, "red", "BMW Corporate", "2014-02-12", "BMW X5");
		carService.save(car);
		Car save = carService.findOne("1001");
		assertNotNull(save.getId());
		assertEquals("red", save.getColor());
		assertEquals("BMW", save.getMake());
	}

	@Test
	public void testSearchByBrand() {
		Car car = new Car("1001", 100000, "red", "BMW Corporate", "2014-02-12", "BMW X5");
		carService.save(car);
		List<Car> cars = carService.findByBrand("BMW X5");
		assertEquals(1, cars.size());
		Car searchResult = cars.get(0);
		assertNotNull(searchResult.getId());
		assertEquals("red", searchResult.getColor());
		assertEquals("BMW", searchResult.getMake());
	}

	@Test
	public void testSearchByBrandPart() {
		Car car = new Car("1001", 100000, "red", "BMW Corporate", "2014-02-12", "BMW X5");
		carService.save(car);
		List<Car> cars = carService.findByBrand("X5");
		assertEquals(1, cars.size());
		Car searchResult = cars.get(0);
		assertNotNull(searchResult.getId());
		assertEquals("red", searchResult.getColor());
		assertEquals("BMW", searchResult.getMake());
	}

}
