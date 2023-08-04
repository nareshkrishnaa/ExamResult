package com.naresh.examresult.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultUpdationPageObject {
    private String name;
    private Integer rollNo;
    private String nameOftheExamination;
    private HashMap<String,Integer> subjectMarkList;


}
