package com.modnsolutions.bankaccount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Withdraw extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Button button = (Button) findViewById(R.id.withdraw_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.withdraw_text_view);
        Double withdraw = Double.parseDouble(textView.getText().toString());
        if (withdraw > Globals.bankAccount.getDeposit()) {
            Toast.makeText(this, "You cannot withdraw more than your deposit " +
                    "($ " + Globals.bankAccount.getDeposit() + ")", Toast.LENGTH_LONG).show();
        } else {
            Globals.bankAccount.setWithdraw(withdraw);
            Toast.makeText(this, "You have withdraw $ " + withdraw.toString(), Toast.LENGTH_LONG).show();

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