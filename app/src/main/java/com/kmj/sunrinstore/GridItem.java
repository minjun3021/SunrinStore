package com.kmj.sunrinstore;

import android.support.v7.app.AppCompatActivity;

public class GridItem extends AppCompatActivity {

    private int product_imgG;
    private String productG;
    private String priceG;


    public int getProduct_imgG() {
        return product_imgG;
    }

    public String getProductG() {
        return productG;
    }

    public String getPriceG() {
        return priceG;
    }

    public GridItem(int product_imgG, String productG, String priceG) {
        this.product_imgG = product_imgG;
        this.productG = productG;
        this.priceG = priceG;

    }
}