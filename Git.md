# Git and GitHub Comprehensive Guide

## Introduction
Git is a distributed version control system that allows developers to track changes in their code and collaborate effectively. GitHub is a cloud-based hosting service for Git repositories that adds additional collaboration tools.

## Setting Up Git
1. **Install Git**: Download and install Git from [git-scm.com](https://git-scm.com/).
2. **Configure Git**:
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "your.email@example.com"
   ```

## Basic Git Commands
- **Initialize a Repository**:
  ```bash
  git init
  ```
- **Clone a Repository**:
  ```bash
  git clone <repository_url>
  ```
- **Check Repository Status**:
  ```bash
  git status
  ```
- **Stage Changes**:
  ```bash
  git add <file_name>
  ```
  ```bash
  git add .  # Add all changes
  ```
- **Commit Changes**:
  ```bash
  git commit -m "Commit message"
  ```
- **View Commit History**:
  ```bash
  git log
  ```
- **Undo Changes**:
  ```bash
  git checkout -- <file_name>
  ```

## Branching and Merging
- **Create a New Branch**:
  ```bash
  git branch <branch_name>
  ```
- **Switch to a Branch**:
  ```bash
  git checkout <branch_name>
  ```
- **Create and Switch to a New Branch**:
  ```bash
  git checkout -b <branch_name>
  ```
- **Merge a Branch**:
  ```bash
  git merge <branch_name>
  ```
- **Delete a Branch**:
  ```bash
  git branch -d <branch_name>
  ```

## Working with Remote Repositories
- **Add a Remote Repository**:
  ```bash
  git remote add origin <repository_url>
  ```
- **View Remote URLs**:
  ```bash
  git remote -v
  ```
- **Fetch Changes**:
  ```bash
  git fetch
  ```
- **Pull Changes**:
  ```bash
  git pull
  ```
- **Push Changes**:
  ```bash
  git push origin <branch_name>
  ```

## Undoing Changes
- **Undo Last Commit (Soft Reset)**:
  ```bash
  git reset --soft HEAD~1
  ```
- **Undo Last Commit (Hard Reset - Destroys Changes)**:
  ```bash
  git reset --hard HEAD~1
  ```
- **Revert a Commit**:
  ```bash
  git revert <commit_hash>
  ```

## Git Rebase
- **Rebase Current Branch onto Another Branch**:
  ```bash
  git rebase <branch_name>
  ```
- **Interactive Rebase to Modify Commit History**:
  ```bash
  git rebase -i HEAD~n  # Replace n with the number of commits
  ```
- **Abort a Rebase**:
  ```bash
  git rebase --abort
  ```
- **Continue a Rebase After Resolving Conflicts**:
  ```bash
  git rebase --continue
  ```

## Git Stash
- **Stash Changes**:
  ```bash
  git stash
  ```
- **List Stashes**:
  ```bash
  git stash list
  ```
- **Apply Stashed Changes**:
  ```bash
  git stash apply
  ```
- **Delete a Stash**:
  ```bash
  git stash drop
  ```

## Git Cherry-Pick
- **Apply a Specific Commit from Another Branch**:
  ```bash
  git cherry-pick <commit_hash>
  ```

## Git Reset
- **Soft Reset (Keeps Changes Staged)**:
  ```bash
  git reset --soft HEAD~1
  ```
- **Mixed Reset (Keeps Changes but Unstages Them)**:
  ```bash
  git reset --mixed HEAD~1
  ```
- **Hard Reset (Deletes Changes)**:
  ```bash
  git reset --hard HEAD~1
  ```

## Git Reflog
- **View Reference Log of All Git Actions**:
  ```bash
  git reflog
  ```
- **Restore a Previous Commit Using Reflog**:
  ```bash
  git reset --hard <commit_hash>
  ```

## GitHub Collaboration
- **Fork a Repository**: Click on the "Fork" button in GitHub UI.
- **Create a Pull Request**:
  1. Push changes to a feature branch.
  2. Go to the GitHub repository and open a Pull Request.
  3. Add reviewers and submit the PR.
- **Resolve Merge Conflicts**:
  ```bash
  git mergetool
  ```
  ```bash
  git commit -m "Resolved merge conflicts"
  ```

## Understanding the .gitignore File
To ignore specific files, create a `.gitignore` file:
```
*.log
node_modules/
.env
```

## Additional Git Commands
- **Show Differences Between Commits**:
  ```bash
  git diff <commit1> <commit2>
  ```
- **Show Remote Branches**:
  ```bash
  git branch -r
  ```
- **Delete a Remote Branch**:
  ```bash
  git push origin --delete <branch_name>
  ```

## Conclusion
Mastering Git and GitHub is essential for efficient software development. Understanding commands and workflows will enhance collaboration and version control management.

