#  Spring AOP (Aspect-Oriented Programming)

Spring AOP provides a way to modularize cross-cutting concerns like logging, transactions, and security. It allows you to separate these concerns from your core business logic using proxy-based interception.

---

##  Key Concepts

| Term         | Description |
|--------------|-------------|
| **Aspect**   | A module that encapsulates behaviors affecting multiple classes (e.g., Logging) |
| **Join Point** | A point in the program execution (method call, exception, etc.) |
| **Advice**   | Action taken by an aspect at a join point (Before, After, Around) |
| **Pointcut** | Expression that matches join points |
| **Weaving**  | Linking aspects with other application types or objects |

---

## ️ Common Use Cases

- Logging
- Transaction Management
- Exception Handling
- Performance Monitoring
- Authorization Checks

---

##  Annotations in Spring AOP

| Annotation          | Purpose |
|---------------------|---------|
| `@Aspect`           | Marks a class as an Aspect |
| `@Before`           | Advice runs before the method |
| `@After`            | Advice runs after the method (always) |
| `@AfterReturning`   | Advice runs after the method returns successfully |
| `@AfterThrowing`    | Advice runs if method throws an exception |
| `@Around`           | Advice wraps method execution |
| `@Pointcut`         | Reusable expressions for join points |

---

##  Example

```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }
}
