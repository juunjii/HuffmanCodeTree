# HuffmanCodeTree

## Overview 
Huffman coding is a lossless data compression algorithm. The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters. 

## Concepts of Encoding 

### 1. Fixed Length Encoding 

Encoding text files in a computer may be an every-day task, but it was originally a difficult challenge
– one to which many different solutions exist. Normal approaches to encoding text files use what
are known as “fixed-length” encoding. This means that each letter corresponds to a fixed number
(say 8, or 16) of bits (zeros/ones) in the file. Each 8/16 bit pattern uniquely identifies one single
letter. A selection of standard fix-length codes under the ASCII coding scheme can be seen in the
table below:

<img src = "https://github.com/juunjii/HuffmanCodeTree/assets/83564748/93755857-4681-4f6e-9ca1-921238415814">

Fixed-length codes work particularly well in hardware, where the predictable and regular length
of data can help make processing this data quick and efficient. Let’s take a quick look at an few
quick examples:

Given the string “Egg cab” we would encode this as follows:

<img src = "https://github.com/juunjii/HuffmanCodeTree/assets/83564748/205194b5-aa03-46f4-aca9-5e0bb6856003">

So the encoded string would be 01000101011001110110011100100000011000110110000101100010

Going in the reverse direction we could decode
010010000110010101100001011001000010000001100111011000010110011001100110 as follows:

![table3](https://github.com/juunjii/HuffmanCodeTree/assets/83564748/56ef2e08-6f0d-4f31-a324-1f0fdce93180)

So decoded we would get “Head gaff”.


### 2. Variable Length Encoding 

Fixed-length codes are easy to work with, but are not always the most efficient. Conceptually, it
doesn’t make sense that common letters like ‘e’ ‘t’, ‘a’, ‘i’, ‘n’, ‘o’, and ‘s’ take up the same amount
of space as more obscure letters like ‘%‘ or ‘q’. Therefore, one solution that’s been explored in the
past to compress text is to have a not-fixed-length coding scheme. In such a scheme different letters
can encode to shorter or longer sequences of binary. If commonly used letters were made to encode to
shorter binary sequences (often forcing less common letters to use larger binary sequences),
substantially smaller binary encodings can be achieved.

One of the most common schemes for creating variable length encoding is known as the **Huffman
coding scheme**. A Huffman code scheme is one in which different letters have different length
representations, and certain properties are met. The different code engths make the encoding 
and decoding process more complicated, but also make the files more
efficient on disk. The codes generated, for example, can reduce the size of an ebook by
around 45%.

Before discussing specific details, an example will be useful. Below is a simplified example that
only covers the letters ‘e’, ‘t’, ‘a’, ‘b’, ‘k’, and ‘ ‘ (space). A real Huffman code would need to
cover all of the letters used in whatever text you wish to compress. 

![table4](https://github.com/juunjii/HuffmanCodeTree/assets/83564748/691d2274-1754-4efc-896d-a42eda13e298)

It’s common to present Huffman codes in two ways. First as a “look up table” where you
can quickly go from a letter to the binary pattern that encodes it, and secondly as a tree. The
codebook/look up table makes it easy to encode text following the same process as fixed length
codes For example to encode the name “kate” we would simply look up each letter in the codebook:

![table5](https://github.com/juunjii/HuffmanCodeTree/assets/83564748/deb00927-637f-4f3f-9871-2127279fb20d)

Decoding with only the lookup table is possible but not efficient. With fixed length codes we
could easily split a long sequence up by length and look up the letter for each 8-bit sub-sequence.
With non-fixed huffman codes like this, this isn’t possible, so an alternate process would be needed.
This is where the tree perspective comes in handy. Decoding text simply becomes the process of
letting the binary string guide us as we walk through the tree.
For example given the series “001111001111011000111” we can take each bit one at a time
following the edges from the root of the tree based on the next bit. Starting from the root, the
first two bits “00” bring us to the first letter ‘e‘. We then restart from the root. The next three
bits 111, bring us to ‘a’. We restart again, and 10 brings us to ‘t’. Following this process bit-by-bit
eventually retrieve the full message: “eat a tea”.

From this example we can see the most important property: Huffman codes are “prefix free”.
This means that no one code can be the prefix-of (same as the beginning of) a second code. If we
had “a” encoded as 01, and “b” encoded as “0100”, and “c” and “00”, for example, we would not
be prefix free, and wouldn’t know what “010001” encodes – is it “aca” or “ba”?
Translated structurally, we see that this means that we should only have two types of nodes
in our code tree – leaves (store a letter but no next nodes) and internal nodes (have both a zero
and one for the next node, but no data) So long as our code tree has this property, we can rely on
decoding to be quick and efficient.





