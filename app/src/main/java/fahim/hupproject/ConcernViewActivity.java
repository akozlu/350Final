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

import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;


public class ConcernViewActivity extends Activity {
    private ConcernAdapter concernAdapter;
    private ListView listView;
    private ParseQueryAdapter.QueryFactory queryFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_concern_view);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        queryFactory = new ParseQueryAdapter.QueryFactory() {
            @Override
            public ParseQuery create() {
                ParseQuery query = ParseQuery.getQuery("concern");
                query.whereEqualTo("username",username);
                try {
                    TextView empty = (TextView) findViewById(R.id.emptyList);
                    if (query.count() == 0){

                        empty.setText("This user has yet to submit any concerns.");
                        empty.setVisibility(View.VISIBLE);

                    } else {
                        empty.setVisibility(View.INVISIBLE);
                    }

                } catch (ParseException e){
                    System.out.println("Error: " + e.getMessage());
                }
                return query;
            }
        };

        concernAdapter = new ConcernAdapter(this, queryFactory);
        listView = (ListView) findViewById(R.id.concernView);
        listView.setAdapter(concernAdapter);
        concernAdapter.loadObjects();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_concern_view, menu);
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
