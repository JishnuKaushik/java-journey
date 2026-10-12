/*
 * Q2. Why must local variables be explicitly initialized before use, while
 * instance and static variables get default values automatically?
 *
 * Ans: Local variables live on the stack in a method's call frame, which the
 * JVM does not zero-initialize for performance and safety reasons — using an
 * uninitialized local variable is actually a compile-time error ("variable
 * might not have been initialized"). Instance and static variables live in
 * the heap/method area respectively, and the JVM guarantees they are zeroed
 * out (0, 0.0, false, or null) as part of object/class creation, so the
 * compiler doesn't force explicit initialization for them.
 */
