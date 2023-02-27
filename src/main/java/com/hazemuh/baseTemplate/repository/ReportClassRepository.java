package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.dto.ReportDetailDto;
import com.hazemuh.baseTemplate.dto.ReportDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ReportClassRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ReportDetailDto> getDataReport(String usersId, String tanggalAwal, String tanggalAkhir) {
        {

            Query query = entityManager.createNativeQuery("SELECT transaction_id,  project.users.\"name\" as name, project.users.users_id, \n" +
                    "project.transactions.created_at , description , amount, transaction_type as type \n" +
                    "FROM project.transactions \n" +
                    "INNER JOIN project.users \n" +
                    "ON project.transactions.users_id  = project.users.users_id \n" +
                    "WHERE project.transactions.users_id = '"+usersId+"' \n" +
                    "AND project.transactions.created_at  >= '"+tanggalAwal+"' \n" +
                    "AND project.transactions.created_at  <= '"+tanggalAkhir+"' \n" +
                    "ORDER BY project.transactions.created_at DESC");

            List hasil = query.getResultList();
            List<ReportDetailDto> result = new ArrayList<>();


            Iterator itr = hasil.iterator();
            while (itr.hasNext()) {
                ReportDetailDto browse = new ReportDetailDto();
                Object[] obj = (Object[]) itr.next();
                String transactions_id = String.valueOf(obj[0]);
                String name = String.valueOf(obj[1]);
                String users_id = String.valueOf(obj[2]);
                String created_at = String.valueOf(obj[3]);
                String descriptions = String.valueOf(obj[4]);
                String amount = String.valueOf(obj[5]);
                String type = String.valueOf(obj[6]);

                browse.setTransactionId(transactions_id);
                browse.setDate(created_at);
                browse.setType(type);
                browse.setDescription(descriptions);
                browse.setAmount(Long.valueOf(amount));

                result.add(browse);
            }
            entityManager.close();
            return result;
        }
    }

}
