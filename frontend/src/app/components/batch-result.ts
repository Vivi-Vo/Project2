import { TestMethod } from './test-method';

export interface BatchResult {
    // skipped: number;
    // failed: number;
    // total: number;
    // passed: number;
    // suiteName: string;
    // durationMS: number;
    // startedAt: Date;
    // finishedAt: Date;
    // className: string;
    status: number;
    testMethods: TestMethod[];
}
