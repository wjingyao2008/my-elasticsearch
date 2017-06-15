package yang.yang.elastic.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import yang.yang.elastic.demo.model.TweetMessage;

/**
 * Created by yanyan on 2017/06/15.
 */
public interface TweetMessageRepository extends ElasticsearchRepository<TweetMessage, String> {

}
