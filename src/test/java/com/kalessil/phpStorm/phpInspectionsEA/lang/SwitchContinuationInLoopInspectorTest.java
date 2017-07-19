package com.kalessil.phpStorm.phpInspectionsEA.lang;

import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.languageConstructions.SwitchContinuationInLoopInspector;

final public class SwitchContinuationInLoopInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testIfFindsAllPatterns() {
        myFixture.configureByFile("fixtures/lang/continue-in-switch.php");
        myFixture.enableInspections(SwitchContinuationInLoopInspector.class);
        myFixture.testHighlighting(true, false, true);
    }
}