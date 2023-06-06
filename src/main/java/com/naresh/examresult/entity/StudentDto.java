/* (C)2023 */
package com.naresh.examresult.entity;

import lombok.*;

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
}
