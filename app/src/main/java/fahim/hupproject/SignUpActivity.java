package fahim.hupproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpActivity extends Activity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.emailAddress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSignUp(View view) {
        String firstNameText = firstName.getText().toString();
        String lastNameText = lastName.getText().toString();
        String emailText = email.getText().toString();
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        String numberText = phoneNumber.getText().toString();

        Log.i("First Name: ", firstNameText);
        Log.i("Last Name: ", lastNameText);
        Log.i("Email: ", emailText);
        Log.i("Username: ", usernameText);
        Log.i("Phone Number: ", numberText);

        if (firstNameText.equals("") || lastNameText.equals("") || emailText.equals("")
                || usernameText.equals("") || passwordText.equals("")){
            Toast.makeText(getApplicationContext(),
                    "Please fill in all of the required fields.",
                    Toast.LENGTH_LONG).show();
        } else {
            ParseUser user = new ParseUser();
            user.setUsername(usernameText);
            user.setPassword(passwordText);
            user.setEmail(emailText);
            user.put("phoneNumber", numberText);
            user.put("firstName", firstNameText);
            user.put("lastName", lastNameText);
            user.put("LoginType", "patient");
            user.put("disclaimer", false);
            user.put("fullName", firstNameText + " " + lastNameText);

            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // Show a simple Toast message upon successful registration
                        Toast.makeText(getApplicationContext(),
                                "You have successfully signed up. Please log in.",
                                Toast.LENGTH_LONG).show();
                        finish();
                        ParseObject flag = new ParseObject("Flag");
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Sign up Error", Toast.LENGTH_LONG)
                                .show();
                        Log.e("ERROR: ", e.getMessage());
                    }
                }
            });

        }

    }
}
