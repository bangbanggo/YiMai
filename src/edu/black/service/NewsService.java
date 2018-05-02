package edu.black.service;


import edu.black.model.EasybuyNews;

import java.util.List;

public interface NewsService {
    public boolean insert(EasybuyNews news);
    public boolean delete(EasybuyNews news);
    public boolean update(EasybuyNews news);
    public EasybuyNews getNews(int newsid);
    public List<EasybuyNews> getNewss(EasybuyNews news);
    public List<EasybuyNews> getHistory(List<Integer> ids);
}
