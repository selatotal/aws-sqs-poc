package br.selat.com.awssnspoc.service;

import br.selat.com.awssnspoc.config.AwsSqsConfig;
import br.selat.com.awssnspoc.config.ConfigurationService;
import br.selat.com.awssnspoc.contract.input.MessageInput;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private final AmazonSQS amazonSQS;
    private final ConfigurationService config;

    @Autowired
    public MessageService(AmazonSQS amazonSQS, AwsSqsConfig awsSqsConfig, ConfigurationService config) {
        this.amazonSQS = amazonSQS;
        this.config = config;
    }

    public String sendMessage(MessageInput input) {
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(amazonSQS.getQueueUrl(config.getQueueName()).getQueueUrl())
                .withMessageGroupId(config.getGroupId())
                .withMessageDeduplicationId(UUID.randomUUID().toString())
                .withMessageBody(new Gson().toJson(input));
        amazonSQS.sendMessage(request);
        return "OK";
    }

    @SqsListener("${aws-sns-poc.queueName}")
    public void listen(String message){
        logger.info("Message Received: " + message);
    }
}
