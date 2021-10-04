package com.ty.Activity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.PropertyValueException;

import lombok.Data;

@Data
@Entity

public class Student implements Serializable{
	

@Id
private int rollNo;
private String name;
private long phno;
private String standard;
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
public String getStandard() {
	return standard;
}
public void setStandard(String standard) {
	this.standard = standard;
}
@Override
public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", phno=" + phno + ", standard=" + standard + "]";
}

}