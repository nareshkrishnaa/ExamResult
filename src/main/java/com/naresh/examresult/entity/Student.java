/* (C)2023 */
package com.naresh.examresult.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Student_Table")
public class Student {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Need to check on a way to autogenerate roll numbers with string*/
    private String rollNo;

    private String name;

    private int math;
    private int subject2;
    private int subject3;
    private String password;
}
