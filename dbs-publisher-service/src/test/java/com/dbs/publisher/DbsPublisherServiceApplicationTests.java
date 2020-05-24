package com.dbs.publisher;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbs.publisher.binding.PublisherBinding;
import com.dbs.publisher.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DbsPublisherServiceApplicationTests {

	private Logger logger = Logger.getLogger(DbsPublisherServiceApplicationTests.class.getName());
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private PublisherBinding binding;
	@Autowired
	private MessageCollector messageCollector;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	 @SuppressWarnings("unchecked")
	 public void testAccepted() {
	  Product commercial = new Product(1L,"Commercial Insurance","commercial-general-insurance.jpg", 5000D);
	  String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(commercial);
			Message<String> msg = MessageBuilder.withPayload(jsonString).build();
			binding.output().send(msg);
			Message<String> received = (Message<String>) messageCollector.forChannel(binding.output()).poll();
			logger.info("DbsPublishServiceApplicationTests :: Order response received ::"+ received.getPayload());
			assertNotNull(received.getPayload());
		} catch (JsonProcessingException e) {
			logger.info("DbsPublishServiceApplicationTests :: JsonProcessingException while parsing : " + commercial);
		}
	 }

}
