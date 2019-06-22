package com.hemika.model;
import java.io.Serializable;
public class UserDtoData implements Serializable {
    private String nationalID;
    private int type;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String userName;
    private String birthDate;
    private String password;
    private String confirmPassword;
    private String email;

    public UserDtoData() { }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public String getConfirmPassword() { return confirmPassword; }

    public int getType() { return type; }

    public String getMobileNumber() { return mobileNumber; }

    public void setAddress(String address) { this.address = address;}

    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate;}

    public void setNationalID(String nationalID) { this.nationalID = nationalID; }

    public String getNationalID() { return nationalID; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setPassword(String password) { this.password = password; }

    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public void setType(int type) { this.type = type; }

    @Override
    public String toString() {
        return "UserDtoData{" +
                "nationalID='" + nationalID + '\'' +
                ", type='" + type + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +

                '}';
    }
}
