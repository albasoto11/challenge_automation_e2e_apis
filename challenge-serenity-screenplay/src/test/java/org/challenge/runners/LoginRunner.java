package org.challenge.runners;
import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key   = PLUGIN_PROPERTY_NAME,
        value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel"
)
@ConfigurationParameter(
        key   = GLUE_PROPERTY_NAME,
        value = "org.challenge.stepDefinition"
)
@ConfigurationParameter(
        key   = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME,
        value = "true"
)

public class LoginRunner {}
