package com.netcom.netsmartapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String sname,smobile,semail,slocation;
    Boolean internet_check,validation_check;

//    final ProgressBar progressBar = findViewById(R.id.progressBar);
    TextInputEditText name ,mobile_no,email_id,location;
    Toolbar register_toolbar;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.temp_layout2);
            FirebaseApp.initializeApp(this);
            mAuth = FirebaseAuth.getInstance();
            submit_btn =findViewById(R.id.submit_btn);
            register_toolbar =findViewById(R.id.reg_toolbar);
            name =findViewById(R.id.nametext);
            mobile_no =findViewById(R.id.mobile_no);
            email_id =findViewById((R.id.emai_id));
            location =findViewById(R.id.location);
            register_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RegisterActivity.this, WelcomeActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
            }
        });
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                Toast.makeText(getApplicationContext(),"OTP has been sent", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HashMap<String, String> reg_data = new HashMap<String, String>();
                        reg_data.put("name", sname);
                        reg_data.put("mob_no", smobile);
                        reg_data.put("email_id", semail);
                        reg_data.put("location", slocation);
                        Intent in = new Intent(RegisterActivity.this, verify_otp_activity.class);
                        in.putExtra("auth", s);
                        in.putExtra("mobile", smobile);
                        in.putExtra("data_to_pass", reg_data);
                        startActivity(in);
                    }
                },1000);


            }
        };
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    internet_check=isConnected();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(internet_check)
                {
                    validation_check=registerValidationCheck();
                    if(validation_check){
                        sendToverify_otp_activity();
                    }
                    else{
                        return;
                    }

                }

                else if (internet_check==false)
                {
                    Toast.makeText(getApplicationContext(),"Please switch on your internet ",
                            Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    private void sendToverify_otp_activity() {
        HashMap<String, String> reg_data = new HashMap<String, String>();
        reg_data.put("name", sname);
        reg_data.put("mob_no", smobile);
        reg_data.put("email_id", semail);
        reg_data.put("location", slocation);

        String phoneNumber = "+91"+smobile;
//        progressBar.setVisibility(View.VISIBLE);
        submit_btn.setVisibility(View.INVISIBLE);

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(RegisterActivity.this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);


        Intent intent = new Intent(RegisterActivity.this, verify_otp_activity.class);
        intent.putExtra("mobile", smobile);
        intent.putExtra("data_to_pass", reg_data);

        startActivity(intent);

//        Intent intent = new Intent(RegisterActivity.this, boardActivity.class);
//        startActivity(intent);


    }

    private  Boolean registerValidationCheck() {

        sname = name.getText().toString().trim();
        smobile = mobile_no.getText().toString().trim();
        semail = email_id.getText().toString().trim();
        Boolean valid_email=isValidEmail(semail);
        slocation = location.getText().toString().trim();
        if (sname ==null || sname.isEmpty() || sname.equals("null"))
        {

            Toast.makeText(getApplicationContext(),"Please enter your name",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        else if (smobile ==null || smobile.isEmpty() || smobile.equals("null") || smobile.length()!=10){
            Toast.makeText(getApplicationContext(),"Please enter your mobile no",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        else if (semail ==null || semail.isEmpty() ) {
            Toast.makeText(getApplicationContext(),"Please enter your email id",
                    Toast.LENGTH_LONG).show();
            return false;



        }
        if(!valid_email)
        {
            Toast.makeText(getApplicationContext(),"Please enter your valid email id",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        else if (slocation.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter your location",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        else
        {
            return true;
        }


    }

    private boolean isValidEmail(String semail) {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9[!#$%&'()*+,/\\-_\\.\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\"\\.]]+");
        Matcher m = emailPattern.matcher(semail);
        return m.matches();

    }

    private Boolean isConnected()  throws InterruptedException, IOException {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
        }

