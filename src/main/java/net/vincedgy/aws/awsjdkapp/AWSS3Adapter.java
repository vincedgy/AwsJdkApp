package net.vincedgy.aws.awsjdkapp;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
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
public class AWSS3Adapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final AWSAdapter awsAdapter;

    private List<Bucket> buckets;

    @Autowired
    public AWSS3Adapter(AWSAdapter awsAdapter) {
        this.awsAdapter = awsAdapter;
    }

    public List<Bucket> getS3Buckets() {
        this.buckets = new ArrayList<Bucket>();
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
            s3Client.listBuckets().stream()
                    .forEach(bucket -> buckets.add(bucket));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.buckets;
    }

}
