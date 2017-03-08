package com.example.service;

import com.example.entity.Client;
import com.example.entity.Record;
import com.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Roma on 06.03.2017.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Record addRecord(Record record) {
        return this.recordRepository.saveAndFlush(record);
    }

    @Override
    public List<Record> searchByClientAndFirstName(Client client, String like) {
        return this.recordRepository.findByClientAndFirstNameContaining(client, like);
    }

    @Override
    public List<Record> searchByClientAndLastName(Client client, String like) {
        return this.recordRepository.findByClientAndLastNameContaining(client, like);
    }

    @Override
    public List<Record> findByClientAndMobileTel(Client client, String like) {
        return this.recordRepository.findByClientAndMobileTelContaining(client, like);
    }

    @Override
    public void deleteRecord(Long id) {
        this.recordRepository.delete(id);
    }

}
