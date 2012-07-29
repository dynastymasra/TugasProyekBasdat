/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel.user.detail;
/**
 *
 * @author Dynastymasra
 */
public class KasirDetail {
    private String chasierCode;
    private String chasierName;
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

    public String getChasierCode() {
        return chasierCode;
    }

    public void setChasierCode(String chasierCode) {
        this.chasierCode = chasierCode;
    }

    public String getChasierName() {
        return chasierName;
    }

    public void setChasierName(String chasierName) {
        this.chasierName = chasierName;
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
}
