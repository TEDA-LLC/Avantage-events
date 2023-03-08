package com.example.avantageevents.service;

import com.example.avantageevents.model.Change;
import com.example.avantageevents.model.Employee;
import com.example.avantageevents.repository.ChangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChangeService {
    private final ChangeRepository changeRepository;

    public void changeSaver (Employee employee, String column, String table, String oldData, String newData){
        Change change = new Change();
        change.setEmployee(employee);
        change.setOldData(oldData);
        change.setNewData(newData);
        change.setColumnName(column);
        change.setTableName(table);
        changeRepository.save(change);
    }
}
