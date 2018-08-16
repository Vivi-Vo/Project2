export enum Status {
    PASSED = 'Passed',
    FAILED = 'Failed',
    SKIPPED = 'Skipped'
}

export interface TestMethod {
    recordID: number;
    BatchID: number;
    InitiatedBy: string;
    status: number;
    signature: string;
    name: string;
    duration_ms: number;
    startedTime: Date;
    finishedTime: Date;
    exceptionClass: string | null;
    exceptionMessage: string | null;
    stackTrace: string | null;
    showStackTrace: boolean | undefined;
}

