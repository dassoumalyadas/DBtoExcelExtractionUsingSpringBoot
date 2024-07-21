package com.soumalya.DBtoExcelExtractor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE_DTLS")
public class Course {
    private Integer ci;
    private String name;
    private double price;
}
