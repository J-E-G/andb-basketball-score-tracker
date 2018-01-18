package com.example.android.basketballscoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamOne = 0;
    int scoreTeamTwo = 0;

    // Initialize variables for findViewById method
    TextView teamOneScoreView;
    TextView teamTwoScoreView;
    TextView teamOneGameOverMsg;
    TextView teamTwoGameOverMsg;

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
