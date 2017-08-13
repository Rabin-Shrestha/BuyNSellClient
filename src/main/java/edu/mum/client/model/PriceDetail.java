package edu.mum.client.model;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public class PriceDetail {
    private Double price;
    private Boolean isNegotiable;

    private String condition;

    private String ownershipDoc;

    public PriceDetail(){}

    public PriceDetail(Double price, Boolean isNegotiable, String condition, String ownershipDoc) {
        this.price = price;
        this.isNegotiable = isNegotiable;
        this.condition = condition;
        this.ownershipDoc = ownershipDoc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getNegotiable() {
        return isNegotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        isNegotiable = negotiable;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOwnershipDoc() {
        return ownershipDoc;
    }

    public void setOwnershipDoc(String ownershipDoc) {
        this.ownershipDoc = ownershipDoc;
    }
}
