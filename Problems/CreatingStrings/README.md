# Creating Strings

This Java program generates all unique permutations of a given string and prints them in lexicographical order. It mimics the functionality of `std::next_permutation` in C++ to generate the permutations in an efficient manner.

## Features

- Reads a string as input.
- Generates all lexicographical permutations of the string.
- Outputs the number of unique permutations and lists them.

## How It Works

1. **Sorting the String**: The input string is first converted into a character array and sorted to ensure the permutations are generated in lexicographical order.
2. **Permutations Generation**: The program uses the next lexicographical permutation technique, similar to `std::next_permutation` in C++, to generate and store each unique permutation in a `TreeSet`, which automatically sorts and removes duplicates.
3. **Output**: The total number of unique permutations is printed, followed by each permutation.

## Algorithm

The program uses a combination of sorting, swapping, and reversing to generate the next lexicographical permutation of the input string.

### Steps:
1. Sort the input string to ensure the first permutation is lexicographically smallest.
2. Use the **next permutation** algorithm:
    - Find the largest index `i` such that `arr[i] < arr[i + 1]`.
    - Find the largest index `j` greater than `i` such that `arr[i] < arr[j]`.
    - Swap `arr[i]` and `arr[j]`.
    - Reverse the sequence from `arr[i + 1]` to the end of the array.
3. Repeat the process until no more permutations can be generated.

## Input Format

- The program expects a single input string from the user:

- example input : 
```input
  abc
  ```

## Output Format
- The first line contains the number of unique permutations.
- The following lines list each permutation in lexicographical order.
- example output : 
```output
  6
  abc
  acb
  bac
  bca
  cab
  cba
  ```


## How to Run

1. Clone the repository or download the source file.
2. Compile and run the program using the following commands:

```
javac CreatingStrings.java
java CreatingStrings
```
3. Input your string and the program will generate and display all unique permutations.



