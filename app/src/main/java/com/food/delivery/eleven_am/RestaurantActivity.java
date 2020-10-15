package com.food.delivery.eleven_am;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.kishandonga.csbx.CustomSnackbar;

public class RestaurantActivity extends AppCompatActivity {

    ImageView add,minus;
    TextView quantity;
    int count=0;
    Snackbar sb;
    int price =150,t_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        add = findViewById(R.id.image_add);
        minus = findViewById(R.id.image_sub);
        quantity = findViewById(R.id.text_quantity);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                minus.setVisibility(View.VISIBLE);
                quantity.setText(String.valueOf(count));
                t_price = count*price;
                String text =String.valueOf(count) + " " + "item" + "  |  " + "₹" + String.valueOf(t_price);

                if(count==1) {
                    sb = Snackbar.make(v, text, Snackbar.LENGTH_INDEFINITE);
                    sb.setAction("View Cart", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(RestaurantActivity.this, CartActivity.class));
                        }
                    });


                    sb.setActionTextColor(Color.parseColor("#ffffff"));
                    View view = sb.getView();

                    TextView textView = (TextView)view.findViewById(com.google.android.material.R.id.snackbar_action);
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shopping_bag, 0);
                    textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));

                    view.setBackgroundColor(ContextCompat.getColor(RestaurantActivity.this, R.color.green));
                    sb.show();
                }else{
                    sb.setText(text);
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                t_price = count*price;
                if(count==0){
                    minus.setVisibility(View.GONE);
                    quantity.setText("Add");
                    sb.dismiss();
                }else{
                    quantity.setText(String.valueOf(count));
                    String text =String.valueOf(count) + " " + "item"+ "  |  " + "₹" + String.valueOf(t_price);
                    sb.setText(text);


                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}