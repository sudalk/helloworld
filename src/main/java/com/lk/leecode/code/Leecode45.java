package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *层次遍历
 */
public class Leecode45 {
    /**
     *关键词：队列
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        //加入根节点
        List<Integer> lroot = new ArrayList<>();
        lroot.add(root.val);
        queue.offer(root);
        res.add(lroot);
        while(!queue.isEmpty()){
            //出队列
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left !=null) {queue1.offer(node.left);list.add(node.left.val);}
                if(node.right !=null) {queue1.offer(node.right);list.add(node.right.val);}
            }
            if(list.size()>0) res.add(new ArrayList<>(list));
            //此时queue为空，queue1不为空,把queue1赋值给queue,并清空
            queue.addAll(queue1);
            queue1.clear();
        }
        return res;
    }
}
