/**
 * CSCI1913 Project 3 - Huffman Coding Trees
 * Name: Jun Hao Cheh
 *
 * The HuffmanCodeTree class uses the node class build and maintain a binary tree that represents
 * a collection of Huffman codes for various letters.
 */
public class HuffmanCodeTree {

    private HuffmanNode root;

    /**
     * This constructor creates a Huffman code tree using a provided node as root
     *
     * @param root root (first node) of the tree
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * This constructor creates a Huffman code tree based on the data stored in a Huffman code book.
     *
     * @param codebook
     */
    public HuffmanCodeTree(HuffmanCodeBook codebook) {
        // Create a new root node
        root = new HuffmanNode(null, null);
        char[] charArray = codebook.getCArray();
        BinarySequence[] binaryArray = codebook.getSeqArray();
       //  Construct Huffman tree based on characters and corresponding sequences in codebook
        for (int i = 0; i < charArray.length; i++) {
            // null check
            if (binaryArray[i] == null) {
                break;
            }
            put(binaryArray[i], charArray[i]);

        }

    }

    /**
     * This method checks if the tree formed by the root node and it's descendants is a
     * valid Huffman code tree.
     * Valid nodes: 1) Leaf nodes - data is not null, one and zero child node variables are null
     * 2) Internal nodes/ root node - data is null, both one and zero child nodes are not null
     *
     * @return true when if root node has ONE of the two valid forms AND
     * if each descendant node has ONE of the two valid forms; else it returns false
     */
    public boolean isValid() {
        return root.isValidTree();
    }

    /**
     * This method should modify the binary tree structure so that the node “addressed”
     * by the binary sequence stores the given char.
     *
     * @param seq    binary sequence
     * @param letter corresponding character
     */
    public void put(BinarySequence seq, char letter) {
        // loops through every element in the binary sequence, if 0, setZero, if 1, setOne
        // if reach leaf, set data = letter
        // Creates leaf node, which stores letter as data

        HuffmanNode currentNode = root; // starts from root
        for (int i = 0; i < seq.size(); i++) {

            // if false (0)
            if (!seq.get(i)) {
                // current node gets updated to next zero node
                if (currentNode.getZero() == null) {
                    // fill empty node (zero, one, data = null)
                    currentNode.setZero(new HuffmanNode(null, null));
                }
                currentNode = currentNode.getZero(); // current node gets updated to next zero node

            }
            // if true (1)
            else {
                // current node gets updated to next one node
                if (currentNode.getOne() == null) {
                    currentNode.setOne(new HuffmanNode(null, null));
                }
                currentNode = currentNode.getOne(); // current node gets updated to next one node
            }
        }
        currentNode.setData(letter);


    }

        /**
         * This method should decode a BinarySequence into a string.
         * @param s binary sequence
         * @return decoded binary sequence
         */
        public String decode (BinarySequence s){
            HuffmanNode node = root;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.size(); i++) {
                if (s.get(i)) {
                    node = node.getOne();
                } else {
                    node = node.getZero();
                }

                // when leaf node is reached
                if (node.getZero() == null && node.getOne() == null) {
                    // data stored in leaf node extracted to form message
                    sb.append(node.getData());
                    node = root; // for loop starts at root node again
                }
            }
            return sb.toString(); // get string representation of sb
        }


    }

