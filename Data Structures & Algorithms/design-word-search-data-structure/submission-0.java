public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}
class WordDictionary {
    private TrieNode root;
    private Queue<Pair<Character, TrieNode>> queue;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        // System.out.print("end: "+cur.children.get(word.charAt(word.length() - 1)).endOfWord);
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return find(0, root, word);
    }

    private boolean find(int i, TrieNode cur, String target) {
        if (i == target.length() && cur.endOfWord) {
            return true;
        } else if (i == target.length()) {
            return false;
        }
        System.out.println(i +" "+target.charAt(i));
        boolean found = false;
        if (target.charAt(i) == '.') {
            for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                System.out.println(entry.getKey());
                if (find(i + 1, entry.getValue(), target)) {
                    return true;
                }
            }
        } else {
            TrieNode next = cur.children.get(target.charAt(i));
            if (next != null) {
                System.out.println(target.charAt(i));
                if (find(i + 1, next, target)) {
                    return true;
                }
            } 
        }
        return found;
    }

}
