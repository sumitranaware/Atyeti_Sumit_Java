#  Java ArrayList Deep Dive – Practice Questions and Explanations

This package contains advanced-level Java ArrayList scenarios explored and solved for better understanding of internal behavior, performance, and corner cases.

---

##  Solved Questions

### 1. How does ArrayList grow internally when the capacity is exceeded?
**🔍 Problem Statement:**  
Simulate ArrayList growth by adding 1000 elements and observe how internal capacity changes.

**Explored:**
- Default capacity and growth pattern.
- Used `ArrayList.ensureCapacity()` and `.size()` as a workaround (reflection avoided due to module restrictions).
- Observed resizing behavior indirectly.

---

### 2. What is the cost of inserting elements at different positions in an ArrayList?
**🔍 Problem Statement:**  
Measure and compare the time to insert elements at:
- Beginning
- Middle
- End  
  Using 100,000 elements in each case.

**Explored:**
- Performance significantly slower for beginning and middle due to shifting.
- End insertion is fastest (`O(1)` amortized).

---

### 3. What happens to element positions when inserting or removing in an ArrayList?
**🔍 Problem Statement:**  
Add elements from 1–10, then:
- Insert at index 4
- Remove at index 4  
  Verify shifting and list consistency.

**Explored:**
- Confirmed all elements after index are shifted on insert/remove.

---

### 4. Can ArrayList store null elements? How are they handled in search and remove?
**🔍 Problem Statement:**
- Add multiple `null`s to an ArrayList.
- Use `.contains(null)`
- Use `.remove(null)`
- Count nulls using streams.

**Explored:**
- ArrayList allows `null` values.
- `.contains(null)` and `.remove(null)` work without exception.
- Counted using streams: `list.stream().filter(Objects::isNull).count()`.

---

### 5. How does ArrayList handle concurrent modification?
**🔍 Problem Statement:**  
Iterate using enhanced-for loop and modify list inside loop.

**Explored:**
- Throws `ConcurrentModificationException`.
- Safe alternatives:
    - Use `Iterator` and `iterator.remove()`.
    - Use `CopyOnWriteArrayList`.

---

### 6. What is the effect of trimming an ArrayList?
**🔍 Problem Statement:**  
Add 1000 elements, remove 900, then call `.trimToSize()`.

**Explored:**
- `.trimToSize()` reduces capacity to current size.
- Demonstrated memory optimization.
- Used indirect verification of capacity via performance and profiling.

---

### 7. How do object references behave inside an ArrayList?
**🔍 Problem Statement:**  
Create a class `Person`, add one object multiple times, modify one, observe changes.

**Explored:**
- All references in the list point to the same object.
- Modifying one reflects in all appearances.

---

### 8. How does subList interact with original ArrayList?
**🔍 Problem Statement:**  
Create subList, modify it, clear it, and observe original list.

**Explored:**
- `subList` is a view (shallow).
- Modifying `subList` affects original.
- Clearing `subList` removes elements from original.
- Warning: Avoid structural modification on original list while using `subList`.

---


