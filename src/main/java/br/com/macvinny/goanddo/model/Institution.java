package br.com.macvinny.goanddo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Institution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String institutionCode;

    public Institution() {}

    public Institution(String name, String phone, String email, String address, String imageUrl, String institutionCode) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageUrl = imageUrl;
        this.institutionCode = institutionCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", institutionCode='" + institutionCode + '\'' +
                '}';
    }
}
