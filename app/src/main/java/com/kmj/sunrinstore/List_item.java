package com.kmj.sunrinstore;

public class List_item {

    private int product_img;
    private String price, product;

    public int getProduct_img() {
        return product_img;
    }
    public String getPrice() {
        return price;
    }
    public String getProduct(){
        return product;
    }


    public List_item(int product_img,String product,String price){
        this.product_img = product_img;
        this.product = product;
        this.price = price;
    }

}
