package com.example.android.basketballscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Initialize global key/value pairs for save and restore states
    public static final String KEY_TEAM_ONE_SCORE = "KEY_TEAM_ONE_SCORE";
    public static final String KEY_TEAM_TWO_SCORE = "KEY_TEAM_TWO_SCORE";
    public static final String KEY_TEAM_ONE_GAME_OVER_MSG = "KEY_TEAM_ONE_GAME_OVER_MSG";
    public static final String KEY_TEAM_TWO_GAME_OVER_MSG = "KEY_TEAM_TWO_GAME_OVER_MSG";

    int scoreTeamOne = 0;
    int scoreTeamTwo = 0;

    // Initialize variables for findViewById method
    TextView teamOneScoreView;
    TextView teamTwoScoreView;
    TextView teamOneGameOverMsg;
    TextView teamTwoGameOverMsg;


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Assign the values of the saved data to local variables for onRestoreInstanceState
        String team_one_score = savedInstanceState.getString(KEY_TEAM_ONE_SCORE);
        String team_two_score = savedInstanceState.getString(KEY_TEAM_TWO_SCORE);
        String team_one_game_over_msg = savedInstanceState.getString(KEY_TEAM_ONE_GAME_OVER_MSG);
        String team_two_game_over_msg = savedInstanceState.getString(KEY_TEAM_TWO_GAME_OVER_MSG);


        if (savedInstanceState != null) {
            teamOneScoreView.setText(team_one_score); // Update Team One Score View
            teamTwoScoreView.setText(team_two_score); // Update Team Two Score View
            teamOneGameOverMsg.setText(team_one_game_over_msg); // Update Team One Game Over Msg
            teamTwoGameOverMsg.setText(team_two_game_over_msg); // Update Team Two Game OVer Msg

            /* Set Int values to prevent score reset on new point button press after restore */
            scoreTeamOne = Integer.parseInt(team_one_score); // Set int value for Team One Score
            scoreTeamTwo = Integer.parseInt(team_two_score); // Set Int value for Team Two Score
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Retrieve and Save the value of Team One Score View
        String team_one_saved_score = teamOneScoreView.getText().toString();
        outState.putString(KEY_TEAM_ONE_SCORE, team_one_saved_score);

        // Retrieve and Save the value of Team Two Score View
        String team_two_saved_score = teamTwoScoreView.getText().toString();
        outState.putString(KEY_TEAM_TWO_SCORE, team_two_saved_score);

        // Retrieve and Save the value of Team One Game Over Msg
        String team_one_saved_game_over_msg = teamOneGameOverMsg.getText().toString();
        outState.putString(KEY_TEAM_ONE_GAME_OVER_MSG, team_one_saved_game_over_msg);

        // Retrieve and Save the value of Team Two Game Over Msg
        String team_two_saved_game_over_msg = teamTwoGameOverMsg.getText().toString();
        outState.putString(KEY_TEAM_TWO_GAME_OVER_MSG, team_two_saved_game_over_msg);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variables for findViewById
        teamOneScoreView = findViewById(R.id.team_one_score);
        teamTwoScoreView = findViewById(R.id.team_two_score);
        teamOneGameOverMsg = findViewById(R.id.team_one_win_lose_msg);
        teamTwoGameOverMsg = findViewById(R.id.team_two_win_lose_msg);
    }

    // Display the score for Team One
    public void displayForTeamOne(int score) {
        teamOneScoreView.setText(String.valueOf(score));
    }

    // Add 3 Points for Team One
    public void addThreePointsForTeamOne(View v) {
        scoreTeamOne = scoreTeamOne + 3;
        displayForTeamOne(scoreTeamOne);
    }

    // Add Three Points for Team One
    public void addTwoPointsForTeamOne(View v) {
        scoreTeamOne = scoreTeamOne + 2;
        displayForTeamOne(scoreTeamOne);
    }

    // Add One Point for Team One
    public void addOnePointForTeamOne(View v) {
        scoreTeamOne = scoreTeamOne + 1;
        displayForTeamOne(scoreTeamOne);
    }

    // Display the score for Team Two
    public void displayForTeamTwo(int score) {
        teamTwoScoreView.setText(String.valueOf(score));
    }

    // Add 3 Points for Team Two
    public void addThreePointsForTeamTwo(View v) {
        scoreTeamTwo = scoreTeamTwo + 3;
        displayForTeamTwo(scoreTeamTwo);
    }

    // Add Three Points for Team Two
    public void addTwoPointsForTeamTwo(View v) {
        scoreTeamTwo = scoreTeamTwo + 2;
        displayForTeamTwo(scoreTeamTwo);
    }

    // Add One Point for Team Two
    public void addOnePointForTeamTwo(View v) {
        scoreTeamTwo = scoreTeamTwo + 1;
        displayForTeamTwo(scoreTeamTwo);
    }

    // Reset score for both teams
    public void resetScore(View v) {
        displayWinnerForTeamOne(getString(R.string.reset_score));
        displayWinnerForTeamTwo(getString(R.string.reset_score));
        scoreTeamOne = 0;
        scoreTeamTwo = 0;
        displayForTeamOne(scoreTeamOne);
        displayForTeamTwo(scoreTeamTwo);
    }

    // Display Win/Loss message for Team One
    public void displayWinnerForTeamOne(String message) {
        teamOneGameOverMsg.setText(message);
    }

    // Display Win/Loss message for Team Two
    public void displayWinnerForTeamTwo(String message) {
        teamTwoGameOverMsg.setText(message);
    }

    public void gameOver(View v) {
        if (scoreTeamOne > scoreTeamTwo) {
            displayWinnerForTeamOne(getString(R.string.win_msg));
            displayWinnerForTeamTwo(getString(R.string.lose_msg));
        } else if (scoreTeamTwo > scoreTeamOne) {
            displayWinnerForTeamOne(getString(R.string.lose_msg));
            displayWinnerForTeamTwo(getString(R.string.win_msg));
        } else if (scoreTeamOne == scoreTeamTwo) {
            displayWinnerForTeamOne(getString(R.string.draw_msg));
            displayWinnerForTeamTwo(getString(R.string.draw_msg));
        }
    }
}
