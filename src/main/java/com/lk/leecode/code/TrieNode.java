package com.lk.leecode.code;

/**
 *  字典树节点类
 *  如果当前的节点，某个字母不为空，说明当前节点数组某个字母就不是空值
 *  link
 */
public class TrieNode {
    private TrieNode[] links;//存放当前节点的子节点的信息
    private final int R = 26;//代表26个字母
    private boolean isEnd; //判断是否需要结束

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
