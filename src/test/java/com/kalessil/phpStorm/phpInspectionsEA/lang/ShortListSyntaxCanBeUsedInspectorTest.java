package com.kalessil.phpStorm.phpInspectionsEA.lang;

import com.jetbrains.php.config.PhpLanguageLevel;
import com.jetbrains.php.config.PhpProjectConfigurationFacade;
import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;
import com.kalessil.phpStorm.phpInspectionsEA.inspectors.languageConstructions.ShortListSyntaxCanBeUsedInspector;

final public class ShortListSyntaxCanBeUsedInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testIfFindsAllPatterns() {
        PhpProjectConfigurationFacade.getInstance(myFixture.getProject()).setLanguageLevel(PhpLanguageLevel.PHP710);

        myFixture.configureByFile("fixtures/lang/short-list-syntax.php");
        myFixture.enableInspections(ShortListSyntaxCanBeUsedInspector.class);
        myFixture.testHighlighting(true, false, true);
    }
}