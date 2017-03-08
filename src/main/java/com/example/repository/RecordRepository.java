package com.example.repository;

import com.example.entity.Client;
import com.example.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Roma on 03.03.2017.
 */
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findByClientAndFirstNameContaining(Client client, String like);

    List<Record> findByClientAndLastNameContaining(Client client, String like);

    List<Record> findByClientAndMobileTelContaining(Client client, String like);

}
