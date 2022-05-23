Paying off technical debt
--------------------------
1. Courses, Insturctor and Department structure.
    - Originally we write the class Courses and Insturctor as a subclass of Department so that it would be easy for us to implement and have a quick view of what the final page would look like. But actually Courses and Insturctor should never be a subclass of Department even by common  sense. So this is a Reckless and Deliberate technical debt. In order to pay the debt, in iteration 2 we have to rewrite the entire three class so that they do not extend and support each other anymore. [This is where the new classes after paying technical debt is located](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/tree/main/app/src/main/java/comp3350/studymanager/Object). 
2. Fack database vs hsqldb
    - For iteration 1 we used an array as a fack database for class signin as insturction tells us. Though it is easy to implement and have a quick view of the output, we still need to make a real database for the project. So this is a prudent and Deliberate technical debt. In order to pay the debt, we tried hard on self learning on how to add a hsqldb to replace the fack database we had which took us almost the entire iteration. [Here is a link to the hsqldb implimented for signin](app/src/main/java/comp3350/studymanager/Persistence/hsqldb/userHSQLDB.java).

SOLID
--------------------------
Link to the SOLID violation we found for Group 2 are [here](https://code.cs.umanitoba.ca/winter-2022-a01/group-2/student-study-stats/-/issues/108).


Retrospective
--------------------------
The retrospective from iteration 1 has greatly changed the way we doing our project. We started our iteration 2 as early as we can, and held way more meeting than we had in iteration 1 to make sure everyone is on the right track and finish assigned jobs on time as planed. For some tasks we found that it requires more linking in object-oriented such as adding courses for perticuler user and also that includes storing its data into database which we will not able to finish on this iteration, so we came together and we decided early and push it into next iteration 3 so that we would not waste our time on successfully implementing hsqldb in our rest of three feature. We also added more issues such as dev and testing issues has check mark for remind the important works which we did not do in iteration 1. Other than that, we implemented our original test as soon as we handed in iteration 1 so that we do not need to rush to write all the tests right before deadline like what we did in iteration 1.

We do not have evidence for the changes of increase meeting and discussion, but the evidence we had for update the old test file are [the commit right here](5e85e268fdf378b8cbbf6416fca663020dc0b336). Also take a look of our [issue page](https://code.cs.umanitoba.ca/winter-2022-a01/group-3/my-awesome-project-a01-3/-/issues) for all the new test and dev issue we made after retrospective from iteration 1.

Design patterns
---------------------------
A wellknown Design pattern we used is [Bridge](623bd516181a36a2e4cb635884c7c70cb059832f) line 17. 

Iteration 1 Feedback fixes
------------------------------
Group 2 did not requires any changes to our project for iteration 1. Thus we do not need to fix any issue.
