import { TestMethod } from './test-method';

/**
 * Expected type recieved from DB for a full batch of tests
 */
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
    batchId: number;
    status: number;
    tests: TestMethod[];
}

export interface BatchID {
    batchID: number;
    passFail: number;
}
