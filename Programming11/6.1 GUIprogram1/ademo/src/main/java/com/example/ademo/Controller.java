package com.example.ademo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Controller {

    public int Computer_target;  //computer generated target
    public int User_target;      // current user value
    public randA rand_generator = new randA(); // class for generating random number
    public Label UserNoValue, computerValueLabel, resultLabel;
    public Button moreButton, holdButton, ReplayButton, start_button;

    public void ShowReward(){
        /* Effects: 1) Compare user generated input (if <= 21) with the computer randomly generated
                    random value, and display corresponding Win/Lose messages
                    2) Disable more and hold buttons.
                    3) Enable the replay button
        */
        moreButton.setDisable(true);   // Disable More button
        holdButton.setDisable(true);   // Disable Hold button
        ReplayButton.setDisable(false); // Enable Replay button

        String Msg ; // this is the message to be displayed after game finishes
        if (User_target>21){
                  Msg = " You Lose. Your number exceeds the limit 21";
                  // this is the case when user number > 21
        }
        else{
            // Generate computer target
            Computer_target = rand_generator.computerNo();  // this generates a number between 16 and 21
            computerValueLabel.setText(String.valueOf(Computer_target));  // display computer's generated target in the field

            if (User_target <= Computer_target ){
                Msg = " You Lose. Your number did not exceed computer's target";
                // User's number is smaller. Losing message is displayed
            }
            else {
                Msg = "You Win. Your number exceeds computer's target";
                // User's number is larger. Winning message is displayed
            }

        }
        resultLabel.setText(Msg);   // Display the result message
    }
    public void onStartButtonClick() {
        /* Requires: mouse click on start button
           Effects: 1) generate the first user number
                    2) disable the start button
                    3) enable the more and hold buttons
        */

        User_target = rand_generator.newNo();    // generate the first number of user
        UserNoValue.setText(String.valueOf(User_target));  // display the random number
        resultLabel.setText("");   // hide result message
        moreButton.setDisable(false);  // enable the more button
        holdButton.setDisable(false);  // enable the hold button
        start_button.setDisable(true);  // once the start button clicked, disable the button.
    }
    public void onMoreButtonClick() {
        /*  Requires: Mouse click on the more button
            Effects: 1) Add user number with another random number
                     2) Invoke the ShowReward method if the user number exceeds 21.
        */

        User_target = User_target + rand_generator.newNo();   // Add a new random number to user's number
        UserNoValue.setText(String.valueOf(User_target));  // display the random number
        if (User_target>21){
           ShowReward();   // show result of the game.
        }

    }
    public void onHoldButtonClick() {
        /*  Requires: Mouse click on the hold button
            Effects: Call the ShowReward method
         */
        ShowReward();    // show result of the game
    }
    public void onReplayButtonClick() {
        /*  Requires: Mouse click on the replay button
            Effects:  the game (including all messages, and numbers) will be reset
        */
        User_target = rand_generator.newNo();    // generate the first number of user
        UserNoValue.setText(String.valueOf(User_target));  // display the random number
        moreButton.setDisable(false);  // Enable the more button
        holdButton.setDisable(false);  // Enable the hold button
        computerValueLabel.setText("Waiting to be generated");  // reset the computer number message
        resultLabel.setText(""); // reset the result message
    }
}