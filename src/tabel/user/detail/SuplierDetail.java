/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel.user.detail;
/**
 *
 * @author Dynastymasra
 */
public class SuplierDetail {
    private String suplierCode;
    private String suplierName;
    private String address;
    private String city;
    private String phone;
    private String gender;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSuplierCode() {
        return suplierCode;
    }

    public void setSuplierCode(String suplierCode) {
        this.suplierCode = suplierCode;
    }

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }
}
