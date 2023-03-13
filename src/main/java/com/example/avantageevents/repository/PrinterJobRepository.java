package com.example.avantageevents.repository;

import com.example.avantageevents.model.PrinterJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrinterJobRepository extends JpaRepository<PrinterJob, Long> {
}
