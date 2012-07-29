/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabel.user.detail;
/**
 *
 * @author Dynastymasra
 */
public class PetugasDetail {
    private String petugasCode;
    private String petugasName;
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

    public String getPetugasCode() {
        return petugasCode;
    }

    public void setPetugasCode(String petugasCode) {
        this.petugasCode = petugasCode;
    }

    public String getPetugasName() {
        return petugasName;
    }

    public void setPetugasName(String petugasName) {
        this.petugasName = petugasName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
