# java-journey — working notes

## Layout

| Folder | Holds |
|---|---|
| `coursework/` | Graded CSL215 work only. `assignmentNN_<name>/`, `labNN_<name>/` (older lab folders keep descriptive names until real lab numbers are known). |
| `practice/` | Self-directed practice by topic (`leetcode/`, `brocode/`, ...). |
| `_review/` | Staging for anything uncertain: `unknown/`, `duplicates/`, `build-artifacts/`. Nothing here is deleted without an explicit decision. |

- Each coursework folder is a default-package unit; compile from inside it (`javac *.java`). Folders whose files reference each other (e.g. `assignment03_asset-inventory-manager/`) must move as a whole.
- `practice/leetcode/` files are LeetCode-harness snippets (no imports / `ListNode`); most don't compile standalone. That's expected.
- After cloning: `git config core.hooksPath .githooks` (gitleaks pre-commit scan).

## Decision Log

| Date | Decision | Options considered | Why | Reversible? |
|---|---|---|---|---|
| 2026-10-12 | Reorganized repo into `coursework/` + `practice/` + `_review/` (plan: `_review/ORGANIZE_PLAN.md`). `JAVA-LAB/` → `practice/leetcode/`; `asignment-3/.../...` flattened to `assignment03_asset-inventory-manager/`; `unit1`/`unit2` → `assignment01`/`assignment02`; `labwork-2026-07-28` → `lab01_2026-07-28`; scratch IDE template → `_review/unknown/`. | Keep `learning/` (existing README convention) vs. `practice/` (new template); `JAVA-LAB` as graded lab vs. practice; number all labs vs. only those with evidence. | `practice/` matches the new convention; `JAVA-LAB` has LeetCode-extension headers, no harness, and was never listed as coursework; lab numbers other than lab01 had no evidence, so those folders kept their names. All moves via `git mv` (history kept), compile results identical to the baseline. | Yes — branch `chore/organize-repo`; `git reset --hard c15f5ab` (pre-batch commit) or drop the branch. |

## Known Pitfalls

| Date | Symptom | Root cause | Fix | Prevention rule |
|---|---|---|---|---|
| 2026-10-12 | `Remove-Item` on an emptied folder failed: "insufficient access rights ... read only". | Windows folder had the `ReadOnly` attribute; `git mv` of the nested child left the empty parent behind. | Confirmed empty, then `Remove-Item -Force`. | After flattening with `git mv`, check leftover parents are empty and remove with `-Force`; never `-Recurse` on them. |
| 2026-10-12 | Untracked `.class` files were not moved in the same script run. | `$ErrorActionPreference='Stop'` aborted the script at the failed `Remove-Item`, skipping later steps. | Re-ran the remaining steps and checked `git status`. | Run each move/cleanup step separately (or verify state) after any error under `Stop`. |
| 2026-10-12 | `git mv` leaves empty source folders on disk. | Git tracks files, not directories. | Delete only verified-empty dirs after the move. | Check for empty leftovers after every folder move. |
| 2026-10-12 | Untracked `.enola/` (~650 KB tool cache) appeared mid-session. | External code-indexing tool writes into the repo root. | Added `.enola/` to `.gitignore`. | Ignore tool caches up front; review `git status` before every commit. |
| 2026-10-12 | "LF will be replaced by CRLF" warnings on every edited file. | `core.autocrlf=true` with LF files; harmless. | None needed — `git ls-files --eol` shows `i/lf w/lf` (unchanged). | Verify with `git ls-files --eol` instead of normalizing line endings. |
