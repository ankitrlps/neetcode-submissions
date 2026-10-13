/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // base case when node is null
        if (node == null) return null;
        
        // if clone node is already created
        // return it for adding as neighbor
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create new cloned node and put corresponding to old node
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // loop through old node's neighbors and add neighbors
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }
        // return any cloned node
        return newNode;
    }
}