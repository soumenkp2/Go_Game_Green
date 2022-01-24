package com.example.gogamegreen.activityclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gogamegreen.R;

public class funfarm extends AppCompatActivity {

    ImageView t00, t01, t02, t03, t10, t11, t12, t13, t20, t21, t22, t23, t30, t31, t32, t33;
    CardView jasmine, sunflower, prinkle;
    TextView crops, flowers, trees;

    TextView score, sunscore, fertscore;

    int currscore = 0;
    int sunbank = 100;
    int fertbank = 100;

    int jasc = 2;
    int sunc = 1;
    int pric = 3;

    int jasstate=0;
    int sunstate=0;
    int pristate = 0;


    int cropstate = 0;
    int treestate = 0;
    int flowerstate = 0;

    int jasminesunintake = 8;
    int jasminefertintake = 23;
    int jasmineo2 = 15;

    int prinklesunintake = 19;
    int prinklefertintake = 20;
    int prinkleo2 = 18;

    int sunsunintake = 27;
    int sunfertintake = 18;
    int suno2 = 28;


    int [][] matrix;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfarm);

        matrix = new int[4][4];

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                matrix[i][j] = 0;
            }
        }



        //Referencing tiles
        t00 = (ImageView) findViewById(R.id.t00);
        t01 = (ImageView) findViewById(R.id.t01);
        t02 = (ImageView) findViewById(R.id.t02);
        t03 = (ImageView) findViewById(R.id.t03);

        t10 = (ImageView) findViewById(R.id.t10);
        t11 = (ImageView) findViewById(R.id.t11);
        t12 = (ImageView) findViewById(R.id.t12);
        t13 = (ImageView) findViewById(R.id.t13);

        t20 = (ImageView) findViewById(R.id.t20);
        t21 = (ImageView) findViewById(R.id.t21);
        t22 = (ImageView) findViewById(R.id.t22);
        t23 = (ImageView) findViewById(R.id.t23);

        t30 = (ImageView) findViewById(R.id.t30);
        t31 = (ImageView) findViewById(R.id.t31);
        t32 = (ImageView) findViewById(R.id.t32);
        t33 = (ImageView) findViewById(R.id.t33);

        //Referencing topics
        crops = (TextView) findViewById(R.id.crops);
        flowers = (TextView) findViewById(R.id.flowers);
        trees = (TextView) findViewById(R.id.trees);

        //Referemcimg objects
        jasmine = (CardView) findViewById(R.id.jasmine);
        sunflower = (CardView) findViewById(R.id.sunflower);
        prinkle = (CardView) findViewById(R.id.prinkle);

        //Referecing scores
        score = (TextView) findViewById(R.id.currentscore);
        sunscore = (TextView) findViewById(R.id.sun_bank);
        fertscore = (TextView) findViewById(R.id.fertilizers_bank);



        flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flowers.setBackgroundColor(Color.GREEN);
                jasmine.setVisibility(View.VISIBLE);
                sunflower.setVisibility(View.VISIBLE);
                prinkle.setVisibility(View.VISIBLE);

                flowerstate = 1;
                cropstate = 0;
                treestate = 0;
            }
        });

        jasmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jasmine.setCardBackgroundColor(Color.GREEN);
                sunflower.setCardBackgroundColor(Color.WHITE);
                prinkle.setCardBackgroundColor(Color.WHITE);

                jasstate = 1;
                sunstate =0;
                pristate = 0;

            }
        });

        sunflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jasmine.setCardBackgroundColor(Color.WHITE);
                sunflower.setCardBackgroundColor(Color.GREEN);
                prinkle.setCardBackgroundColor(Color.WHITE);

                jasstate = 0;
                sunstate =1;
                pristate = 0;
            }
        });

        prinkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jasmine.setCardBackgroundColor(Color.WHITE);
                sunflower.setCardBackgroundColor(Color.WHITE);
                prinkle.setCardBackgroundColor(Color.GREEN);

                jasstate = 0;
                sunstate = 0;
                pristate = 1;
            }
        });


        RelativeLayout last = (RelativeLayout) findViewById(R.id.last);
        TextView result = (TextView) findViewById(R.id.result);
        TextView restart = (TextView) findViewById(R.id.restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), funfarm.class);
                startActivity(i);
            }
        });


        //Clicking on any of the tile

        t00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[0][1]==0 && matrix[0][0]==0)
                        {sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][0] = 1;
                            matrix[0][1] = 1;

                            t00.setImageResource(R.drawable.jasmine);
                            t01.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {

                        if(matrix[0][0]==0 && matrix[1][0]==0 )
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][0] = 1;
                            matrix[1][0] = 1;

                            t00.setImageResource(R.drawable.prinkle);
                            t10.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {

                        if(matrix[0][0]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][0] = 1;

                            t00.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }



            }
        });

        t01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {
                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();

                        if(matrix[0][1]==0 && matrix[0][2]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][1] = 1;
                            matrix[0][2] = 1;

                            t01.setImageResource(R.drawable.jasmine);
                            t02.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {

                        if(matrix[0][1]==0 && matrix[1][1]==0 )
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][1] = 1;
                            matrix[1][1] = 1;

                            t01.setImageResource(R.drawable.prinkle);
                            t11.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {

                        if(matrix[0][1]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][1] = 1;

                            t01.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });

        t02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[0][2]==0 && matrix[0][3]==0)
                        {sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][2] = 1;
                            matrix[0][3] = 1;

                            t02.setImageResource(R.drawable.jasmine);
                            t03.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[0][2]==0 && matrix[1][2]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][2] = 1;
                            matrix[0][2] = 1;

                            t12.setImageResource(R.drawable.prinkle);
                            t02.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[0][2]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][2] = 1;

                            t02.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }


            }
        });

        t03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {
                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();


                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[0][3]==0 && matrix[1][3]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][3] = 1;
                            matrix[0][3] = 1;

                            t13.setImageResource(R.drawable.prinkle);
                            t03.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[0][3]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[0][3] = 1;

                            t03.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });


        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[1][0]==0 && matrix[1][1]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][1] = 1;
                            matrix[1][0] = 1;

                            t11.setImageResource(R.drawable.jasmine);
                            t10.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[1][0]==0 && matrix[2][0]==0)
                        { sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][0] = 1;
                            matrix[1][0] = 1;

                            t20.setImageResource(R.drawable.prinkle);
                            t10.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[1][0]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][0] = 1;

                            t10.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });


        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[1][1]==0 && matrix[1][2]==0)
                        {sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][2] = 1;
                            matrix[1][1] = 1;

                            t11.setImageResource(R.drawable.jasmine);
                            t12.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);
                        if(matrix[1][1]==0 && matrix[2][1]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));

                            matrix[1][1] = 1;
                            matrix[2][1] = 1;

                            t11.setImageResource(R.drawable.prinkle);
                            t21.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[1][1]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][1] = 1;

                            t11.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }


            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[1][2]==0 && matrix[1][3]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][2] = 1;
                            matrix[1][3] = 1;

                            t12.setImageResource(R.drawable.jasmine);
                            t13.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[1][2]==0 && matrix[2][2]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][2] = 1;
                            matrix[2][2] = 1;

                            t12.setImageResource(R.drawable.prinkle);
                            t22.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[1][2]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][2] = 1;

                            t12.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }



                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }
            }
        });

        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();


                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[1][3]==0 && matrix[2][3]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[1][3] = 1;
                            matrix[2][3] = 1;

                            t13.setImageResource(R.drawable.prinkle);
                            t23.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[1][3]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][3] = 1;

                            t02.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });




        t20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[2][0]==0 && matrix[2][1]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][1] = 1;
                            matrix[2][0] = 1;

                            t21.setImageResource(R.drawable.jasmine);
                            t20.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[2][0]==0 && matrix[3][0]==0)
                        { sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][0] = 1;
                            matrix[3][0] = 1;

                            t20.setImageResource(R.drawable.prinkle);
                            t30.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[2][0]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][0] = 1;

                            t20.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }


            }
        });


        t21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[2][1]==0 && matrix[2][2]==0)
                        {sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][2] = 1;
                            matrix[2][1] = 1;

                            t21.setImageResource(R.drawable.jasmine);
                            t22.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);
                        if(matrix[2][1]==0 && matrix[3][1]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));

                            matrix[3][1] = 1;
                            matrix[2][1] = 1;

                            t31.setImageResource(R.drawable.prinkle);
                            t21.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[2][1]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][1] = 1;

                            t21.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });

        t22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[2][2]==0 && matrix[2][3]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][2] = 1;
                            matrix[2][3] = 1;

                            t12.setImageResource(R.drawable.jasmine);
                            t13.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[2][2]==0 && matrix[3][2]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][2] = 1;
                            matrix[2][2] = 1;

                            t32.setImageResource(R.drawable.prinkle);
                            t22.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[2][2]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][2] = 1;

                            t22.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });

        t23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();


                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        if(matrix[2][3]==0 && matrix[3][3]==0)
                        {sunbank -= prinklesunintake;
                            fertbank -= prinklefertintake;
                            currscore += prinkleo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][3] = 1;
                            matrix[2][3] = 1;

                            t33.setImageResource(R.drawable.prinkle);
                            t23.setImageResource(R.drawable.prinkle);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[2][3]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[2][3] = 1;

                            t23.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });


        t30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[3][0]==0 && matrix[3][1]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][1] = 1;
                            matrix[3][0] = 1;

                            t31.setImageResource(R.drawable.jasmine);
                            t30.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);

                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[3][0]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][0] = 1;

                            t30.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });


        t31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[3][1]==0 && matrix[3][2]==0)
                        {sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][2] = 1;
                            matrix[3][1] = 1;

                            t31.setImageResource(R.drawable.jasmine);
                            t32.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[3][1]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][1] = 1;

                            t31.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });

        t32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {

                        //Toast.makeText(getApplicationContext(), "jasstate-1", Toast.LENGTH_SHORT).show();
                        if(matrix[3][2]==0 && matrix[3][3]==0)
                        { sunbank -= jasminesunintake;
                            fertbank -= jasminefertintake;
                            currscore += jasmineo2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][2] = 1;
                            matrix[3][3] = 1;

                            t32.setImageResource(R.drawable.jasmine);
                            t33.setImageResource(R.drawable.jasmine);


                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[3][2]==0)
                        {sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][2] = 1;

                            t32.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });

        t33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flowerstate==1)
                {
                    //Toast.makeText(getApplicationContext(), "flowerstate-1", Toast.LENGTH_SHORT).show();
                    if(jasstate==1 && pristate==0 && sunstate==0)
                    {


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();


                    }
                    else if(jasstate==0 && pristate==1 && sunstate==0)
                    {
                        //updatescore(19,20,18);


                        Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        //updatescore(27,18,20);

                        if(matrix[3][3]==0)
                        { sunbank -= sunsunintake;
                            fertbank -= sunfertintake;
                            currscore += suno2;
                            score.setText(String.valueOf(currscore));
                            sunscore.setText(String.valueOf(sunbank));
                            fertscore.setText(String.valueOf(fertbank));
                            matrix[3][3] = 1;

                            t02.setImageResource(R.drawable.sunflower);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "already filled", Toast.LENGTH_SHORT).show();
                        }
                    }

                }


                if(currscore>=100 && sunbank>=0 && fertbank>=0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You WON!");
                    result.setTextColor(Color.GREEN);

                }
                else if(sunbank<0 || fertbank<0)
                {
                    last.setVisibility(View.VISIBLE);
                    result.setText("You LOSE!");
                    result.setTextColor(Color.RED);
                }

            }
        });









    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void updatescore(int sunremain, int fertremain, int o2)
    {
        sunbank -= sunremain;
        fertbank -= fertremain;
        currscore += o2;


    }
}