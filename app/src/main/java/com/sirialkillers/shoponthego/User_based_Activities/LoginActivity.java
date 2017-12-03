package com.sirialkillers.shoponthego.User_based_Activities;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.os.AsyncTask;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sirialkillers.shoponthego.Controllers.LoginController;
import com.sirialkillers.shoponthego.Maps_Related_Activities.MapsActivity;
import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.Models.AccountModel;
import com.sirialkillers.shoponthego.R;
import com.sirialkillers.shoponthego.Shop_Related_Activities.AddDiscountActivity;

import org.w3c.dom.Text;


public class LoginActivity extends AppCompatActivity {

    int loadtime=2000; // 2 seconds
    LoginValidation user;
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView mLogginInTextView;

    //Loading time
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.emailEditText);
        mLogginInTextView = (TextView) findViewById(R.id.loadingTextView);
        TextView signUpTextView = (TextView) findViewById(R.id.signUpTextView);

        mPasswordView = (EditText) findViewById(R.id.passwordEditText);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button manualLoginButton = (Button) findViewById(R.id.manualLoginButton);
        manualLoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        signUpTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUpActivity();
            }
        });
        mLoginFormView = findViewById(R.id.loginActivityConstrainLayout);
        mProgressView = findViewById(R.id.progressBar);
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        user = new LoginValidation(email,password);
        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.

        if (!user.isEmailNotEmpty()) {
            mEmailView.setError("This field is required");
            focusView = mEmailView;
            cancel = true;
        } else if (!user.isEmailValid()) {
            mEmailView.setError("Please enter a valid email.");
            focusView = mEmailView;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.


        // Check for a valid password, if the user entered one.
        if(!user.isPasswordNotEmpty()){
            mPasswordView.setError("This field is required");
            focusView = mPasswordView;
            cancel = true;}
        else if (!user.isPasswordLengthEnough()) {
            mPasswordView.setError("Your password should be at least 6 characters");
            focusView = mPasswordView;
            cancel = true;
        }
        //TODO check with database if the user is alright

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Loading();
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);


        }
    }



    /**
     * Shows the progress UI and hides the login form.
     */
    private void Loading() {
        mLoginFormView.setVisibility(View.INVISIBLE);
        mProgressView.setVisibility(View.VISIBLE);
        mLogginInTextView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent  intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);



            }
        },loadtime);
    }
    /**
     * Represents an asynchronous login task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {


            try {
                LoginController loginController = new LoginController();
                if(loginController.emailExists(mEmail)){
                    if(loginController.emailMatchesPassword(mEmail,mPassword))
                    {
                        //TODO: Login
                        Loading();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Your email and password do not match.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "The email "+mEmail+" do not exist.", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                return false;
            }
            //TODO: validate with database here
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {
                goToSignUpActivity();

            } else {
                Toast.makeText(LoginActivity.this, "Something went wrong! Please try again", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }

    public void goToSignUpActivity(){
        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);

    }

}
