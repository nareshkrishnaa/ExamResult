package com.naresh.examresult.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Teacher_Table")
public class Teacher {
    @Id
    String staffId;
    String name;
    String password;

}
