/*
ProjectMain is the class that runs all small projects that I am currently messing around with. 
Will contain many recursive solutions and attempts at less seen answers to potentially easy 
problems. This class currently runs a factorial calculator that utilizes user input as well as a
prime number generator that asks the user how many prime numbers he/she would like to generate.
*/

import java.util.*;

public class ProjectMain {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      // prime number generation, user cannot enter a negative number
      System.out.print("How many prime numbers would you like to print? ");
      int primes = input.nextInt();
      System.out.print("Printing the first " + primes + " Prime Numbers:");
      if (primes > 0) {
         int i = 0;
         int begin = 2;
         System.out.print(" " + 1);
         while (i < primes - 1) {
            int prime1 = checkAllMultiples(2, begin);
            if (prime1 != -1) {
               System.out.print(" " + prime1);
               i++;
            }  
            begin++; 
         } 
         System.out.println(); 
      }       
      
      // factorial computation
      System.out.print("What number would you like to get the factorial for? ");
      int num1 = input.nextInt();
      int factorial = factorialize(num1);
      System.out.println(num1 + "! = " + factorial);
   }
   
   // pre: given int fin cannot be negative.
   // post: determines if the given int fin is a prime number based on given int start.
   //       Returns either a prime number or a -1, indicating that the given int fin was not prime.
   private static int checkAllMultiples(int start, int fin) {
      if (start == fin) {
         return fin;
      } else if (fin % start != 0) {
         return checkAllMultiples(start + 1, fin);
      } else {
         return -1;
      }   
   }
   
   
   // pre: given int n cannot be less than 0 (throws IllegalArgumentException if so).
   // post: factorializes the given int n and returns final factorialized number. 
   private static int factorialize(int n) {
      if (n < 0) {
         throw new IllegalArgumentException();
      }
         
      if (n == 0 || n == 1) {
         return 1;
      } else {
         return n * factorialize(n - 1);
      }      
   }
}   