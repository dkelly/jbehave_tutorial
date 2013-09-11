package com.macadamian.jbehave_tutorial;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import static org.jbehave.core.reporters.Format.ANSI_CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;

import java.util.List;

public class PurchasingScenario extends JUnitStory {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // location of narratives
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // report to console and text file
                .useStoryReporterBuilder(
                    new StoryReporterBuilder().withDefaultFormats().withFormats(ANSI_CONSOLE, TXT));
//                        StoryReporterBuilder.Format.HTML,
//                        StoryReporterBuilder.Format.XML
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(
            configuration(), new PurchasingScenarioSteps()).createCandidateSteps();
    }
}
