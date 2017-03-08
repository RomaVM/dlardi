package com.example.service;

import com.example.entity.Client;
import com.example.entity.Record;

import java.util.List;

/**
 * Created by Roma on 04.03.2017.
 */
public interface RecordService {

    Record addRecord(Record record);

    List<Record> searchByClientAndFirstName(Client client, String like);

    List<Record> searchByClientAndLastName(Client client, String like);

    List<Record> findByClientAndMobileTel(Client client, String like);

    void deleteRecord(Long id);

}
