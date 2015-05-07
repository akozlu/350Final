package fahim.hupproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class SurveryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_survery);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_survery, menu);
        return true;
    }

    public void onUploadClick(View view){
        ParseObject survey = new ParseObject("Survey");
        // get selected radio button from different radio groups
        int question1ButtonId = ((RadioGroup)findViewById(R.id.question1radio)).getCheckedRadioButtonId();
        final String question1answer = (String)((RadioButton)findViewById(question1ButtonId)).getText();

        int question2ButtonId = ((RadioGroup)findViewById(R.id.question2radio)).getCheckedRadioButtonId();
        final String question2answer = (String)((RadioButton)findViewById(question2ButtonId)).getText();

        int question3ButtonId = ((RadioGroup)findViewById(R.id.question3radio)).getCheckedRadioButtonId();
        final String question3answer = (String)((RadioButton)findViewById(question3ButtonId)).getText();

        int question4ButtonId = ((RadioGroup)findViewById(R.id.question4radio)).getCheckedRadioButtonId();
        final String question4answer = (String)((RadioButton)findViewById(question4ButtonId)).getText();

        int question5ButtonId = ((RadioGroup)findViewById(R.id.question5radio)).getCheckedRadioButtonId();
        final String question5answer = (String)((RadioButton)findViewById(question5ButtonId)).getText();

        String question6answer = ((EditText)findViewById(R.id.question6_edit)).getText().toString();

        survey.put("User", ParseUser.getCurrentUser());
        survey.put("Question1",question1answer);
        survey.put("Question2",question2answer);
        survey.put("Question3",question3answer);
        survey.put("Question4",question4answer);
        survey.put("Question5",question5answer);
        survey.put("Question6",question6answer);
        survey.put("username", ParseUser.getCurrentUser().getUsername());

        survey.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    System.out.println("My object saved successfully.");
//                    if (question1answer.equals("Yes")
//                            || question2answer.equals("Yes")
//                            || question3answer.equals("Yes")
//                            || question4answer.equals("Yes")
//                            || question5answer.equals("Yes")){
//                        MainMenuActivity.setFlag();
//                    }
                } else {
                    System.out.println("My object failed to save.");
                    System.out.println(e.getMessage());
                }
            }
        });
        finish();

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
}
