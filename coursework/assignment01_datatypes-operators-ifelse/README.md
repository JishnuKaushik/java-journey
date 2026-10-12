# CSL215 — Unit 1 Assignment: Data Types, Operators & If-Else Statements

Self-framed questions based on the class covered 21 Aug 2026 (Data Types,
Operators, Local/Instance/Static Variables). Sections A-C are solved via
LeetCode problems mapped to each concept; Section D covers class-discussion
questions; the written task covers Java's data type system.

## Section A — Data Types (via LeetCode)

| File | Solves / Explains |
|---|---|
| [Q1_ReverseInteger.java](section-a-datatypes/Q1_ReverseInteger.java) | LeetCode #7 — reverses a 32-bit signed integer's digits, using a `long` accumulator to safely detect overflow before narrowing back to `int`. |
| [Q2_HappyNumber.java](section-a-datatypes/Q2_HappyNumber.java) | LeetCode #202 — detects whether repeated sum-of-squares-of-digits reaches 1, using a `HashSet<Integer>` to demonstrate autoboxing/unboxing. |
| [Q3_AddDigits.java](section-a-datatypes/Q3_AddDigits.java) | LeetCode #258 — repeatedly sums digits down to a single digit (digital root) via `%`/`/`, with an O(1) formula alternative. |
| [Q4_SelfDividingNumbers.java](section-a-datatypes/Q4_SelfDividingNumbers.java) | LeetCode #728 — finds numbers in a range where every digit evenly divides the number, using a `List<Integer>` (autoboxing) and safe zero-digit checks. |
| [Q5_NumberOf1Bits.java](section-a-datatypes/Q5_NumberOf1Bits.java) | LeetCode #191 — counts set bits (Hamming weight) of a 32-bit int using unsigned right shift (`>>>`) to avoid sign-bit corruption. |

## Section B — Operators (via LeetCode)

| File | Solves / Explains |
|---|---|
| [Q1_SingleNumber.java](section-b-operators/Q1_SingleNumber.java) | LeetCode #136 — finds the single non-duplicated element in an array using XOR (`^`) cancellation. |
| [Q2_HammingDistance.java](section-b-operators/Q2_HammingDistance.java) | LeetCode #461 — counts differing bits between two integers by chaining XOR, AND, and right shift. |
| [Q3_PlusOne.java](section-b-operators/Q3_PlusOne.java) | LeetCode #66 — adds one to a digit-array integer, modeling manual carry propagation with `++` and relational checks. |
| [Q4_PowerOfTwo.java](section-b-operators/Q4_PowerOfTwo.java) | LeetCode #231 — tests if an integer is a power of two via `n > 0 && (n & (n - 1)) == 0`, illustrating operator precedence. |
| [Q5_NimGame.java](section-b-operators/Q5_NimGame.java) | LeetCode #292 — determines the Nim game winner with a single modulo/relational check (`n % 4 != 0`). |

## Section C — If-Else Statements (via LeetCode)

| File | Solves / Explains |
|---|---|
| [Q1_FizzBuzz.java](section-c-ifelse/Q1_FizzBuzz.java) | LeetCode #412 — classic FizzBuzz if-else-if ladder, where the divisible-by-15 check must come first. |
| [Q2_ValidParentheses.java](section-c-ifelse/Q2_ValidParentheses.java) | LeetCode #20 — validates bracket matching/nesting using if-else branching around a stack (`ArrayDeque`). |
| [Q3_BinarySearch.java](section-c-ifelse/Q3_BinarySearch.java) | LeetCode #704 — binary search implemented as a 3-way if-else-if (equal / less than / greater than target). |
| [Q4_RemoveElement.java](section-c-ifelse/Q4_RemoveElement.java) | LeetCode #27 — removes all occurrences of a value in place using a single `if` gate with a two-pointer overwrite. |
| [Q5_SortedSquares.java](section-c-ifelse/Q5_SortedSquares.java) | LeetCode #977 — produces sorted squares of a sorted array using if-else to drive a two-pointer merge from the outside in. |

## Section D — Class Discussion Questions (21 Aug class)

| File | Solves / Explains |
|---|---|
| [Q1_LocalInstanceStatic.java](section-d-variables/Q1_LocalInstanceStatic.java) | Explains the difference between local, instance, and static variables (scope, default values, lifetime). |
| [Q2_DefaultInitialization.java](section-d-variables/Q2_DefaultInitialization.java) | Explains why local variables need explicit initialization while instance/static variables get JVM defaults (stack vs. heap/method area). |
| [Q3_VariableDemo.java](section-d-variables/Q3_VariableDemo.java) | Demonstrates a local, an instance, and a static variable together in one class (`VariableDemo`). |
| [Q4_StaticAccess.java](section-d-variables/Q4_StaticAccess.java) | Shows a static variable (`Counter.count`) accessed via the class name without creating an object. |
| [Q5_VariableShadowing.java](section-d-variables/Q5_VariableShadowing.java) | Demonstrates variable shadowing (`ShadowDemo`) and accessing the shadowed instance variable via `this`. |
| [Q6_MemoryModel.java](section-d-variables/Q6_MemoryModel.java) | Explains where local, instance, and static variables are stored in memory (stack, heap, method area). |
| [Q7_ScopeLifetime.java](section-d-variables/Q7_ScopeLifetime.java) | Compares the scope and lifetime of a local variable vs. a static variable. |
| [Q8_IntVsInteger.java](section-d-variables/Q8_IntVsInteger.java) | Differentiates `int` vs. `Integer` and demonstrates autoboxing/unboxing. |
| [Q9_CompoundAssignment.java](section-d-variables/Q9_CompoundAssignment.java) | Shows how `x += 5` implicitly narrows while `x = x + 5` does not, using a `byte` example. |
| [Q10_DefaultValuesDemo.java](section-d-variables/Q10_DefaultValuesDemo.java) | Declares one uninitialized instance variable per primitive type and prints their JVM-assigned default values. |

## Written Task

| File | Solves / Explains |
|---|---|
| [DataTypesDemo.java](written-task/DataTypesDemo.java) | Covers Java's 8 primitive types (size/default/range) and non-primitive (reference) types, with a runnable example of each. |
