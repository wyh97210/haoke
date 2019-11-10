package com.wyh.haoke.dubbo.api.config;

import com.aliyun.oss.OSS;

import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:aliyun.properties"})
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String urlPrefix;
    @Bean
    public OSS oSSClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    }

}
