package com.modnsolutions.bankaccount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Deposit extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button deposit = (Button) findViewById(R.id.deposit_button);
        deposit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deposit, menu);
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

    @Override
    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.deposit_edit_text);
        Double deposit = Double.parseDouble(editText.getText().toString());

        Globals.bankAccount.setDeposit(deposit);

        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String output = decimalFormat.format(deposit);

        TextView textView = (TextView) findViewById(R.id.deposit_text_view);
        textView.setText("$ " + output);
    }
}
