package week2LabPractical3;//my package name

//Author: Myint Zu
//Date: 04.10.2025
//Program Title: E-Learning Quiz System

//import
import java.util.Scanner;

//abstraction
abstract class Quiz {
	String title;
	int numQuestions;
	String difficulty;
	
	Quiz(String title, int numQuestions, String difficulty) {
		this.title = title;
		this.numQuestions = numQuestions;
		this.difficulty = difficulty;
	}
	//abstract method (overridden)
	abstract int calculateScore(int correctAnswer);
	
	void showSummary(int score) {
		System.out.println("\n===Quiz Summary===");
		System.out.println("Title: "+ title);
		System.out.println("Difficulty: "+ difficulty);
		System.out.println("Questions: "+ numQuestions);
		System.out.println("Final Score: "+ score + "%");
	}
}
//inheritance, polymorphism
class MCQQuiz extends Quiz {
	MCQQuiz(String title, int numQuestions, String difficulty) {
		super(title, numQuestions, difficulty);
	}
	@Override
	int calculateScore(int correctAnswers) {
		//correct answer = 5marks
		return (correctAnswers*5);
	}
}
class TrueFalseQuiz extends Quiz {
	TrueFalseQuiz(String title, int numQuestions, String difficulty) {
		super(title, numQuestions, difficulty);
	}
	@Override
	int calculateScore(int correctAnswers) {
		//correct answer = 10marks
		return (correctAnswers*10);
	}
}

//main class , encapsulation
public class ELearningQuizSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//input
		System.out.print("Enter quiz title: ");
		String title = sc.nextLine();
		System.out.print("Enter difficulty (easy/medium/hard): ");
		String difficulty = sc.nextLine();
		System.out.print("Enter number of Questions: ");
		int num = sc.nextInt();		
		System.out.print("Choose type (1=MCQ, 2=True/False): ");
		int type = sc.nextInt();
		System.out.print("Enter number of correct answers: ");
		int correct = sc.nextInt();
		
		//polymorphism
		Quiz quiz;
		if (type == 1)
			quiz = new MCQQuiz(title, num, difficulty);
		else
			quiz = new TrueFalseQuiz(title, num, difficulty);
		
		int score = quiz.calculateScore(correct);
		quiz.showSummary(score);
		
		sc.close();
	}
}
