package com.naresh.examresult.baeldung;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Serializable {
    private Integer id;
    private String name;
    // standard getters and setters
}
