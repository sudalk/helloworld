package com.lk.leecode.code;

/**
 *  实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class Leecode36 {

    /**
     * 关键字：字典树
     * 思路：
     *     字典树的数据结构：TrieNode 判断结尾  存储节点
     *
     */
    class Trie {


        //初始化root节点（该节点不指向某字母，其子节点代表每个单词的开始）
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }


        //插入时，首先找到位置，如果当前节点的子节点为空，则就需要插入新的节点，然后得到刚插入的新节点，继续
        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char currentChar = word.charAt(i);
                if(!node.containsKey(currentChar)){
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }


        //查找 从根节点往下查找，如果没有则返回false，如果存在并且最终结束，则返回true
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }


        //找前缀 如果从根节点开始，则就可以不用判断是否为结束
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
