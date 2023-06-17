/* (C)2023 */
package com.naresh.examresult.entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Integer rollNo;
    private String name;
    private int math;
    private int science;
    private int english;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentDto student = (StudentDto) o;
        return rollNo == student.rollNo
                && math == student.math
                && science == student.science
                && english == student.english
                && Objects.equals(name, student.name);
    }
}
