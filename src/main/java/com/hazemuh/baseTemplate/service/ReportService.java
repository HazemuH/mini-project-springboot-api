package com.hazemuh.baseTemplate.service;
import com.hazemuh.baseTemplate.dto.ReportDetailDto;
import com.hazemuh.baseTemplate.dto.ReportDto;
import com.hazemuh.baseTemplate.entity.Transactions;
import com.hazemuh.baseTemplate.entity.Users;
import com.hazemuh.baseTemplate.pdf.PdfFileExporter;
import com.hazemuh.baseTemplate.repository.ReportClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.repository.usersRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Strings;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ReportService {
   @Autowired
   private ReportClassRepository reportClassRepository;
   @Autowired
   private transactionsRepository transactionsRepository;
   @Autowired
   private usersRepository usersRepository;


    public ResponseEntity cetakReport(String usersId, String tanggalAwal, String tanggalAkhir){

        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{

            PdfFileExporter pdfFileExporter = new PdfFileExporter();
            ReportDto hasildata = dataReportDto(usersId,tanggalAwal, tanggalAkhir);

            Map<String, Object> data = createData(hasildata);

            String pdfFileName = ""+ UUID.randomUUID()+"-"+"laporanTransaksi"+usersId+".pdf";
            pdfFileExporter.exportPdfFile("transactionReport", data, pdfFileName);
            String dataRespon = "berhasil";

            /* PDF TO BYTE */
            Path pdfPath = Paths.get(""+pdfFileName);
            System.out.println(pdfPath.toAbsolutePath());
            byte[] pdf = Files.readAllBytes(pdfPath);
            System.out.println("byte nyaaa "+pdf);

            File pdfSigned = new File( ""+pdfPath);

            System.out.println("pdfSigned : " + pdfSigned);

            /*NADINE*/
            /* Delete file + upload hdfs */
            deleteFile(String.valueOf(pdfPath));

            msg.setStatus(true);
            msg.setMessage("Success");
            msg.setData(pdf);
            return ResponseEntity.ok().body(msg);

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }

    }

    public static void deleteFile(String namaFIle) {

        try {
            File file = new File(namaFIle);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ReportDto dataReportDto(String usersId, String tanggalAwal, String tanggalAkhir) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        Long total =0L;
        Users hasil = usersRepository.getUsersbyId(UUID.fromString(usersId));
        List<ReportDetailDto> detail = reportClassRepository.getDataReport(usersId,tanggalAwal,tanggalAkhir);
        for(ReportDetailDto maps:detail){
            total=total+ maps.getAmount();
        }

        ReportDto data = new ReportDto();
        data.setNama(hasil.getName());
        data.setUsersId(usersId);
        data.setPeriode(tanggalAwal+" - "+tanggalAkhir);
        data.setReportDetailDtos(detail);
        data.setTotal(total);

        return data;
    }

    public static Map<String, Object> createData(ReportDto reportDto){
        Map<String, Object> data = new HashMap<>();
        data.put("data", reportDto);
        return data;
    }

}
