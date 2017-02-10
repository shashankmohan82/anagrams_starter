package com.google.engedu.anagrams;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by shashank on 10/18/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnitTestSample {
    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;

//    @Test
//    public void readStringFromContext_LocalizedString() throws IOException {
//        // Given a mocked Context injected into the object under test...
//        when(mMockContext.getString(R.string.app_name))
//                .thenReturn(FAKE_STRING);
//        AnagramDictionary myObjectUnderTest = new AnagramDictionary(mMockContext);
//
//        // ...when the string is returned from the object under test...
//        String result = myObjectUnderTest.getHelloWorldString();
//
//        // ...then the result should be the expected one.
//        assertThat(result, is(FAKE_STRING));
//    }
}
