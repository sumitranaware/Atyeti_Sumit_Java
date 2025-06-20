##  Java Stream API: `Collectors.teeing()` (Java 12+)

`Collectors.teeing()` is a powerful feature introduced in Java 12 that allows you to perform **two independent stream operations in parallel** and **combine their results**.

###  Syntax:
```java
Collectors.teeing(collector1, collector2, mergerFunction)


