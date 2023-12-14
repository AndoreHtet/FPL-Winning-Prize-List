package com.example.calculatingfunds.ds;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InfoBean {

    private Set<InfoData>infoData= new HashSet<>();

    public Set<InfoData>getInfoData(){
return infoData;
    }
}
