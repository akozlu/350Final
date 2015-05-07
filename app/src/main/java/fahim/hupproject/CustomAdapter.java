package fahim.hupproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by RossMechanic on 4/30/15.
 */
public class CustomAdapter extends ParseQueryAdapter{

    public CustomAdapter(Context context) {
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = ParseUser.getQuery();
                query.whereEqualTo("LoginType", "patient");
                query.orderByAscending("lastName");
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent){
        if (v == null){
            v = View.inflate(getContext(), R.layout.patient,null);
        }

        super.getItemView(object, v, parent);

        TextView nameTextView = (TextView) v.findViewById(R.id.fullName);
        nameTextView.setText(object.getString("fullName"));

//        final ImageView flag = (ImageView) v.findViewById(R.id.flag);
//        ParseQuery query = ParseQuery.getQuery("Flag");
//        query.whereEqualTo("username",object.getString("username"));
//        query.getFirstInBackground(new GetCallback<ParseObject>() {
//            public void done(ParseObject parseObject, ParseException e) {
//                if (e == null){
//                    boolean isFlagged = parseObject.getBoolean("new");
//                    if(isFlagged){
//                        flag.setVisibility(View.VISIBLE);
//                    } else {
//                        flag.setVisibility(View.INVISIBLE);
//                    }
//                }
//            }
//        });

        return v;
    }
}
