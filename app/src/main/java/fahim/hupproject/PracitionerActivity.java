package fahim.hupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import java.text.ParseException;
import java.util.List;


public class PracitionerActivity extends Activity {
    private CustomAdapter patientAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_pracitioner);

        patientAdapter = new CustomAdapter(this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(patientAdapter);
        patientAdapter.loadObjects();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, int position, long id) {


                ParseUser selectedUser = (ParseUser) listView.getItemAtPosition(position);

                String username = selectedUser.getUsername();

//                ParseQuery query = ParseQuery.getQuery("Flag");
//                query.whereEqualTo("username",username);
//                query.getFirstInBackground(new GetCallback<ParseObject>() {
//                    @Override
//                    public void done(ParseObject parseObject, com.parse.ParseException e) {
//                        if (e == null){
//                            parseObject.put("new",false);
//                            parseObject.saveInBackground();
//                        }
//                    }
//                });
//                patientAdapter.loadObjects();
                Intent i = new Intent(getApplicationContext(), PatientActivity.class);
                i.putExtra("username",username);
                startActivity(i);

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pracitioner, menu);
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

    public void onLogoutClick(View view){
        ParseUser.logOut();
        finish();
    }





}
