package fahim.hupproject;

/**
 * Created by Fahim on 3/25/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

public class LoginSignupActivity extends Activity {

    private String usernameText;
    private String passwordText;
    private EditText password;
    private EditText username;

//    private User u;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Get the view from main.xml
        setContentView(R.layout.loginsignup);

        // Locate EditTexts in main.xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }




    public void onLoginClick(View view){
            // Retrieve the text entered from the EditText
            usernameText = username.getText().toString();
            passwordText = password.getText().toString();

            // Send data to Parse.com for verification
            ParseUser.logInInBackground(usernameText, passwordText,
                    new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {

                                if(user.getString("LoginType").equals("patient")) {
                                    // If user exist and authenticated, send user to Welcome.class
                                    Intent intent = new Intent(LoginSignupActivity.this,
                                            Welcome.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in as a patient.",
                                            Toast.LENGTH_LONG).show();

                                } else {
                                    Intent intent = new Intent (LoginSignupActivity.this,
                                            PracitionerActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in as a practitioner.",
                                            Toast.LENGTH_LONG).show();
                                }





                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "No such user exists. Please sign up.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
    }



    public void onSignUpClick(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}