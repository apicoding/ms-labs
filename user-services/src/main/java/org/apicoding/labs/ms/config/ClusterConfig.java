package org.apicoding.labs.ms.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apicoding.labs.ms.cluster.LeaderCandidate;
import org.apicoding.labs.ms.cluster.LeaderEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.leader.event.DefaultLeaderEventPublisher;
import org.springframework.integration.leader.event.LeaderEventPublisher;
import org.springframework.integration.zookeeper.leader.LeaderInitiator;

/**
 * Created by Nous on 15/10/2016.
 */
@Configuration
public class ClusterConfig {

    @Bean
    public LeaderCandidate candidate() {
        return new LeaderCandidate();
    }


    @Bean(destroyMethod = "close")
    public CuratorFramework curatorClient() {
        CuratorFramework client = CuratorFrameworkFactory.builder().defaultData(new byte[0])
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectString("192.168.99.100:2181").build();
        // for testing we start it here, thought initiator
        // is trying to start it if not already done
        client.start();
        return client;
    }

    @Bean
    public LeaderInitiator leaderInitiator() throws Exception {
        LeaderInitiator initiator = new LeaderInitiator(curatorClient(), candidate());
        initiator.setLeaderEventPublisher(leaderEventPublisher());
        initiator.start();
        return initiator;
    }

   /* @Bean
    public LeaderInitiatorFactoryBean leaderInitiator() {
        LeaderInitiatorFactoryBean leaderInitiatorFactoryBean =  new LeaderInitiatorFactoryBean();
        leaderInitiatorFactoryBean.setClient(curatorClient());
        leaderInitiatorFactoryBean.
        return leaderInitiatorFactoryBean;
    }*/

    @Bean
    public LeaderEventPublisher leaderEventPublisher() {
        return new DefaultLeaderEventPublisher();
    }


    @Bean
    public LeaderEventListener leaderEventListener() {
        return new LeaderEventListener();
    }
}
