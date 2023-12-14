package com.example.calculatingfunds.service;

import com.example.calculatingfunds.dao.InfoDao;
import com.example.calculatingfunds.ds.InfoBean;
import com.example.calculatingfunds.ds.InfoData;
import com.example.calculatingfunds.entity.Info;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final InfoDao infoDao;
    private final InfoBean infoBean;
    public List<Info> findAllInfo(){
        return infoDao.findAll();
    }

    public Integer infoSize(){
        return infoDao.findAll().size();
    }

    public Info findInformationById(int id){
        return infoDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

  public void saveInfo(Info info){
         infoDao.save(info);
  }


    public void deleteInfo(int id) {
        infoDao.deleteById(id);
    }

    public void editInfo(Info info){
        infoDao.save(info);
    }

    public double calculateTotalAmount() {
        List<Info> allInfo = infoDao.findAll();
        return allInfo.stream()
                .mapToDouble(Info::getAmount)
                .sum();
    }
}
