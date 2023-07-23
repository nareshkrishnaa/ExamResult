/* (C)2023 */
package com.naresh.examresult.entity;

import jakarta.annotation.Nullable;
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

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Need to check on a way to autogenerate roll numbers with string*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNo;

    private String name;
    @Column(nullable = true)
    private Integer math;
    @Column(nullable = true)
    private Integer english;
    @Column(nullable = true)
    private Integer science;
    private String password;
}
