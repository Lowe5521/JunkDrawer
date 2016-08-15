package com.jonkoester.junkdrawer;

import android.support.test.rule.UiThreadTestRule;
import android.util.Log;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AlwaysRunOnUIThreadRule extends UiThreadTestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new LoggingStatementDecorator(super.apply(base, description), getTestName(description));
    }

    private String getTestName(Description description) {
        return description.getTestClass().getName() + "." + description.getMethodName();
    }

    @Override
    protected boolean shouldRunOnUiThread(Description description) {
        return true;
    }

    private class LoggingStatementDecorator extends Statement {
        private final Statement base;
        private final String testName;

        public LoggingStatementDecorator(Statement base, String testName) {
            this.base = base;
            this.testName = testName;
        }

        @Override
        public void evaluate() throws Throwable {
            long startTest = System.currentTimeMillis();
            Log.i(AlwaysRunOnUIThreadRule.class.getSimpleName(), "** STARTING TEST " + testName + " **");
            try {
                base.evaluate();
            } finally {
                Log.i(AlwaysRunOnUIThreadRule.class.getSimpleName(), "** COMPLETED TEST " + testName + " " + (System.currentTimeMillis() - startTest) + " ms **");
            }
        }
    }
}
