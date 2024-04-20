package com.find.figurefinder.figurefinder;

import com.deepl.api.LanguageCode;
import com.find.figurefinder.transformation.LanguageTransformation;
import org.junit.jupiter.api.Test;

public class LanguageTransClassTest {

    @Test
    public void requestTransWordTest() {

        LanguageTransformation languageTransformation = new LanguageTransformation(LanguageCode.Korean, LanguageCode.Japanese);

        String text = languageTransformation.requestTransWord("안녕하세요.");

        System.out.println(text);
    }
}
