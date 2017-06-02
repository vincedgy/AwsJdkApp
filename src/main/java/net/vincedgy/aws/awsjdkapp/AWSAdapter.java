package net.vincedgy.aws.awsjdkapp;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by vincent on 02/06/2017.
 */

@Service
public class AWSAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProfileCredentialsProvider awsCredentials;

    public AWSAdapter() {
        try {
            this.awsCredentials = new ProfileCredentialsProvider();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AWSCredentials getAwsCredentials() {
        return this.awsCredentials.getCredentials();
    }


}
