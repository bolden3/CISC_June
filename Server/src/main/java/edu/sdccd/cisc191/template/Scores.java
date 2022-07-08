package edu.sdccd.cisc191.template;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Scores {
    private String name;
    private String name2;
    private int score;
    private int score2;
    String winner;
    private static ArrayList <Scores> scoreList = new ArrayList<Scores>();
    private Scores[] moreScores;

    public Scores () {
        this.name = "";
        this.name2 = "";
        this.score = 0;
        this.score2 = 0;
        this.winner = "";
    }
    public Scores (String name, String name2, int score, int score2, String winner){
        this.name = name;
        this.name2 = name2;
        this.score = score;
        this.score2 = score2;
        this.winner = winner;
    }
    public void newScores() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the first team name: ");
        this.name = scanner.next();
        System.out.println("");
        try{
        System.out.print("Input " + this.name + "'s score: ");
        this.score = scanner.nextInt();}
        catch (InputMismatchException i) {
            scanner.next();
            System.out.println("Invalid input, please input a number");
            this.score = scanner.nextInt();

        }
        System.out.println("");
        System.out.print("Input the second team's name: ");
        this.name2 = scanner.next();
        System.out.println("");
        try{
            System.out.print("Input " + this.name2 + "'s score: ");
            this.score2 = scanner.nextInt();
        }
        catch (InputMismatchException i) {
            scanner.next();
            System.out.println("Invalid input, please input a number");
            this.score2 = scanner.nextInt();

        }
        //if else to test who the winner is. Tie = 0, team 1 is 1, team 2 is 2.
        if(score == score2) {
            winner = "Tie!";
        }
        else if (score > score2) {
            this.winner = this.name;

        }
        else {
            this.winner = this.name2;

        }
        Scores toAdd = new Scores(this.name, this.name2, this.score, this.score2, this.winner);
        addScore(toAdd);


        //System.out.println(this.scoreList);
        System.out.println("Scores received!");
        System.out.println("To input another score, type 'n'");
        System.out.println("To check old scores, type 'o'");
        System.out.println("To quit, type 'q'");
        Server.menu();

        }
    public void addScore(Scores score) {
            this.scoreList.add(score);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public static ArrayList<Scores> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Scores> scoreList) {
        this.scoreList = scoreList;
    }

    public String toString() {
        System.out.println(name + ": " + score);
        System.out.println(name2 + ": " + score2);
        if(score == score2) {
            System.out.println(winner);
        }
        else {
            System.out.println("Winner was: " + winner);
        }
        return("");
    }



    }


