package fahim.hupproject;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

/**
 * Created by RossMechanic on 4/30/15.
 */
public class PhotoAdapter extends ParseQueryAdapter {
    public PhotoAdapter(Context context, QueryFactory queryFactory) {
        super(context,  queryFactory);

    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent){
        if (v == null){
            v = View.inflate(getContext(), R.layout.photo ,null);
        }

        super.getItemView(object, v, parent);


        ParseImageView imageView = (ParseImageView) v.findViewById(R.id.wound);
        ParseFile imageFile =  object.getParseFile("photo");
        if (imageFile != null) {
            imageView.setParseFile(imageFile);
            imageView.loadInBackground();

        }else {
            Log.i("Image: ", "is null");
        }

        TextView textView = (TextView) v.findViewById(R.id.createDate);
        String dateCreated = object.getCreatedAt().toString();
        textView.setText(dateCreated);

        return v;
    }
}
