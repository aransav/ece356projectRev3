/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author siva
 */
public interface UtilitiesService {
    public List<java.sql.Date> generateRangeDates(Date firstDate, Date lastDate);
    public void prePopulateDatabase();
}
