export enum Status {
    PASSED = 'Passed',
    FAILED = 'Failed',
    SKIPPED = 'Skipped'
}

export interface TestMethod {
    status: Status;
    signature: string;
    name: string;
    durationMS: number;
    startedAt: Date;
    finishedAt: Date;
    exception: string | null;
    stackTrace: string | null;
}
