package com.example.brain_training_game;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {


    public GameFragment() {
        // Required empty public constructor
    }


    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDel, bHash, bMinus,start_button;
    TextView question,user_answer,time,original_answer;
    private CountDownTimer gameTimer;
    private final int availableRounds = 10;
    private int noOfRounds = 0;
    private int tryCount = 0;
    private View rootView;
    private int hashClick = 0;
    private boolean continueGame = false;
    private AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =  inflater.inflate(R.layout.fragment_game, container, false);

        b1 = rootView.findViewById(R.id.b1);
        b2 = rootView.findViewById(R.id.b2);
        b3 = rootView.findViewById(R.id.b3);
        b4 = rootView.findViewById(R.id.b4);
        b5 = rootView.findViewById(R.id.b5);
        b6 = rootView.findViewById(R.id.b6);
        b7 = rootView.findViewById(R.id.b7);
        b8 = rootView.findViewById(R.id.b8);
        b9 = rootView.findViewById(R.id.b9);
        b0 = rootView.findViewById(R.id.b0);
        bDel = rootView.findViewById(R.id.bDel);
        bHash = rootView.findViewById(R.id.bHash);
        bMinus = rootView.findViewById(R.id.bMinus);
        start_button = rootView.findViewById(R.id.start);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "1");


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "2");


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0) set = "=";
                user_answer.setText(set + "0");
            }
        });

        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if (set.compareTo("=?") == 0)
                    set = "=";
                else if (!(set.compareTo("=") == 0))
                    set = set.substring(0, set.length() - 1);

                user_answer.setText(set);



            }
        });


        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_answer = (TextView) rootView.findViewById(R.id.user_answer);
                String set = (String) user_answer.getText();

                if(set.compareTo("=?") ==0 || set.compareTo("=") ==0)
                    set = "=-";

                user_answer.setText(set);
            }
        });




        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button startBtn = (Button) rootView.findViewById(R.id.start);
                startBtn.setVisibility(View.INVISIBLE);

                TextView timeLabel = (TextView) rootView.findViewById(R.id.time);
                String timeOnScreen = (String) timeLabel.getText();
                int time = Integer.parseInt(timeOnScreen.substring(0, timeOnScreen.indexOf(" ")));

                CountDownTimer timer = getMyTimer();
                if (timer != null)
                    timer.cancel();

                if (isContinueGame()) {
                    if (!anyStatusVisible()) {
                        doTimer(time);
                    }
                }

                else {
                    doTimer(time);
                }


            }
        });



        return  rootView;

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView txtHint = (TextView) rootView.findViewById(R.id.hints);
        int hint = Integer.parseInt((String) txtHint.getText());

        hashClick1();

        //region Switch Hints
          if(hint == 0)
        {
            if(anyStatusVisible())
                hashClick4();
            else
                hashClick3();
        }
        else
        {
            if(anyStatusVisible())
                hashClick2();
            else
                hashClick1();
        }

    }


    public void hashClick1()
    {

        hashClick = 1;

        bHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPossibleAnswer())
                {
                    //Return the answer by Comparing the User Answer and Correct Answer
                    int answer =  getCorrectAnswer();


                    //Cancel Timer
                    CountDownTimer timer = getMyTimer();

                    if (timer != null)
                        timer.cancel();

                    //Display correct or Wrong based on the Answer
                    setLabelVisible(answer);

                    //Display the Total Score to the at the end of the 10th Question
                    if(noOfRounds == availableRounds)
                        end();
                    else
                        hashClick = 2;
                        hashClick2();
                }

            }
        });


    }

    public void hashClick2()
    {
        hashClick = 2;

        bHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPossibleAnswer())
                {
                    if(noOfRounds == availableRounds)
                        end();

                    else
                    {
                        //Generate a New Question
                        getQuestion();
                        hashClick1();
                    }

                }


            }
        });



    }

    public void hashClick3()
    {
        hashClick = 3;

        bHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPossibleAnswer())
                {
                    int result = getCorrectAnswer();

                    if(tryCount < 3)
                        resultsWithHints(result);

                    else
                    {

                        CountDownTimer timer = getMyTimer();

                        if(timer!= null)
                            timer.cancel();

                        if(noOfRounds == availableRounds)
                            end();
                        else
                            getQuestion();

                    }

                }

            }
        });

    }

    public void hashClick4()
    {
        hashClick = 4;

        bHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPossibleAnswer())
                {
                    if(noOfRounds == availableRounds)
                        end();

                    else
                    {
                        getQuestion();
                        hashClick3();
                    }


                }


            }
        });


    }


    public void resultsWithHints(int result)
    {

        if(result == 0)
        {

            CountDownTimer timer = getMyTimer();

            if(timer != null)
                timer.cancel();

            setLabelVisible(result);

            getScore();

            if(noOfRounds == availableRounds)
                end();

            else
            {
                hashClick4();
            }

        }

        else if(result > 0)
        {

            CountDownTimer timer = getMyTimer();

            if(timer != null)
                timer.cancel();

            TextView myTextView;

            myTextView = (TextView) rootView.findViewById(R.id.wrong);
            myTextView.setVisibility(View.VISIBLE);

            //Display the "Less" Message when the User Answer is wrong and Less
            Toast toast = Toast.makeText(

                    getActivity().getApplicationContext(), "Less", Toast.LENGTH_SHORT
            );
            toast.show();

            tryCount++;

        }

        else
        {

            CountDownTimer timer = getMyTimer();

            if(timer != null)
                timer.cancel();

            TextView myTextView;


            myTextView = (TextView) rootView.findViewById(R.id.wrong);
            myTextView.setVisibility(View.VISIBLE);

            //Display the "Greater" Message when the User Answer is wrong and Greater
            Toast toast = Toast.makeText(

                    getActivity().getApplicationContext(), "Greater", Toast.LENGTH_SHORT
            );
            toast.show();

            tryCount++;

        }

    }


    private void end()
    {

        CountDownTimer timer = getMyTimer();
        if(timer != null)
        {

            timer.cancel();

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Well Done");

        TextView totalScore = (TextView) rootView.findViewById(R.id.score);

        String message = "Congratulations !. Your Final Score is " + (String) totalScore.getText();

        builder.setMessage(message);

        builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
            }
        });

        builder.setCancelable(false);
        dialog = builder.show();

    }


    public void doTimer(int miliseconds) {

        gameTimer = new CountDownTimer(miliseconds * 1000, 1000) {
            TextView time = (TextView) rootView.findViewById(R.id.time);

            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000 + " secs");
            }

            public void onFinish() {
                getQuestion();
            }
        }.start();
    }


    public void getQuestion()
    {
        setLabelInvisible();

        TextView txtLvl = (TextView) rootView.findViewById(R.id.game_level);
        int level = Integer.parseInt((String) txtLvl.getText());

        Question nextQuestion = new Question(level);
        nextQuestion.start();

        //Set the question to the TextView : question
        question = (TextView) rootView.findViewById(R.id.question);
        question.setText(nextQuestion.getQuestion());

        //Reset the user Answer to "=?"
        TextView user_answer = (TextView) rootView.findViewById(R.id.user_answer);
        user_answer.setText("=?");


        //Reset the try with Hint Count to 0
        tryCount = 0;

        // Save the correct answer to the TextView : original_answer
        original_answer = (TextView) rootView.findViewById(R.id.original_answer);
        original_answer.setText(Integer.toString(nextQuestion.getOriginalAnswer()));

        //Start a new Timer
        doTimer(10);

        //Increase the No of Question that user tried
        noOfRounds++;

    }

    public int  getCorrectAnswer()
    {
        int finalAnswer=0;


        TextView corr_ans = (TextView) rootView.findViewById(R.id.original_answer);
        TextView usr_ans = (TextView) rootView.findViewById(R.id.user_answer);

        String user_answer_rough = (String) usr_ans.getText();
        user_answer_rough = user_answer_rough.substring(1, user_answer_rough.length());

        int correct_answer = Integer.parseInt((String) corr_ans.getText());

        int user_answer = Integer.parseInt(user_answer_rough);

        finalAnswer = user_answer - correct_answer;


        return finalAnswer;

    }


    public boolean isPossibleAnswer()
    {

        TextView usr_ans = (TextView) rootView.findViewById(R.id.user_answer);
        String answer = (String) usr_ans.getText();

        if(answer.equals("=?") )
            return false;
        else if(answer.equals( "=-"))
            return false;
        else if(answer.equals("="))
            return false;
        else
            return true;

    }






    public void setLabelVisible(int answer)
    {
        TextView correct_label;
        TextView wrong_label;

        if(answer==0)
        {

            correct_label = (TextView) rootView.findViewById(R.id.correct);
            correct_label.setVisibility(View.VISIBLE);
            wrong_label = (TextView) rootView.findViewById(R.id.wrong);
            wrong_label.setVisibility(View.INVISIBLE);
            getScore();

        }

        else
        {
            wrong_label = (TextView) rootView.findViewById(R.id.wrong);
            wrong_label.setVisibility(View.VISIBLE);
            correct_label = (TextView) rootView.findViewById(R.id.correct);
            correct_label.setVisibility(View.INVISIBLE);

        }

    }

    public void setLabelInvisible()
    {

        TextView wrong_label,correct_label;

        wrong_label = (TextView) rootView.findViewById(R.id.wrong);
        wrong_label.setVisibility(View.INVISIBLE);
        correct_label = (TextView) rootView.findViewById(R.id.correct);
        correct_label.setVisibility(View.INVISIBLE);

    }

    public CountDownTimer getMyTimer() {
        return gameTimer;
    }


    public void getScore()
    {

        TextView score = (TextView) rootView.findViewById(R.id.score);
        TextView time = (TextView) rootView.findViewById(R.id.time);

        String stringScore = (String) score.getText();

        int colonIndex = stringScore.indexOf(":");

        int currentScore = Integer.parseInt(stringScore.substring(colonIndex + 1, stringScore.length()));


        String timer = (String) time.getText();
        int timeRemaining = Integer.parseInt(timer.substring(0, timer.indexOf(" ")));

        if (timeRemaining == 10)
            timeRemaining = 9;

        int newScore = (int) Math.round((double) 100 / (10 - timeRemaining));

        int finalScore = currentScore + newScore;
        score.setText("Score:" + Integer.toString(finalScore));

    }

    public boolean anyStatusVisible() {
        boolean anyVisible = false;
        TextView myTextView;

        myTextView = (TextView) rootView.findViewById(R.id.correct);
        if (myTextView.getVisibility() == View.VISIBLE)
            anyVisible = true;
        myTextView = (TextView) rootView.findViewById(R.id.wrong);
        if (myTextView.getVisibility() == View.VISIBLE)
            anyVisible = true;

        return anyVisible;
    }



    public String setState()
    {

        StringBuilder stringBuilder = new StringBuilder();

        //region to save current state values to a strings and append them to the StringBuilder

        TextView myView = (TextView) rootView.findViewById(R.id.question);
        String myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.game_level);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.score);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.user_answer);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.time);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.original_answer);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myString = Integer.toString(hashClick);

        stringBuilder.append(myString);
        stringBuilder.append(',');


        myView = (TextView) rootView.findViewById(R.id.correct);
        myString = Integer.toString(myView.getVisibility());

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myView = (TextView) rootView.findViewById(R.id.wrong);
        myString = Integer.toString(myView.getVisibility());

        stringBuilder.append(myString);
        stringBuilder.append(',');


        myView = (TextView) rootView.findViewById(R.id.hints);
        myString = (String) myView.getText();

        stringBuilder.append(myString);
        stringBuilder.append(',');

        myString = Integer.toString(noOfRounds);

        stringBuilder.append(myString);
        stringBuilder.append(',');





        return stringBuilder.toString();



    }

    public void putState(String gameData)
    {

        String[] textFields = gameData.split(",");
        int index = 0;

        //region to put the previous state values String Variables
        String question = textFields[index];
        index++;
        String gameLevel = textFields[index];
        index++;
        String score = textFields[index];
        index++;
        String usersAnswer = textFields[index];
        index++;
        String time = textFields[index];
        index++;
        String originalAnswer = textFields[index];
        index++;
        String hashClick = textFields[index];
        index++;
        String correctVisibility = textFields[index];
        index++;
        String wrongVisibility = textFields[index];
        index++;
        String strHint = textFields[index];
        index++;
        String noOfRounds = textFields[index];
        index++;


        //region to pass the previous state values to correspond methods
        restoreOriginalQuestion(question);
        restoreLevel(gameLevel);
        restoreScore(score);
        restoreUserAnswer(usersAnswer);
        restoreTime(time);
        restoreOriginalAnswer(originalAnswer);
        restoreCorrect(correctVisibility);
        restoreWrong(wrongVisibility);
        restoreNoOfRounds(noOfRounds);
        restoreHashClick(hashClick);
        restoreHint(strHint);
    }



    // Region to restore to the previous state to correspond TextViews and variables
    public void restoreNoOfRounds(String noOfRoundsLeft) {
        int number = Integer.parseInt(noOfRoundsLeft);
        noOfRounds = number;
    }

    public void restoreHint(String strHint)
    {

        TextView hint = (TextView) rootView.findViewById(R.id.hints);
        hint.setText(strHint);

    }

    public void restoreHashClick(String hasClick)
    {

        int hash = Integer.parseInt(hasClick);

        if(hash == 1)
            hashClick1();
        else if(hash == 2)
            hashClick2();
        else if(hash == 3)
            hashClick3();
        else
            hashClick4();

    }


    public void restoreWrong(String wrongVisibility) {
        int wrong = Integer.parseInt(wrongVisibility);
        TextView wrongView = (TextView) rootView.findViewById(R.id.wrong);

        switch (wrong) {
            case View.VISIBLE:
                wrongView.setVisibility(View.VISIBLE);
                break;
            default:
                wrongView.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void restoreCorrect(String correctVisibility) {
        int correct = Integer.parseInt(correctVisibility);
        TextView correctView = (TextView) rootView.findViewById(R.id.correct);

        switch (correct) {
            case View.VISIBLE:
                correctView.setVisibility(View.VISIBLE);
                break;
            default:
                correctView.setVisibility(View.INVISIBLE);
                break;
        }

    }

    public void restoreUserAnswer(String answer) {
        TextView Answer = (TextView) rootView.findViewById(R.id.user_answer);
        Answer.setText(answer);
    }

    public void restoreScore(String score) {
        TextView Score = (TextView) rootView.findViewById(R.id.score);
        Score.setText(score);
    }

    public void restoreOriginalQuestion(String quiz) {
        TextView question = (TextView) rootView.findViewById(R.id.question);
        question.setText(quiz);
    }

    public void restoreLevel(String level) {
        TextView lvl = (TextView) rootView.findViewById(R.id.game_level);
        lvl.setText(level);
    }

    public void restoreTime(String time) {
        TextView Time = (TextView) rootView.findViewById(R.id.time);
        Time.setText(time);
    }

    public void restoreOriginalAnswer(String goodAnswer) {
        TextView goodAnswerView = (TextView) rootView.findViewById(R.id.original_answer);
        goodAnswerView.setText(goodAnswer);
    }


    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

    public boolean isContinueGame()
    {
        return continueGame;

    }


}
