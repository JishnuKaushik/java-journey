# Repo organization plan — java-journey

Status: APPROVED 2026-10-12 and executed on branch `chore/organize-repo` (created from `main` @ `c15f5ab`).
Approved decisions: D1 `practice/` · D2 `JAVA-LAB/` → `practice/leetcode/` · D3 no lab numbers given, so only `lab01` was renamed and `student-class-exercise/`, `collections-lab-exercises/`, `collections-lab-exercises-6-10/` **keep their names** (the lab02–04 rows below were not applied) · D4 yes · D5 no (`.vscode/` stays untracked) · D6 yes.
Before-snapshot: `%TEMP%\repo_before.csv` (118 files, SHA256). Compile baseline: `%TEMP%\compile_baseline.csv`.

## Decisions needed before execution

| # | Question | Recommendation | Evidence |
|---|---|---|---|
| D1 | Practice root: `practice/` (your template) or keep `learning/` (current README convention)? | `practice/` | Template is the newer statement of intent; README docs get updated to match. Keeping `learning/` = fewer doc edits. |
| D2 | `JAVA-LAB/` graded or practice? | Practice → `practice/leetcode/` | `@lc app=leetcode` headers (VS Code LeetCode ext); 18 one-file commits on 2026-09-23; not listed in `coursework/README.md` (which lists every graded folder, incl. ones added later); README defines "LeetCode-style problems solved for fun" as learning; no `main`, not standalone-compilable unlike every coursework file. Against: folder name says "LAB". |
| D3 | Real lab numbers? | Confirm/correct the `labNN` guesses below | Only `lab01` has evidence (`package ...lab01july28`). lab02–04 ordered by commit/assignment date = guess. Alternative: keep current folder names for these. |
| D4 | `unit1`/`unit2` → `assignment01`/`assignment02`? | Yes | README calls unit1 "Unit 1 assignment"; "Assignment 3" exists, so units 1–2 are plausibly assignments 1–2. |
| D5 | Add `.vscode/` to `.gitignore`? | Your call | You chose "leave untracked, frozen" → tree keeps showing `?? .vscode/settings.json` forever. Ignoring it makes `git status` clean without committing it. |
| D6 | Commit this plan file (`_review/ORGANIZE_PLAN.md`)? | Yes, in the `_review` batch | Otherwise it stays untracked and `git status` is not clean at the end. |

## Move table

Folder rows move the whole folder with one `git mv` (all files inside keep relative paths). No `package`/`import` edits are required by any move.

| Old path | New path | Class | Reason / evidence | Pkg/import edit? | Conf |
|---|---|---|---|---|---|
| `coursework/asignment-3/Assignment3_AssetInventoryManager/Assignment3_AssetInventoryManager/` (6 files: Asset, AssetManager, HardwareAsset, Main, SoftwareAsset .java + README.md) | `coursework/assignment03_asset-inventory-manager/` | GRADED | README "Assignment 3", name/course header; flattens double nesting, fixes "asignment" typo. Atomic default-package unit. Empty parent dirs disappear. | No | H |
| `coursework/unit1-datatypes-operators-ifelse/` (24 files) | `coursework/assignment01_datatypes-operators-ifelse/` | GRADED | README "Unit 1 assignment ... 21 Aug 2026 class" (D4) | No | M |
| `coursework/unit2-loops/` (26 files) | `coursework/assignment02_loops/` | GRADED | commit `ccfbde2` "Add unit2-loops coursework" (D4) | No | M |
| `coursework/labwork-2026-07-28/` (Main.java, helloworld.java) | `coursework/lab01_2026-07-28/` | GRADED | README "Lab work from the 28 Jul 2026 class"; `package coursework.labwork.lab01july28` | No (see note P1) | M |
| `coursework/student-class-exercise/` (Student.java) | `coursework/lab02_student-class/` | GRADED | listed in coursework README; number is a guess (D3) | No | L |
| `coursework/collections-lab-exercises/` (Q1–Q5 .java) | `coursework/lab03_collections-q1-5/` | GRADED | README "Collections Framework lab exercises 1–5"; number guess (D3) | No | L |
| `coursework/collections-lab-exercises-6-10/` (Q6–Q10 .java) | `coursework/lab04_collections-q6-10/` | GRADED | README "lab exercises 6–10 (assigned 1 Oct 2026)"; number guess (D3) | No | L |
| `coursework/README.md` | unchanged | DOC | index for coursework | — | H |
| `JAVA-LAB/` (18 files) | `practice/leetcode/` | PRACTICE | see D2 | No | M |
| `learning/README.md` | `practice/README.md` | DOC | D1 | — | M |
| `learning/brocode/README.md` | `practice/brocode/README.md` | DOC | placeholder for Bro Code course practice | — | M |
| `learning/scratch/Main.java` | `_review/unknown/learning-scratch/Main.java` | SCRATCH/junk | Unfilled IDE template: `package PACKAGE_NAME; public class main {}`; fails to compile; added only in the 2026-08-24 reorg commit | No (content untouched) | H |
| `coursework/collections-lab-exercises/*.class` (6, untracked, ignored) | `_review/build-artifacts/collections-lab-exercises/` | BUILD-ARTIFACT | compiled output of Q1–Q5; would be orphaned in the old folder after the `git mv` (git only moves tracked files). Plain `Move-Item`; stays gitignored. | — | H |
| `README.md`, `.gitignore`, `.githooks/pre-commit` | unchanged | DOC / config | root files | — | H |
| `.idea/`, `out/` | unchanged (frozen) | BUILD-ARTIFACT / IDE | already ignored, untracked | — | H |
| `.vscode/settings.json` | unchanged (frozen) | IDE | only `java.jdt.ls.vmargs`; no source paths (D5) | — | H |
| `.enola/` (6 files, ~650 KB, untracked) | unchanged | UNKNOWN | appeared 2026-10-12 09:47 during this session; not created by me; looks like an external tool's code-index cache (`llm_context.md`, `facts.jsonl`). Propose gitignore. | — | M |

