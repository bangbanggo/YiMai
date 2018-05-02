package edu.black.service;

import edu.black.model.EasybuyUser;

import java.util.List;

public interface UserService {
    public EasybuyUser login(EasybuyUser user);
    public boolean register(EasybuyUser user);
    public boolean updateUserInfo(EasybuyUser user);
    public boolean deleteUser(EasybuyUser user);
    public EasybuyUser getUserByUserId(EasybuyUser user);
    public List<EasybuyUser> getAll();
}
