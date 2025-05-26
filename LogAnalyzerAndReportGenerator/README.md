# Log Analyzer and Controller

A Java-based Log Analyzer that processes `.log` files from given directories, counts the occurrences of `ERROR`, `WARNING`, and `INFO` messages, and stores the results in a MySQL database using JDBC.

## Features
- Scans multiple directories for `.log` files
- Multithreaded processing using `ExecutorService`
- Thread-safe log level counting using `ConcurrentHashMap`
- Counts:
    - `ERROR`
    - `WARNING`
    - `INFO`
- Stores aggregated results to a database using JDBC.
