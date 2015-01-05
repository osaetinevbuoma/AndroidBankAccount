package com.modnsolutions.bankaccount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Withdraw extends ActionBarActivity implements View.OnClickListener {
    private static String TAG = "com.modnsolutions.bankaccount.Withdraw";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Button button = (Button) findViewById(R.id.withdraw_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            editText = (EditText) findViewById(R.id.withdraw_text_view);
            Double withdraw = Double.parseDouble(editText.getText().toString());
            Double balance = Globals.bankAccount.getDeposit() - Globals.bankAccount.getWithdraw();
            if (withdraw > balance) {
                Toast.makeText(this, "You cannot withdraw more than your balance " +
                        "($ " + balance + ")", Toast.LENGTH_LONG).show();
            } else {
                Globals.bankAccount.setWithdraw(withdraw);
                Toast.makeText(this, "You have withdrawn $ " + withdraw.toString(), Toast.LENGTH_LONG).show();

            }
        } catch (NumberFormatException e) {
            Log.e(TAG, e.getMessage());
            editText.setError("Enter value to withdraw");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_withdraw, menu);
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
