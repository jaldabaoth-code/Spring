package com.wildcodeschool.wildandwizard.repository.injection.injectionSample;

import com.wildcodeschool.wildandwizard.model.injection.injectionSample.InjectionSampleReview;

/* Quest : Injection Sample */
public interface InjectionSampleReviewDao {
    void sendGame(String game);

    void review();

    InjectionSampleReview getReview();
}
