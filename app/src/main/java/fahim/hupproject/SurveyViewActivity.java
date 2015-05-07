package fahim.hupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;


public class SurveyViewActivity extends Activity {
    private SurveyAdapter surveyAdapter;
    private ListView listView;
    private ParseQueryAdapter.QueryFactory queryFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_survey_view);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");

        queryFactory = new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = ParseQuery.getQuery("Survey");
                query.whereEqualTo("Username",username);
                query.orderByDescending("createdAt");
                try {
                    TextView textView = (TextView) findViewById(R.id.noSurveys);
                    if (query.count() == 0) {
                        textView.setText("This user has yet to complete any surveys.");
                        textView.setVisibility(View.VISIBLE);
                    } else {
                        textView.setVisibility(View.INVISIBLE);
                    }

                } catch (ParseException e){
                    System.out.println("Error: " + e.getMessage());
                }
                return query;
            }
        };

        surveyAdapter = new SurveyAdapter(this,queryFactory);
        listView = (ListView) findViewById(R.id.surveyView);
        listView.setAdapter(surveyAdapter);
        surveyAdapter.loadObjects();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_survey_view, menu);
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
}
