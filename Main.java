package com.company;

import java.util.Scanner;
class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3;
        int currentRound = 1;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have to guess a number between 1 and 100.");

        while (currentRound <= totalRounds) {
            int targetNumber = getRandomNumber(minRange, maxRange);
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nRound " + currentRound + " of " + totalRounds);
            System.out.println("Round Score: " + score);

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    int roundScore = calculateRoundScore(attempts);
                    score += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too Low! Try Again!");
                } else {
                    System.out.println("Too High! Try Again");
                }

                if (attempts >= maxAttempts) {
                    System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            currentRound++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);
        scanner.close();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static int calculateRoundScore(int attempts) {
        if (attempts <= 3) {
            return 10;
        } else if (attempts <= 6) {
            return 5;
        } else {
            return 1;
        }
    }
}