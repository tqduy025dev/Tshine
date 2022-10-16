package com.tshine.server.apiserver.entities.user;

import com.tqd.solution.tqdserver.entities.product.Image;

public class UserInfo {
    private String userId;
    private String firstName;
    private String lastName;
    private String nick;
    private String mobile;
    private String email;
    private String password;
    private String dateOfBirth;
    private String gender;
    private String isOnline;
    private String status;
    private String address;
    private Image image;
    private UserRole role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof UserInfo))
            return false;
        UserInfo userInfo = (UserInfo) obj;
        return this.userId.equals(userInfo.getUserId()) || this.email.equals(userInfo.getEmail()) || this.mobile.equals(userInfo.getMobile()) ;
    }

    @Override
    public int hashCode() {
        int result = 52;
        if(userId != null){
            result = result + userId.hashCode();
        }
        if(mobile != null){
            result = result + mobile.hashCode();
        }
        if(email != null){
            result = result + email.hashCode();
        }
        return result;
    }
}
