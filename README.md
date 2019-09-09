# aws-sns-poc
Simple Spring AWS SQS POC 

# POC Application

Application is started via Gradle. 
To start it, access spring-data-redis-poc folder and run:
 
```bash
gradle bootRun
```

Application uses Springfox to give you a web interface to test.
After start application, access http://localhost:8080/swagger-ui.html in your browser


# Configure

## AWS SQS
* Open AWS Console and access SQS service (https://console.aws.amazon.com/sqs/home)
* Create a SQS queue and set queue permission

## Application
* Update application.yml with your AWS credentials and SQS queues

# Learning More
* https://spring.io/projects/spring-data
* https://spring.io/projects/spring-cloud-aws
* https://cloud.spring.io/spring-cloud-aws/reference/html/#_messaging
