package com.kalessil.phpStorm.phpInspectionsEA.regularExpressions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.regularExpressions.NotOptimalRegularExpressionsInspector;

final public class NotOptimalRegularExpressionsInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testFindGreedyCharacterSets() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/greedy-character-sets.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testProblematicModifiers() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/problematic-modifiers.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testNestedQuantifiers() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/quantifier-compounds-quantifier.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testSenselessIgnoreCaseModifier() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/senseless-i-modifier.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testUnnecessaryCaseManipulation() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/unnecessary-case-manipulation.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testMissingUnicodeModifier() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/missing-u-modifier.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testPossibleCtypeUsages() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/ctype-functions-usage.php");
        myFixture.testHighlighting(true, false, true);
    }
    public void testPossiblePlainApiUsages() {
        myFixture.enableInspections(new NotOptimalRegularExpressionsInspector());
        myFixture.configureByFile("fixtures/regularExpressions/plain-api-usage.php");
        myFixture.testHighlighting(true, false, true);

        for (final IntentionAction fix : myFixture.getAllQuickFixes()) {
            myFixture.launchAction(fix);
        }
        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("fixtures/regularExpressions/plain-api-usage.fixed.php");
    }
}