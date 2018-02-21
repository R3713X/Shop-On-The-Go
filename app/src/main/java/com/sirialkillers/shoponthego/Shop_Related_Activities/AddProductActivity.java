package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.Models.CategoryModel;
import com.sirialkillers.shoponthego.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.UUID;

public class AddProductActivity extends AppCompatActivity {

    /**NOTE: in order for this to work we have to do
     * 1) return a list of product category models
     * 2) display the category models in the dialog
     * 3) save the product with the categoryID
     *
     * steps 1 and 3 need to be done in the rest server and client
     * */
    private ProductRegisterTask productRegisterTask = null;
    EditText productNameEditText;
    EditText productDescriptionEditText;
    EditText productPriceEuroEditText;
    EditText productPriceCentEditText;
    TextView productCategoryTextView;
    ImageView productImageView;
    Bitmap bitmap;
    ConstraintLayout constraintLayout;
    ProgressBar progressBar;
    TextView loadingTextView;
    private final static int REQUEST_CAMERA = 1;
    private final static int SELECT_FILE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        productNameEditText = findViewById(R.id.titleProductEditText);
        productDescriptionEditText = findViewById(R.id.productDescriptionEditText);
        productPriceEuroEditText = findViewById(R.id.eurosEditText);
        productPriceCentEditText = findViewById(R.id.centsEditText);
        productCategoryTextView = findViewById(R.id.productCategoryTextView);
        productImageView = findViewById(R.id.productPhotoImageView);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);

        Button addPhotoButton = findViewById(R.id.addProductPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhoto();
            }
        });

        Button saveProductButton = findViewById(R.id.submitProductButton);
        saveProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSubmitProduct();
            }
        });
        
        TextView selectCategoryTextView = findViewById(R.id.selectCategoryTextView);
        selectCategoryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoriesDialog();
            }
        });
        
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    private void showCategoriesDialog() {
    }

    private void attemptSubmitProduct() {
        hideKeyboard();
        if (productRegisterTask != null) {
            return;
        }

        boolean cancel = false;
        View focusView = productNameEditText;


        productNameEditText.setError(null);
        productDescriptionEditText.setError(null);
        productPriceCentEditText.setError(null);


        if (productNameEditText.getText().toString().isEmpty()) {
            productDescriptionEditText.setError("Please enter a product name ");
            focusView = productNameEditText;
            cancel = true;

        } else if (productDescriptionEditText.getText().toString().length() > 100) {

            productDescriptionEditText.setError("Please enter a name shorter than 100 characters");
            focusView = productDescriptionEditText;
            cancel = true;
        }


        if (productDescriptionEditText.getText().toString().isEmpty()) {

            productDescriptionEditText.setError("Please write a description of this category");

            cancel = true;

        }
        if(Integer.parseInt(productPriceCentEditText.getText().toString())>99&&Integer.parseInt(productPriceCentEditText.getText().toString())<0){

            productPriceCentEditText.setError("Please enter a proper cents amount");
            productPriceCentEditText.setText("99");
            cancel = true;

        }
        if(Integer.parseInt(productPriceEuroEditText.getText().toString())<0){

            productPriceCentEditText.setError("You cannot have negative numbers on the price.");
            productPriceEuroEditText.setText("0");
            cancel = true;

        }



        UUID productID = UUID.randomUUID();

        if (cancel) {
            // There was an error; don't to register the shop and show
            // form field with an error.
            focusView.requestFocus();
        } else {
            productRegisterTask = new ProductRegisterTask(
                    productID,
                    productNameEditText.getText().toString(),
                    productDescriptionEditText.getText().toString(),
                    UUID.randomUUID(),
                    Integer.parseInt(productPriceEuroEditText.getText().toString()),
                    Integer.parseInt(productPriceCentEditText.getText().toString()),
                    bitmap);
            productRegisterTask.execute((Void) null);
        }
    }

    private void addPhoto() {


        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(productImageView);

            } else if (requestCode == SELECT_FILE) {

                Uri selectedImageUri = data.getData();
                Picasso.with(this).load(selectedImageUri).fit().centerInside().into(productImageView);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public class ProductRegisterTask extends AsyncTask<Void, Boolean, Boolean> {
        UUID productID;
        String productName;
        String productDescription;
        UUID productCategoryId;
        int productEuros;
        int productCents;

        public ProductRegisterTask(UUID productID, String productName, String productDescription,UUID productCategoryId, int productEuros, int productCents, Bitmap productPhoto) {
            this.productID = productID;
            this.productName = productName;
            this.productDescription = productDescription;
            this.productCategoryId = productCategoryId;
            this.productEuros = productEuros;
            this.productCents = productCents;
            this.productPhoto = productPhoto;
        }

        Bitmap productPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.addphoto);;


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
                Toast.makeText(AddProductActivity.this, "Something went wrong!!! Try again", Toast.LENGTH_SHORT).show();
                loadingTextView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                constraintLayout.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected void onCancelled() {
            productRegisterTask = null;
        }
    }
    private void goToMenuActivity(){
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
