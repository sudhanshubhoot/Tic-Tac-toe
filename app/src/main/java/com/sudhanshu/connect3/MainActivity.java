package com.sudhanshu.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int acv_player = 0;
    boolean gamestatus = true;
    int[] gamestate = {3,3,3,3,3,3,3,3,3};
    int[][] winning_position = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        public void click (View view)
        {
            ImageView counter = (ImageView) view;
            int tappedcounter = Integer.parseInt(counter.getTag().toString());
            if (gamestate[tappedcounter] == 3&& gamestatus==true)
            {
                gamestate[tappedcounter]= acv_player;
                if (acv_player == 0) {
                    counter.setImageResource(R.drawable.img_2);
                    acv_player = 1;

                } else {
                    counter.setImageResource(R.drawable.img_1);
                    acv_player = 0;
                }
                for (int [] who_win : winning_position ){
                    if (gamestate[who_win[0]]==gamestate[who_win[1]] && gamestate[who_win[1]] == gamestate[who_win[2]]&&
                            gamestate[who_win[0]] != 3){
                        gamestatus = false;
                        String winner = "X";
                        if (gamestate[who_win[0]]==0){
                            winner = "O";
                        }
                        TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                        winnermessage.setText(winner + " has Won");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(view.VISIBLE);

                    }
                    else{
                        boolean gameIsOver= true;
                        for (int counterstate :gamestate ){
                            if (counterstate==3){
                                gameIsOver=false;
                            }
                        }
                        if (gameIsOver){
                            TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                            winnermessage.setText("It's a Tie");
                            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                            layout.setVisibility(view.VISIBLE);

                        }
                    }
                }

            }
        }
        public void playAgain(View view){
            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
            layout.setVisibility(view.INVISIBLE);
            acv_player = 0;
            gamestatus=true;
            for( int i=0; i<gamestate.length; i++)
            {
                gamestate[i]=3;
            }
            ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}