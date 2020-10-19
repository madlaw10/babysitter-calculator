#Babysitter Invoice Calculator

Console application to create an invoice for a single babysitting job. 
Babysitter supplies the times shift started and ended, and time child 
went to bed, if applicable. Preset rates are applied to each time frame
(time child is awake, time child is asleep, and overtime/past midnight). 
Babysitter is compensated for the full hour of each shift, regardless of 
start or end times.

### Project Details and Requirements
* Java Version: 11
* Highly suggest running application and tests in preferred IDE 
(bts: I was unable to use the command line prompts below after 
including a second class in this project, and struggled to resolve issue) 

### Build & Test Application
Run from command line in root project directory
```
./gradlew clean build
```
### Run Unit Tests
Tests can be run in IDE:
1. Navigate to file ShiftTest.java
2. Select to run all tests or a single test

### Start Calculator
Run from command line in root project directory
```
./gradlew run
```
Alternatively, calculator can be started from IDE: 
1. Navigate to file BabysitterCalculatorApplication.java
2. Run BabysitterCalculatorApplication.main()
3. Interact with calculator in IDE terminal

### Future Iterations
* Validate time inputs are 1) expected format and return error message if not, 
and 2) logical (ie end time is not before start time).
* Allow for sitter to provide their desired hourly rate for each shift type.
