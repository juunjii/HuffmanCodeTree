/**
 * CSCI1913 Project 3 - Huffman Coding Trees
 * Name: Jun Hao Cheh
 *
 * The Huffman Node class ultimately serves as a component of the HuffmanCodeTree class.
 * It’s structure is quite typical of a binary tree node.
 */
public class HuffmanNode {
    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;

    /**
     * This constructor makes a non-leaf node by providing it's two child nodes
     * @param zero zero (left) child node
     * @param one one (right) child node
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.zero = zero;
        this.one = one;
        data = null;
    }

    /**
     * This constructor makes a leaf node, specifying the data
     * @param data data to be stored in node
     */
    public HuffmanNode(char data) {
        this.zero = null;
        this.one = null;
        this.data = data;
    }

    public HuffmanNode getZero() {
        return zero;
    }

    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    public HuffmanNode getOne() {
        return one;
    }

    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    public Character getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    /**
     * This method checks if node is a leaf (have no child nodes)
     * @return true if node is a leaf; false if it's not
     */
    public boolean isLeaf() {
        // zeroNode and oneNode points to null
        return (data != null && (zero ==  null && one == null));
    }

    /**
     * This method check if the node is valid - is a leaf node (data is not null,
     * and both child nodes are null)
     * / internal node (data is null, both child node are not null)
     * @return true if node is valid; false if it's not
     */
    public boolean isValidNode() {
        // Check leaf node
        if (isLeaf()) {
            return true;
        }
        // Check internal node
        return data == null && (zero != null && one != null);
    }

    /**
     * This function checks if the node (parent) and all descendant nodes are valid for a Huffman coding tree.
     * Valid nodes: 1) Leaf nodes - data is not null, one and zero child node variables are null
     *              2) Internal nodes - data is null, both one and zero child nodes are not null
     *
     * @return true when if current node has ONE of the two valid forms AND
     * if each descendant node has ONE of the two valid forms; else it returns false
     */
    public boolean isValidTree() {

        if (!isValidNode()) {
            return false;
        }

        // Traverse zero descendant nodes (Checks until leaf, where zero == null)
        if (zero != null && !zero.isValidTree()) {
            return false;
        }
        // Traverse one descendant nodes (Checks until leaf, where one == null)
        if (one != null && !one.isValidTree()) {
            return false;
        }

        return true;
    }

}
