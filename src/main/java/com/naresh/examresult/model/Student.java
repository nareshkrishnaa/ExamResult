package com.naresh.examresult.model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
private Integer rollNo;
private String name;
private Date dob;

}
