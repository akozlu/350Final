package fahim.hupproject;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by RossMechanic on 5/1/15.
 */
public class ConcernAdapter extends ParseQueryAdapter {
    public ConcernAdapter (Context context, ParseQueryAdapter.QueryFactory queryFactory){
        super(context,queryFactory);
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent){
        if (v == null){
            v = View.inflate(getContext(), R.layout.concern ,null);
        }

        super.getItemView(object, v, parent);

        TextView timeStampView = (TextView) v.findViewById(R.id.timeStamp);
        String timeStamp = "Submitted at: " + object.getCreatedAt().toString();
        timeStampView.setText(timeStamp);

        TextView textView = (TextView) v.findViewById(R.id.concern);
        String concern = object.getString("message");
        textView.setText(concern);

        return v;
    }

}
