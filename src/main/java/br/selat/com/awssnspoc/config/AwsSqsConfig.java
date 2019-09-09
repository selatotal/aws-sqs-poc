package br.selat.com.awssnspoc.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSqsConfig {

    @Bean
    public AmazonSQS amazonSQS(){
        return AmazonSQSClientBuilder.defaultClient();
    }

    @Bean
    public AmazonSQSAsync amazonSQSAsync(){
        return AmazonSQSAsyncClientBuilder.defaultClient();
    }
}
