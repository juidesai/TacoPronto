package com.jui.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;


public class MainActivity extends AppCompatActivity {
    RadioButton large, medium, corn,flour;
    CheckBox beef, chicken,fish,cheese,seefood,rice,beans,pdg,gua,lbt,soda,cer,marg,teq;
    Button order,confirm;
    TextView bill;
    StringBuilder amount= new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onPlaceOrder();
    }

    public void onPlaceOrder(){
        large = (RadioButton) findViewById(R.id.radio_large);
        medium=(RadioButton)findViewById(R.id.radio_medium);
        corn=(RadioButton)findViewById(R.id.radio_corn);
        flour = (RadioButton) findViewById(R.id.radio_flour);
        beef=(CheckBox)findViewById(R.id.cb_beef);
        chicken=(CheckBox)findViewById(R.id.cb_chicken);
        fish=(CheckBox)findViewById(R.id.cb_fish);
        cheese=(CheckBox)findViewById(R.id.cb_cheese);
        seefood=(CheckBox)findViewById(R.id.cb_seefood);
        rice=(CheckBox)findViewById(R.id.cb_rice);
        beans=(CheckBox)findViewById(R.id.cb_beans);
        pdg=(CheckBox)findViewById(R.id.cb_pdg);
        gua=(CheckBox)findViewById(R.id.cb_gua);
        lbt=(CheckBox)findViewById(R.id.cb_lbt);
        soda=(CheckBox)findViewById(R.id.cb_soda);
        cer=(CheckBox)findViewById(R.id.cb_cerzeva);
        marg=(CheckBox)findViewById(R.id.cb_marg);
        teq=(CheckBox)findViewById(R.id.cb_teq);
        order=(Button)findViewById(R.id.button);
        confirm=(Button)findViewById(R.id.button2);
        bill=(TextView)findViewById(R.id.tv_bill);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringBuilder result=new StringBuilder();
                amount.append(" ");
                result.append("Customer has ordered: ");
                double total=0;

                if (large.isChecked()) {
                    total = total + 20;
                    result.append("\n Large Taco : 20$");
                }
                if (medium.isChecked()){
                    total = total + 10;
                    result.append("\n Medium Taco : 10$");
                }
                if (flour.isChecked()) {
                    total = total + 10;
                    result.append("\n Flour Tortila : 10$");
                }
                if(corn.isChecked()){
                    total = total + 15;
                    result.append("\n Corn Tortila : 15$");
                }
                if (beef.isChecked()) {
                    total = total + 10;
                    result.append("\n Fillings-Beef : 10$");
                }
                if (chicken.isChecked()) {
                    total = total + 15;
                    result.append("\n Fillings-Chicken : 15$");
                }
                if (fish.isChecked()) {
                    total = total + 10;
                    result.append("\n Fillings-White Fish : 10$");
                }
                if (cheese.isChecked()) {
                    total = total + 5;
                    result.append("\n Fillings-Cheese : 5$");
                }
                if (seefood.isChecked()) {
                    total = total + 20;
                    result.append("\n Fillings-Seefood : 20$");
                }
                if (rice.isChecked()) {
                    total = total + 8;
                    result.append("\n Fillings-Rice : 8$");
                }
                if (beans.isChecked()) {
                    total = total + 10;
                    result.append("\n Fillings-Beans : 10$");
                }
                if (pdg.isChecked()) {
                    total = total + 12;
                    result.append("\n Fillings-Pico De Gallo : 12$");
                }
                if (gua.isChecked()) {
                    total = total + 15;
                    result.append("\n Fillings-Guacamole : 15$");
                }
                if (lbt.isChecked()) {
                    total = total + 10;
                    result.append("\n Fillings-LBT : 10$");
                }
                if (soda.isChecked()) {
                    total = total + 4;
                    result.append("\n Beverage-Soda: 04$");
                }
                if (cer.isChecked()) {
                    total = total + 6;
                    result.append("\n Beverage-Cerveza: 06$");
                }
                if (marg.isChecked()) {
                    total = total + 8;
                    result.append("\n Beverage-Margarita: 08$");
                }
                if (teq.isChecked()) {
                    total = total + 10;
                    result.append("\n Beverage-Tequilla: 08$");
                }
                        bill.setText(""+total);
                        result.append("\n Total Amount: ").append(total).append("$");
                        amount=result;
                        Toast.makeText(getApplicationContext(), amount.toString(), Toast.LENGTH_LONG).show();
            }

        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = amount.toString();
                String phonenumber= "+15623169186";
                try {
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(phonenumber,null,msg,null,null);
                    Toast.makeText(getApplicationContext(),"Order Confirmed and Message Sent", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

}
