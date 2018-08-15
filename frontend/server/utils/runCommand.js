const util = require('util');
const exec = util.promisify(require('child_process').exec);

module.exports = function runCommand(command) {
    return new Promise(async(resolve, reject) => {
        try {
            const {stdout, stderr} = await exec(command, {cwd: "C:\\Users\\qiunn\\Documents\\Reveture\\Projects\\project2\\api"});
            
            if (stderr !== '') {
                reject(stderr);
            } else {
                resolve(stdout);
            }
        } catch (err) {
            reject(err);
        }
    });
};