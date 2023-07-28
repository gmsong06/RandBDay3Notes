import java.util.Scanner;

class WordGenerator {
    private static String[] wordList;
    
    WordGenerator(String[] wordList) {
    	this.wordList = wordList;
    }
    
    public String selectSecretWord() {
        // Code to randomly select a secret word from the wordList array
        int randomIndex = (int) (Math.random() * wordList.length);
        return wordList[randomIndex];
    }
}

class HangmanGame {
    private String secretWord;
    private char[] wordProgress;
    private int remainingAttempts;
    private int difficulty;
    private WordGenerator generator;
    
    public HangmanGame(int remainingAttempts, int difficulty) {
    	this.difficulty = difficulty;
    	if (this.difficulty == 0) {
    		String[] wordList = {"red", "orange"};
    		generator = new WordGenerator(wordList);
    	}
    	else if (this.difficulty == 1) {
    		String[] wordList = {"red", "orange"};
    		generator = new WordGenerator(wordList);
    	}
    	else if (this.difficulty == 2) {
    		String[] wordList = {"red", "orange"};
    		generator = new WordGenerator(wordList);
    	}
        this.secretWord = generator.selectSecretWord();
        initializeWordProgress(secretWord);
        this.remainingAttempts = remainingAttempts; // Set the maximum number of attempts
    }

    public void initializeWordProgress(String secretWord) {
        wordProgress = new char[secretWord.length()];
        for(int i = 0; i < wordProgress.length; i++) {
            wordProgress[i] = '_';
        }
    }

    public void play() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.println("The word contains " + secretWord.length() + " letters.");

        while (remainingAttempts > 0) {
            System.out.println("Word: " + String.valueOf(wordProgress));
            System.out.println("Attempts Remaining: " + remainingAttempts);

            System.out.println("Enter your guess:");
            char guess = s.next().charAt(0);

            boolean correctGuess = updateWordProgress(guess);

            if (correctGuess) {
                if (String.valueOf(wordProgress).equals(secretWord)) {
                    System.out.println("\nCongratulations! You guessed the word correctly: " + secretWord);
                    break;
                } else {
                    System.out.println("Good guess!");
                }
            } else {
                System.out.println("Incorrect guess!");
                remainingAttempts--;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("\nGame over! You ran out of attempts. The correct word was: " + secretWord);
        }
        s.close();
    }

    private boolean updateWordProgress(char guessedLetter) {
    	boolean correctGuess = false;
        
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedLetter) {
                wordProgress[i] = guessedLetter;
                correctGuess = true;
            }
        }
            
        return correctGuess;
    }
}

public class HangmanRestructured {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame(6, 1);
        game.play();
    }
}
