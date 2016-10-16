package org.apicoding.labs.ms.cluster;

import org.springframework.context.ApplicationListener;
import org.springframework.integration.leader.event.AbstractLeaderEvent;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Nous on 15/10/2016.
 */
public class LeaderEventListener implements ApplicationListener<AbstractLeaderEvent> {

    CountDownLatch onEventLatch = new CountDownLatch(1);

    ArrayList<AbstractLeaderEvent> events = new ArrayList<AbstractLeaderEvent>();

    @Override
    public void onApplicationEvent(AbstractLeaderEvent event) {
        System.err.println("****************** JE SUIS LEADER LeaderEventListener");
        events.add(event);
        onEventLatch.countDown();
    }

}