#  Spring Core Deep Dive 

This document covers **Spring Core internals**, focusing on the IoC Container, Dependency Injection (DI), Bean Lifecycle, and internal behaviors of the Spring Framework. Includes theoretical insights, hands-on problems, and interview-ready questions.

---

##  Topics Covered

###  IoC (Inversion of Control) Container
- Delegates the creation and management of objects (beans) to the container.
- Promotes loose coupling and easier testing.

###  Dependency Injection Types
- **Constructor Injection**: Mandatory dependencies, preferred for immutability and testability.
- **Setter Injection**: Optional dependencies.
- **Field Injection**: Easy to use but discouraged due to testability issues.

###  Bean Lifecycle
1. Instantiate bean
2. Populate dependencies
3. Aware interfaces (BeanNameAware, BeanFactoryAware)
4. `@PostConstruct` method
5. `afterPropertiesSet()` from `InitializingBean`
6. Custom `init-method`
7. Use phase
8. Cleanup (`@PreDestroy`, `DisposableBean`)

---

##  Internal Concepts

###  ApplicationContext vs BeanFactory

| Feature              | BeanFactory  | ApplicationContext |
|----------------------|--------------|----------------|
| Lazy initialization |  Yes        |  No (Eager)    |
| Event handling       | No          |  Yes           |
| AOP support          |  Limited    | Full           |

- `ApplicationContext` is a superset and preferred in modern Spring apps.

### ️ Internal Bean Management Flow
1. Scan metadata (`@Component`, XML, etc.)
2. Register `BeanDefinition`
3. Instantiate with constructor/factory
4. Inject dependencies
5. Apply `BeanPostProcessor`s
6. Invoke lifecycle hooks
7. Manage scopes (`singleton`, `prototype`)

###  @ComponentScan Behavior
- Scans current and sub-packages for:
    - `@Component`
    - `@Service`
    - `@Repository`
    - `@Controller`
    - `@Configuration`

###  Important Annotations

| Annotation   | Description |
|--------------|-------------|
| `@Lazy`      | Defers bean creation until first use |
| `@Scope`     | Sets scope: `singleton`, `prototype`, etc. |
| `@Primary`   | Gives priority to one of many beans |
| `@Qualifier` | Disambiguates between multiple candidates |

---

##  Hands-on Problems

### Problem 1: Lightweight IoC Container in Core Java

```java
class Injector {
    private Map<Class<?>, Object> registry = new HashMap<>();
    public <T> void register(Class<T> type, T instance) {
        registry.put(type, instance);
    }
    public <T> T getInstance(Class<T> type) {
        return type.cast(registry.get(type));
    }
}
