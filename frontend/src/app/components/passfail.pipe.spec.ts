import { PassfailPipe } from './passfail.pipe';

describe('PassfailPipe', () => {
  it('create an instance', () => {
    const pipe = new PassfailPipe();
    expect(pipe).toBeTruthy();
  });
});
