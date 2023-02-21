package com.example.tablebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BookingActivity extends AppCompatActivity {
    TextView time;
    int t1Hour,t1Min;
    EditText editText0,editText6,person;
    Button map,book;
    ImageView  images;

    DatabaseReference databaseReference;
//private  SQLLiteHandler db;
    private final String url="htttp://10.0.2.2'/document_deep/db.insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction t=manager.beginTransaction();
        ProfileFragment pf=new ProfileFragment();

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Bookings");


        images=findViewById(R.id.images);
        time=findViewById(R.id.time);
        person=findViewById(R.id.person);
        editText0=findViewById(R.id.editText0);
        editText6=findViewById(R.id.editText6);
        map=findViewById(R.id.map);
        book=findViewById(R.id.book);

       // db=new SQLLiteHandler(getApplicationContext());
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText0.getText().toString();
                String phone=editText6.getText().toString();
                String times=time.getText().toString();
                String persons=person.getText().toString();
                String qrystring="?editText0"+name+"&editText6"+phone+"&time"+times+"&Person"+persons;

                insertData();
                class dbclass extends AsyncTask<String,Void,String> {
               /* if(!name.isEmpty()&&!phone.isEmpty()&&!times.isEmpty()){
                    registerUser(name,phone,times);
                }*/

                    protected  void  onPostExecute(String data){
                    editText0.setText("");
                    editText6.setText("");
                    time.setText("");
                        person.setText("");
                    }

                    @Override
                    protected String doInBackground(String... param) {
                        try {
                            URL url=new URL(param[1]);
                            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            return  br.readLine();
                        }catch (Exception e){
                            return  e.getMessage();
                        }


                    }
                }
                dbclass obj=new dbclass();

                obj.execute(url+qrystring);

                Intent intent =new Intent(BookingActivity.this,MiddleActivity.class );
                intent.putExtra("keyname",name);
                intent.putExtra("keyphone",phone);
                intent.putExtra("keytime",times);
                intent.putExtra("keyperson",persons);
                startActivity(intent);
            }

        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                TimePickerDialog timePickerDialog =new TimePickerDialog(BookingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hourofday, int min) {
                        t1Hour = Hourofday;
                        t1Min = min;

                        //initialize calander

                        Calendar calendar = Calendar.getInstance();

                        //set hour and mins

                        calendar.set(0, 0, 0, t1Hour, t1Min);

                          time.setText(String.format(Locale.getDefault(),"%02d:%02d",t1Hour,t1Min));
                    }
                },12,0,false
                );
                //Display preview

                    timePickerDialog.updateTime(t1Hour,t1Min);
                    timePickerDialog.show();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookingActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });
    }

  /*  private void registerUser(String name, String phone, String times) {
        StringRequest request=new StringRequest(Request.Method.POST, "http://10.10.2.2:80/DB_Function.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj=new JSONObject(response);
                    boolean error =jobj.getBoolean("error");
                    if(!error){
                        String id=jobj.getString("id");
                        JSONObject user=jobj.getJSONObject("user");

                        String name=user.getString("name");
                        String phone=user.getString("phone");
                        String created_at=user.getString("created_at");
                        String time=user.getString("time");

                        db.addUser(name,phone,id,created_at,time);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
                @Override
            protected Map<String,String> getParams(){
                    Map<String,String> params=new HashMap<String, String>();
                    params.put("tag","register");
                    params.put("name",name);
                    params.put("phone",phone);
                    params.put("time",times);
                    return  params;

                }

        };
        Volley.newRequestQueue(getApplicationContext()).add(request);
    }*/


//    public void popTimePicker(View view){
//        TimePickerDialog.OnTimeSetListener onTimeSetListener =new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int i, int i1) {
//                t1Hour = i;
//                t1Min = i1;
//                time.setText(String.format(Locale.getDefault(),"%02d:%02d",t1Hour,t1Min));
//            }
//        };
//        TimePickerDialog timePickerDialog=new TimePickerDialog(this,onTimeSetListener,t1Hour,t1Min,true);
//        timePickerDialog.setTitle("Select Time");
//        timePickerDialog.show();

    private  void insertData(){
        String name=editText0.getText().toString() ;
        String phone=editText6.getText().toString();
        String timing=time.getText().toString();
        String persons=person.getText().toString();

        modelclass m=new modelclass(name,phone,timing,persons);
        databaseReference.push().setValue(m);
    }
    }
