##  Difference Between `volatile` and `AtomicInteger` in Java

| Feature               | `volatile`                                                | `AtomicInteger`                                                |
|-----------------------|-----------------------------------------------------------|----------------------------------------------------------------|
| **Purpose**           | Ensures visibility of variable changes across threads     | Provides atomic operations for integer variables               |
| **Thread Safety**     | Only guarantees visibility, **not atomicity**             | Guarantees atomicity for compound operations                   |
| **Supported Operations** | Read/write only                                       | Atomic `increment`, `decrement`, `getAndSet`, `compareAndSet`, etc. |
| **Use Case**          | Use when a variable is accessed concurrently but **not modified** in a compound way | Use when multiple threads **update** a shared counter or flag  |
| **Limitation**        | `count++` is not thread-safe even if `count` is `volatile`| Atomic methods prevent race conditions                         |
