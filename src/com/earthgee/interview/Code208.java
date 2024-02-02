package com.earthgee.interview;

public class Code208 {

    static class Trie {

        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children=new Trie[26];
            isEnd=false;
        }

        public void insert(String word) {
            Trie cur=this;
            int length=word.length();
            for(int i=0;i<length;i++){
                char ch=word.charAt(i);
                int index=ch-'a';
                if(cur.children[index] == null){
                    cur.children[index]=new Trie();
                }
                cur=cur.children[index];
            }
            cur.isEnd=true;
        }

        public boolean search(String word) {
            int index=0;
            int length=word.length();
            Trie trie=this;
            while(index < length && trie.children[word.charAt(index)-'a']!=null){
                trie=trie.children[word.charAt(index)-'a'];
                index++;
            }
            if(index == length){
                if(trie.isEnd){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            int index=0;
            int length=prefix.length();
            Trie trie=this;
            while(index < length && trie.children[prefix.charAt(index)-'a']!=null){
                trie=trie.children[prefix.charAt(index)-'a'];
                index++;
            }
            if(index==length){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }

}