`docs/` and root `scratch/` from the template are not created: there are no loose notes and the only scratch file goes to `_review/`. Empty folders aren't tracked by git.

## (a) Atomic units kept intact
- `assignment03_asset-inventory-manager/`: 5 classes reference each other (default package). Moved as one folder.
- All other folders: each `.java` is self-contained (own `main` or answer-only comment). Folder moves keep them together anyway.

## (b) Duplicates
- Identical file hashes: **none**.
- No `X (1).java` / `Copy of` / `Untitled` names.
- Same simple class name in different files (not duplicates; only matters if compiled into one output dir): `Solution` ×45, `Main` ×3, `Node` ×2, `Student` ×2 (`collections Q5` vs `student-class-exercise`). No action.

## (c) UNKNOWN / pre-existing issues (reported, not fixed)
- P1 `coursework/labwork-2026-07-28/*.java`: `package coursework.labwork.lab01july28` doesn't match the folder path (and a hyphenated folder can't be a package). That's already the case before the move, and the move doesn't make it worse. Compiles with `javac -d`.
- P2 `JAVA-LAB/141.linked-list-cycle.java`: `public class Solution` in a file not named `Solution.java`.
- P3 `learning/scratch/Main.java`: `public class main` in `Main.java` + placeholder package.
- P4 `JAVA-LAB/*`: 12 files reference `ListNode`/`Deque`/etc. without imports or definitions (LeetCode harness provides these). They don't compile standalone.
- P5 `coursework/README.md` has no row for `unit2-loops`.
- P6 `.githooks/pre-commit` mentions `.gitleaks.toml`, which doesn't exist (only needed for allowlisting).
- P7 Existing commits `c15f5ab`, `2a54ffe`, `a72f632` carry `Co-Authored-By` trailers. Not rewritten (history rewrite is out of scope).
- `.enola/`: see table.

## (d) References/config to update (doc edits only)
| File | Lines | Change |
|---|---|---|
| `README.md` | 11, 12, 13 | coursework links → new folder names; add rows for the other coursework folders |
| `README.md` | 15–22 | "Learning" section → "Practice", `learning/` → `practice/`; replace scratch row with `practice/leetcode/` row |
| `coursework/README.md` | 7–12 | links → new folder names; add `assignment02_loops` row (P5) |
| `practice/README.md` (moved) | 1, 3, 8 | title "Learning" → "Practice"; remove scratch row; add leetcode row |
| asg3 `README.md` | — | none needed ("inside this folder: javac *.java" still holds after flatten) |
| `.vscode/settings.json` | — | none (no `sourcePaths`/`referencedLibraries`) |
| `pom.xml` / `build.gradle` / tracked `*.iml` | — | none exist |
| `.idea/` (untracked, frozen) | — | not edited. IntelliJ may need "Reload/Re-import project" if it pins module paths. |

## (e) `.gitignore` additions
```
# Tool caches
.enola/

# JVM crash logs
hs_err_pid*
replay_pid*

# Secrets / keys
.env.*
*.pem
*.key
*.p12
*.jks
*.keystore
```
Plus `.vscode/` if D5 = yes. Already present: `.idea/ *.iml out/ *.class bin/ target/ build/ *.jar .env`.

## (f) Baseline compile (JDK Temurin 25.0.4, each file compiled alone with `-sourcepath <its folder>` into `%TEMP%\organize_baseline\`)
- **75 PASS / 14 FAIL**. Every failure is pre-existing:
  - 13 × `JAVA-LAB/*`: missing `ListNode`/imports (P4), plus 141's public-class mismatch (P2). Pass: 1603, 622, 706, 707, 912.
  - 1 × `learning/scratch/Main.java` (P3).
- Unit `assignment-3/*.java` together: PASS on JDK 25 and with `--release 8` (matches its README's "JDK 8+"). Scan found no Java 9+ features.
- Secrets scan: none. `Q5_PasswordAttemptSimulator.java` has demo strings (`"letmein"`, `"password1"`, `"java123"`) as simulated input, not credentials. gitleaks is installed and wired through `core.hooksPath=.githooks`.

## Execution batches (after approval)
1. `chore(organize): restructure graded work under coursework/`: 7 `git mv` + move 6 untracked `.class` to `_review/build-artifacts/`
2. `chore(organize): move practice work under practice/`: `JAVA-LAB/` → `practice/leetcode/`, `learning/*` → `practice/`
3. `chore(organize): stage scratch template under _review/`: `learning/scratch/Main.java` (+ this plan if D6)
4. `docs: update README links for new layout`
5. `chore(gitignore): ignore tool caches, crash logs, key files`
6. `docs: add CLAUDE.md with decision log`: CLAUDE.md is currently **absent**, so it will be created

After each move batch: recompile the affected files and diff against the baseline. If a batch regresses: `git reset --hard HEAD~1` on this branch and report.
No push, no merge, no attribution trailers.
