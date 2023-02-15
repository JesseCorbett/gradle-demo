# Gradle demo

An example of some of the core features of Gradle
as well as how plugins are made and used

## plugin

The plugin directory includes a compiled plugin which
includes one existing task and a DSL for adding tasks

## Presentation

This repo is built to be presented one branch at a time

1. `one` presents the base project with only the kotlin requisites
2. `two` adds the application plugin to demonstrate plugins adding interesting functionality and new tasks
3. `three` adds the ListFilesTask, showing how creating a task works and how it can be configured
4. Return to `main` to show the SourceSizeTask, showing how to have dynamic task creation & other utilities
