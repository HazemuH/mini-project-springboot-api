package com.hazemuh.baseTemplate.service;

import com.hazemuh.baseTemplate.dto.ReportDetailDto;
import com.hazemuh.baseTemplate.dto.ReportDto;
import com.hazemuh.baseTemplate.entity.Users;
import com.hazemuh.baseTemplate.repository.ReportClassRepository;
import com.hazemuh.baseTemplate.repository.transactionsRepository;
import com.hazemuh.baseTemplate.repository.usersRepository;
import com.hazemuh.baseTemplate.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DataService {
   @Autowired
   private ReportClassRepository reportClassRepository;
   @Autowired
   private transactionsRepository transactionsRepository;
   @Autowired
   private usersRepository usersRepository;

    public ReportDto DataReportDto(String usersId, String tanggalAwal, String tanggalAkhir) {
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
        data.setPeriode(tanggalAwal+" s/d "+tanggalAkhir);
        data.setReportDetailDtos(detail);
        data.setTotal(total);

        return data;
    }

}
