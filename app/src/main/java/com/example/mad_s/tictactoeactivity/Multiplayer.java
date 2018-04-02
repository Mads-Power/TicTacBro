package com.example.mad_s.tictactoeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mad-s on 25.03.2018.
 */

public class Multiplayer extends Activity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btn_reset;

    private TextView player1;
    private TextView player2;
    private TextView txtViewInfo;

   int COUNT_TURN =0;

    private boolean playerTurn = true;

    int [][] boardStatus = new int[3][3];



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_activity);


        btn1 = findViewById(R.id.btn_01);
        btn2 = findViewById(R.id.btn_02);
        btn3 = findViewById(R.id.btn_03);
        btn4 = findViewById(R.id.btn_04);
        btn5 = findViewById(R.id.btn_05);
        btn6 = findViewById(R.id.btn_06);
        btn7 = findViewById(R.id.btn_07);
        btn8 = findViewById(R.id.btn_08);
        btn9 = findViewById(R.id.btn_09);

        btn_reset = findViewById(R.id.btn_reset);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btn_reset.setOnClickListener(this);

        txtViewInfo = findViewById(R.id.textView_info);

        //has X
        player1 = findViewById(R.id.txtplayer1);
        //has O
        player2 = findViewById(R.id.txtplayer2);

        initializeBoardStatus();

    }

    @Override
    public void onClick(View view) {

        boolean ifResetButtonPressed = false;

        switch (view.getId()) {
            case  R.id.btn_01:
                        if (playerTurn){
                            btn1.setText("X");
                            boardStatus[0][0] = 1;
                        }else {
                            btn1.setText("O");
                            boardStatus[0][0] = 0;
                        }btn1.setEnabled(false);
                        break;

            case R.id.btn_02:
                if (playerTurn){
                    btn2.setText("X");
                    boardStatus[0][1] = 1;
                }else {
                    btn2.setText("O");
                    boardStatus[0][1] = 1;

                }btn2.setEnabled(false);
                break;

            case R.id.btn_03:
                if (playerTurn) {
                    btn2.setText("X");
                    boardStatus[0][2] = 1;
                }
                    else {
                        btn3.setText("O");
                        boardStatus[0][2] = 0;

                    }btn3.setEnabled(false);
                    break;

                    //fdafd

            case R.id.btn_04:
                if (playerTurn) {
                    btn4.setText("X");
                    boardStatus[1][0] = 1;
                }
                else {
                    btn4.setText("O");
                    boardStatus[1][0] = 0;

                }btn4.setEnabled(false);
                break;

            case R.id.btn_05:
                if (playerTurn) {
                    btn5.setText("X");
                    boardStatus[1][1] = 1;
                }
                else {
                    btn5.setText("O");
                    boardStatus[1][1] = 0;

                }btn5.setEnabled(false);
                break;

            case R.id.btn_06:
                if (playerTurn) {
                    btn6.setText("X");
                    boardStatus[1][2] = 1;
                }
                else {
                    btn6.setText("O");
                    boardStatus[1][2] = 0;

                }btn6.setEnabled(false);
                break;

                //asda

            case R.id.btn_07:
                if (playerTurn) {
                    btn7.setText("X");
                    boardStatus[2][0] = 1;
                }
                else {
                    btn7.setText("O");
                    boardStatus[2][0] = 0;

                }btn7.setEnabled(false);
                break;

            case R.id.btn_08:
                if (playerTurn) {
                    btn8.setText("X");
                    boardStatus[2][1] = 1;
                }
                else {
                    btn8.setText("O");
                    boardStatus[2][1] = 0;

                }btn8.setEnabled(false);
                break;

            case R.id.btn_09:
                if (playerTurn) {
                    btn9.setText("X");
                    boardStatus[2][2] = 1;
                }
                else {
                    btn9.setText("O");
                    boardStatus[2][2] = 0;

                }btn9.setEnabled(false);
                break;

            case R.id.btn_reset:
                ifResetButtonPressed = true;
                default:
                break;

        }
        if (ifResetButtonPressed){
            resetBoard();
        }else {
            COUNT_TURN ++;
            playerTurn = ! playerTurn;

            if (playerTurn){
                setInfo("player 1 turn");
            }else {
                setInfo("Player 2 Turn");
            }
            if (COUNT_TURN == 9){
                result("GaME Draw");
            }
            checkForWinner();
        }

            }

    private void checkForWinner(){
         // sjekker horisontalt
        for (int i=0; i < 3; i++){
            if (boardStatus[i][0] == boardStatus[i][1] &&
                    boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0] == 1){
                    result("player X Winner \n" + (i+1)+ "row");
                    break;
                }else if (boardStatus[i][0] == 0){
                    result("player 0 Winner\n" + (i+1) + "row");
                    break;
                }

            }
        }
        // sjekker vertikalt
        for (int i = 0; i < 3; i++){
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i] == 1){
                    result("player x Winner\n" + (i+1) + " column");
                }else if (boardStatus[0][i] == 0){
                    result("player 0 Winner\n" + (i+1) + " column");
                    break;
                }
            }
        }
        //første diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("Player X winner\nFirst Diagonal");
            }
            else if (boardStatus[0][0]==0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //andre diagonal
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("Player X winner\nSecond Diagonal");
            }
            else if (boardStatus[0][2]==0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }


    private void result(String winner){
        setInfo(winner);
        enableAllBoxes(false);

    }
    private void enableAllBoxes(boolean value){

        btn1.setEnabled(value);
        btn2.setEnabled(value);
        btn3.setEnabled(value);

        btn4.setEnabled(value);
        btn5.setEnabled(value);
        btn6.setEnabled(value);

        btn7.setEnabled(value);
        btn8.setEnabled(value);
        btn9.setEnabled(value);
    }

    private void setInfo(String text){
        txtViewInfo.setText(text);
    }

    private void resetBoard() {

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");

        btn4.setText("");
        btn5.setText("");
        btn6.setText("");

        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        enableAllBoxes(true);

        playerTurn = true;
        COUNT_TURN = 0;

        initializeBoardStatus();

        setInfo("Start Again!!!");

    }

    private void initializeBoardStatus(){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }

    }

    }



