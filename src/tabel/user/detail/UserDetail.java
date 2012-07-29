/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel.user.detail;
/**
 *
 * @author Dynastymasra
 */
public class UserDetail {
    private String goodsCode;
    private String goodsName;
    private String stockMax;
    private String stockMin;
    private String price;
    private String Sell;
    private String Stock;
    private String unit;
    private String discount;
    private String ppn;

    public String getSell() {
        return Sell;
    }
    public void setSell(String Sell) {
        this.Sell = Sell;
    }
    public String getStock() {
        return Stock;
    }
    public void setStock(String Stock) {
        this.Stock = Stock;
    }
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    public String getGoodsCode() {
        return goodsCode;
    }
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getPpn() {
        return ppn;
    }
    public void setPpn(String ppn) {
        this.ppn = ppn;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getStockMax() {
        return stockMax;
    }
    public void setStockMax(String stockMax) {
        this.stockMax = stockMax;
    }
    public String getStockMin() {
        return stockMin;
    }
    public void setStockMin(String stockMin) {
        this.stockMin = stockMin;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }  
}
