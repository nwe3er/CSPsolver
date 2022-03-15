# CSPsolver

This project is a constraint satisfaction problem solver using backtracking and forward checking.

The CSP chooses variable according to the most constrained variable heuristic, breaking ties using the most constraining variable heuristic. If more than one variable remains after applying these heuristics, break ties alphabetically.

The CSP chooses values according to least constraining value heuristic.

The "Test Cases" folder contains 3 sample test cases.

To Run

Command line arguments :

.var file which contains a list of variables.
.con file which contains a list of constraints.
consistency enforcing procedure "none" for only backtracking and "fc" for backtracking with forward checking.

Example arguments:

java Main ex1.var ex1.con fc 

java Main ex2.var ex2.con none
