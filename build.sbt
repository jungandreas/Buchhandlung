name := """iuk_ii_w-fs18"""
organization := "ch.htwchur"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice
