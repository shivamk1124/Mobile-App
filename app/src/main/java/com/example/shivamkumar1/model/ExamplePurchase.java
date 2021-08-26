package com.example.shivamkumar1.model;

import java.util.List;

public class ExamplePurchase {

    private List<PurchaseDetail> purchase = null;

    public List<PurchaseDetail> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<PurchaseDetail> purchase) {
        this.purchase = purchase;
    }
}
