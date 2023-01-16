package com.wildcodeschool.wildandwizard.controller.injection.injectionSample;

import com.wildcodeschool.wildandwizard.model.injection.injectionSample.InjectionSampleReview;
import com.wildcodeschool.wildandwizard.repository.injection.injectionSample.InjectionSampleReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/* Quest : Injection Sample */
@Controller
public class InjectionSampleVideoReviewController {
    @Autowired
    @Qualifier("injectionSampleVideoReviewRepository")
    private InjectionSampleReviewDao reviewDao;

    @GetMapping("/injection/sample/video-review")
    @ResponseBody
    public InjectionSampleReview showReview(@RequestParam(required = false, defaultValue = "Untitled") String game) {
        reviewDao.sendGame(game);
        reviewDao.review();
        return reviewDao.getReview();
    }
}
