/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.init;

import ca.uw.proj.service.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author siva
 */
public class initPop {
    
    @Autowired
    UtilitiesService util;
    
    public void runInitPop(){
        util.prePopulateDatabase();
    }
    
}
