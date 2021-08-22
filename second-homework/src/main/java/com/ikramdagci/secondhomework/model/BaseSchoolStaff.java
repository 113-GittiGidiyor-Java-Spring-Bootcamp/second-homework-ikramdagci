package com.ikramdagci.secondhomework.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_school_staff")
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "staff_id"))
public abstract class BaseSchoolStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Embedded
    Address address;

    public BaseSchoolStaff(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    public BaseSchoolStaff() {}

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseSchoolStaff that = (BaseSchoolStaff) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, address);
    }

    @Override
    public String toString() {
        return "staffId=" + id +
                ", fullName='" + fullName + '\'' +
                ", address=" + address;
    }
}
