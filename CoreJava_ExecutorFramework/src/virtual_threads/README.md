# Java Virtual Threads (Project Loom - Java 21+)

Java Virtual Threads are a lightweight concurrency feature introduced in **Java 21** under **Project Loom**. They enable high-throughput, scalable applications by allowing you to spawn **millions of threads** with minimal overhead.

---

## What Are Virtual Threads?

> Virtual Threads are managed by the JVM, not the OS.  
> They're ideal for I/O-bound, highly concurrent applications.

###  Key Properties:
- Use the same `Thread` API.
- Created via `Thread.startVirtualThread()` or `Executors.newVirtualThreadPerTaskExecutor()`.
- Managed internally by the JVM using **carrier threads**.
- Do **not block** OS threads during `sleep()`, `I/O`, or `wait()` (when intercepted by JVM).

---

## Why Use Virtual Threads?

| Feature | Platform Threads | Virtual Threads |
|--------|------------------|-----------------|
| Memory per thread | ~1MB | ~a few KB |
| Thread limit | Thousands | Millions |
| Scheduling | OS-based | JVM-based |
| Ideal for | CPU-bound | I/O-bound |

---

##  Code Examples

### Mass Concurrency with Sleep

```java
ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
for (int i = 0; i < 100_000; i++) {
    executor.submit(() -> Thread.sleep(1000));
}
