package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class AddOfferActivity extends AppCompatActivity {
    private OfferRegisterTask offerRegisterTask = null;

    EditText offerTitleEditText;
    TextView offerProductsTextView;
    TextView offerExpirationDateTextView;
    ImageView offerPhotoImageView;
    ProgressBar progressBar;
    ConstraintLayout constraintLayout;
    TextView loadingTextView;
    private String date;
    private int DIALOG_ID = 0;
    private int dYear, dMonth, dDay;
    private Calendar calendar = Calendar.getInstance();

    private final static int REQUEST_CAMERA = 1;
    private final static int SELECT_FILE = 0;

    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
        offerTitleEditText = (EditText) findViewById(R.id.offerTitleEditText);
        offerProductsTextView = (TextView) findViewById(R.id.selectedProductsTextView);
        offerExpirationDateTextView = (TextView) findViewById(R.id.expirationDateTextView);
        offerPhotoImageView = (ImageView) findViewById(R.id.offerPhotoImageView);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        constraintLayout =(ConstraintLayout) findViewById(R.id.constraintLayout);
        loadingTextView =(TextView) findViewById(R.id.loadingTextView);

        setCalendar();
        TextView selectExpirationDateTextView = (TextView) findViewById(R.id.selectExpirationDateTextView);
        selectExpirationDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectExpDate();
            }
        });

        Button addPhotoButton = (Button) findViewById(R.id.addPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhoto();
            }
        });

        Button saveOfferButton = (Button) findViewById(R.id.saveOfferButton);
        saveOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSubmit();
            }
        });
    }

    private void attemptSubmit() {hideKeyboard();
        if (offerRegisterTask != null) {
            return;
        }

        boolean cancel = false;
        View focusView = offerTitleEditText;


        offerTitleEditText.setError(null);
        offerExpirationDateTextView.setError(null);



        if (offerTitleEditText.getText().toString().isEmpty()) {
            offerTitleEditText.setError("Please enter a title ");
            focusView = offerTitleEditText;
            cancel = true;
        }

        if (offerTitleEditText.getText().toString().length() > 70) {
            offerTitleEditText.setError("Please enter a title shorter than 70 characters");
            focusView = offerTitleEditText;
            cancel = true;
        }


        if (offerExpirationDateTextView.getText().toString().isEmpty()) {
            Toast expDateToast = Toast.makeText(AddOfferActivity.this,
                    "Please select a expiration date.", Toast.LENGTH_LONG);
            offerExpirationDateTextView.setError("Please fill");
            cancel = true;
            expDateToast.show();
        }


        if (cancel) {

            focusView.requestFocus();
        } else {



            offerRegisterTask = new OfferRegisterTask();
            offerRegisterTask.execute((Void) null);
        }
    }
    /**
     * Setting the discount register task for sending the Offer to the REST
     */

    public class OfferRegisterTask extends AsyncTask<Void, Boolean, Boolean> {



        @Override
        protected void onPreExecute() {
            constraintLayout.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            loadingTextView.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try {


            } catch (Exception e) {
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if(success){
                goToMenuActivity();


            }
            else {
                Toast.makeText(AddOfferActivity.this, "Something went wrong!!! Try again", Toast.LENGTH_SHORT).show();
                constraintLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                loadingTextView.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        protected void onCancelled() {
            offerRegisterTask = null;
        }
    }


    private void goToMenuActivity(){
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void selectExpDate() {
        showDialog(DIALOG_ID);
    }
    private void setCalendar() {

        dYear = calendar.get(Calendar.YEAR);
        dMonth = calendar.get(Calendar.MONTH);
        dDay = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(AddOfferActivity.this, datePickerListener, dYear, dMonth, dDay);
        }
        return null;
    }
    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            dYear = year;
            dMonth = month;

            //Months are from 0 to 11 but we need to look from 1 to 12 like IRL
            int realMonth = month + 1;
            dDay = dayOfMonth;

            //if you chose a valid date display that date
            if (dYear > calendar.get(Calendar.YEAR) ||
                    dYear == calendar.get(Calendar.YEAR) && dMonth > calendar.get(Calendar.MONTH) ||
                    dYear == calendar.get(Calendar.YEAR) && dMonth == calendar.get(Calendar.MONTH) && dDay >= calendar.get(Calendar.DAY_OF_MONTH)) {
                date = Integer.toString(dDay) + "/" + Integer.toString(realMonth)
                        + "/" + Integer.toString(year);
                offerExpirationDateTextView.setError(null);
                offerExpirationDateTextView.setText(date);

                //else you chose a past date display an error and set the date to today's date
            } else {

                date = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) +
                        "/" + Integer.toString(calendar.get(Calendar.MONTH) + 1) +
                        "/" + Integer.toString(calendar.get(Calendar.YEAR));
                offerExpirationDateTextView.setText(date);
                offerExpirationDateTextView.setError("Please select a future date.");
                Toast toast = Toast.makeText(AddOfferActivity.this,
                        "The day you selected is a past one. Please select a future date.",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };

    private void addPhoto() {


        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(AddOfferActivity.this);
        builder.setTitle("Add Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (items[i].equals("Camera")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[i].equals("Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);

                } else if (items[i].equals("Cancel")) {
                    dialogInterface.dismiss();

                }

            }
        });
        builder.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {

                Uri selectedImageUri = data.getData();
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(offerPhotoImageView);

            } else if (requestCode == SELECT_FILE) {

                Uri selectedImageUri = data.getData();
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(offerPhotoImageView);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
