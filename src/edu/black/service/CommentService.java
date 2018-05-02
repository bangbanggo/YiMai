package edu.black.service;

import edu.black.model.EasybuyComment;

import java.util.List;

public interface CommentService {
    public boolean insert(EasybuyComment comment);
    public boolean delete(EasybuyComment comment);
    public boolean update(EasybuyComment comment);
    public EasybuyComment getComment(int commentid);
    public List<EasybuyComment> getComments(EasybuyComment comment);
    public List<EasybuyComment> getHistory(List<Integer> ids);
}
