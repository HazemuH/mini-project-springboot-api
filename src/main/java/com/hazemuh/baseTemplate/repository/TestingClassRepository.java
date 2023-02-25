package com.hazemuh.baseTemplate.repository;

import com.hazemuh.baseTemplate.dto.TestingDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TestingClassRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<TestingDto> getDataTesting() {
        {

            Query query = entityManager.createNativeQuery("select * from public.td_testing");

            List hasil = query.getResultList();
            List<TestingDto> result = new ArrayList<>();

            Iterator itr = hasil.iterator();
            while (itr.hasNext()) {
                TestingDto browse = new TestingDto() {
                };
                Object[] obj = (Object[]) itr.next();
                String nama = String.valueOf(obj[0]);
                String umur = String.valueOf(obj[1]);

                browse.setNama(nama);
                browse.setUmur(umur);

                result.add(browse);
            }
            entityManager.close();
            return result;
        }
    }

}
