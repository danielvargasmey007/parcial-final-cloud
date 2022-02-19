package com.cloud.showtimes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.showtimes.domain.ShowTimes;
import com.cloud.showtimes.repositories.ShowTimeRepository;
import com.cloud.showtimes.services.ShowTimeService;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    private ShowTimeRepository showTimeRepository;

    @Autowired
    public ShowTimeServiceImpl(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    @Override
    public List<ShowTimes> getShowTimes() {
        return this.showTimeRepository.findAll();
    }

    @Override
    public ShowTimes createShowTimes(ShowTimes showTimes) {
        return this.showTimeRepository.save(showTimes);
    }

    @Override
    public ShowTimes getShowTimesById(Long id) {
        return this.showTimeRepository.findById(id).orElse(null);
    }

}
