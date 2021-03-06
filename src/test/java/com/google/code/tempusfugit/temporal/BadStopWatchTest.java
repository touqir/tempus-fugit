/*
 * Copyright (c) 2009-2012, toby weston & tempus-fugit committers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.tempusfugit.temporal;

import com.google.code.tempusfugit.concurrency.ThreadUtils;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static com.google.code.tempusfugit.temporal.Duration.millis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Ignore ("example of how not to implement a stop watch")
public class BadStopWatchTest {

    private final Mockery context = new JUnit4Mockery();

    @Test
    public void getElapsedTime() {
        BadStopWatch watch = new BadStopWatch();
        ThreadUtils.sleep(millis(100));
        assertThat(watch.getElapsedTime(), is(millis(100)));
    }

    public static class BadStopWatch {

        private Date startDate;

        public BadStopWatch() {
            this.startDate = new Date();
        }

        public Duration getElapsedTime() {
            return millis(new Date().getTime() - startDate.getTime());
        }

    }
}
