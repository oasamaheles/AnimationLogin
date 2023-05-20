package com.example.animationlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.animationlogin.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;
    private ValueAnimator valueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        valueAnimator = ValueAnimator.ofInt(0,50,0,0,-50,0);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                int animated_value =(int)animation.getAnimatedValue();
                binding.linear.setTranslationX(animated_value);
            }
        });

        binding.btAnmationLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG","onClick: ");
                        String email = binding.emailEditText.getText().toString();
                        String password = binding.passwordEditText.getText().toString();

                        if (isValidEmail(email) && isValidPassword(password)) {
                            // Both email and password are valid
                            // Proceed with login logic here
                        } else if (email.isEmpty()&&password.isEmpty()) {
                            valueAnimator.start();
                        }


            }
        });

    }

    public boolean isValidEmail(String email) {
        // Email pattern regex
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        // Check if the email matches the pattern
        return Pattern.matches(emailPattern, email);
    }

    public boolean isValidPassword(String password) {
        // Define your password validation criteria
        int minimumLength = 8; // Minimum length of the password

        // Perform the password validation
        return password.length() >= minimumLength;
    }

}