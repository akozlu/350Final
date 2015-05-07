package fahim.hupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;


public class PatientActivity extends Activity {
    private String username;
    TextView name;
    TextView email;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_patient);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        ParseQuery query = ParseUser.getQuery();
        query.whereEqualTo("username",username);
        query.getFirstInBackground(new GetCallback<ParseUser>() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null){
                    email = (TextView) findViewById(R.id.patientEmail);
                    name = (TextView) findViewById(R.id.patientName);
                    phone = (TextView) findViewById(R.id.patientNumber);
                    phone.setText(user.getString("phoneNumber"));
                    name.setText(user.getString("fullName"));
                    email.setText(user.getEmail());
                }

            }
        });

    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient, menu);
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

    public void onPhotosClick(View view){
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void onSurveysClick(View view){
        Intent intent = new Intent(this, SurveyViewActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void onConcernsClick(View view){
        Intent intent = new Intent(this, ConcernViewActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
