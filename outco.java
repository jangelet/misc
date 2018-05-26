import java.io.*;
import java.util.*;

class MyCode {

  /*
   * anagramPalindrome
   *
   * Write a function which accepts an input word and returns true or false if there exists
   * an anagram of that input word that is a palindrome.
   */
  
  public static boolean anagramPalindrome(String word){
    //lowercase characters only
    HashMap<Character, Integer> charCounter = new HashMap<>();
    
    for(int i = 0; i < word.length(); i++){
      char currChar = word.charAt(i);
      //check if current char exists in hashmap
      if(charCounter.get(currChar) == null){
        charCounter.put(currChar, 1);
      }else{
        charCounter.put(currChar, charCounter.get(currChar) + 1);
      }
      //if no, add char as key with value of 1
      //if yes, increment char's value by 1      
    }
    
    
    //c:1, u: 1, t: 1, o: 2
    
    int oddCounter = 0;
    //iterate over map, checking each key's value
    for(Integer occurs : charCounter.values()){
      if(occurs%2 != 0) oddCounter++;
      if(oddCounter > 1) return false;
    }
    
    return true;
  
  }
  
  /*
   * sortedBitSearch
   *
   * Write a function that accepts an int array of 0's and 1's and returns the number of 1's
   * in the array
   */
  
  public static int sortedBitSearch(int[] bitArray){
    
    
    if(bitArray[0] == 1) return bitArray.length;
    
    
    //tracks if last 0 found
    boolean lastZero = false;
    
    int currPointer = bitArray.length/2;
    int prevPointer = currPointer - 1;
    
    while(!lastZero && currPointer < bitArray.length){
      if(bitArray[currPointer] == 1 && bitArray[prevPointer] == 0){ //last zero found, can compute # of 1's
        lastZero = true; 
      }else if(bitArray[currPointer] == 1){ //move left
        currPointer--;
        prevPointer--;
      }else{ //if currPointer is 0, move right
        prevPointer = currPointer;
        currPointer++;
      }
    }
    
    return bitArray.length - currPointer;
  
  }
  
  public static void main (String[] args) {
    int[] test1 = {0,0,0,0,0,1,1,1}; //length == 8
    int[] test2 = {0,1,1,1,1,1,1,1};
    int[] test3 = {1,1,1,1,1,1,1,1};
    int[] test4 = {0,0,0,0,0,0,0,0};


    System.out.println(sortedBitSearch(test1)); // 3
    System.out.println(sortedBitSearch(test2));
    System.out.println(sortedBitSearch(test3));
    System.out.println(sortedBitSearch(test4));


    // System.out.println(anagramPalindrome("carrace")); // true
    // System.out.println(anagramPalindrome("cutoo")); // false
  }
}


