package com.camp.camping.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.ReviewDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ReviewMapper;


@Service
public class ReviewService implements MyService<Integer, ReviewDTO> {

    @Autowired
    ReviewMapper mapper;
    @Autowired
    SiteService siteService;
    @Autowired
    BookService bookService;

    @Override
    public void insert(ReviewDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(ReviewDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public ReviewDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<ReviewDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public List<ReviewDTO> selectBySiteCode(int site_code){
        return mapper.selectBySiteCode(site_code);
    }

    public List<ReviewDTO> selectByCompanyCode(int company_code) {
        return mapper.selectByCompanyCode(company_code);
    }

    public int GetSiteCodeByReview(ReviewDTO review) throws Exception {
        return bookService.select(review.getBook_code()).getSite_code();
    }

    public String GetSiteNameByReview(ReviewDTO review) throws Exception {
        return siteService.select(GetSiteCodeByReview(review)).getSite_name();
    }

    public List<ReviewDTO> selectMainReview(int company_code) throws Exception{
        return mapper.selectMainReview(company_code);
    }
}
