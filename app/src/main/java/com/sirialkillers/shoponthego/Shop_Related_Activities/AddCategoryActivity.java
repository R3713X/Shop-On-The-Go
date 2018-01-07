package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.ui.PlacePicker;
import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.Models.CategoryModel;
import com.sirialkillers.shoponthego.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

public class AddCategoryActivity extends AppCompatActivity {
    /**NOTE: We need to make a method that creates the discount. This needs to be done in the rest client And server!.
     * */
    ConstraintLayout constraintLayout;
    ProgressBar progressBar;
    TextView loadingTextView;
    EditText categoryNameEditText;
    EditText categoryDescriptionEditText;
    ImageView categoryPhotoImageView;
    Bitmap bitmap;
    String chosenShopId;
    private CategoryRegisterTask categoryRegisterTask = null;
    private final static int REQUEST_CAMERA = 1;
    private final static int SELECT_FILE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);
        categoryNameEditText = (EditText) findViewById(R.id.titleCategoryEditText);
        categoryDescriptionEditText = (EditText) findViewById(R.id.categoryDescriptionEditText);
        categoryPhotoImageView = (ImageView) findViewById(R.id.categoryPhotoImageView);
        Intent intent = getIntent();
        chosenShopId = intent.getExtras().getString("chosenShopId");

        Button addPhotoButton = (Button) findViewById(R.id.addCategoryPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhoto();
            }
        });

        Button addCategoryButton = (Button) findViewById(R.id.submitCategoryButton);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSubmitCategory();
            }
        });

    }
    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void attemptSubmitCategory() {
        hideKeyboard();
        if (categoryRegisterTask != null) {
            return;
        }

        boolean cancel = false;
        View focusView = categoryNameEditText;


        categoryNameEditText.setError(null);
        categoryDescriptionEditText.setError(null);


        if (categoryNameEditText.getText().toString().isEmpty()) {
            categoryNameEditText.setError("Please enter a category name ");
            focusView = categoryNameEditText;
            cancel = true;

        } else if (categoryNameEditText.getText().toString().length() > 70) {

            categoryNameEditText.setError("Please enter a name shorter than 70 characters");
            focusView = categoryNameEditText;
            cancel = true;
        }


        if (categoryDescriptionEditText.getText().toString().isEmpty()) {

            categoryDescriptionEditText.setError("Please write a description of this category");

            cancel = true;

        }




        UUID categoryId = UUID.randomUUID();

        if (cancel) {
            // There was an error; don't to register the shop and show
            // form field with an error.
            focusView.requestFocus();
        } else {
            categoryRegisterTask = new CategoryRegisterTask(categoryNameEditText.getText().toString(),categoryDescriptionEditText.getText().toString(),bitmap,categoryId);
            categoryRegisterTask.execute((Void) null);
        }
    }

    private void addPhoto() {


            final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
            AlertDialog.Builder builder = new AlertDialog.Builder(AddCategoryActivity.this);
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
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(categoryPhotoImageView);

            } else if (requestCode == SELECT_FILE) {

                Uri selectedImageUri = data.getData();
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(categoryPhotoImageView);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public class CategoryRegisterTask extends AsyncTask<Void, Boolean, Boolean> {

        private String categoryName;
        private String categoryDesc;
        private Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.addphoto);
        private UUID categoryID;

        public CategoryRegisterTask(String categoryName, String categoryDesc, Bitmap bitmap, UUID categoryID) {
            this.categoryName = categoryName;
            this.categoryDesc = categoryDesc;
            this.bitmap = bitmap;
            this.categoryID = categoryID;
        }

        @Override
        protected void onPreExecute() {
            loadingTextView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            constraintLayout.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try
            {
                CategoryModel categoryModel = new CategoryModel(categoryID.toString(),categoryName,categoryDesc);



            } catch (Exception e){

                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {

                goToMenuActivity();
            } else {
                Toast.makeText(AddCategoryActivity.this, "Something went wrong!!! Try again", Toast.LENGTH_SHORT).show();
                loadingTextView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                constraintLayout.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected void onCancelled() {
            categoryRegisterTask = null;
        }
    }
    private void goToMenuActivity(){
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }

}
