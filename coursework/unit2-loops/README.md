# Unit 2 — Loops

Self-framed questions covering Java's loop constructs (for, while, do-while,
enhanced for, nested loops). Sections A, B, D, and E are solved via
LeetCode problems mapped to each loop type; Section C is self-framed
(no LeetCode problem is idiomatically solved with do-while).

## Section A — For Loop (via LeetCode)

| File | Solves | Demonstrates |
|---|---|---|
| [Q1_TwoSum.java](section-a-for-loop/Q1_TwoSum.java) | LC #1 — finds two indices whose values sum to a target. | Single indexed `for` loop with a running hash map, one pass over a known-length array. |
| [Q2_MoveZeroes.java](section-a-for-loop/Q2_MoveZeroes.java) | LC #283 — moves all zeroes to the end in place. | `for` loop where the index doubles as a running write-position pointer. |
| [Q3_MaxConsecutiveOnes.java](section-a-for-loop/Q3_MaxConsecutiveOnes.java) | LC #485 — longest run of consecutive 1's. | `for` loop tracking a running streak over a fixed-length array. |
| [Q4_NumberOfGoodPairs.java](section-a-for-loop/Q4_NumberOfGoodPairs.java) | LC #1512 — counts index pairs with equal values. | `for` loop with a frequency map, avoiding a brute-force nested scan. |
| [Q5_ConcatenationOfArray.java](section-a-for-loop/Q5_ConcatenationOfArray.java) | LC #1929 — builds `nums + nums` into one array. | `for` loop mapping each source index to two fixed output indices. |

## Section B — While Loop (via LeetCode)

| File | Solves | Demonstrates |
|---|---|---|
| [Q1_SqrtX.java](section-b-while-loop/Q1_SqrtX.java) | LC #69 — integer square root. | `while` loop driving binary search until the search window closes. |
| [Q2_ValidPerfectSquare.java](section-b-while-loop/Q2_ValidPerfectSquare.java) | LC #367 — checks if a number is a perfect square. | `while` loop binary search, stopping condition depends on the data. |
| [Q3_SearchInsertPosition.java](section-b-while-loop/Q3_SearchInsertPosition.java) | LC #35 — finds/insert position in a sorted array. | `while` loop binary search with a data-dependent stopping point. |
| [Q4_LinkedListCycle.java](section-b-while-loop/Q4_LinkedListCycle.java) | LC #141 — detects a cycle in a linked list. | `while` loop running Floyd's slow/fast pointers for an unknown number of steps. |
| [Q5_MiddleOfLinkedList.java](section-b-while-loop/Q5_MiddleOfLinkedList.java) | LC #876 — finds the middle node of a linked list. | `while` loop with slow/fast pointers stopping when fast runs off the list. |

## Section C — Do-While Loop (self-framed)

| File | Solves | Demonstrates |
|---|---|---|
| [Q1_RetryUntilValidInput.java](section-c-do-while-loop/Q1_RetryUntilValidInput.java) | Retries a simulated prompt until a positive number is entered. | `do-while` — the first attempt must happen before it can be validated. |
| [Q2_MenuDrivenCalculator.java](section-c-do-while-loop/Q2_MenuDrivenCalculator.java) | Runs a simulated menu-driven calculator. | `do-while` — the menu must run and act at least once before the exit check. |
| [Q3_NumberGuessingGame.java](section-c-do-while-loop/Q3_NumberGuessingGame.java) | Simulates guessing a target number. | `do-while` — a guess must be made before win/lose can be evaluated. |
| [Q4_SumDigitsAtLeastOnce.java](section-c-do-while-loop/Q4_SumDigitsAtLeastOnce.java) | Sums the digits of a number, including 0. | `do-while` — guarantees the digit-extraction body runs at least once, correctly handling 0. |
| [Q5_PasswordAttemptSimulator.java](section-c-do-while-loop/Q5_PasswordAttemptSimulator.java) | Simulates limited password attempts. | `do-while` — an attempt must be made before it can be checked against the limit. |

## Section D — Enhanced For Loop (via LeetCode)

| File | Solves | Demonstrates |
|---|---|---|
| [Q1_ShuffleTheArray.java](section-d-enhanced-for-loop/Q1_ShuffleTheArray.java) | LC #1470 — interleaves two array halves. | Enhanced `for` over one half, consumed by value with no index-driven condition. |
| [Q2_HowManyNumbersSmaller.java](section-d-enhanced-for-loop/Q2_HowManyNumbersSmaller.java) | LC #1365 — counts smaller numbers per element. | Enhanced `for` loops over the input array for both the counting and lookup passes. |
| [Q3_UniqueNumberOfOccurrences.java](section-d-enhanced-for-loop/Q3_UniqueNumberOfOccurrences.java) | LC #1207 — checks if occurrence counts are all unique. | Enhanced `for` loops over array values and over counted occurrences. |
| [Q4_SubtractProductAndSumOfDigits.java](section-d-enhanced-for-loop/Q4_SubtractProductAndSumOfDigits.java) | LC #1281 — product minus sum of an integer's digits. | Enhanced `for` over a digit-character array. |
| [Q5_ContainsDuplicate.java](section-d-enhanced-for-loop/Q5_ContainsDuplicate.java) | LC #217 — checks for any duplicate value. | Enhanced `for` loop as a pure by-value membership check against a set. |

## Section E — Nested Loops (via LeetCode)

| File | Solves | Demonstrates |
|---|---|---|
| [Q1_SpiralMatrix.java](section-e-nested-loops/Q1_SpiralMatrix.java) | LC #54 — reads a matrix in spiral order. | Nested loops walking a shrinking rectangular boundary layer by layer. |
| [Q2_ValidSudoku.java](section-e-nested-loops/Q2_ValidSudoku.java) | LC #36 — validates a 9x9 Sudoku board. | Nested loops over rows and columns to identify each cell's row/column/box. |
| [Q3_RotateImage.java](section-e-nested-loops/Q3_RotateImage.java) | LC #48 — rotates a matrix 90 degrees in place. | Nested loops for the transpose step and the row-reversal step. |
| [Q4_SetMatrixZeroes.java](section-e-nested-loops/Q4_SetMatrixZeroes.java) | LC #73 — zeroes out rows/columns containing a 0. | Nested loops scanning and updating every cell of a 2D grid. |
| [Q5_ThreeSum.java](section-e-nested-loops/Q5_ThreeSum.java) | LC #15 — finds all unique zero-sum triplets. | Outer loop fixing one number, inner two-pointer `while` loop for the other two. |
