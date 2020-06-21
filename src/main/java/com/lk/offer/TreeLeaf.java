package com.lk.offer;

/**
 * @Author: likang
 * @Date: 2020/4/20 21:31
 */
public class TreeLeaf {

    /*
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
                if(node.left == null && (node.right ==null){
                    //输出所有的叶子节点==队列中所有的节点
                }
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

    public static void valueUpSort() {
// 默认情况，TreeMap按key升序排序
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("acb1", 5);
        map.put("bac1", 3);
        map.put("bca1", 20);
        map.put("cab1", 80);
        map.put("cba1", 1);
        map.put("abc1", 10);
        map.put("abc2", 12);

// 升序比较器
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
// TODO Auto-generated method stub
                return o1.getValue()-o2.getValue();
            }
        };
// map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
// 排序
        Collections.sort(list,valueComparator);
// 默认情况下，TreeMap对key进行升序排序
        System.out.println("------------map按照value升序排序--------------------");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {

    }
    */
}
