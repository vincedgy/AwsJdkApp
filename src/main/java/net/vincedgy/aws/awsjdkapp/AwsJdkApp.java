package net.vincedgy.aws.awsjdkapp;

import com.amazonaws.services.s3.model.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AwsJdkApp {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    AWSS3Adapter awss3Adapter;

    @Autowired
    public AwsJdkApp(AWSS3Adapter awss3Adapter) {
        List<Bucket> buckets = awss3Adapter.getS3Buckets();
        logger.info("Number of buckets is : " + buckets.size());
    }

    public static void main(String[] args) {
        SpringApplication.run(AwsJdkApp.class, args);
    }

}
