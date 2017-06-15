package yang.yang.elastic.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yang.yang.elastic.demo.model.TweetMessage;
import yang.yang.elastic.demo.service.DemoService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests2 {

    static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    DemoService demoService;

	@Test
	public void testFindMessage() {
		List<TweetMessage> list = demoService.findByTweetMessage("I visit google");
		assertEquals(1,list.size());
		assertEquals("Jack Smith", list.get(0).getName());
		assertEquals("movie star", list.get(0).getTag());
	}

    @Test
    public void testFindTag() {
        List<TweetMessage> list = demoService.findByTag("star");
        assertEquals(0,list.size());
        list = demoService.findByTag("movie star");
        LOGGER.info("we got {}",list);
        assertEquals(1,list.size());
        assertEquals("Jack Smith", list.get(0).getName());
        assertEquals("movie star", list.get(0).getTag());
        assertEquals(10002, list.get(0).getUserId());
    }



}
