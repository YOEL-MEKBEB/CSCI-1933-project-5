Yoel Mekbeb
mekbe003@umn.edu

contribution...
implemented hash function and add function


Stats for a hashtable of size 250...
hashTable1
# unique words: 348
# empty indices: 113
# nonempty indices: 137
average collision length: 2.54014598540146
length of longest chain: 24

hashTable2
# unique words: 266
# empty indices: 140
# nonempty indices: 110
average collision length: 2.418181818181818
length of longest chain: 11

hashTable3
# unique words: 50
# empty indices: 202
# nonempty indices: 48
average collision length: 1.0416666666666667
length of longest chain: 2


Analysis...
The hashfunction takes the hashcode of the item and takes the absolute value of the hashcode to exclude negative values and stores it in an int. THe modulus is used on the number and the hashtable's length. This has an approximately of O(1). The "approximately" is due to the fact that there is a form
of looping incase of collisions.

I certify that the information contained in this README
file is complete and accurate. I have both read and followed the course
policies in the ’Academic Integrity - Course Policy’ section of the course
syllabus.
Yoel Mekbeb
