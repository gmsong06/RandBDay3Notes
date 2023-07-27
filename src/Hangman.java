import java.util.*;

public class Hangman {
	public static final String[] easyWords = {"area", "army", "baby", "back", "ball", "band", "bank"};
	public static final String[] mediumWords = {"breathe", "trolley", "product", "deserve", "retiree"};
	public static final String[] hardWords = {"manufacturer", "spokesperson", "consultation", "jurisdiction", "compensation"};
	
	public static char[] wordProgress;
	public static int remainingAttempts = 6;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select difficult (0 = easy, 1 = medium, 2 = hard): ");
		
		int difficulty = sc.nextInt();
		
		String secretWord = selectSecretWord(difficulty); // calling selectSecretWord() returns a String
		
		
		initializeWordProgress(secretWord); // initialize length of wordProgress array and sets to _
		
		System.out.println("Welcome to Hangman!");
		System.out.println("The word contains " + secretWord.length() + " letters.");
		
		while(remainingAttempts > 0) {
			System.out.println("Word: " + String.valueOf(wordProgress));
			System.out.println("Attempts Remaining: " + remainingAttempts);
			
			System.out.println("Enter your guess: ");
			char guess = sc.next().charAt(0);
			
			boolean correctGuess = updateWordProgress(secretWord, guess);
			
			if (correctGuess) {
				if(String.valueOf(wordProgress).equals(secretWord)) {
					System.out.println("\n Congratulations! You guessed the word correctly: " + secretWord);
					break;
				}
				else {
					System.out.println("Good guess!");
				}
			}
			else {
				System.out.println("Incorrect guess");
				remainingAttempts--;
			}
		}
		
		if (remainingAttempts == 0) {
			System.out.println("\n Game over! You ran out of attempts. The correct word was: " + secretWord);
		}
	}
	
	public static String selectSecretWord(int difficulty) {
		if (difficulty == 0) {
			int randomIndex = (int) (Math.random() * easyWords.length);
			return easyWords[randomIndex];
		}
		else if (difficulty == 1) {
			int randomIndex = (int) (Math.random() * mediumWords.length);
			return mediumWords[randomIndex];
		}
		else if (difficulty == 2) {
			int randomIndex = (int) (Math.random() * hardWords.length);
			return hardWords[randomIndex];
		}
		else {
			return mediumWords[1];
		}
	}
	
	public static void initializeWordProgress(String secretWord) {
		wordProgress = new char[secretWord.length()];
		
		for(int i = 0; i < wordProgress.length; i++) {
			wordProgress[i] = '_';
		}
	}
	
	public static boolean updateWordProgress(String secretWord, char guessedLetter) {
		boolean correctGuess = false;
		
		for(int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i) == guessedLetter) {
				wordProgress[i] = guessedLetter;
				correctGuess = true;
			}
		}
		
		return correctGuess;
	}

}
