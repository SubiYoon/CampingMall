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

    public List<ReviewDTO> selectByCompanyCode(int company_code) {
        return mapper.selectByCompanyCode(company_code);
    }

    public int GetSiteCodeByReview(ReviewDTO review) throws Exception {
        return bookService.select(review.getBook_code()).getSite_code();
    }

    public String GetSiteNameByReview(ReviewDTO review) throws Exception {
        return siteService.select(GetSiteCodeByReview(review)).getSite_name();
    }

    public Map<String, Double> ReviewScore(int company_code) throws Exception {
        Map<String, Double> reviewCountMap = new TreeMap<>();
        List<ReviewDTO> reviews = selectByCompanyCode(company_code);
        int count = 1;
        int beforeSiteCode = 0;
        String beforeSiteName = "";
        for (ReviewDTO review : reviews) {
            if (beforeSiteCode == GetSiteCodeByReview(review)) {
                reviewCountMap.put(beforeSiteName,
                    reviewCountMap.get(beforeSiteName) + review.getReview_score());
                count++;
            } else {
                if (!beforeSiteName.equals("")) {
                    reviewCountMap.put(beforeSiteName,
                        reviewCountMap.get(beforeSiteName) / count);
                }
                count = 1;
                beforeSiteName = GetSiteNameByReview(review);
                beforeSiteCode = GetSiteCodeByReview(review);
                reviewCountMap.put(beforeSiteName, (double) review.getReview_score());
            }
            if (!beforeSiteName.equals("")) {
                reviewCountMap.put(beforeSiteName,
                    reviewCountMap.get(beforeSiteName) / count);
            }
        }
        return reviewCountMap;
    }
}
