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

So decoded we would get “Head gaff”

