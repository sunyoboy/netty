package com.lieve.zero.rpc.mock.registry.impl;

import com.google.common.collect.Lists;
import com.lieve.zero.rpc.mock.registry.IServiceDiscovery;
import com.lieve.zero.rpc.mock.registry.ZkConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

/**
 * @author sunlijiang
 * @date 2020/1/12
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery {

    List<String> repos = Lists.newArrayList();

    private CuratorFramework curatorFramework;

    public ServiceDiscoveryImpl() {
        curatorFramework = CuratorFrameworkFactory.builder().connectString(ZkConfig.CONNECTION_STR).sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000, 10)).build();
        curatorFramework.start();
    }
}
