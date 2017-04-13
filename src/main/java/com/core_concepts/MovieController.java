package com.core_concepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by chrisaanerud on 4/12/17.
 */

@SuppressWarnings("ALL")
@Controller
public class MovieController {

    @Autowired
    MovieRepository repository;

    @RequestMapping("/")
    public String listMovies(Model model){

        model.addAttribute("movies", repository.listMovies());

        return "index";
    }

    @RequestMapping(path = "/enterMovies", method = RequestMethod.POST)
    private String enterMovies(Model model, Movie movie, Star star){

        model.addAttribute("movie", movie);
        model.addAttribute("star", star);
        model.addAttribute("id", repository.getMovie(movie.getId()));

        return "success";
    }

    }

