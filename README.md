# java-journey

Java code from CSL215 coursework and personal practice, kept in one repo and split by intent.

## Coursework

Official CSL215 deliverables — graded assignments, lab submissions, homework tied to a specific class/date. See [coursework/README.md](coursework/README.md) for details.

| Folder | Description |
|---|---|
| [coursework/assignment01_datatypes-operators-ifelse/](coursework/assignment01_datatypes-operators-ifelse/) | Unit 1 assignment — data types, operators, and if-else (21 Aug 2026 class). |
| [coursework/assignment02_loops/](coursework/assignment02_loops/) | Unit 2 — loop constructs (for, while, do-while, enhanced for, nested). |
| [coursework/assignment03_asset-inventory-manager/](coursework/assignment03_asset-inventory-manager/) | Assignment 3 — Asset Inventory Manager (Collections & Generics). |
| [coursework/lab01_2026-07-28/](coursework/lab01_2026-07-28/) | Lab work from the 28 Jul 2026 class session. |
| [coursework/student-class-exercise/](coursework/student-class-exercise/) | `Student` class exercise. |
| [coursework/collections-lab-exercises/](coursework/collections-lab-exercises/) | Collections Framework lab exercises 1–5. |
| [coursework/collections-lab-exercises-6-10/](coursework/collections-lab-exercises-6-10/) | Collections Framework lab exercises 6–10. |

## Java Lab

Graded work from the separate Java lab classes, kept apart from the CSL215 coursework.

| Folder | Description |
|---|---|
| [JAVA-LAB/](JAVA-LAB/) | Lab problems (LeetCode format) — linked lists, stacks, queues, sorting, and design problems. |

## Practice

Personal practice — workbook exercises, syntax practice, concept demos, LeetCode-style problems solved for fun. See [practice/README.md](practice/README.md) for details.

| Folder | Description |
|---|---|
| [practice/brocode/](practice/brocode/) | Practice code following the Bro Code YouTube Java course. |

Items awaiting a keep/discard decision live in [_review/](_review/) — see [_review/ORGANIZE_PLAN.md](_review/ORGANIZE_PLAN.md).

## Setup

After cloning, run `git config core.hooksPath .githooks` once — this points git at the repo's tracked pre-commit hook (a secret scan via gitleaks). This setting isn't shared automatically by git; only the hook script itself is tracked, so every clone needs to opt in.
