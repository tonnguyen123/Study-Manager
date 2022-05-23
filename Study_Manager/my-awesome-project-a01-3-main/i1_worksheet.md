Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Feature: Course detail and selector #8  
The user stories for the feature is:
- #27
- #30

We divided works based on feature, so for this specific feature, we assign one member for coding the course detail and choose course user story where he implemented the object layer and logic layer. Database is implemented by group, and one member for testing.
Once we were finished working individually, we come together and merged our program, and pushes it on GitLab.

Test files for the program.
- [Click here](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/tree/master/app/src/test/java/comp3350/studymanager)

Exceptional code
----------------

Exceptional code was used in the choosing course(courseSelection.java), when the user clicks on the EditView, the program will read a File so that it could load whole the courses and instructors. For the read part of the file, we used the try and catch exceptions so that if the file is not found by the program, then it will throw an exception but if the file is found it would load the details to the class accordingly. We did the test for Objects in the program such as Instructor, User and Course objects to test some of their methods. We also tested by running the app. However, we did not have enough time to create AllTest.java. We use try and catch here when reading a file [here](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/blob/master/app/src/main/java/comp3350/studymanager/presentation/courseSelection.java)

Branching
----------

Branching strategy is created in README.md [Click here](README.md#L18)

Screen shot:
![](Graph.png)


SOLID
-----

On March 2 we tried to look at group 4's Repository to find is there are any SOLID violation, but we found that they haven't upload any code for us to check at that time.

Agile Planning
--------------

Currently we are useing ArrayList for storing the data(fake database), which will be changed later to a real database(using hsqldb). So each time we reopen the program all the data will refresh.
Also we have just implemented the user to enter the name of the university manually which will later be changed to let the user select from the list of university we have in the database.
After the user has selected the section of the course they are enrolled, the user is taken back to the choose course part so they could select other courses, but the user is not able to see the list of the courses they have selected due to fake database, so that was moved to iteration 2 where the user could be able to see the list of the course. And also in this page there is a next button that has not implemented which also being moved to the next iteration so that when the user has clicked the next button, they shoud be able to move to another activity.

