# Project2
Revature Project2

<!-- TOC -->

- [Project2](#project2)
    - [Setup](#setup)
        - [Frontend](#frontend)
        - [Database](#database)
        - [API](#api)
    - [Structure](#structure)

<!-- /TOC -->

## Setup
---
### Frontend

1. Navigate to the frontend directory
    ```
    cd frontend
    ```

2. Install dependencies

    *Recommended to use yarn*
    ```
    // this wil install the yarn tool globally for use in the shell
    npm install -g yarn

    // tool used to automate Angular development
    npm install -g ng-cli
    ```
    ```
    // This command will install all dependencies
    yarn
    ```

3. Test working frontend
    ```
    ng serve
    ```
    **This should open the web application for you to see in browser if this is not the case something went wrong**

### Database

1. Download [Oracle SQL Developer](http://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html)

2. Create an RDS instance on [Amazon Web Services](https://aws.amazon.com/rds/?nc2=h_m1)

3. Connect to your RDS using Oracle SQL Developer

4. Open the [setup script](database/setup.sql) in Oracle SQL Developer and run it

### API

1. Download [Spring](https://spring.io/tools)
2. Open workspace and import new project

    1. Right click on Project Explorer
    2. Select Import
    3. Select Existing Maven Project
    4. Set the base directory to be api/
    5. Finish


## Structure
---

- [frontend](frontend/)
    - contains the code for the frontend angular application
- [api](api/)
    - contains the Java code for the api layer of the application
- [database](database/)
    - contains the scripts associated with the database
        - setup: will create all necessary tables, procedures, constraints ect.
        - teardown: will completely remove the project from a database
        
        NOTE: In the future there will be mock data that will be stored here 
- [ci](ci/)
    - contains scripts for the use of the CI for the project
- [docs](docs/)
    - will house all documentation for the project
