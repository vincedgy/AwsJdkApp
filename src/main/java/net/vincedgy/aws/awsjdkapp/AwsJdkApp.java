package net.vincedgy.aws.awsjdkapp;

import com.amazonaws.services.s3.model.Bucket;
import net.vincedgy.aws.awsjdkapp.services.AwsServiceLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AwsJdkApp {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    AwsServiceLayer awsServiceLayer;

    @Autowired
    public AwsJdkApp(AwsServiceLayer awsServiceLayer) {

        // Get S3 buckets
        List<Bucket> buckets = null;
        logger.info("Displaying S3 buckets creation date ");
        try {
            awsServiceLayer
                    .getAwsS3Adapter()
                    .getS3Buckets()
                    .stream()
                    .filter( b -> b.getName().startsWith("44"))
                    .forEach( b -> logger.info(
                            b.getName() +
                                    ":" +
                            b.getCreationDate().toString()
                    ));

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }

        // Get Dynamodb tables
        logger.info("Displaying DynamoDB table names");
        try {
            awsServiceLayer
                    .getAwsDynamoDBAdapter()
                    .getTables()
                    .getTableNames()
                    .forEach( t -> logger.info(t.toString()));

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(AwsJdkApp.class, args);
    }

}
