/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.Prescription;
import java.util.List;

/**
 *
 * @author siva
 */
public interface PrescriptionDataService {
    public Prescription getPrescriptionByName(String name);
    public Prescription getPrescriptionById(Long id);
    public List<Prescription> getPrescriptionsBasedOnDescriptionKeyWord(String keyWord);
    public List<Prescription> getPrescriptionsBasedOnDescriptionKeyWords(List<String> keyWords);
    public List<Prescription> getAllPrescriptions();
    
}
