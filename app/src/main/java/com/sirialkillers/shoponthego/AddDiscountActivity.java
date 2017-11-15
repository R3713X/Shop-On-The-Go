package com.sirialkillers.shoponthego;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class AddDiscountActivity extends AppCompatActivity {
    private EditText dTitleEditText;
    private DiscountRegisterTask discountRegisterTask = null;
    private EditText dDescriptionEditText;
    private NumberPicker numberPicker;
    private TextView dcatergoriesTextView;
    private String date;
    private TextView dExpDateTextView;
    private int DIALOG_ID = 0;
    private int dyear, dmonth, dday;
    private Calendar calendar = Calendar.getInstance();
    String scategories;
    String[] categories;

    boolean[] checkedCategories;

    ArrayList<Integer> mUserCategories = new ArrayList<>();


    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            dyear = year;
            dmonth = month;
            int realmonth = month + 1;
            dday = dayOfMonth;

            if (dyear > calendar.get(Calendar.YEAR) ||
                    dyear == calendar.get(Calendar.YEAR) && dmonth > calendar.get(Calendar.MONTH) ||
                    dyear == calendar.get(Calendar.YEAR) && dmonth == calendar.get(Calendar.MONTH) && dday >= calendar.get(Calendar.DAY_OF_MONTH)) {
                date = Integer.toString(dday) + "/" + Integer.toString(realmonth)
                        + "/" + Integer.toString(year);
                dExpDateTextView.setError(null);
                dExpDateTextView.setText(date);

            } else {

                date = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) +
                        "/" + Integer.toString(calendar.get(Calendar.MONTH) + 1) +
                        "/" + Integer.toString(calendar.get(Calendar.YEAR));
                dExpDateTextView.setText(date);
                dExpDateTextView.setError("Please select a future date.");
                Toast toast = Toast.makeText(AddDiscountActivity.this,
                        "The day you selected is a past one. Please select a future date.",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_discount);

        dTitleEditText = (EditText) findViewById(R.id.titleDiscountEditText);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(99);
        numberPicker.setMinValue(1);
        numberPicker.setValue(20);


        dDescriptionEditText = (EditText) findViewById(R.id.descriptionDiscountEditText);
        dcatergoriesTextView = (TextView) findViewById(R.id.categoriesTextView);

        dExpDateTextView = (TextView) findViewById(R.id.expirationDateTextView);


        categories = getResources().getStringArray(R.array.productCategories);
        checkedCategories = new boolean[categories.length];
        dcatergoriesTextView.setMovementMethod(new ScrollingMovementMethod());
        TextView selectExpDateTextView = (TextView) findViewById(R.id.selectExpirationDateTextView);
        selectExpDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectExpDate();
            }
        });
        setCalendar();

        TextView selectCategoriesTextView = (TextView) findViewById(R.id.selectCategoriesTextView);
        selectCategoriesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCategories();
            }
        });

        Button submitOrderButton = (Button) findViewById(R.id.submitDiscountButton);
        submitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSubmitDiscount();
            }
        });
    }


    private void selectCategories() {
        AlertDialog.Builder categoryMBuilder = new AlertDialog.Builder(AddDiscountActivity.this);
        categoryMBuilder.setTitle(R.string.title);
        categoryMBuilder.setMultiChoiceItems(categories, checkedCategories, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                if (isChecked) {
                    if (!mUserCategories.contains(position)) {
                        mUserCategories.add(position);
                    }
                } else if (mUserCategories.contains(position)) {
                    mUserCategories.remove((Integer) position);
                }
            }
        });
        categoryMBuilder.setCancelable(false);

        categoryMBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String categoriesString = "";
                scategories = "";
                for (int i = 0; i < mUserCategories.size(); i++) {
                    categoriesString = categoriesString + categories[mUserCategories.get(i)];
                    scategories = categoriesString + categories[mUserCategories.get(i)];
                    if (i != mUserCategories.size() - 1) {
                        categoriesString = categoriesString + ", ";
                        scategories = scategories + " ";
                    }
                }
                dcatergoriesTextView.setText(categoriesString);
            }
        });

        categoryMBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        categoryMBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < checkedCategories.length; i++) {
                    checkedCategories[i] = false;
                    mUserCategories.clear();
                    dcatergoriesTextView.setText("");
                }
            }
        });

        AlertDialog mDialog = categoryMBuilder.create();
        mDialog.show();
    }

    private void selectExpDate() {
        showDialog(DIALOG_ID);
    }

    private void setCalendar() {

        dyear = calendar.get(Calendar.YEAR);
        dmonth = calendar.get(Calendar.MONTH);
        dday = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(AddDiscountActivity.this, datePickerListener, dyear, dmonth, dday);
        }
        return null;
    }

    private void attemptSubmitDiscount() {

        /*if (discountRegisterTask != null) {
            return;
        }*/
        boolean cancel = false;
        View focusView = dTitleEditText;
        Log.i("A","1");
        dTitleEditText.setError(null);
        dDescriptionEditText.setError(null);
        dcatergoriesTextView.setError(null);
        Log.i("A","1");

        if (dTitleEditText.getText().toString().isEmpty()) {
            dTitleEditText.setError("Please enter a title ");
            focusView = dTitleEditText;
            cancel = true;
            Log.i("A","1");
        }
        if (dTitleEditText.getText().toString().length() > 70) {
            dTitleEditText.setError("Please enter a title shorter than 70 characters");
            focusView = dTitleEditText;
            cancel = true;
            Log.i("A","1");
        }


        if (dDescriptionEditText.getText().toString().length() > 500) {
            dDescriptionEditText.setError("Please enter a Description shorter than 500 characters");
            focusView = dDescriptionEditText;
            cancel = true;
        }
        if (dcatergoriesTextView.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(AddDiscountActivity.this,
                    "Please select the Product Categories", Toast.LENGTH_LONG);
            dcatergoriesTextView.setError("Please fill");
            cancel = true;
        }
        if (dExpDateTextView.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(AddDiscountActivity.this,
                    "Please select a expiration date.", Toast.LENGTH_LONG);
            dExpDateTextView.setError("Please fill");
            cancel = true;

        }
        Log.i("B","1");

        if (cancel) {
            // There was an error; don't to register the discount and show
            // form field with an error.
            focusView.requestFocus();
            Log.i("B","1");
        } else {
            String dTitle = dTitleEditText.getText().toString();
            Date dExpDate = new Date(dyear, dmonth, dday);
            String dDescription = dDescriptionEditText.getText().toString();
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //Loading();
            Log.i("C","1");
            discountRegisterTask = new DiscountRegisterTask(dTitle, dExpDate, numberPicker.getValue(), scategories, dDescription);
        }
    }

    public class DiscountRegisterTask extends AsyncTask<Void, Void, Boolean> {

        private String discountTitle;
        private Date discountExpDate;
        private int discountValue;
        private String discountCategories;
        private String discountDescription = "default_empty";

        DiscountRegisterTask(String discountTitle, Date discountExpDate, int discountValue, String discountCategories, String discountDescription) {
            this.discountTitle = discountTitle;
            this.discountExpDate = discountExpDate;
            this.discountValue = discountValue;
            this.discountCategories = discountCategories;
            this.discountDescription = discountDescription;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }


            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            discountRegisterTask = null;

            finish();
            if (success) {
                finish();
            }
        }

        @Override
        protected void onCancelled() {
            discountRegisterTask = null;
            //Loading();
        }
    }
}

