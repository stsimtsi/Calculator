package com.example.simplecalculator;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.app.Activity;
        import android.speech.tts.TextToSpeech;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Locale;


public class MainActivity extends Activity {
private TextToSpeech textToSpeech;
private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_android_example);
        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result = textToSpeech.setLanguage(Locale.US);;
                }else{
                    Toast.makeText(getApplicationContext(), "Feature is no available on this device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final TextView output 		= (TextView) findViewById(R.id.output);
        final Button bparsejson      = (Button) findViewById(R.id.bparsejson);
        final Button bparsejson2      = (Button) findViewById(R.id.bparsejson2);
        /************  Static JSON data ***********/
        final String strJson = "{ \"Profiles\" :[{\"color\":\"black\",\"Font_Size\":\"34\",\"Font\":\"MONOSPACE\",\"background\":\"white\",\"texttospeach\":\"true\", \"B_color\":\"#ff385f\",\"B_tcolor\":\"white\",\"B_tsize\":\"20\"},{\"color\":\"white\",\"Font_Size\":\"22\",\"Font\":\"Arial\",\"background\":\"#4f4e4e\",\"texttospeach\":\"false\",\"B_color\":\"#aaaaaa\",\"B_tcolor\":\"white\",\"B_tsize\":\"15\"}] }";

        //String dataToBeParsed = "Click on button to parse JSON.\n\n JSON DATA : \n\n"+strJson;
        //output.setText(dataToBeParsed);

        /******** Listener for button click ********/
        bparsejson.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {




                String OutputData = "";
                JSONObject jsonResponse;

                try {

                    /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                    jsonResponse = new JSONObject(strJson);

                    /***** Returns the value mapped by name if it exists and is a JSONArray. Returns null otherwise.*******/
                    JSONArray jsonMainNode = jsonResponse.optJSONArray("Profiles");

                    /*********** Process each JSON Node ************/
                    int lengthJsonArr = jsonMainNode.length();
                    // for(int i=0;i<lengthJsonArr;i++)
                    // {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(0);

                    /******* Fetch node values **********/
                    int fs = Integer.parseInt(jsonChildNode.optString("Font_Size").toString());
                    String Fcolor = jsonChildNode.optString("color").toString();
                    String Ffont = jsonChildNode.optString("Font").toString();
                    String bg = jsonChildNode.optString("background").toString();
                    boolean tts = Boolean.parseBoolean(jsonChildNode.optString("texttospeach").toString());
                    String Bcolor = jsonChildNode.optString("B_color").toString();
                    String Btcolor = jsonChildNode.optString("B_tcolor").toString();
                    int Btsize = Integer.parseInt(jsonChildNode.optString("B_tsize").toString());

                   // OutputData += "Node : \n\n     " + fs + " | "
                      //      + Fcolor + " | "
                       //     + bg + " | "
                        //    + tts + " | "
                        //    + Ffont + " \n\n ";
                    //Log.i("JSON parse", Fcolor);
                    //}

                    /************ Show Output on screen/activity **********/

                    //output.setBackgroundColor(Color.parseColor(bg));
                    //output.setTextColor(Color.parseColor(Fcolor));
                   // output.setTextSize(fs);
                    //output.setText(OutputData);


//                        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                            Toast.makeText(getApplicationContext(), "Feature is not anailable on this device", Toast.LENGTH_SHORT).show();
//                        } else {
//                            textToSpeech.speak("gamoo to spitaki soyyy", TextToSpeech.QUEUE_FLUSH, null);
//                        }
                   // startActivity(new Intent(MainActivity.this, MainActivity2.class));
                   // if(tts) {
                    //    textToSpeech.speak("On the screen there is an empty textfield that is named number 1 , an empty textfield that is named number 2 ," +
                    //            " a button with the name add, a button with the name substract , a button with the name multiply and a button with the name divide  ", TextToSpeech.QUEUE_FLUSH, null);
                  //  }

                    Intent activity2 = new Intent (MainActivity.this, MainActivity2.class);
                    activity2.putExtra("back",bg);
                    activity2.putExtra("fontsize",fs);
                    activity2.putExtra("fontcolor",Fcolor);
                    activity2.putExtra("font",Ffont);
                    activity2.putExtra("txts",tts);
                    activity2.putExtra("bcolor",Bcolor);
                    activity2.putExtra("btcolor",Btcolor);
                    activity2.putExtra("btsize",Btsize);
                    startActivity (activity2);


                } catch (JSONException e){

                    e.printStackTrace();
                }

            }
        });
        bparsejson2.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                String OutputData = "";
                JSONObject jsonResponse;

                try {

                    /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                    jsonResponse = new JSONObject(strJson);

                    /***** Returns the value mapped by name if it exists and is a JSONArray. Returns null otherwise.*******/
                    JSONArray jsonMainNode=jsonResponse.optJSONArray("Profiles");

                    /*********** Process each JSON Node ************/
                    int lengthJsonArr = jsonMainNode.length();
                    // for(int i=0;i<lengthJsonArr;i++)
                    // {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(1);

                    /******* Fetch node values **********/
                    int fs 		= Integer.parseInt(jsonChildNode.optString("Font_Size").toString());
                    String Fcolor	= jsonChildNode.optString("color").toString();
                    String Ffont 	= jsonChildNode.optString("Font").toString();
                    String bg 	= jsonChildNode.optString("background").toString();
                    boolean tts = Boolean.parseBoolean(jsonChildNode.optString("texttospeach").toString());
                    String Bcolor = jsonChildNode.optString("B_color").toString();
                    String Btcolor = jsonChildNode.optString("B_tcolor").toString();
                    int Btsize = Integer.parseInt(jsonChildNode.optString("B_tsize").toString());

                    /*OutputData += "Node : \n\n     "+ fs +" | "
                            + Fcolor +" | "
                            + bg +" | "
                            + tts +" | "
                            + Ffont +" \n\n ";*/
                    //Log.i("JSON parse", Fcolor);
                    //}

                    /************ Show Output on screen/activity **********/
                    /*output.setBackgroundColor(Color.parseColor(bg));
                    output.setTextColor(Color.parseColor(Fcolor));
                    output.setTextSize(fs);
                    output.setText(OutputData);*/
                   // if(tts) {
                      //  textToSpeech.speak("On the screen there is an empty textfield that is named number 1 , an empty textfield that is named number 2 ," +
                             //   " a button with the name add, a button with the name substract , a button with the name multiply and a button with the name divide  ", TextToSpeech.QUEUE_FLUSH, null);
                   // }
                    Intent activity2 = new Intent (MainActivity.this, MainActivity2.class);
                    activity2.putExtra("back",bg);
                    activity2.putExtra("fontsize",fs);
                    activity2.putExtra("fontcolor",Fcolor);
                    activity2.putExtra("font",Ffont);
                    activity2.putExtra("txts",tts);
                    activity2.putExtra("bcolor",Bcolor);
                    activity2.putExtra("btcolor",Btcolor);
                    activity2.putExtra("btsize",Btsize);
                    startActivity (activity2);

                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }
        });




    }
}
