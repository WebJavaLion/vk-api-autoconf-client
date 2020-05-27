package ru.customvk.searcher.vkclientautoconfigurationspringbootstarter.config;


import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(VkClientProperties.class)
@ConditionalOnProperty(prefix = "custom-vk.client", value = {"app-id", "app-name"})
@ConditionalOnClass(VkApiClient.class)
public class VkClientAutoConfiguration {

    final VkClientProperties properties;

    @Autowired
    public VkClientAutoConfiguration(VkClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    VkApiClient apiClient() {
        System.out.println("AUTO CONFIGURE VK-CLIENT");
        return new VkApiClient(new HttpTransportClient());
    }

    @Bean
    @ConditionalOnMissingBean
    ServiceActor serviceActor() {
        System.out.println("AUTO CONFIGURE SERVICE ACTOR");
        return new ServiceActor(properties.getAppId(), properties.getAppName());
    }

}
