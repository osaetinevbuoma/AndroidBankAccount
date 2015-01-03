package com.modnsolutions.bankaccount;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button deposit = (Button) findViewById(R.id.deposit);
        Button withdraw = (Button) findViewById(R.id.withdraw);
        Button checkBalance = (Button) findViewById(R.id.check_balance);

        deposit.setOnClickListener(this);
        withdraw.setOnClickListener(this);
        checkBalance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deposit:
                Intent depositIntent = new Intent(this, Deposit.class);
                startActivity(depositIntent);
                break;

            case R.id.withdraw:
                Intent withdrawIntent = new Intent(this, Withdraw.class);
                startActivity(withdrawIntent);
                break;

            case R.id.check_balance:
                Intent checkBalanceIntent = new Intent(this, CheckBalance.class);
                startActivity(checkBalanceIntent);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
