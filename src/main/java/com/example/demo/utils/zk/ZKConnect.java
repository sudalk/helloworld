package com.example.demo.utils.zk;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @Author: likang
 * @Date: 2021/7/17 16:28
 */
public class ZKConnect {

    private ZooKeeper zk = null;

    private int sessionTimeout = 2000;

    private String hostPort = "127.0.0.1:2181";


    public ZooKeeper getZkClient(String hostPort, int sessionTimeout, Watcher watcher){
        try {
            zk = new ZooKeeper(hostPort, sessionTimeout, watcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zk;
    }


    public void close(){
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
