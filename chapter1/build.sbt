name := """chapter1-demo"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

doc in Compile <<= target.map(_ / "none")

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
