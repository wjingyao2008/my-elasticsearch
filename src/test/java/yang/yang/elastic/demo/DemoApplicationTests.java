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
		Car car = new Car("1001", 100000, "red", "honda", "2014-02-12");
		carService.save(car);
		Car save = carService.findOne("1001");
		assertNotNull(save.getId());
		assertEquals("red", save.getColor());
		assertEquals("honda", save.getMake());
	}
}
