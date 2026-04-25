class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, TrieNode node) {

        if (node == null) return false;

        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);
        if (ch != '.') {
            return dfs(word, index + 1, node.children[ch - 'a']);
        }

        for (int i = 0; i < 26; i++) {
            if (dfs(word, index + 1, node.children[i])) {
                return true;
            }
        }

        return false;
    }
}