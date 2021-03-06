package net.vincedgy.aws.awsjdkapp.services;

import net.vincedgy.aws.awsjdkapp.adapter.AWSCredentialsAdapter;
import net.vincedgy.aws.awsjdkapp.adapter.AWSDynamoDBAdapter;
import net.vincedgy.aws.awsjdkapp.adapter.AWSS3Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vincent on 02/06/2017.
 */
@Service
public class AwsServiceLayer {

    AWSCredentialsAdapter awsCredentialsAdapter;
    AWSDynamoDBAdapter awsDynamoDBAdapter;
    AWSS3Adapter awsS3Adapter;

    @Autowired
    public AwsServiceLayer(AWSS3Adapter awss3Adapter,
                           AWSDynamoDBAdapter awsDynamoDBAdapter,
                           AWSCredentialsAdapter awsCredentialsAdapter) {
        this.awsS3Adapter = awss3Adapter;
        this.awsDynamoDBAdapter = awsDynamoDBAdapter;
        this.awsCredentialsAdapter = awsCredentialsAdapter;
    }

    public AWSS3Adapter getAwsS3Adapter() {
        return awsS3Adapter;
    }

    public AWSDynamoDBAdapter getAwsDynamoDBAdapter() {
        return awsDynamoDBAdapter;
    }

    public AWSCredentialsAdapter getAwsCredentialsAdapter() {
        return awsCredentialsAdapter;
    }
}
