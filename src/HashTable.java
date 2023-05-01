//Yoel Mekbeb
//mekbe003@umn.edu

import java.io.*;
import java.util.Scanner;

public class HashTable<T>{
    NGen<T>[] hashTable;

    //TODO: Create a constructor that takes in a length and initializes the hash table array
    public HashTable(int length){
        hashTable = new NGen[length];
    }
    //TODO: Implement a hash function
    public int hash(T item) {
        int num = Math.abs(item.hashCode());
        num = num % hashTable.length;
        return num;
    }

    //TODO: Implement the add method which adds an item to the hash table using your hash function
    // Does NOT add duplicate items
    public void add(T item) {
        int index = hash(item);
        NGen<T> node = new NGen<>(item, null);
        if(hashTable[index] == null) {
            hashTable[index] = node;
        } else {
            NGen<T> pointer = hashTable[index];
            while(pointer.getNext()!=null){
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
    }

    // ** Already implemented -- no need to change **
    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    // ** Already implemented -- no need to change **
    // When the debug boolean is true, the display method prints the indices of the hash table
    // and the number of words "hashed" to each index.
    //
    // The display method will always print:
    // - total number of unique words
    // - number of empty indices
    // - number of nonempty indices
    // - average collision length
    // - length of longest chain
    public void display(boolean debug) {
        int numUniqueWords = 0;
        int numEmptyIndices = 0;
        int longestChainLength = 0;
        String row = "";

        for (int i = 0; i < hashTable.length; i++) {
            row = "" + i + ": ";
            int currChainLength = 0;
            NGen<T> ptr = hashTable[i];
            while (ptr != null) {
                currChainLength += 1;
                ptr = ptr.getNext();
            }
            if (currChainLength == 0) {
                numEmptyIndices += 1;
            }
            else if (currChainLength > longestChainLength) {
                longestChainLength = currChainLength;
            }
            numUniqueWords += currChainLength;
            row += currChainLength;
            if (debug) System.out.println(row);
        }

        int numNonEmptyIndices = hashTable.length - numEmptyIndices;

        System.out.println("# unique words: " + numUniqueWords);
        System.out.println("# empty indices: " + numEmptyIndices);
        System.out.println("# nonempty indices: " + numNonEmptyIndices);
        System.out.println("average collision length: " + ((double) numUniqueWords / numNonEmptyIndices));
        System.out.println("length of longest chain: " + longestChainLength);
    }

    // TODO: Create a hash table, store all words from "canterbury.txt", and call the display method
    //  Create another hash table, store all words from "gettysburg.txt", and call the display method
    //  Create a third hash table, store all words from "keywords.txt", and call the display method
    public static void main(String args[]) throws IOException {
        HashTable<String> hashTable1 = new HashTable<>(250);
        hashTable1.addWordsFromFile("canterbury.txt");
        hashTable1.display(true);
        HashTable<String> hashTable2 = new HashTable<>(250);
        hashTable2.addWordsFromFile("gettysburg.txt");
        hashTable2.display(true);
        HashTable<String> hashTable3 = new HashTable<>(250);
        hashTable3.addWordsFromFile("keywords.txt");
        hashTable3.display(true);

    }
}
