package fahim.hupproject;

/**
 * Created by Fahim on 3/25/15.
 */
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {

    // Declare Variable
//    Button logout;
    private boolean checked;
    private ParseUser currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Retrieve current user from Parse.com
        currentUser = ParseUser.getCurrentUser();
        boolean disclaimer = currentUser.getBoolean("disclaimer");
        if (disclaimer){
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        } else {

            setContentView(R.layout.welcome);
            checked = false;
        }


    }

    public void onCheckboxClicked(View view) {
        // Is terms and conditions checkbox checked?
        checked = ((CheckBox) view).isChecked();

    }

    public void onButtonClick(View view){

        if(checked){
            currentUser.put("disclaimer",true);
            Intent intent = new Intent(this,MainMenuActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Please confirm that you have read and understand " +
                    "the terms and conditions.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

}