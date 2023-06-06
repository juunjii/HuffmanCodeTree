/**
 * CSCI1913 Project 3 - Huffman Coding Trees
 * Name: Jun Hao Cheh
 *
 * The Huffman CodeBook class represents the “codebook” of the Huffman coding process, that is,
 * it tells us, for each letter – what is the correct binary sequence. When encoding files, the Huffman
 * CodeBook class is used to encode files – transform them from a series of letters, to a compact
 * binary sequence.
 */

public class HuffmanCodeBook {

    private char[] cArray;
    private BinarySequence[] seqArray;
    private int count;

    public HuffmanCodeBook() {
        cArray = new char[10];
        seqArray = new BinarySequence[10];
        count = 0;
    }

    /**
     * This method should add a given character/letter and binary sequence into the codeBook.
     *
     * @param c character to add
     * @param seq sequence of the character that corresponds to the character
     */
    public void addSequence(char c, BinarySequence seq) {
        char temp;
        BinarySequence temp2;

        if (isFull()) {
            expandArray(count * 2);
        }

        cArray[count] = c;
        seqArray[count] = seq;
        count++; // number of elements in array


        int i = count - 1; // index of array (starts from last element)

        // O(N) Sorting
        // Stops at index 1 (compares with index 0)
        // Next element compares with previous element
        while (i > 0 && (cArray[i] < cArray[i - 1])) {
            temp = cArray[i];
            temp2 = seqArray[i];
            cArray[i] = cArray[i - 1]; // larger char moves to the back
            cArray[i - 1] = temp; // smaller char moves to the front
            seqArray[i] = seqArray[i - 1]; // larger sequence moves to the back
            seqArray[i - 1] = temp2; // smaller sequence moves to the front

            // Sort similar input characters
            if (c == cArray[i]) {
                temp = cArray[i];
                temp2 = seqArray[i];
                cArray[i] = cArray[i - 1];
                cArray[i - 1] = temp;
                seqArray[i] = seqArray[i - 1];
                seqArray[i - 1] = temp2;
            }
            i--;
        }

    }

    /**
     * Checks if the map (cArray & seqArray) is full
     *
     * @return true if map is full; false if map is not full
     */
    private boolean isFull() {
        return count == seqArray.length;
    }

    /**
     * This method expands the cArray and seqArray array to newSize (count *2)
     *
     * @param newSize size of the new array
     */
    private void expandArray(int newSize) {
        char[] newCArray = new char[newSize];
        BinarySequence[] newSeqArray = new BinarySequence[newSize];

        for (int j = 0; j < count; j++) {
            newCArray[j] = cArray[j];
            newSeqArray[j] = seqArray[j];
        }
        cArray = newCArray;
        seqArray = newSeqArray;
    }

    /**
     * This method should return true/false to indicate if the codebook contains a given letter.
     *
     * @param letter letter to be searched in the codebook
     * @return boolean value to indicate if the codebook contains the given letter
     */
    public boolean contains(char letter) {
        // Binary Search - 0(log N)
        int left = 0;
        int right = count - 1; // keeps track of added elements in cArray
        while (left <= right) {
            int mid = (left + right) / 2;
            // Letter is smaller than middle element
            if (letter < cArray[mid]) {
                right = mid - 1; // search moves to the left
            }
            // Letter is larger than middle element
            else if (letter > cArray[mid]) {
                left = mid + 1; // search moves to te right
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * This function checks if a given codebook can handle a given piece of text.
     *
     * @param letters text to be checked with codebook
     * @return true if every letter in the input string is contained in the codebook
     */
    public boolean containsAll(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            boolean inLetter = contains(letters.charAt(i));
            // If one of the letter is letters is not in cArray
            if (!inLetter) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method should get the binary sequence associated with the given letter
     *
     * @param c letter that you want to retrieve the binary sequence from
     * @return the binary sequence of the letter
     */
    public BinarySequence getSequence(char c) {
        // Binary Search - 0(log N)
        int left = 0;
        int right = count - 1; //  keeps track of added elements in cArray
        while (left <= right) {
            int mid = (left + right) / 2;
            // Letter is smaller than middle element
            if (c < cArray[mid]) {
                right = mid - 1; // search moves to the left
            }
            // Letter is larger than middle element
            else if (c > cArray[mid]) {
                left = mid + 1; // search moves to te right
            } else {
                return seqArray[mid];
            }
        }
        return null;
    }

    /**
     * This method encodes the input string into a binary sequence.
     *
     * @param s input string
     * @return binary sequence of the input string
     */
    public BinarySequence encode(String s) {
        // Creates a new empty binary sequence
        BinarySequence correspondingSeq = new BinarySequence();
        // Compare elements of string with every element in cArray
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < cArray.length; j++) {
                if (s.charAt(i) == cArray[j]) {
                    // Appends character corresponding sequence into correspondingSeq
                    correspondingSeq.append(seqArray[j]);
                }
            }
        }
        return correspondingSeq;
    }

    public char[] getCArray() {
        return cArray;
    }

    public BinarySequence[] getSeqArray() {
        return seqArray;
    }
}
