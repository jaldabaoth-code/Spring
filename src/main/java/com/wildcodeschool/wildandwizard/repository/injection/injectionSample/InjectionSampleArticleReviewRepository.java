package com.wildcodeschool.wildandwizard.repository.injection.injectionSample;

import com.wildcodeschool.wildandwizard.model.injection.injectionSample.InjectionSampleReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.Random;

/* Quest : Injection Sample */
@Repository
public class InjectionSampleArticleReviewRepository implements InjectionSampleReviewDao {
    @Autowired
    @Qualifier("injectionSampleArticleReview")
    private InjectionSampleReview review;

    @Override
    public void sendGame(String game) {
        review.setTitle(game);
    }

    @Override
    public void review() {
        String[] reviews = {
            "Worst game ever made!",
            "Best game ever made!",
            "So-so...",
        };
        Random rand = new Random();
        review.setContent(reviews[rand.nextInt(3)]);
        review.setScore(new Random().nextInt(6));
    }

    @Override
    public InjectionSampleReview getReview() {
        return review;
    }
}