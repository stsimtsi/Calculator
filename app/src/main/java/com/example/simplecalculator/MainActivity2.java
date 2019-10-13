package com.example.simplecalculator;


  import android.app.Activity;
  import android.graphics.Color;
  import android.os.Bundle;
  import android.speech.tts.TextToSpeech;
  import android.view.KeyEvent;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.TextView;
  import android.widget.Toast;

  import java.util.Locale;

public class MainActivity2 extends Activity {
    private TextToSpeech textToSpeech;
    private int result1;
    EditText number1, number2;
          TextView result;
          Button addButton, subButton, mulButton, divButton, ttspeak, ttstop;

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech=new TextToSpeech(MainActivity2.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result1 = textToSpeech.setLanguage(Locale.UK);

                }else{
                    Toast.makeText(getApplicationContext(), "Feature is no available on this device", Toast.LENGTH_SHORT).show();
                }
            }
        });







        String bg = getIntent().getStringExtra("back");
        String Fcolor = getIntent().getStringExtra("fontcolor");
        String Ffont = getIntent().getStringExtra("font");
        int fs = getIntent().getIntExtra("fontsize",0);
        final boolean tts = getIntent().getBooleanExtra("txts",true);
        int Btsize=getIntent().getIntExtra("btsize",0);
        String Bcolor = getIntent().getStringExtra("bcolor");
        String Btcolor = getIntent().getStringExtra("btcolor");
       //rl.setBackgroundColor(Color.parseColor(bg));
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor(bg));







              //initialize variables
             number1 = (EditText)findViewById(R.id.number1);
              number2 = (EditText)findViewById(R.id.number2);
              result = (TextView)findViewById(R.id.result);
             addButton = (Button)findViewById(R.id.addButton);
             subButton = (Button)findViewById(R.id.subButton);
             mulButton = (Button)findViewById(R.id.mulButton);
              divButton = (Button)findViewById(R.id.divButton);
             ttspeak = (Button)findViewById(R.id.ttspeak);
        ttstop= (Button)findViewById(R.id.ttstop);
        final TextView textview1 = (TextView)findViewById(R.id.title1);
        final TextView n1 = (TextView)findViewById(R.id.num1);
        final TextView n2 = (TextView)findViewById(R.id.num2);
        final TextView r = (TextView)findViewById(R.id.res);
        final TextView nb1 = (TextView)findViewById(R.id.number1);
        final TextView nb2 = (TextView)findViewById(R.id.number2);
        final TextView rs = (TextView)findViewById(R.id.result);
           addButton.setBackgroundColor(Color.parseColor(Bcolor));
            addButton.setTextColor(Color.parseColor(Btcolor));
           addButton.setTextSize(Btsize);

        subButton.setBackgroundColor(Color.parseColor(Bcolor));
        subButton.setTextColor(Color.parseColor(Btcolor));
       subButton.setTextSize(Btsize);
        mulButton.setBackgroundColor(Color.parseColor(Bcolor));
        mulButton.setTextColor(Color.parseColor(Btcolor));
        mulButton.setTextSize(Btsize);
        divButton.setBackgroundColor(Color.parseColor(Bcolor));
        divButton.setTextColor(Color.parseColor(Btcolor));
        divButton.setTextSize(Btsize);
        ttspeak.setBackgroundColor(Color.parseColor(Bcolor));
        ttspeak.setTextColor(Color.parseColor(Btcolor));
        ttspeak.setTextSize(Btsize);
        ttstop.setBackgroundColor(Color.parseColor(Bcolor));
        ttstop.setTextColor(Color.parseColor(Btcolor));
        ttstop.setTextSize(Btsize);
        ttstop.setVisibility(View.GONE);



        textview1.setTextColor(Color.parseColor(Fcolor));
        textview1.setTextSize(fs);
        n1.setTextColor(Color.parseColor(Fcolor));
        n1.setTextSize(fs);
        n2.setTextColor(Color.parseColor(Fcolor));
        n2.setTextSize(fs);
        r.setTextColor(Color.parseColor(Fcolor));
        r.setTextSize(fs);
        nb1.setTextColor(Color.parseColor(Fcolor));
        nb1.setTextSize(fs);
        nb2.setTextColor(Color.parseColor(Fcolor));
        nb2.setTextSize(fs);
        rs.setTextColor(Color.parseColor(Fcolor));
        rs.setTextSize(fs);
        //textview1.setText(fs);
       // output.setBackgroundColor(Color.parseColor(bg));
        //output.setTextColor(Color.parseColor(Fcolor));
        // output.setTextSize(fs);
        //output.setText(OutputData);
               // setTextColor(Color.parseColor(Fcolor));

        //listener on SPEAK button

        if (tts) {


            number1.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() != KeyEvent.ACTION_DOWN)
                        return false;
                    char pressedKey = (char) event.getUnicodeChar();
                    textToSpeech.speak(String.valueOf(pressedKey), TextToSpeech.QUEUE_FLUSH, null);

                    return false;
                }
            });


            number2.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() != KeyEvent.ACTION_DOWN)
                        return false;
                    char pressedKey = (char) event.getUnicodeChar();
                    textToSpeech.speak(String.valueOf(pressedKey), TextToSpeech.QUEUE_FLUSH, null);

                    return false;
                }
            });
        }

        if(!tts){
            ttspeak.setVisibility(View.GONE);

        }







        ttspeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (result1 == TextToSpeech.LANG_MISSING_DATA || result1 == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(getApplicationContext(), "Feature is not anailable on this device", Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println("SOFIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIA");
                    ttstop.setVisibility(View.VISIBLE);
                    ttstop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            textToSpeech.stop();
                            ttstop.setVisibility(View.GONE);
                        }
                    });
                    textToSpeech.speak("On the screen there is an empty textfield that is named number 1 , an empty textfield that is named number 2 ," +
                            " a button with the name add, a button with the name substract , a button with the name multiply and a button with the name divide  ", TextToSpeech.QUEUE_FLUSH, null);


                }


            }
        });




              //listener on add button
             addButton.setOnClickListener(new View.OnClickListener() {

                                    @Override
                            public void onClick(View v) {
                                      // TODO Auto-generated method stub
                                    try{
                                              //String n1 = number1.getText().toString();
                                              //String n2 = number2.getText().toString();
                                              //String sum = String.valueOf(((Integer.parseInt(n1)) + (Integer.parseInt(n2))));
                                              float n1=Float.parseFloat(number1.getText().toString());
                                              float n2=Float.parseFloat(number2.getText().toString());
                                                float sum =n1+n2;

                                        result.setText(sum + " (Sum)");
                                        if(tts) {
                                            textToSpeech.speak("The result is " + sum, TextToSpeech.QUEUE_FLUSH, null);
                                        }
                                     }catch(Exception e){
                                          Toast.makeText(MainActivity2.this, "Please enter two numbers to calculate the sum", Toast.LENGTH_LONG).show();
                                        if(tts) {
                                            textToSpeech.speak("Please enter two numbers to calculate the sum", TextToSpeech.QUEUE_FLUSH, null);
                                        }
                                         e.printStackTrace();
                                    }




                               }
                      });


             //listener on sub button
             subButton.setOnClickListener(new View.OnClickListener() {

                              @Override
                             public void onClick(View v) {
                                      // TODO Auto-generated method stub
                                      try{
                                              //String n1 = number1.getText().toString();
                                             //String n2 = number2.getText().toString();
                                               //String sub = String.valueOf(((Integer.parseInt(n1)) - (Integer.parseInt(n2))));
                                          float n1=Float.parseFloat(number1.getText().toString());
                                          float n2=Float.parseFloat(number2.getText().toString());
                                          float sub =n1-n2;
                                              result.setText(sub + " (Subtraction)");
                                          if (tts)
                                          textToSpeech.speak("The result is "+ sub , TextToSpeech.QUEUE_FLUSH, null);
                                    }catch(Exception e){
                                         Toast.makeText(MainActivity2.this, "Please enter two numbers to calculate the subtraction", Toast.LENGTH_LONG).show();
                                          if(tts) {
                                              textToSpeech.speak("Please enter two numbers to calculate the subtraction", TextToSpeech.QUEUE_FLUSH, null);
                                          }
                                         e.printStackTrace();}
                                }
                   });

             //listener on mul button
              mulButton.setOnClickListener(new View.OnClickListener() {

                               @Override
                            public void onClick(View v) {
                                     // TODO Auto-generated method stub
                                     try{
                                             // String n1 = number1.getText().toString();
                                             // String n2 = number2.getText().toString();
                                              //String mul = String.valueOf(((Integer.parseInt(n1)) * (Integer.parseInt(n2))));
                                         float n1=Float.parseFloat(number1.getText().toString());
                                         float n2=Float.parseFloat(number2.getText().toString());
                                         float mul =n1*n2;
                                               result.setText(mul + " (Multiplication)");
                                         if(tts)
                                         textToSpeech.speak("The result is "+ mul , TextToSpeech.QUEUE_FLUSH, null);
                                     }catch(Exception e){
                                          Toast.makeText(MainActivity2.this, "Please enter two numbers to calculate the multiplication", Toast.LENGTH_LONG).show();
                                         if(tts) {
                                             textToSpeech.speak("Please enter two numbers to calculate the multiplication", TextToSpeech.QUEUE_FLUSH, null);
                                         }
                                          e.printStackTrace();
                                     }
                                }
                        });

             //listener on div button
              divButton.setOnClickListener(new View.OnClickListener() {

                  @Override
                             public void onClick(View v) {
                                     // TODO Auto-generated method stub
                                     try{
                                             // String n1 = number1.getText().toString();
                                             // String n2 = number2.getText().toString();
                                        // String div = String.valueOf(((Integer.parseInt(n1)) / (Integer.parseInt(n2))));
                                         float n1=Float.parseFloat(number1.getText().toString());
                                         float n2=Float.parseFloat(number2.getText().toString());
                                         float div =n1/n2;
                                              result.setText(div + " (Division)");
                                         if(tts)
                                         textToSpeech.speak("The result is "+ div , TextToSpeech.QUEUE_FLUSH, null);
                                    }catch(Exception e){
                                         Toast.makeText(MainActivity2.this, "Please enter two numbers to calculate the division", Toast.LENGTH_LONG).show();
                                         if(tts) {
                                             textToSpeech.speak("Please enter two numbers to calculate the division", TextToSpeech.QUEUE_FLUSH, null);
                                         }
                                          e.printStackTrace();
                                     }
                                 }
                        });
           }




              }


