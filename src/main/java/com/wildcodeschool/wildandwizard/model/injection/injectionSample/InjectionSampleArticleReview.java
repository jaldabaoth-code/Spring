package com.wildcodeschool.wildandwizard.model.injection.injectionSample;

import org.springframework.stereotype.Component;

/* Quest : Injection Sample */
@Component
public class InjectionSampleArticleReview extends InjectionSampleReview {
    @Override
    public void setTitle(String title) {
        super.setTitle("Article of " + title);
    }
}
