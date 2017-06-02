package net.vincedgy.aws.awsjdkapp;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 02/06/2017.
 */

@Service
public class AWSDynamoDBAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final AWSAdapter awsAdapter;
    

    @Autowired
    public AWSDynamoDBAdapter(AWSAdapter awsAdapter) {
        this.awsAdapter = awsAdapter;
    }



}
