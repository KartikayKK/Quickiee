package com.example.quickiee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.ToggleButton;

public class imp extends AppCompatActivity {
    SeekBar seekBar;
    TextView time;
    Button butt;
    ImageView yo;
    Button go;
    Switch call;
    Switch job;
    String taskTodo="SOMETHING";
    String help;
    EditText task;
    EditText num;
    static int timetext=5;
    static int tune =1;
    private ActionMenuView toolbar;
    //New
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_imp);





        seekBar=findViewById(R.id.seekBar);
        time=findViewById(R.id.textView2);
        butt=findViewById(R.id.button3);
        call= findViewById(R.id.switch3);
        job=findViewById(R.id.switch4);
        go=findViewById(R.id.goo);
        seekBar.setMax(59);
        seekBar.setProgress(5);
//        seekBar.setMin(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                timetext=i+1;

                if (i>8){
                time.setText(String.valueOf(timetext));}
                else{
                    if (i==0) time.setText("01");
                    time.setText('0'+String.valueOf(timetext));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(imp.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog,null);
                 num= mView.findViewById(R.id.editText);
                 task=mView.findViewById(R.id.editText2);
                num.setText(String.valueOf(timetext));
                Button go =mView.findViewById(R.id.button_log);
                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        taskTodo=task.getText().toString();
                        help=num.getText().toString();
                        timetext=Integer.parseInt(help);
                        if (!num.getText().toString().isEmpty() && !task.getText().toString().isEmpty()){
//                            Toast.makeText(imp.this,taskTodo,Toast.LENGTH_LONG).show();
                            Intent intenti=new Intent(imp.this,NewApproach2.class);
                            intenti.putExtra("Task",taskTodo);
                            intenti.putExtra("Time",timetext);
                            startActivity(intenti);
                            finish();
                        }else{
                            Toast.makeText(imp.this,"Theek se karna",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setView(mView);
                AlertDialog dialog=builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();
            }
        });

        call.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                taskTodo="CAll/TEXT SOMEONE";
                System.out.println(taskTodo);

            }
        });
        job.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                taskTodo="A JOB TO DO";
                System.out.println(taskTodo);

            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intenti=new Intent(imp.this,NewApproach2.class);
                intenti.putExtra("Task",taskTodo);
                intenti.putExtra("Time",timetext);
                startActivity(intenti);
                finish();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ringtones, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.one) {
                tune=1;
            SharedPreferences editor = getSharedPreferences("Hello", MODE_PRIVATE);
            editor.edit().putInt("INT",tune).commit();
            //do something
            return true;
        }
        if (id == R.id.two) {
            tune=2;
            SharedPreferences editor = getSharedPreferences("Hello", MODE_PRIVATE);
            editor.edit().putInt("INT",tune).commit();

            //do something
            return true;
        }
        if (id == R.id.three) {
            tune=3;
            SharedPreferences editor = getSharedPreferences("Hello", MODE_PRIVATE);
            editor.edit().putInt("INT",tune).commit();
            //do something
            return true;
        }


        if (id == R.id.about) {


            final AlertDialog.Builder pbuilder = new AlertDialog.Builder(imp.this);
            View mView=getLayoutInflater().inflate(R.layout.about_dialog,null);
            pbuilder.setView(mView);
            ImageView yo=mView.findViewById(R.id.imageView4);
            final AlertDialog dialog=pbuilder.create();
            yo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();


            //do something
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
