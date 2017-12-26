package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sirialkillers.shoponthego.R;

public class AddProductActivity extends AppCompatActivity {
    EditText productNameEditText;
    EditText productDescriptionEditText;
    EditText productPriceEuroEditText;
    EditText productPriceCentEditText;
    TextView productCategoryTextView;
    ImageView productImageView;

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

    private void showCategoriesDialog() {
    }

    private void attemptSubmitProduct() {
    }

    private void addPhoto() {
    }
}
