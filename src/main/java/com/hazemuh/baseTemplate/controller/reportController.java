package com.hazemuh.baseTemplate.controller;

import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.service.ReportService;
import com.hazemuh.baseTemplate.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/report")
public class reportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/cetakTransaksiReport")
    public ResponseEntity cetakReportTransaksi(@RequestParam String usersId, String tanggalAwal, String tanggalAkhir) {

        ResponseEntity responseEntity = reportService.cetakReport(usersId,tanggalAwal, tanggalAkhir);
        return responseEntity;
    }

}

