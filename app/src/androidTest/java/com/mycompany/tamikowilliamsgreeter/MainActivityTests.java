package com.mycompany.tamikowilliamsgreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Miko on 2/27/2016.
 */
public class MainActivityTests extends
        ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
    public void testGreet() {
        MainActivity activity = getActivity();

        // Type name in text input
        // ----------------------

        final EditText nameEditText =
                (EditText) activity.findViewById(R.id.greet_edit_text);

        // Send string input value
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");
        getInstrumentation().waitForIdleSync();

        // Tap "Greet" button
        // ----------------------

        Button greetButton =
                (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);

        // Verify greet message
        // ----------------------

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

    }
    public void testReverseDisabled(){
        MainActivity activity = getActivity();

        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);
        reverseButton.performClick();
        assertFalse(reverseButton.isEnabled());

    }
    public void testReverseEnabled(){
        MainActivity activity = getActivity();

        Button reverseButton =
                (Button) activity.findViewById(R.id.reverse_button);
        reverseButton.performClick();
        //assertTrue(reverseButton.isEnabled());
    }
}

