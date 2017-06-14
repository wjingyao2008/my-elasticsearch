package yang.yang.elastic.demo;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * Created by yanyan on 2017/06/14.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "yang.yang.elastic.demo.repository")
public class DemoConfig {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("client.transport.ignore_cluster_name", true)
                .build();
        TransportClient transportClient = TransportClient.builder().settings(esSettings).build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
        return transportClient;


    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
