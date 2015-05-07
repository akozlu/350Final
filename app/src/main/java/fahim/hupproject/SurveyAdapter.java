package fahim.hupproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by RossMechanic on 5/1/15.
 */
public class SurveyAdapter extends ParseQueryAdapter {
    public SurveyAdapter (Context context, QueryFactory queryFactory){
        super (context,queryFactory);
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent){
        if (v == null){
            v = View.inflate(getContext(), R.layout.survey ,null);
        }

        super.getItemView(object, v, parent);

        TextView timeStampView = (TextView) v.findViewById(R.id.surveyTimeStamp);
        String timeStamp = "Submitted at: " + object.getCreatedAt().toString();
        timeStampView.setText(timeStamp);

        TextView question1 = (TextView) v.findViewById(R.id.viewQuestion1);
        TextView question2 = (TextView) v.findViewById(R.id.viewQuestion2);
        TextView question3 = (TextView) v.findViewById(R.id.viewQuestion3);
        TextView question4 = (TextView) v.findViewById(R.id.viewQuestion4);
        TextView question5 = (TextView) v.findViewById(R.id.viewQuestion5);
        TextView question6 = (TextView) v.findViewById(R.id.viewQuestion6);

        String answer1 = object.getString("Question1");
        String answer2 = object.getString("Question2");
        String answer3 = object.getString("Question3");
        String answer4 = object.getString("Question4");
        String answer5 = object.getString("Question5");
        String answer6 = object.getString("Question6");

        question1.setText("Question 1: " + answer1);
        question2.setText("Question 2: " + answer2);
        question3.setText("Question 3: " + answer3);
        question4.setText("Question 4: " + answer4);
        question5.setText("Question 5: " + answer5);
        question6.setText("Question 6: " + answer6);

        return v;
    }
}
