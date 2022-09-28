package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Currency {

    private String code;
    private String name;



    public String getCode() {
        return code;
    }
}
