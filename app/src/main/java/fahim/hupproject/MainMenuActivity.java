package fahim.hupproject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bolts.Task;


public class MainMenuActivity extends Activity {

    private NotificationManager notificationManager;
    private int notificationID = 100;
    private Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL,true);



        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);

        displayNotification();
        // Locate Button in welcome.xml
        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                ParseUser.logOut();
                finish();


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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



    private static final int TAKE_PICTURE = 1888;

    public void onCameraClick(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == TAKE_PICTURE){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte[] byteArray = stream.toByteArray();
            ParseObject image = new ParseObject("image");
            ParseFile imageFile = new ParseFile("photo.png",byteArray);
            ParseUser user = ParseUser.getCurrentUser();
            image.put("user", user);
            image.put("photo", imageFile);
            image.saveInBackground(new SaveCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        System.out.println("My object saved successfully.");
                    } else {
                        System.out.println("My object failed to save.");
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
    }



    public void onSurveyClick(View view){
        Intent intent = new Intent(this,SurveryActivity.class);
        startActivity(intent);
    }

    public void onFAQClick(View view){
        Intent intent = new Intent(this,FAQActivity.class);
        startActivity(intent);
    }

    protected void displayNotification(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_launcher);
        mBuilder.setContentTitle("Take your survey!");
        mBuilder.setContentText("Please take the time to complete a short survey" +
                " about your wound.");
        Intent resultIntent = new Intent(this,SurveryActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(SurveryActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID,mBuilder.build());
    }
//
//    public static void setFlag(){
//        ParseQuery flagQuery = new ParseQuery("Flag");
//        flagQuery.whereEqualTo("username",ParseUser.getCurrentUser().getUsername());
//        flagQuery.getFirstInBackground(new GetCallback<ParseObject>() {
//            public void done(ParseObject o, ParseException e) {
//                ParseACL acl = new ParseACL();
//                acl.setPublicWriteAccess(true);
//                acl.setPublicReadAccess(true);
//                if (e == null) {
//                    if (o == null) {
//                        ParseObject flag = new ParseObject("Flag");
//                        flag.put("username", ParseUser.getCurrentUser().getUsername());
//                        flag.put("new", true);
//                        flag.setACL(acl);
//                        flag.saveInBackground();
//                    }
//                    else {
//                        o.put("new",true);
//                        o.saveInBackground();
//                    }
//                } else {
//                    System.out.println("Error: " + e.getMessage());
//                    if (e.getMessage().equals("no results found for query")){
//                        ParseObject flag = new ParseObject("Flag");
//                        flag.put("username", ParseUser.getCurrentUser().getUsername());
//                        flag.put("new", true);
//                        flag.setACL(acl);
//                        flag.saveInBackground();
//                    }
//                }
//            }
//        });
//    }


    public void onConcernClick(View view){
        Intent intent = new Intent(this, ConcernActivity.class);
        startActivity(intent);
    }
}
