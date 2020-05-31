package com.example.justjava;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;
    int count = 0;
    double price = 5.00;
    String message = "" ;
    String name;
    String text = "Your order has been placed!!";
    boolean isWhippedCream = false;
    boolean isChocolate = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        if (count == 0) {
            message += "Name: " + name;
            message += "\nAdd whipped cream: " + isWhippedCream;
            message += "\nAdd chocolate: " + isChocolate;
            message += "\nQuantity: " + quantity;
            message += "\nTotal Cost: $" + String.format("%.2f", getPrice(quantity));
            message += "\nThank You!!";
            count += 1;
        }else{
            Toast.makeText(this, text, Toast.LENGTH_SHORT ).show();
        }
        displayMessage(message);
    }

    public void setName(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        name = username.getText().toString();
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void setQuantity(View view) {
        EditText number = (EditText) findViewById(R.id.quantity_text_view);
        quantity = Integer.parseInt(number.getText().toString());
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setWhippedCream(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        isWhippedCream = whippedCream.isChecked();
        if (isWhippedCream == true){
            price+=1.00;
        }
    }

    public void setChocolate(View view) {
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        isChocolate = chocolate.isChecked();
        if (isChocolate == true){
            price+=2.00;
        }
    }

    private double getPrice(int quantity){
        price = price * quantity;
        return price;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}