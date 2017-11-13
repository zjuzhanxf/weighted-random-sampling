# weighted-random-sampling
1. Clone the project to local machine. <br>
2. Open the project with Intellij <br>
3. In Intellij, go to Run -> Edit Configuration -> Program arguments, enter the arguments. For example: 1000 0.3 0.2 0.15 0.35 means
the number of total samples is 1000. The weights of 1, 2, 3, 4 is 0.3, 0.2, 0.15 and 0.35, respectively.
4. Go to Run -> Run 'Main'. The program will be executed. The output will be printed in the console. Below is an example.
```
===== Input =====
Sample 1 weight: 0.3
Sample 2 weight: 0.2
Sample 3 weight: 0.15
Sample 4 weight: 0.35
Total number of samples: 10000

===== Output =====
1 is sampled 3078 times. Probability: 0.3078
2 is sampled 1982 times. Probability: 0.1982
3 is sampled 1472 times. Probability: 0.1472
4 is sampled 3468 times. Probability: 0.3468

Process finished with exit code 0
```
