package org.apicoding.labs.ms.cluster;

import org.springframework.integration.leader.Context;
import org.springframework.integration.leader.DefaultCandidate;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Nous on 15/10/2016.
 */
public class LeaderCandidate extends DefaultCandidate {

    CountDownLatch onGrantedLatch = new CountDownLatch(1);

    @Override
    public void onGranted(Context ctx) {
        System.err.println("****************** JE SUIS LEADER LeaderCandidate");
        onGrantedLatch.countDown();
        super.onGranted(ctx);
    }

}

