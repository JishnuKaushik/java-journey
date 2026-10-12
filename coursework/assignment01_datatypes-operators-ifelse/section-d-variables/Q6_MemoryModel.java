/*
 * Q6. Where in memory are local variables, instance variables, and static
 * variables stored? Briefly justify.
 *
 * Ans: Local variables are stored on the stack, inside the stack frame
 * created for each method call — this is why they disappear the moment the
 * method returns. Instance variables are stored on the heap, as part of the
 * object they belong to, so they persist as long as the object is
 * reachable. Static variables are stored in the method area (part of the
 * JVM's metaspace since Java 8), associated with the class itself rather
 * than any object, so a single copy exists for the whole class regardless of
 * how many objects are created.
 */
