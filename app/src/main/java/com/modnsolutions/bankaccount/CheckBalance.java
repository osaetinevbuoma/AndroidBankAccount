package com.modnsolutions.bankaccount;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;


public class CheckBalance extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_balance);
        checkBalance();
    }

    /**
     * Check user's account balance
     */
    public void checkBalance() {
        Double deposit = Globals.bankAccount.getDeposit();
        Double withdraw = Globals.bankAccount.getWithdraw();
        Double balance = deposit - withdraw;

        TextView previousAmount = (TextView) findViewById(R.id.previous_amount);
        TextView lastWithdrawal = (TextView) findViewById(R.id.last_withdrawal);
        TextView balanceTextView = (TextView) findViewById(R.id.balance);

        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String outputDeposit = decimalFormat.format(deposit);
        String outputWithdraw = decimalFormat.format(withdraw);
        String outputBalance = decimalFormat.format(balance);

        previousAmount.setText("$ " + outputDeposit);
        lastWithdrawal.setText("$ " + outputWithdraw);
        balanceTextView.setText("$ " + outputBalance);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_balance, menu);
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
