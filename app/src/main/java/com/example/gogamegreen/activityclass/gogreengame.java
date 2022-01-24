package com.example.gogamegreen.activityclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gogamegreen.R;

public class gogreengame extends AppCompatActivity {
    TextView questions, nextbutton,buttonA, buttonB, imagetext,restart;
    ImageView images;
    LinearLayout mcq_queslayout, imageslayout;
    RelativeLayout mcqresult;
    CardView mcqinfotag, cardoptA, cardoptB;
    int next = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gogreengame);

        restart =findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),gogreengame.class);
                startActivity(i);
            }
        });

        cardoptA = findViewById(R.id.cardoA);
        cardoptB = findViewById(R.id.cardoB);

        mcq_queslayout = findViewById(R.id.mcq_queslayout);
        imageslayout = findViewById(R.id.imageslayout);
        mcqresult = findViewById(R.id.mcq_result);
        mcqinfotag = findViewById(R.id.mcq_infotag);

        questions = findViewById(R.id.questions);
        buttonA = findViewById(R.id.btnA);
        buttonB = findViewById(R.id.btnB);
        images = findViewById(R.id.images);
        imagetext = findViewById(R.id.imagetxt);


        questions.setVisibility(View.VISIBLE);
        buttonA.setVisibility(View.VISIBLE);
        buttonB.setVisibility(View.VISIBLE);

        questions.setText("Hope you would love to have a morning tea.Isn't?\nSo which method do you prefer to have it?");
        buttonA.setText("Electric Induction");
        buttonB.setText("Gas Stove");

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cardoptA.setCardBackgroundColor(Color.GREEN);
                mcqinfotag.setVisibility(View.VISIBLE);
                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.cooking);

                imagetext.setVisibility(View.VISIBLE);
                imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment");
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cardoptB.setCardBackgroundColor(Color.RED);
                mcqinfotag.setVisibility(View.VISIBLE);
                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.cooking);

                imagetext.setVisibility(View.VISIBLE);
                imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
            }
        });

        nextbutton = findViewById(R.id.nextbtn);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next++;
                next();
            }
        });

    }

    private void next() {
        questions.setVisibility(View.GONE);
        buttonA.setVisibility(View.GONE);
        buttonB.setVisibility(View.GONE);
        imageslayout.setVisibility(View.GONE);
        images.setVisibility(View.GONE);
        imagetext.setVisibility(View.GONE);
        mcqinfotag.setVisibility(View.GONE);
//        cardoptA.setBackgroundColor(Color.WHITE);
//        cardoptB.setBackgroundColor(Color.WHITE);

        if(next == 1)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("Now like daily routine it's very obvious that you will rush towards your office.\nSo, which travel medium do you prefer for this?");
            buttonA.setText("Carpooling");
            buttonB.setText("Own Vehicle");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.vacation);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment");
                }
            });

            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.vacation);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
        }

        if(next == 2)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("It's lunch time guys..\nSo, what amount of food do you prefer to cook? ");
            buttonA.setText("In Excess Amount");
            buttonB.setText("In Limited Amount");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.extrafood);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.extrafood);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment\n");
                }
            });
        }

        if(next == 3)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("What kind of food do you prefer to cook?");
            buttonA.setText("Non-Vegeterian");
            buttonB.setText("Vegeterian");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.vegeterian);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.vegeterian);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment\n");
                }
            });
        }

        if(next == 4)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("Great one. It seems you are tired of working whole day their, isn't?\nSo it's time to take some break.\nWhich activity do you prefer in your rest time?");
            buttonA.setText("Gardening");
            buttonB.setText("Watching Web Series");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.gardening);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment\n");
                }
            });

            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.gardening);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
        }

        if(next == 5)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("Ok now lets suppose you wishes to have any beverages. Which type of carry bag do you prefer to have for it?");
            buttonA.setText("Recyclable");
            buttonB.setText("Non - Recyclable");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.recyclable);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment\n");
                }
            });

            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.recyclable);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
        }

        if(next == 6)
        {
            questions.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            questions.setText("When feeling hot, which option do you prefer to choose?");
            buttonA.setText("Fresh Air from Environment");
            buttonB.setText("CFC consumed Air Conditioner");

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptA.setCardBackgroundColor(Color.GREEN);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.freshair);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Correct Choice.\nDoing so you are contributing towards Green Environment\n");
                }
            });

            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    cardoptB.setCardBackgroundColor(Color.RED);
                    mcqinfotag.setVisibility(View.VISIBLE);
                    imageslayout.setVisibility(View.VISIBLE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.freshair);

                    imagetext.setVisibility(View.VISIBLE);
                    imagetext.setText("Not Satisfying!!\n Try to think something towards playing your part towards Green Environment");
                }
            });
        }

        if(next == 7)
        {
            mcq_queslayout.setVisibility(View.GONE);
            imageslayout.setVisibility(View.GONE);
            mcqinfotag.setVisibility(View.GONE);
            mcqresult.setVisibility(View.VISIBLE);
        }
    }
}