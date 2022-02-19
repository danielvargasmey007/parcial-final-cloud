package com.cloud.showtimes.services;

import java.util.List;

import com.cloud.showtimes.domain.ShowTimes;

public interface ShowTimeService {

    List<ShowTimes> getShowTimes();

    ShowTimes createShowTimes(ShowTimes showTimes);

    ShowTimes getShowTimesById(Long id);
}
