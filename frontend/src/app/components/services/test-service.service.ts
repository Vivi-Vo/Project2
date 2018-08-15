import { Injectable } from '@angular/core';
import { TestResult } from '../test-result';
import { Status } from '../test-method';

export class TestService {

    public testNGResults: TestResult = {
        skipped: 0,
        failed: 1,
        passed: 3,
        total: 4,
        suiteName: 'Default Suite',
        durationMS: 20,
        startedAt: new Date('2015-03-10T06:11:58'),
        finishedAt: new Date('2015-03-10T06:11:58'),
        className: 'com.javacodegeeks.testng.reports.TestClass2',
        testMethods: [
            {
                status: Status.PASSED,
                signature: 'c1()[pri:0, instance:com.javacodegeeks.testng.reports.TestClass2@1c2c22f3]',
                name: 'c1',
                durationMS: 0,
                startedAt: new Date('2015-03-10T11:41:58'),
                finishedAt: new Date('2015-03-10T11:41:58'),
                exception: null,
                stackTrace: null
            },
            {
                status: Status.PASSED,
                signature: 'c2()[pri:0, instance:com.javacodegeeks.testng.reports.TestClass2@1c2c22f3]',
                name: 'c2',
                durationMS: 0,
                startedAt: new Date('2015-03-10T11:41:58Z'),
                finishedAt: new Date('2015-03-10T11:41:58Z'),
                exception: null,
                stackTrace: null
            },
            {
                status: Status.PASSED,
                signature: 'c3()[pri:0, instance:com.javacodegeeks.testng.reports.TestClass2@1c2c22f3]',
                name: 'c3',
                durationMS: 10,
                startedAt: new Date('2015-03-10T11:41:58Z'),
                finishedAt: new Date('2015-03-10T11:41:58Z'),
                exception: null,
                stackTrace: null
            },
            {
                status: Status.FAILED,
                signature: 'c4()[pri:0, instance:com.javacodegeeks.testng.reports.TestClass2@1c2c22f3]',
                name: 'c4',
                durationMS: 0,
                startedAt: new Date('2015-03-10T11:41:58'),
                finishedAt: new Date('2015-03-10T11:41:58'),
                exception: 'java.lang.AssertionError',
                // tslint:disable-next-line:max-line-length
                stackTrace: `expected [true] but found [false] at org.testng.Assert.fail(Assert.java:94) at org.testng.Assert.failNotEquals(Assert.java:494) at org.testng.Assert.assertTrue(Assert.java:42) at org.testng.Assert.assertTrue(Assert.java:52) at com.javacodegeeks.testng.reports.TestClass2.c4(TestClass2.java:22) at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) at java.lang.reflect.Method.invoke(Unknown Source) at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84) at org.testng.internal.Invoker.invokeMethod(Invoker.java:714) at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901) at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231) at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127) at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111) at org.testng.TestRunner.privateRun(TestRunner.java:767) at org.testng.TestRunner.run(TestRunner.java:617) at org.testng.SuiteRunner.runTest(SuiteRunner.java:334) at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329) at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291) at org.testng.SuiteRunner.run(SuiteRunner.java:240) at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52) at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86) at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224) at org.testng.TestNG.runSuitesLocally(TestNG.java:1149) at org.testng.TestNG.run(TestNG.java:1057) at org.testng.remote.RemoteTestNG.run(RemoteTestNG.java:111) at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:204) at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:175)
                `
            }
        ]
    }; // TODO: Ditch and use actual data

    constructor() {}

}
//     <test name="Default test" duration-ms="20" started-at="2015-03-10T06:11:58Z" finished-at="2015-03-10T06:11:58Z">
