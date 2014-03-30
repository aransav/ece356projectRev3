/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uw.proj.service;

import ca.uw.proj.model.User;

/**
 *
 * @author siva
 */
public interface AuthenticationService {
    public boolean authenticate(User user);
    public boolean authenticate(String username, String password);
}
