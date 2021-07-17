package com.example.demo.utils.zk.watch;

import com.example.demo.utils.zk.ZKConnect;
import lombok.Data;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @Author: likang
 * @Date: 2021/7/17 16:46
 */
@Data
public class ZKWatch1 implements Watcher {

    private ZooKeeper zk;

    private ZKConnect connect ;

    private String ROOT_LOCK = "/test";

    public ZKWatch1() {
        connect = new ZKConnect();
        this.zk = connect.getZkClient("127.0.0.1:2181", 2000, this);
    }

    public void create(){
        try {
            Stat stat = zk.exists(ROOT_LOCK, true);
            if (stat == null) {
                zk.create(ROOT_LOCK, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println(ROOT_LOCK + " 已经创建");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            System.out.println("释放锁 " + ROOT_LOCK);
            Stat exists = zk.exists(ROOT_LOCK, true);
            if(exists != null){
                System.out.println("删除节点");
                zk.delete(ROOT_LOCK, -1);
            } else{
                System.out.println("no node");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("节点发生变化： " + event);
    }


    public static void main(String[] args) throws Exception{
        ZKWatch1 watch1 = new ZKWatch1();
        watch1.create();
        Thread.sleep(2000);
        watch1.delete();
        Thread.sleep(2000);
        watch1.getConnect().close();
    }
}
