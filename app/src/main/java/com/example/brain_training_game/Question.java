package com.example.brain_training_game;

/**
 * Created by ACER on 2/25/2018.
 */

public class Question {

    private int diffLevel;
    private final String[] operator = {"*", "/", "+", "-"};
    private final int maxNum = 10;
    private String userQuestion;
    private int numberCount;
    private int correctAnswer;

    public Question(int level) {
        this.diffLevel = level;
        userQuestion = "Question:";
        correctAnswer = 999999;
    }

    public void start() {

        if(diffLevel == 0)
        {

            numberCount = 2; //novice level numberCount should be exactly 2
            createQuestion(numberCount);

        }

        else if(diffLevel == 1)
        {
            double number = Math.floor(Math.random() * 2 + 2);
            numberCount = (int) number;
            createQuestion(numberCount);

        }

        else if(diffLevel == 2)
        {
            double number = Math.floor(Math.random() * 3 + 2);
            numberCount = (int) number;
            createQuestion(numberCount);


        }

        else
        {

            double number = Math.floor(Math.random() * 3 + 4);
            numberCount = (int) number;
            createQuestion(numberCount);

        }

    }

    public void createQuestion(int numbers) {

        int i = 1, randomNumber, sign;
        double number;

        //first random number: 0 -> maximumNumber
        number = Math.floor(Math.random() * maxNum);
        randomNumber = (int) number;

        //adding the first random number to the question string and answer
        setQuestion(randomNumber);
        correctAnswer = randomNumber;

        while (i < numbers) {

            //generate random operation sign
            number = Math.floor(Math.random() * 4);
            sign = (int) number;
            //adding the sign to the final challenge expression
            setQuestion(operator[sign]);

            //random number: 0 -> maximumNumber
            randomNumber = generateNumber();

            if (operator[sign].equals("/"))
                while (randomNumber == 0)
                    randomNumber = generateNumber();

            /*
            * this basically means that if the sign is / (division),
            * then the following random number should not be 0
            */

            //adding the random number to the challenge string
            setQuestion(randomNumber);

            //add the operation and number to the final good answer
            setOriginalAnswer(operator[sign], randomNumber);

            i++;
        }

    }

    public String getQuestion() {
        return userQuestion;
    }

    public void setQuestion(String question) {
        this.userQuestion = userQuestion + question;
    }

    public void setQuestion(int number) {

        this.userQuestion = userQuestion + Integer.toString(number);
    }

    public int generateNumber() {
        //generate random number
        double number = Math.floor(Math.random() * maxNum);
        int randomNumber = (int) number;
        return randomNumber;
    }

    public void setOriginalAnswer(String operation, int number) {

       if(operation == "*")
       {
           correctAnswer = correctAnswer * number;
       }
        else if(operation == "/")
       {
           double set = (double) correctAnswer/ number;
           correctAnswer  = (int) Math.round(set);
       }

       else if(operation == "-")
       {
           correctAnswer = correctAnswer - number;
       }

       else
       {
           correctAnswer = correctAnswer + number;
       }

    }

    public int getOriginalAnswer() {
        return correctAnswer;
    }
}
