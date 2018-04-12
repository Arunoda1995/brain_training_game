package com.example.brain_training_game;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {



    private GameFragment gameFragment;
    private Handler handler = new Handler();
    public static final String KEY_RESTORE = "key_restore";
    public static final String PREF_RESTORE = "pref_restore";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        View root = findViewById(android.R.id.content);

        gameFragment = (GameFragment) getFragmentManager().findFragmentById(R.id.game_fragment);


        boolean restore = getIntent().getBooleanExtra(KEY_RESTORE, false);

        if (restore) {

            gameFragment.setContinueGame(true);

            String gameData = getPreferences(MODE_PRIVATE).getString(PREF_RESTORE, null);
            if (gameData != null) {
                gameFragment.putState(gameData);
            }

        }else{
            gameFragment.setContinueGame(false);

            String intentVal = getIntent().getStringExtra("difficultyLevel");

            String strHint = getIntent().getStringExtra("hints");

            int level = Integer.parseInt(intentVal);

            int hint = Integer.parseInt(strHint);


            //call Question class, start method to generate a user question
            Question firstQuestion = new Question(level);
            firstQuestion.start();


            //set the generated question to question TextView : question
            TextView txt = (TextView) root.findViewById(R.id.question);
            txt.setText(firstQuestion.getQuestion());

            //set hints On or Off which choose by the use to hidden textView : hints
            txt = (TextView) root.findViewById(R.id.hints);
            txt.setText(Integer.toString(hint));


            //set the difficulty level chose by the user to hidden TextView : game_level
            txt = (TextView) root.findViewById(R.id.game_level);
            txt.setText(Integer.toString(level));


            //set the original answer to hidden TextView : original_answer
            txt = (TextView) root.findViewById(R.id.original_answer);
            txt.setText(Integer.toString(firstQuestion.getOriginalAnswer()));


        }




    }


    protected void onPause() {
        super.onPause();

        CountDownTimer timer = gameFragment.getMyTimer();
        if(timer!=null) timer.cancel();

        handler.removeCallbacks(null);
        String gameData = gameFragment.setState();
        getPreferences(MODE_PRIVATE).edit()
                .putString(PREF_RESTORE, gameData)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
