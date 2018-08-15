import { TestMethod } from './test-method';

export interface TestResult {
    skipped: number;
    failed: number;
    total: number;
    passed: number;
    suiteName: string;
    durationMS: number;
    startedAt: Date;
    finishedAt: Date;
    className: string;
    testMethods: TestMethod[];
}
