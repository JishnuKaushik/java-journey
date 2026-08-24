# java-journey

Java code from CSL215 coursework and personal practice, kept in one repo and split by intent.

## Coursework

Official CSL215 deliverables — graded assignments, lab submissions, homework tied to a specific class/date. See [coursework/README.md](coursework/README.md) for details.

| Folder | Description |
|---|---|
| [coursework/unit1-datatypes-operators-ifelse/](coursework/unit1-datatypes-operators-ifelse/) | Unit 1 assignment — data types, operators, and if-else (21 Aug 2026 class). |
| [coursework/labwork-2026-07-28/](coursework/labwork-2026-07-28/) | Lab work from the 28 Jul 2026 class session. |
| [coursework/student-class-exercise/](coursework/student-class-exercise/) | `Student` class exercise. |

## Learning

Personal practice — workbook exercises, syntax practice, concept demos, LeetCode-style problems solved for fun. See [learning/README.md](learning/README.md) for details.

| Folder | Description |
|---|---|
| [learning/brocode/](learning/brocode/) | Practice code following the Bro Code YouTube Java course. |
| [learning/scratch/](learning/scratch/) | Misc leftover/template files with no other home yet. |

## Setup

After cloning, run `git config core.hooksPath .githooks` once — this points git at the repo's tracked pre-commit hook (a secret scan via gitleaks). This setting isn't shared automatically by git; only the hook script itself is tracked, so every clone needs to opt in.
