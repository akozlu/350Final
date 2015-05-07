package fahim.hupproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.text.Html;
import android.webkit.WebView;


public class FAQActivity extends Activity {

    private final String htmlText = "<html>\n" +
            "<head>\n" +
            "\t<title></title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"page\" title=\"Page 1\">\n" +
            "<div class=\"layoutArea\">\n" +
            "<div class=\"column\">\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">University of Pennsylvania Health System </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">DISCHARGE INSTRUCTION SHEET </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Outpatient Microdiscectomy Surgery </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Follow-up Appointments </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">When you are discharged from the hospital, you should receive a call the following day from the office nurse practitioner/physician assistant to discuss how you are doing and ask/answer any clinical questions. Before hanging up, please make sure you have two appointments: </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<ol>\n" +
            "\t<li style=\"font-size: 12.000000pt; font-family: 'Cambria'\">\n" +
            "\t<p><span style=\"font-size: 12pt;\">a wound check visit with the Nurse Practitioner or Physician Assistant for about 7-14 days after surgery </span></p>\n" +
            "\t</li>\n" +
            "\t<li style=\"font-size: 12.000000pt; font-family: 'Cambria'\">\n" +
            "\t<p><span style=\"font-size: 12pt;\">a post-operative visit with your surgeon for 4-6 weeks after surgery. </span></p>\n" +
            "\t</li>\n" +
            "</ol>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">The office phone number is </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">(215) 829-6700. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Wound Care </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Remove the dry gauze dressing the 2nd day after surgery. The incision should then be open to air. You may shower day 3 after surgery. </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Starting on the 3rd day, gently cleanse the incision and surrounding area with soap and water</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">, patting it dry when you are finished.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Do not put </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700; font-style: italic\">any </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">lotion or ointments on the incision. Do not scratch the incision. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">If you have Steri-strips (small white paper tapes over the incision), they may start to curl up and fall off. This is OK but do not actively peel them off.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Some incisional swelling and bruising is normal. Your muscles have been cut, separated and sewn back together as part of your surgical procedure. You will leave the hospital with back discomfort from the surgical incision. As you become more active and the incision continues to heal, the swelling bruising and pain will decrease. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Have someone look at the incision </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">daily </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">until the wound appointment and for as long as instructed. </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Call the surgeon&rsquo;s office if you notice any of the following: </span>\n" +
            "\t<ul>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Increased redness along the incision</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Increased swelling of the area around your incision</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Drainage from the incision</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Weakness of your arms/legs greater than before surgery </span><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">o </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Loss of bowel or bladder control</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Development of severe headache</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Leg swelling or calf tenderness</span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">&nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Fever above 101.5 </span></li>\n" +
            "\t</ul>\n" +
            "\t</li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">At your wound check visit, the Nurse Practitioner or Physician Assistant, will check your wound and remove any sutures or staples or steri-strips.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Do not soak or immerse your incision in water for 1 month. For example, no tub baths, swimming pools or Jacuzzi. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Medications </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">You will be given prescriptions for pain medications, muscle relaxers and stool softeners upon discharge from the hospital.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Pain medications and muscle relaxers should be taken </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-style: italic\">as prescribed </span><span style=\"font-family: Cambria; font-size: 12pt;\">by your surgeon or nurse practitioner/ physician assistant. You are allowed to gradually reduce the number of pills you take when the pain begins to subside. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">If you are taking more than the recommended dose, please contact the office to discuss this with a practitioner (the medication may need to be increased or changed).</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">You may be discharged on a decreasing amount of oral steroids (steroid taper). Follow the instructions regarding how to take this medication. You should continue an anti-ulcer medication until you have finished the steroids. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Constipation: </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Pain medications (narcotics) may cause constipation. It is important to be aware of </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">your bowel habits so you don&rsquo;t develop severe constipation that cannot be treated with simple, </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">over the counter laxatives.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Most prescription pain medications cannot be called into the pharmacy for renewal. </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">The following are 2 options you may explore to obtain a renewal of your narcotic medications: </span></li>\n" +
            "</ul>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"page\" title=\"Page 2\">\n" +
            "<div class=\"layoutArea\">\n" +
            "<div class=\"column\">\n" +
            "<ol>\n" +
            "\t<li style=\"font-size: 12.000000pt; font-family: 'Cambria'\">\n" +
            "\t<p><span style=\"font-size: 12pt;\">Call the office 3-4 days before your prescription runs out and speak with a Nurse Practitioner/ Physician Assistant about mailing a prescription to your home/pharmacy. (Prescriptions will not be sent by Fed Ex/UPS) </span></p>\n" +
            "\t</li>\n" +
            "\t<li style=\"font-size: 12.000000pt; font-family: 'Cambria'\">\n" +
            "\t<p><span style=\"font-size: 12pt;\">Call the office 24 hours in advance and speak with a Nurse Practitioner/Physician Assistant about coming into the office to pick up a prescription. </span></p>\n" +
            "\t</li>\n" +
            "</ol>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">If you continue to require medications, you may be referred to a pain management specialist or your medical doctor for ongoing management of your pain medications. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Activity Guidelines</span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Avoid strenuous activity, bending, pushing or holding your breath. For example, do not vacuum, wash the car, do large loads of laundry, or walk the dog until your follow-up visit with your surgeon.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Avoid heavy lifting. Do not lift anything over 5-10 pounds for the first few weeks that you are home from the hospital. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Increase your activities a little each day</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">. Walking is good exercise. Plan rest periods and try to avoid hills if possible. Remember, exercise should not increase your back pain or cause leg pain. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Reaching</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">: When you have to reach things on or near the floor, always squat (bending the knees), rather than bending over at the waist. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Lying down</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">: when lying on your back, you may find that a pillow under the knees is more comfortable. When on your side, a pillow between the knees will help keep your back straight. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Sitting</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">: should be limited to 20-30 minutes at a time for the first week. Slowly increase the amount of sitting time, remembering that it should not increase your back pain. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Stairs</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">: use stairs only once or twice a day for the first week, or as directed by the surgeon. Climb steps one at a time, placing both feet on the step before moving to the next one.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Driving: </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">you should </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">not </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">drive for 2-4 weeks after surgery. You should discuss driving with your surgeon /nurse practitioner /physician assistant. You may ride in a car for short distances. When in the car, avoid sitting in one position for too long. If you must take long car rides, do not ride for more than 60 minutes without taking a break to stretch (walk for several minutes and change position.). </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Sexual activity</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">: you may resume sexual activity 2-4 weeks after surgery (avoiding pain or stress on the back).</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Reduction in symptoms: </span>\n" +
            "\t<ul>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Short-term symptoms: if the pain has been present for a short period of time before surgery, then patients who have experienced back and radiating leg pain should anticipate a significant decrease in pre-operative symptoms. </span></li>\n" +
            "\t\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Longer-term symptoms: If the pain has been present for a longer period (months to years), the pre-operative symptoms will recover on a more gradual basis week by week. It is not practical to expect immediate relief of symptoms. Routinely, pain will gradually improve on a weekly basis, weakness on a monthly basis, and numbness in the range of 6 months to 1 year. </span></li>\n" +
            "\t</ul>\n" +
            "\t</li>\n" +
            "</ul>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"page\" title=\"Page 3\">\n" +
            "<div class=\"layoutArea\">\n" +
            "<div class=\"column\">\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Physical Therapy </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Outpatient Physical Therapy (if appropriate) will not begin until after your post-operative visit with your surgeon. A prescription is needed for formal outpatient therapy.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">You may be given simple stretching exercises or a prescription for formal outpatient physical therapy, based on what your needs are after surgery. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Meals </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Resume your usual diet when you return home. Avoid alcoholic beverages while taking new medications. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Increase your fluid and fiber intake as narcotic pain medications may cause constipation (difficulty having a bowel movement). It is important be aware of your bowel habits so you d</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">on&rsquo;t </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">develop severe constipation. Call the office if this occurs for more than 3 days or if you have stomach pain. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Blood Clots in the Leg </span></p>\n" +
            "\n" +
            "<ul>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">It is not uncommon for patients who recently had surgery to develop blood clots in leg veins. Symptoms can include any of the following: low-grade fever, redness, swelling, tenderness, aching/cramping pain in your calf.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">You should call your doctor immediately if you have these symptoms. </span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">To prevent blood clots in legs, try walking and/or pumping ankles several times during the day.</span></li>\n" +
            "\t<li><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">If the blood clot breaks free from the leg vein, it can travel to the lungs and cause severe breathing difficulty and/or chest pain. If you experience these symptoms, call 911 immediately. </span></li>\n" +
            "</ul>\n" +
            "\n" +
            "<p><span style=\"font-size: 14.000000pt; font-family: 'Cambria'; font-weight: 700\">Questions </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Any questions may be directed to your surgeon or nurse practitioner/ physician assistant.</span><br />\n" +
            "<span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">o </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-style: italic\">During </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">normal business hours (8:30am- 5:00pm), you can call the Neurosurgery office directly at </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">(215) 829-6700</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">. Turn around time for a phone call is 24 hours.</span><br />\n" +
            "<span style=\"font-size: 12.000000pt; font-family: 'CourierNewPSMT'\">o </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-style: italic\">After </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">normal business hours, you can call the on-call service and ask to be connected to the </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">Neurosurgery resident on-call at </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">(215) 829-3000</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">. </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">If you are calling with </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">an urgent medical issue</span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">, please tell the coordinator that it is an </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">&ldquo;urgent issue&rdquo; </span><span style=\"font-size: 12.000000pt; font-family: 'Cambria'\">and needs to be discussed in less than 24 hours (i.e. pain unrelieved with medications, wound breakdown/infection, or new neurological symptoms). </span></p>\n" +
            "\n" +
            "<p><span style=\"font-size: 12.000000pt; font-family: 'Cambria'; font-weight: 700\">Department of Neurosurgery at Pennsylvania Hospital University of Pennsylvania Health System<br />\n" +
            "235 S. Eighth Street, Philadelphia, PA 19106 (215) 829-6700 </span></p>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_faq);
        //TextView textView= (TextView) findViewById(R.id.html_text);
        //textView.setText(Html.fromHtml(htmlText));

        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadData(htmlText, "text/html", null);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faq, menu);
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
