package fahim.hupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Determine whether the current user is an anonymous user

        if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {

            // If user is anonymous, send the user to LoginSignupActivity.class

            Intent intent = new Intent(MainActivity.this,
                    LoginSignupActivity.class);

            startActivity(intent);
            finish();

        } else {

            // If current user is NOT anonymous user
            // Get current user data from Parse.com

            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null) {

                // Send logged in users to MainMenuActivity.class

                // Debugging purposes changed to loginsignup
                // usually an already logged in user should be directed to welcome page
                if(currentUser.getString("LoginType").equals("patient")) {
                    ParseInstallation installation = ParseInstallation.getCurrentInstallation();
                    installation.put("LoginType","patient");
                    installation.saveInBackground();
                    Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    ParseInstallation installation = ParseInstallation.getCurrentInstallation();
                    installation.put("LoginType","practitioner");
                    installation.saveInBackground();
                    Intent intent = new Intent (MainActivity.this, PracitionerActivity.class);
                    startActivity(intent);
                    finish();
                }

            } else {

                // Send user to LoginSignupActivity.class
                Intent intent = new Intent(MainActivity.this,
                        LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }
}