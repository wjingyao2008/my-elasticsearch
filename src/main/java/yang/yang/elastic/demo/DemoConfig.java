package yang.yang.elastic.demo;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

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

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
    @Bean
    public Client client() throws Exception {
//
        Settings esSettings = Settings.settingsBuilder()
//                .put("cluster.name", EsClusterName)
                .put("client.transport.sniff", true)
                .put("client.transport.ignore_cluster_name", true)
                .build();
//   return TransportClient.builder().settings(esSettings).build();
        TransportClient transportClient = TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort))
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(EsHost), 9200));
        List<DiscoveryNode> discoveryNodes = transportClient.listedNodes();
        return transportClient;


    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
