/*
 * Q7. What is the scope and lifetime of a local variable compared to a
 * static variable?
 *
 * Ans: A local variable's scope is limited to the block/method it's
 * declared in, and its lifetime is exactly the duration of that single
 * method call — a fresh copy is created every time the method runs and
 * destroyed when it returns. A static variable's scope is the entire class
 * (and any code with access to it), and its lifetime spans the whole
 * program — from when the class is first loaded by the JVM until the
 * program ends — with only one copy ever existing, shared by every
 * instance.
 */
