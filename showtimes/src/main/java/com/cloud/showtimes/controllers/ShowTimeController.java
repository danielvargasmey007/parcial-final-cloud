package com.cloud.showtimes.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.showtimes.domain.ShowTimes;
import com.cloud.showtimes.dto.ShowTimeDTO;
import com.cloud.showtimes.services.ShowTimeService;

@RestController
@RequestMapping("/showtimes")
public class ShowTimeController extends BaseController {

    private ShowTimeService showTimeService;

    @Autowired
    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ShowTimeDTO> getShowTime() throws Exception {
        List<ShowTimes> response = this.showTimeService.getShowTimes();

        List<ShowTimeDTO> responseDTO = response
                .stream()
                .map(st -> modelMapper.map(st, ShowTimeDTO.class))
                .collect(Collectors.toList());

        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ShowTimeDTO createUser(@Valid @RequestBody ShowTimeDTO showTimeDTO) throws Exception {
        ShowTimes movie = this.showTimeService
                .createShowTimes(modelMapper.map(showTimeDTO, ShowTimes.class));
        return modelMapper.map(movie, ShowTimeDTO.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ShowTimeDTO getMovieById(@Valid @PathVariable Long id) throws Exception {
        ShowTimes showTimes = this.showTimeService.getShowTimesById(id);
        return modelMapper.map(showTimes, ShowTimeDTO.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ShowTimeDTO updateUser(@Valid @RequestBody ShowTimeDTO showTimeDTO,
            @PathVariable Long id) throws Exception {
        ShowTimes movie = this.showTimeService
                .createShowTimes(modelMapper.map(showTimeDTO, ShowTimes.class));
        return modelMapper.map(movie, ShowTimeDTO.class);
    }
}
