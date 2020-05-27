package ru.customvk.searcher.vkclientautoconfigurationspringbootstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "custom-vk.client")
public class VkClientProperties {

    private Integer appId;
    private String appName;
}
