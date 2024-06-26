# Java Stream Methods

This table provides a brief description and example implementation of various Java Stream methods.

| **Method**               | **Description**                                                                                         | **Example Implementation**                                                                                              |
|--------------------------|---------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| `filter(Predicate)`      | Filters the stream based on a predicate.                                                               | `stream.filter(e -> e.getAge() > 30)`                                                                                   |
| `map(Function)`          | Transforms each element in the stream using a function.                                                | `stream.map(e -> e.getName())`                                                                                          |
| `flatMap(Function)`      | Transforms each element to a stream and then flattens the resulting streams into a single stream.      | `stream.flatMap(e -> e.getCourses().stream())`                                                                          |
| `distinct()`             | Returns a stream with unique elements, removing duplicates.                                            | `stream.distinct()`                                                                                                     |
| `sorted()`               | Sorts the elements in the stream in natural order.                                                     | `stream.sorted()`                                                                                                       |
| `sorted(Comparator)`     | Sorts the elements in the stream based on a comparator.                                                | `stream.sorted((e1, e2) -> e1.getAge() - e2.getAge())`                                                                  |
| `limit(long)`            | Truncates the stream to the first `n` elements.                                                        | `stream.limit(5)`                                                                                                       |
| `skip(long)`             | Skips the first `n` elements of the stream.                                                            | `stream.skip(3)`                                                                                                        |
| `forEach(Consumer)`      | Performs an action for each element of the stream.                                                     | `stream.forEach(e -> System.out.println(e))`                                                                            |
| `collect(Collector)`     | Collects the elements of the stream into a collection or other data structure.                         | `stream.collect(Collectors.toList())`                                                                                   |
| `reduce(BinaryOperator)` | Combines elements of the stream using an associative accumulation function and returns a single value. | `stream.reduce((e1, e2) -> e1 + e2)`                                                                                    |
| `anyMatch(Predicate)`    | Returns `true` if any elements of the stream match the given predicate.                                | `stream.anyMatch(e -> e.getAge() > 30)`                                                                                 |
| `allMatch(Predicate)`    | Returns `true` if all elements of the stream match the given predicate.                                | `stream.allMatch(e -> e.getAge() > 30)`                                                                                 |
| `noneMatch(Predicate)`   | Returns `true` if no elements of the stream match the given predicate.                                 | `stream.noneMatch(e -> e.getAge() > 30)`                                                                                |
| `findFirst()`            | Returns the first element of the stream, if present.                                                   | `Optional<E> first = stream.findFirst()`                                                                                |
| `findAny()`              | Returns any element of the stream, useful in parallel streams.                                         | `Optional<E> any = stream.findAny()`                                                                                    |
| `peek(Consumer)`         | Performs an action on each element of the stream and returns a stream of the same elements.            | `stream.peek(e -> System.out.println(e))`                                                                               |
| `count()`                | Returns the count of elements in the stream.                                                           | `long count = stream.count()`                                                                                           |
| `toArray()`              | Returns an array containing the elements of the stream.                                                | `Object[] array = stream.toArray()`                                                                                     |
| `dropWhile(Predicate)`   | Drops elements from the stream while the predicate is true and returns the remaining elements once the predicate becomes false. | `stream.dropWhile(e -> e.getAge() < 30)` |



### Examples in Context

1. **`filter` Example**:
     ```java
   List<Student> students = Arrays.asList(
       new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics")),
       new Student("Bob", 31, "Male", Arrays.asList("Chemistry", "Biology")),
       new Student("Carol", 25, "Female", Arrays.asList("History", "Literature"))
   );

   List<Student> olderStudents = students.stream()
                                         .filter(e -> e.getAge() > 30)
                                         .collect(Collectors.toList());


2. **`filter` Example**:
   ```java
   List<Student> students = Arrays.asList(
   new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics")),
   new Student("Bob", 31, "Male", Arrays.asList("Chemistry", "Biology")),
   new Student("Carol", 25, "Female", Arrays.asList("History", "Literature"))
   );


2. **`filter` Example**:
   ```java
   List<String> names = students.stream()
   .map(Student::getName)
   .collect(Collectors.toList());
    Example:

4. **`flatMap` Example**:
   ```java
   List<Student> students = Arrays.asList(
   new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics")),
   new Student("Bob", 31, "Male", Arrays.asList("Chemistry", "Biology")),
   new Student("Carol", 25, "Female", Arrays.asList("History", "Literature"))
   );


5. **`filter` Example**:
   ```java
   List<String> allCourses = students.stream()
   .flatMap(e -> e.getCourses().stream())
   .distinct()
   .collect(Collectors.toList());


5. **`distinct` Example**:
   ```java
   List<Student> students = Arrays.asList(
   new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics")),
   new Student("Bob", 31, "Male", Arrays.asList("Chemistry", "Biology")),
   new Student("Carol", 25, "Female", Arrays.asList("History", "Literature")),
   new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics"))
   );

6. **`filter` Example**:
   ```java
   List<Student> uniqueStudents = students.stream()
   .distinct()
   .collect(Collectors.toList());
   dropWhile Example:


7. **`filter` Example**:
   ```java
   List<Student> students = Arrays.asList(
   new Student("Alice", 22, "Female", Arrays.asList("Math", "Physics")),
   new Student("Bob", 24, "Male", Arrays.asList("Chemistry", "Biology")),
   new Student("Carol", 25, "Female", Arrays.asList("History", "Literature")),
   new Student("David", 26, "Male", Arrays.asList("Computer Science", "Statistics")),
   new Student("Eve", 23, "Female", Arrays.asList("Art", "Music"))
   );


8. **`filter` Example**:
   ```java
   List<Student> filteredStudents = students.stream()
   .dropWhile(student -> student.getAge() < 25)
   .collect(Collectors.toList());
   filteredStudents.forEach(System.out::println);