What technical debt has been cleaned up
========================================

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.

For iteration 2 in order to quickly see the result of improted HSQLDB, we have some directed database access in presentation layer instead of logic layer. In iteration 3, we moved all those codes into logic layer so that everything are located at the place where they should belong.The changes happens internally so there are no specific commit that shows the pay off. Pleace check all changed file at [this location](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/tree/main/app/src/main/java/comp3350/studymanager).

What technical debt did you leave?
==================================

What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.

For quick multy feature development, the database table are created to specific features, which causing a issue that all the database tables has no connection with each other. We would like to fix this problem but due to the time limit we could not do it in this iteration.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.

The be begining of Iteration 3, for the feature "[Note sharer](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/issues/20)" we decided not to do(cut) this feature. Because this is base on different user and database sharing, which we do no have the ability to make it work. 

Acceptance test/end-to-end
==========================

Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.

TO-Do list, from login, delet all db after testing
When testing the to-do list, we symulate a new user to start using our app from registeration, then all the way to the phase where they add a task in to-do list, mark it as finished, and delet the task. In order to make sure it is not flaky, we clean the user data everytime when runing the test, and during the test, we alway do the same create-and-delete operation for the task so that there are nothing changes after we run the test. So that we can make sure that every time we run the test for to-do list it would function in the same way and not flaky. The test is [right here](app/src/test/java/comp3350/studymanager/persistenceLayer/toDoListNotePersistenceStub.java).

Acceptance test, untestable
===============

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?

When testing the freature "note", we could not test the user story of deleting a note, because the original design for deletion is "long press" to prevent slip, but Espresso does not support long pressing operation, so for testing that is impossible for us.

Velocity/teamwork
=================

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.

The estimation is getting better from iteration 0 to iteration 3. Check our [Velocity graph](velocitygraph.png).
