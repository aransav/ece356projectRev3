/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uw.proj.service.impl;

import ca.uw.proj.dao.PrescriptionDAO;
import ca.uw.proj.model.Prescription;
import ca.uw.proj.service.PrescriptionDataService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author siva
 */
@Service
@Transactional
public class PrescriptionDataServiceImpl implements PrescriptionDataService {

    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Override
    public Prescription getPrescriptionByName(String name) {
        return prescriptionDAO.getPrescription("name", name).get(0);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionDAO.getPrescription("id", id).get(0);
    }

    @Override
    public List<Prescription> getPrescriptionsBasedOnDescriptionKeyWord(String keyWord) {
        return prescriptionDAO.getPrescription("description", "%" + keyWord + "%");
    }

    @Override
    public List<Prescription> getPrescriptionsBasedOnDescriptionKeyWords(List<String> keyWords) {
        List<Prescription> prescriptions = new ArrayList<Prescription>();
        for (String keyWord : keyWords) {
            List<Prescription> result = getPrescriptionsBasedOnDescriptionKeyWord(keyWord);
            if (result != null && !result.isEmpty()) {
                Set setboth = new HashSet(prescriptions);
                setboth.addAll(result);
                prescriptions.clear();
                prescriptions.addAll(setboth);
            }
        }
        return prescriptions;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescription();
    }

}
