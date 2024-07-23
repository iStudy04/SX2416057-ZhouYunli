package com.example.softwaretesting.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<Lives> lives;
}
