package com.tshine.server.apiserver.entities.user;


import com.tshine.server.apiserver.entities.system.SystemFile;
import com.tshine.server.apiserver.entities.role.Role;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "user_infos")
public class UserInfo {
    @Id
    private String userId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String nick;
    private String mobile;
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String oldPassword;
    private String dateOfBirth;
    private String gender;
    private String isOnline;
    private String status;
    private String address;
    private Integer loginCount;
    private Timestamp createdTime;
    private Timestamp lastUpdated;
    private String createdBy;
    private String updatedBy;
    private String branchNo;
    @OneToOne(cascade = CascadeType.ALL)
    private SystemFile image;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getUserId() {
        return userId;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public SystemFile getImage() {
        return image;
    }

    public void setImage(SystemFile systemFile) {
        this.image = systemFile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof UserInfo))
            return false;
        UserInfo userInfo = (UserInfo) obj;
        return this.userId.equals(userInfo.getUserId()) || this.username.equals(userInfo.getUsername()) || this.mobile.equals(userInfo.getMobile()) ;
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
        if(username != null){
            result = result + username.hashCode();
        }
        return result;
    }
}
